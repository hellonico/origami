(ns origami.video-test
  (:require
    [clojure.test :refer :all]
    [opencv4.utils :as u]
    [opencv4.core :refer :all])
  (:import
    [org.opencv.videoio VideoWriter]))

(deftest simple-cam-test

  (u/simple-cam-window
    {:frame {:fps true} :video {:device  0}}
    (fn [buffer] buffer))

  ; (Thread/sleep 10000)
  )

(deftest video-test

  (.delete (clojure.java.io/as-file "target/hello.avi"))
  (let [outputVideo (VideoWriter.)]

    (is (.open
          outputVideo
          "target/hello.avi"
          (VideoWriter/fourcc \M \J \P \G)
          12
          (new-size 300 400)))

    (doseq [_ (range 0 120)]
      (.write outputVideo (new-mat 400 300 CV_8UC3 (new-scalar 0 0 255))))
    (doseq [_ (range 0 120)]
      (.write outputVideo (new-mat 400 300 CV_8UC3 (new-scalar 255 0 0))))
    (.release outputVideo)

    )

  (let [v (new-videocapture) buffer (new-mat)]
    (.open v "target/hello.avi")
    (.read v buffer)
    (imwrite buffer "target/red.png"))

  (is (.exists (clojure.java.io/as-file "target/red.png")))

  )