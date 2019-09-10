(ns origami.process-test
    (:require
      [opencv4.utils :as u]
      [opencv4.process :as p]
      [opencv4.colors.rgb :as rgb]
      [clojure.test :refer :all]
      [clojure.java.io :as io]
      [opencv4.core :as cv]))

(defn- black-white [out in]
    (-> in
        (cv/imread cv/CV_8UC1)
        (cv/imwrite (str out "/bw_" (.getName (io/as-file in))))))

(deftest folder-sequential
    (p/sequential 
        "doc" 
        "target/doc" 
        black-white))

(deftest folder-parallel
    (p/parallel 
        "doc" 
        "target/doc" 
        black-white))