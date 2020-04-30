(ns origami.filter-test
  (:require
    [opencv4.utils :as u]
    [opencv4.filter :as f]
    [clojure.test :refer :all]
    [opencv4.core :as cv]))

(def img (cv/imread "doc/lena.png"))
(deftest from-string-with-map
    (let [fop (f/s->fn-filter "{:class origami.filters.NoOPFilter}")]
      (is (not (nil? (fop img))))))

(deftest from-string-with-array
    (let [fop (f/s->fn-filter "[{:class origami.filters.NoOPFilter}{:class origami.filters.NoOPFilter}]")]
      (is (not (nil? (fop img))))))

(deftest from-clojure-map
    (let [fop (f/s->fn-filter {:class origami.filters.NoOPFilter})]
      (is (not (nil? (fop img))))))

(deftest from-clojure-array
  (let [fop (f/s->fn-filter [{:class origami.filters.NoOPFilter}{:class origami.filters.NoOPFilter}])]
    (is (not (nil? (fop img))))))

(deftest from-file-with-map
  (let [fop (f/s->fn-filter "dev/filter_1.edn")]
    (is (not (nil? (fop img))))))

(deftest from-file-with-array
  (let [fop (f/s->fn-filter "dev/filter_2.edn")]
    (is (not (nil? (fop img))))))