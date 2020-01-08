(ns origami.bi-test
  (:require
    [opencv4.utils :as u]
    [clojure.test :refer :all]
    [opencv4.core :as cv])
  (:import (org.opencv.core Mat)))

(deftest a-test
  (testing "Cat in bowl."
  (let [
  	img ^Mat (-> "doc/cat_in_bowl.jpeg" (cv/imread))
  	looped ^Mat (-> img (u/>>>) (u/<<<))
  	]
  (is 
  	(= (.height img) (.height looped))
  	(= (.width img) (.width looped))))))
