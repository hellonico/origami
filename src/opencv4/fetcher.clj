(ns opencv4.fetcher
  (:gen-class
    :direct-linking true
;    :disable-locals-clearing true
    :name origami.Fetcher
    :methods [#^{:static true} [fetchFromSpec [String] String]])
  (:require [opencv4.core :refer [min-max-loc new-size new-scalar imread imwrite]]
            [clojure.java.io :as io]
            [clojure.string :as s])
  (:import (java.io File)))

(defn find-first-file [files ext]
  (let [f (->> files
               (filter #(= ext (last (s/split (.getName %) #"\."))))
               (first)
               (str))]
    ;  (println "Found: [" ext " ] > " f " < ")
    f))

(defn copy-uri-to-file [uri file]
  (with-open [in (clojure.java.io/input-stream uri)
              out (clojure.java.io/output-stream file)]
    (clojure.java.io/copy in out)))

(defn extra-download [_url]
  (let [folder (.getParent _url)
        uri (s/trim (slurp _url))
        target-local-file (str folder "/" (subs uri (inc (s/last-index-of uri "/"))))]
    (println "Extra Download:" uri)
    (println "From:" uri )
    (println "To:" target-local-file)
    (copy-uri-to-file uri target-local-file)
    (println " [done]")
    (.delete _url)
    (io/as-file target-local-file)))

(defn extra-downloads [files]
  (let [filtered (filter #(s/includes? (.getName %) "url") files)]
    (apply conj files (map extra-download filtered) )))


(defn folder-contains[files_ ext]
  (not
    (empty? (->> files_
                 (filter #(s/includes?  (.getName %) ext ))))))

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

(defn fetch-from-spec [spec]
  (let [repo (or (System/getProperty "networks.repo") "https://repository.hellonico.info/repository/hellonico/")
        [group art version] (clojure.string/split spec #":")
        [cat-type type_] (clojure.string/split group #"\.")
        uri (str repo cat-type "/" type_ "/" art "/" version "/" art "-" version ".zip")
        folder (fetch uri)
        ]
    folder))

(defn -fetchFromSpec [ spec]
  (fetch-from-spec spec))

