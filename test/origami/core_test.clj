(ns origami.core-test
  (:require
    [opencv3.utils :as u]
    [clojure.test :refer :all]
    [opencv3.core :refer :all]))



(deftest a-test
  (testing "Cat in bowl."
  (is (not (nil?
  (->
   (imread "doc/cat_in_bowl.jpeg")
   (cvt-color! COLOR_RGB2GRAY)
   (canny! 300.0 100.0 3 true)
   (bitwise-not!)
   (u/resize-by 0.5)
   (imwrite "doc/canny-cat.jpg"))

    )))))
