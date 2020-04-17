(ns opencv4.vido
  (:use camel-snake-kebab.core)
  (:require [clojure.string :as str]
    [opencv4.video :as vid])
  (:import
    [org.opencv.videoio Videoio VideoWriter VideoCapture]))


(defn- key-to-prop-s [k]
    (let [ks (name k) prop (str "CAP_PROP_" (clojure.string/upper-case (clojure.string/replace ks  "-" "_")))]
    (str "org.opencv.videoio.Videoio/" prop)))

  (defn- key-to-prop [k]
    (eval (key-to-prop-s k)))

;(debug-device (capture-device "cam.edn"))


(defn capture-device [ video ]
  (let [capture (vid/new-videocapture) video-map (if (map? video) video (read-string (slurp video))) ]
      (let [settings (keys (dissoc video-map :device)) ]
        (doseq [s settings]
            (.set capture (eval (symbol (key-to-prop s))) (-> video-map s))))
      (.open capture (-> video-map :device))    
  capture))

(require '[opencv4.core :as cv])
(capture-device {:device 0 :frame-height 400} )



