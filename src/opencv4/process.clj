(ns opencv4.process
    (:require
      [clojure.java.io :as io] 
      [clojure.string :as s]))

(defn parallel 
    ([folder out myfn] (parallel folder out myfn "jpg"))
    ([folder out myfn ext] 
    (let [_myfn (partial myfn out)]
    (.mkdirs (io/as-file out))

    (->> folder
        (io/as-file)
        (.listFiles)
        (filter #(s/includes? (s/lower-case (.getName %)) ext))
        (pmap #(.getAbsolutePath %))
        (pmap _myfn)
        (doall))

    (shutdown-agents))))

(defn sequential 
    ([folder out myfn] (sequential folder out myfn "jpg"))
    ([folder out myfn ext] 
    (let [_myfn (partial myfn out)]
    (.mkdirs (io/as-file out))

    (->> folder
        (io/as-file)
        (.listFiles)
        (filter #(s/includes? (s/lower-case (.getName %)) ext))
        (map #(.getAbsolutePath %))
        (map _myfn)
        (doall)))))