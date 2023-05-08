(ns opencv4.dnn.core
  (:gen-class
    :direct-linking true
;    :disable-locals-clearing true
    :name origami.Dnn
    :methods [#^{:static true} [readNetFromSpec [String] java.util.List]])
  (:require [clojure.string :as str]
            [opencv4.core :refer [min-max-loc new-size new-scalar]]
            [opencv4.dnn :as dnn]
            [opencv4.fetcher :refer :all]
            [clojure.java.io :as io]))

(defn- guess-network-type [files]
  (cond
    (folder-contains files "caffemodel") :caffe
    (folder-contains files "pbtxt")      :tensorflow
    (folder-contains files "weights")    :yolo
    (folder-contains files "onnx")    :onnx
    :else :unknown ))

(defn- load-labels [files]
  (let [l (find-first-file files "labels" )
        _labels (cond  (= "" l) (find-first-file files "names") :else l )
        labels (cond  (= "" _labels) (find-first-file files "txt") :else _labels )
        ]
    (println "Loading labels:" labels)
    ; (println (map #(.getName %) files))
    (line-seq (io/reader labels))))

; [ net opts names]
(defn- read-net-from-files [files]
  (let [

        files (extra-downloads files)
         ;_ (println files)
        _type (guess-network-type files)
        net (condp = _type
              :caffe  (dnn/read-net-from-caffe (find-first-file files "prototxt") (find-first-file files "caffemodel"))
              :yolo (dnn/read-net-from-darknet (find-first-file files "cfg") (find-first-file files "weights"))
              :onnx (dnn/read-net-from-onnx (find-first-file files "onnx"))
              :tensorflow (dnn/read-net-from-tensorflow  (find-first-file files "pb" ) (find-first-file files "pbtxt"))
              nil)
        ]
    (println "Loaded:" net)
    [  net
     (try (read-string (slurp (find-first-file files "edn"))) (catch Exception e
                                                                ; (println "no option file found")
                                                                ))
     (load-labels files)
     (second files)]))

(defn read-net-from-folder [folder]
  (let [files (file-seq (io/file folder))]
    (read-net-from-files files)))

(defn read-net-from-uri
  [uri]
  (let [ folder (fetch uri)]
    (read-net-from-folder folder)))

; spec is something like
; networks.caffe:mobilenet:1.0.0
(defn read-net-from-repo [ spec ]
  (let [folder (fetch-from-spec spec)]
    (println "Loading network:" spec )
    (read-net-from-folder folder)))
(def read-net-from-spec read-net-from-repo)

(defn -readNetFromSpec [ spec]
  (read-net-from-repo spec))
