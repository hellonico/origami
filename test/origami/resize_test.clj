(ns origami.resize-test
  (:require
    [opencv4.utils :as u]
    [clojure.test :refer :all]
    [opencv4.core :as cv]))

(def img (cv/imread "doc/lena.png"))
(def _size (cv/size img))

(deftest resize-bikkuri
  (let [c (cv/clone img) new-s (cv/new-size 250 250)]
    (is (= new-s (cv/size (cv/resize! c new-s))))))

(deftest resize-keep-ratio-smaller
  (let [c (cv/clone img)]
    (is (= (cv/new-size 250 250) (cv/size (u/resize-keep-ratio! c 250 250))))))

(deftest resize-keep-ratio-bigger
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! c 600 600))))))

(deftest resize-keep-ratio-width-greater
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! c 800 600))))))

(deftest resize-keep-ratio-height-greater
  (let [c (cv/clone img)]
    (is (= (cv/new-size 600 600) (cv/size (u/resize-keep-ratio! c 600 800))))))

(deftest resize-keep-ratio-zero
  (let [c (cv/clone img)]
    (is (= _size (cv/size (u/resize-keep-ratio! c 0 0))))))