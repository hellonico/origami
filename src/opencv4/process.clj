(ns opencv4.process
  (:require
   [clojure.java.io :as io]
   [clojure.string :as s]))

(defn list-folder [ext folder]
  (->>   folder
         (io/as-file)
         (.listFiles)
         (filter #(s/includes? (s/lower-case (.getName %)) ext))))

(defn parallel
  ([folder myfn] (parallel folder "." (fn [_ in] (myfn in))))
  ([folder out myfn] (parallel folder out myfn "jpg"))
  ([folder out myfn ext]
   (let [_myfn (partial myfn out)]
     (.mkdirs (io/as-file out))

     (->> (list-folder ext folder)
          (pmap #(.getAbsolutePath %))
          (pmap _myfn)
          (doall))

    ;(shutdown-agents)
     )))

(defn sequential
  ([folder myfn] (sequential folder "." (fn [_ in] (myfn in))))
  ([folder out myfn] (sequential folder out myfn "jpg"))
  ([folder out myfn ext]
   (let [_myfn (partial myfn out)]
     (.mkdirs (io/as-file out))

     (->> (list-folder ext folder)
          (map #(.getAbsolutePath %))
          (map _myfn)
          (doall)))))