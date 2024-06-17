(ns opencv4.utils
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [clojure.string :as str]
    [opencv4.core :as cv]
    [opencv4.filter :as f]
    [opencv4.colors.rgb :as rgb]
    [nextjournal.beholder :as beholder]
    [opencv4.video :as vid])
  (:import [org.opencv.core Size CvType Core Mat MatOfByte]
           [org.opencv.imgcodecs Imgcodecs]
           [org.opencv.videoio VideoCapture]
           [org.opencv.imgproc Imgproc]

           [java.net URL]
           [java.nio.channels ReadableByteChannel Channels]
           [java.io File FileOutputStream IOException PushbackReader]

           [javax.imageio ImageIO]
           [javax.swing ImageIcon JFrame JLabel]
           [java.awt.event ComponentListener KeyListener MouseAdapter]
           [java.awt FlowLayout]))

;;;
; CLEAN
;;;
(defn clean-up-namespace []
  (map #(ns-unmap *ns* %) (keys (ns-interns *ns*))))

;;;
;;;

(defn ->cv1 [bytes h w]
  (let [u (cv/new-mat h w cv/CV_8U)]
    (cv/>> u (byte-array bytes))))

(defn split3! [org]
  (let [splits (cv/split! org)
        [r g b :as arrays] (reverse (map cv/->bytes splits))]
    (byte-array (for [ar arrays i ar] i))))
(def mat->flat-rgb-array split3!)

(defn merge3! [mat bytes]
  (let [h (.height mat)
        w (.width mat)
        spatial-size (* h w)
        byte-arrays (reverse (partition spatial-size bytes))
        mats (map #(->cv1 % h w) byte-arrays)]
    (cv/merge! mats mat)))

;;;
; MAT OPERATIONS
;;;
(defn resize-by [mat factor]
  (let [height (.rows mat) width (.cols mat)]
    (cv/resize! mat (cv/new-size (* width factor) (* height factor)))))

(defn matrix-to-mat [matrix mat array-fn]
  (map-indexed
   (fn [i line]
     (map-indexed
      (fn [j val] (.put mat i j (array-fn [val])))
      line))
   matrix))

(defn matrix-to-matofpoint2f [pts]
  (cv/new-matofpoint2f
   (into-array org.opencv.core.Point
               (map #(cv/new-point (first %) (second %)) pts))))

(defn matrix-to-mat [matrix]
  (let [flat (flatten matrix)
        rows (count matrix)
        cols (count (first matrix))
        mat (Mat. rows cols CvType/CV_32F)
        total (.total mat)
        bytes (float-array total)]
    (doseq [^int i (range 0 total)]
      (aset-float bytes i (nth flat i)))
    (.put mat 0 0 bytes)
    mat))


(defn matrix-to-mat-of-double [matrix]
  (let [flat (flatten matrix)
        rows (count matrix)
        cols (count (first matrix))
        mat (cv/new-mat rows cols cv/CV_64F)
        total (.total mat)
        bytes (double-array total)]
    (doseq [^int i (range 0 total)]
      (aset-double bytes i (nth flat i)))
    (.put mat 0 0 bytes)
    mat))

(defn scalar->bytes [s]
  (byte-array (take 3 (.val s))))

(defn scalar-matrix-to-mat [matrix]
  (let [row (count matrix) col (count (first matrix)) b (cv/new-mat row col cv/CV_8UC3)]
    (for [i row j col]
      (.put b i j (scalar->bytes (nth (nth matrix i) j))))
    b))

(defn mat-from [src]
  (Mat. (.rows src) (.cols src) (.type src)))

(defn mat-to-buffered-image [src]
  (let [matOfBytes (MatOfByte.)]
    (Imgcodecs/imencode ".jpg" src matOfBytes)
    (ImageIO/read
     (java.io.ByteArrayInputStream. (.toArray matOfBytes)))))
(def >>> mat-to-buffered-image)

; merge with above
(defn mat-to-array-png [src]
  (let [matOfBytes (org.opencv.core.MatOfByte.)]
    (org.opencv.imgcodecs.Imgcodecs/imencode ".png" src matOfBytes)
    (.toArray matOfBytes)))
(def >png mat-to-array-png)

(defn buffered-image-to-mat [bi]
  ; (javax.imageio.ImageIO/write bi "jpg"  (clojure.java.io/file "target/debug.jpg")) 
  (let [nbio (java.awt.image.BufferedImage. (.getWidth bi) (.getHeight bi) java.awt.image.BufferedImage/TYPE_3BYTE_BGR)
        _ (-> nbio (.getGraphics) (.drawImage bi 0 0 nil))
        mat (org.opencv.core.Mat. (.getHeight bi) (.getWidth bi) (org.opencv.core.CvType/CV_8UC3))
          ; buffer (cast java.awt.image.DataBufferByte (.getDataBuffer (.getRaster nbio)))
        buffer (.getDataBuffer (.getRaster nbio))
        bytes  (-> buffer (.getData))]
    (cv/>> mat bytes)))
(def <<< buffered-image-to-mat)

; points
(defn middle-of-two-points [p1 p2]
  (cv/new-point
   (/ (+ (.-x p1) (.-x p2)) 2)
   (/ (+ (.-y p1) (.-y p2)) 2)))

(defn bytes-to-mat! [mat bytes]
  (.put mat 0 0 bytes);
  mat)

(defn mat-to-bytes [mat]
  (let [bytes (byte-array (* (.total mat) (.channels mat)))]
    (.get mat 0 0 bytes)
    bytes))

(defn pixel-map!
  "Applies a function to each pixel. Very slow."
  [im fn_]
  (let [buffer (cv/->bytes im)
        pixels (partition 3 buffer)]
    (->> pixels
         (map fn_)
         (flatten)
         (byte-array)
         (.put im 0 0))
    im))

(defn center-of-rect [rect]
  (middle-of-two-points (.tl rect) (.br rect)))

(defn distance-of-two-points [p1 p2]
  (let [xd (- (.x p1) (.x p2)) yd (- (.y p1) (.y p2))]
    (Math/sqrt (+ (Math/pow xd 2) (Math/pow yd 2)))))

(defn image-from-url [url]
  (let [connection (->  url
                        (java.net.URL.)
                        (.openConnection))]
    (.setRequestProperty connection
                         "User-Agent"
                         "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
    (ImageIO/read (.getInputStream connection))))

(defn mat-from-url2 [url option]
  (let [tmp-file (File/createTempFile "temp-image" ".tmp")
        fos (FileOutputStream. tmp-file)
        url (URL. url)
        connection (.openConnection url)]
    (.setRequestProperty connection
                         "User-Agent"
                         "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
    (.transferFrom
     (.getChannel fos)
     (Channels/newChannel (.getInputStream connection))
     0 Long/MAX_VALUE)
    (.close fos)
    (.disconnect connection)
    (cv/imread (.getAbsolutePath tmp-file) option)))


(defn mat-from-url
  ([url]
   (buffered-image-to-mat (image-from-url url)))
  ([url option]
   (mat-from-url2 url option)))

(defn annotate! [mat text]
  (cv/put-text! mat
               text (cv/new-point 100 100) cv/FONT_HERSHEY_PLAIN 1 (cv/new-scalar 255 0 0) 1))

;;;
; CONTOURS
;;;
(defn draw-contours-with-rect!
  ([buffer contours] (draw-contours-with-rect! buffer contours false))
  ([buffer contours save-frame]
   (doseq [c contours]
     (let [area (cv/contour-area c)]
       (if (> area 1000)
         (let [rect (cv/bounding-rect c)]
           (if save-frame (cv/imwrite (.submat buffer rect) (str "video/" (java.util.Date.) ".png")))
           (cv/rectangle
            buffer
            (cv/new-point (.x rect) (.y rect))
            (cv/new-point (+ (.width rect) (.x rect)) (+ (.y rect) (.height rect)))
            (cv/new-scalar 255 0 0) 3))))
     buffer)))

(defn draw-contours-with-line! [img contours]
  (dotimes [i (.size contours)]
    (let [c (.get contours i)
          m2f (cv/new-matofpoint2f (.toArray c))
          len (cv/arc-length m2f true)
          ret (cv/new-matofpoint2f)
          approx (cv/approx-poly-dp m2f ret (* 0.005 len) true)
          nb-sides (.size (.toList ret))]
; (println ">" nb-sides)
      (cv/draw-contours img contours i
                        (condp = nb-sides
                          3  (cv/new-scalar 56.09 68.05 66.27)
                          4  (cv/new-scalar 356.09 51.57 43.73)
                          7  (cv/new-scalar 26.09 51.57 43.73)
                          8  (cv/new-scalar 146.09 51.57 43.73)
                          9  (cv/new-scalar 266.09 51.57 43.73)
                          10 (cv/new-scalar 236.09 51.57 43.73)
                          11 (cv/new-scalar 206.09 68.05 66.27)
                          12 (cv/new-scalar 0 0 255)
                          (cv/new-scalar 127 50 0))
                        -1)))
  img)

;;;
;;; SIZING
;;;
(defn resize-keep-ratio! [mat w h]
  (if (or (zero? w) (zero? h))
    mat
    (let [mh (.height mat)
          mw (.width mat)
          fh (double (/ h mh))
          fw (double (/ w mw))
          ff (Math/min fh fw)
          nw (* ff mw)
          nh (* ff mh)]
      (cv/resize! mat (cv/new-size nw nh)))))

(defn resize-to-fullscreen!
  ([mat] (resize-to-fullscreen! mat true))
  ([mat keep-ratio]
   (let [screen-size (.getScreenSize (java.awt.Toolkit/getDefaultToolkit))
         h (.height screen-size)
         w (.width screen-size)]
     (if keep-ratio
       (resize-keep-ratio! mat w h)
       (cv/resize! mat (cv/new-size w h))))))

;;;
; SWING
;;;
(defn- toggle-fs
  ; ([window mat]
  ;  (toggle-fs window)
  ;  (cv/resize! mat (cv/new-size (.getWidth (.getSize window)) (.getHeight (.getSize window)))))
  ([frame]
   (let [pane (.getContentPane frame)
         dsd   (->
                (java.awt.GraphicsEnvironment/getLocalGraphicsEnvironment)
                (.getDefaultScreenDevice))]
     (if (.getClientProperty pane "fullscreen")
       (do
         (.putClientProperty pane "fullscreen" nil)
         (.setFullScreenWindow dsd nil))
       (do
         (.putClientProperty pane "fullscreen" true)
         (.setFullScreenWindow dsd frame)
         (.setVisible frame true) )))))

(defn re-show [mat pane]
  (let [image (.getIcon (first (.getComponents pane)))]
    (if (not (nil? mat))
      (do
      (.setImage image (mat-to-buffered-image mat))
      (doto pane
        (.revalidate)
        (.repaint))))))

(defn screenshot[label options]
  (let [out (str (-> options :frame :title) "_" (System/currentTimeMillis) ".png") file (io/as-file out)]
  (ImageIO/write
    (.getImage (.getIcon label))
    "png" file )
  (println "Written:" out)
  ))

(defn delayed-execution [f delay-ms]
  (future
    (Thread/sleep delay-ms)
    (f)))

(defn show
  ([src] (show src {}))
  ([src _options]
   (let [options (merge-with merge {:frame {:color "00" :title "origami" :width 400 :height 400}} _options)
         is-atom? (= (class src) clojure.lang.Atom)
         buf (if is-atom? (mat-to-buffered-image @src) (mat-to-buffered-image src))
         frame (JFrame. (-> options :frame :title))
         pane (.getContentPane frame)
         image (ImageIcon. buf)
         label (JLabel. image)
         history (cv/new-arraylist)
         get-src (fn [] (buffered-image-to-mat (.getImage  (.getIcon (first (.getComponents pane))))))]
     (println options)
     (doto pane
       (.setOpaque true)
       (.setPreferredSize (java.awt.Dimension. (-> options :frame :width)  (-> options :frame :height)))
       (.setBackground (java.awt.Color/decode (-> options :frame :color)))
       (.setLayout (FlowLayout.))
       (.add label))
     (.addComponentListener frame
       (proxy [ComponentListener] []
         (componentShown [event])
         (componentMoved [event])
         (componentResized [event]
           (re-show (cv/resize! (-> src cv/clone) (cv/new-size (.getWidth frame) (.getHeight frame))) pane ))))
     (.addKeyListener frame
                      (proxy [KeyListener] []
                        (keyTyped [event])
                        (keyReleased [event])
                        (keyPressed [event]
                          (let [c (.getKeyChar event) handler (-> options :handlers (get c))]
          ;(println c ">" handler)
                            (if (not (nil? handler))
                              (re-show (handler (get-src) pane)))
                            (condp = (str c)
                              " " (if (.getClientProperty pane "paused")
                                    (.putClientProperty pane "paused" false)
                                    (.putClientProperty pane "paused" true))
                              "b" (dotimes [i 10]
                                    (delayed-execution #(screenshot label options) (* i 1000)))
                              "s" (screenshot label options)
                              "f" (toggle-fs frame)
                              "t" (delayed-execution #(screenshot label options) 5000)
                              "q" (do (.putClientProperty pane "quit" true) (.dispose frame))
                              (do))))))
     (.addMouseListener label
                        (proxy [MouseAdapter] []
                          (mousePressed [event])))
     (if is-atom?
       (add-watch src :cat
                  (fn [key ref old new-s]
                    (if (empty? history) (.add history old))
                    (.add history new-s)
                    (re-show @src pane))))
     (doto frame
       (.setPreferredSize (java.awt.Dimension. (-> options :frame :width)  (-> options :frame :height)))
       (.setVisible true)
       (.pack)
       (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE))
     (if (-> options :frame :fullscreen)  (toggle-fs frame))
     pane)))
(def imshow show)


(defn take-one-mat[cam]
  (let[ capture (vid/capture-device cam) target (cv/new-mat)]
    (.read capture target)
    (.release capture)
    target))
(def <cam take-one-mat)

(defn take-one[cam output]
  (let [target (<cam cam)]
    (cv/imwrite target output)
    (println "One shot:" output " > " target)
    target))


(defn long-exposure[cam output frames lag]
  (let[ capture (vid/capture-device cam) target (cv/new-mat) acc (atom nil)]
    (dotimes [_ frames]
      (.read capture target)
      (if (nil? @acc)
        (reset! acc (cv/new-mat (cv/size target) CvType/CV_32FC3)))
      (cv/convert-to target target CvType/CV_32FC3)
      (cv/add! @acc target)
      (Thread/sleep lag))

    (.release capture)
    (cv/normalize! @acc 0 255 cv/NORM_MINMAX)
    (cv/convert-to! @acc CvType/CV_8UC3)

    (cv/imwrite @acc output)
    (println "Long exposure:" output " > " @acc)
    @acc
    ))

(defn script-helper[script-file]
  (let [
        file (clojure.java.io/as-file script-file)
        parent (.getParent file)
        file-name (str/replace (.getName file) #"\.[^.]*$" "")
        help-file (str  parent "/" file-name ".md")
        ]
    {:file file :parent parent :file-name file-name :help-file help-file}
  ))

(defn print-help[script-file summary]
  (let [{:keys [file parent file-name help-file]} (script-helper script-file)]
  (println (slurp help-file) "\n\n")
  (println "Usage: " (.getName file))
  (println summary)))

(defn on-shutdown[fn]
  (.addShutdownHook (Runtime/getRuntime) (Thread. fn)))

(def DEFAULTS {:frame {:fps false :color "00" :title "video" :width 400 :height 400} :video {:device 0}})

(defn- load-video-fn[_myvideofn]
  (try
  (cond
    (string? _myvideofn) (f/s->fn-filter _myvideofn)
    ;(instance? origami.Filter _myvideofn) (java-filter _myvideofn)
    (fn? _myvideofn) _myvideofn
    (vector? _myvideofn) (apply comp (into [] _myvideofn))
    :else
    ; try anyway
    ;_myvideofn
    identity
    )
  (catch Exception e
    (println "loading of video fn" _myvideofn " failed with:" e)
    identity)))

(defn- wrap-load-video-fn [_myvideofn]
  (let [a (if (instance? clojure.lang.Atom _myvideofn)
            _myvideofn
            (atom (load-video-fn _myvideofn)))]
    (if (string? _myvideofn)
      (let [___f (clojure.java.io/as-file _myvideofn) ___p (.getParent ___f)]
        (if (.exists ___f )
          (do (println "Watching " ___p)
              (beholder/watch #(do (println %) (reset! a (load-video-fn _myvideofn))) ___p))))
      )
    a))

(defn simple-cam-window
  ([] (simple-cam-window {} identity))
  ([myvideofn] (simple-cam-window {} myvideofn))
  ([_options _myvideofn]
   (let [__options (if (string? _options)
                       (if (.exists (io/as-file _options))
                          (read-string (slurp _options))
                          (read-string _options))
                       _options
                       )
         options (cond
                   (and (map? __options) (contains? __options :video))
                     (merge-with merge DEFAULTS __options)
                   (int? (try (Integer/parseInt __options) (catch Exception e false)))
                     (merge-with merge DEFAULTS {:video {:device (read-string __options)}})
                   :default
                     (merge-with merge DEFAULTS {:video __options})
                   )
         capture (vid/capture-device (-> options :video))
         window (show (cv/new-mat (-> options :frame :width) (-> options :frame :height)   cv/CV_8UC3 (cv/new-scalar 255 255 255)) options)
         buffer (cv/new-mat)
         start (System/currentTimeMillis)
         myvideofn (wrap-load-video-fn _myvideofn)
         ]

     (.start (Thread.
              (fn []
                (while (nil? (.getClientProperty window "quit"))
                  (if (.read capture buffer)
                    (if (not (.getClientProperty window "paused"))
                      (re-show (-> buffer
                                  ;;  cv/clone
                                   ((fn [mat]
                                      (cv/resize! mat (cv/new-size (.getWidth (.getSize window)) (.getHeight (.getSize window))))))
                                   ((fn[mat] (try (@myvideofn mat) (catch Exception e mat))))
                                   )
                               window))))
                ; TODO: clean watcher
                (.release capture)))))))

(defn start-cam-thread [window device-map buffer-atom]
  (.start (Thread.
           (fn []
             (println ">> Starting: " (-> device-map :device) " << ")
             (let [buffer (cv/new-mat) capture (vid/capture-device device-map) _fn (load-video-fn (-> device-map :fn)) ]
               (while (nil? (.getClientProperty window "quit"))
                 (if (.read capture buffer)
                   (if (not (.getClientProperty window "paused"))
                     (reset! buffer-atom (_fn (cv/clone buffer))))))
               (.release capture))))))

(defn cams-window [_options]
  (let [options        (merge-with merge {:frame {:color "00" :title "video"}} _options)
        showing         (nil? (-> options :frame :hide))
        devices        (-> options :devices)
        ; devices-count  (count devices)
        buffer-atoms   (into [] (map (fn [_] (atom (cv/new-mat))) devices))
        window         (show (cv/new-mat 100 100 cv/CV_8UC3 (cv/new-scalar 0 0 0)) options)
        ; output         (cv/new-mat)
        outputVideo     (vid/new-videowriter)
        recording       (-> options :video :recording)
        render-fn (f/s->render (-> options :video :fn))
        ]
    (doall
     (map #(start-cam-thread window %2 (get buffer-atoms %1)) (range) devices))

    (if (not (nil? recording))
      (do
        (println "Recording Mode")
        (.open
         outputVideo
         (get-in recording [:output] "opencv4.avi")
         1196444237
         (get-in recording [:frame-rate] 30)
         (cv/new-size (get-in recording [:width] 400) (get-in recording [:height] 300)))))

    (.start (Thread.
             (fn []
               (while (nil? (.getClientProperty window "quit"))
                 (if (not (.getClientProperty window "paused"))
                   (do
                     (if (= (count (filter #(= % 0)  (map #(.cols (deref %)) buffer-atoms))) 0)
                       (let [output (.apply render-fn (into-array Mat (map deref buffer-atoms)))]
                         ; TODO: check an option before resizing ?
                         (cv/resize! output (cv/new-size (.getWidth (.getSize window)) (.getHeight (.getSize window))))
                         (if showing (re-show output window))
                         (if (not (nil? recording))
                           (.write outputVideo
                                   (->
                                    output
                                    (cv/clone)
                                    (cv/resize!
                                     (cv/new-size (get-in recording [:width] 400) (get-in recording [:height] 300)))))))))))

               (.release outputVideo))))))
