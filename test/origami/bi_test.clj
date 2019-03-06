(ns origami.bi-test
  (:require
    [opencv4.utils :as u]
    [clojure.test :refer :all]
    [opencv4.core :as cv]))

(deftest a-test
  (testing "Cat in bowl."
  (let [
  	img 	(-> "doc/cat_in_bowl.jpeg" (cv/imread))
  	looped  (-> img (u/>>>) (u/<<<))
  	]
  (is 
  	(= (.height img) (.height looped))
  	(= (.width img) (.width looped))))))
