(ns opencv4.dnn.core
  (:gen-class
    :name origami.Dnn
    :methods [
              #^{:static true} [readNetFromSpec [String] java.util.List]])
  (:require [opencv4.core :refer [min-max-loc new-size new-scalar imread imwrite]]
            [opencv4.dnn :as dnn]
            [clojure.java.io :as io]
            [clojure.string :as s])
  (:import (java.io File)))

(defn- find-first-file [files ext]
  (let [f (->> files
               (filter #(= ext (last (s/split (.getName %) #"\."))))
               (first)
               (str))]
    ;  (println "Found: [" ext " ] > " f " < ")
    f))

(defn- folder-contains[files_ ext]
  (not
    (empty? (->> files_
                 (filter #(s/includes?  (.getName %) ext ))))))

(defn- guess-network-type [files]
  (cond
    (folder-contains files "caffemodel") :caffe
    (folder-contains files "pbtxt")      :tensorflow
    (folder-contains files "weights")    :yolo
    :else :unknown ))

(defn- load-labels [files]
  (let [l (find-first-file files "labels" )
        _labels (cond  (= "" l) (find-first-file files "names") :else l ) 
        labels (cond  (= "" _labels) (find-first-file files "txt") :else l ) 
        ]
    ; (println "Loading labels:" labels)
    ; (println (map #(.getName %) files))
    (line-seq (io/reader labels))))

; [ net opts names]
(defn- read-net-from-files [files]
  (let [
  						; _ (println files)
        _type (guess-network-type files)
        net (condp = _type
              :caffe  (dnn/read-net-from-caffe (find-first-file files "prototxt") (find-first-file files "caffemodel"))
              :yolo (dnn/read-net-from-darknet (find-first-file files "cfg") (find-first-file files "weights"))
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

(defn get-tmp-folder [uri]
  (str
    (or (System/getProperty "networks.local") (str (System/getProperty "user.home") File/separator ".origami"))
    "/" (last (s/split uri #"/"))  ))

(defn fetch [uri]
  (let [folder (get-tmp-folder uri)]
    (if (not (.exists (io/as-file folder)))
      (with-open [in (java.util.zip.ZipInputStream. (io/input-stream uri))]
        (println "Extracting [" uri "] > " [folder])
        (loop [entry (.getNextEntry in)]
          (if (not (nil? entry))
            (let [
                  path (str folder "/" (.getName entry))
                  f (io/file path)
                  parent (.getParentFile f)
                  ]
              (println ">" (.getName entry))
              (.mkdirs parent)
              (if (not (.isDirectory entry)) (io/copy in f))
              (recur (.getNextEntry in)))))))
    folder))

(defn read-net-from-uri
  [uri]
  (let [ folder (fetch uri)]
    (read-net-from-folder folder)))

; spec is something like
; networks.caffe:mobilenet:1.0.0
(defn read-net-from-repo [ spec ]
  (let [repo (or (System/getProperty "networks.repo") "https://repository.hellonico.info/repository/hellonico/")
        [group art version] (clojure.string/split spec #":")
        type_ (second (clojure.string/split group #"\."))
        uri (str repo "networks/" type_ "/" art "/" version "/" art "-" version ".zip")
        ]
    (println "Loading network: [" type_ "]:" spec )
    (read-net-from-uri uri)))

(defn -readNetFromSpec [ spec]
  (read-net-from-repo spec))
;
;(defn -main[ & args]
;  (println (slurp "README.md")))
