(ns origami.resize-test
  (:require
   [opencv4.utils :as u]
   [clojure.test :refer :all]
   [opencv4.core :as cv]))

(def img (cv/imread "doc/lena.png"))
(def _size (cv/size img))

(deftest resize-keep-ratio-smaller
  (let [c (cv/clone img)]
    (is (= (cv/new-size 250 250) (cv/size (u/resize-keep-ratio! img 250 250))))))

(deftest resize-keep-ratio-bigger
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! img 600 600))))))

(deftest resize-keep-ratio-width-greater
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! img 800 600))))))

(deftest resize-keep-ratio-height-greater
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! img 600 800))))))

(deftest resize-keep-ratio-zero
  (let [c (cv/clone img)]
    (is (= _size (cv/size (u/resize-keep-ratio! img 0 0))))))