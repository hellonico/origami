(ns origami.core-test
  (:require
    [opencv4.utils :as u]
    [clojure.test :refer :all]
    [opencv4.core :refer [COLOR_RGB2GRAY imread vconcat! set-to! mean cvt-color! canny! bitwise-not! imwrite]]))

(deftest a-test
  (testing "Cat in bowl."
  (is (not (nil?
  (->
   (imread "doc/cat_in_bowl.jpeg")
   (cvt-color! COLOR_RGB2GRAY)
   (canny! 300.0 100.0 3 true)
   (bitwise-not!)
   (u/resize-by 0.5)
   (imwrite "target/canny-cat.jpg"))

    )))))

(defn- show-average[img]
  (let[
  source  (-> img imread (u/resize-by 0.25))
  avg-mat (-> source (u/mat-from) (set-to! (mean source)))]

  (-> [source avg-mat]
      (vconcat!)
      (imwrite "target/average_cat.jpg"))))

(deftest b-test
  (testing "average"
  (is (not (nil?  (show-average "doc/cat_in_bowl.jpeg"))))))