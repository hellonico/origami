(ns origami.bikkuri-test
    (:require
      [opencv4.utils :as u]
      [clojure.test :refer :all]
      [opencv4.core :refer [CV_8UC1 lut! bilateral-filter! ->string new-mat new-scalar merge! new-matofbyte COLOR_RGB2GRAY imread vconcat! set-to! mean cvt-color! canny! bitwise-not! imwrite]]))
  
  (deftest bilateral-test
   (testing "Cat in bowl."
    (-> 
 	 "doc/cat_in_bowl.jpeg"
   	 (imread)
     (bilateral-filter! 10 (* 2 20) (/ 20 2))
     (cvt-color! COLOR_RGB2GRAY)
     (canny! 200.0 100.0 3 true)
     (bitwise-not!))))

(defn lookup-mat [_gamma] 
(let[lut-mat (new-mat 1 256 CV_8UC1) ]
(doseq [i (range 1 256)]  
  (.put lut-mat 0 i (double-array [(int (* 255 (Math/pow (/ i 255) (/ 1 _gamma))) )] )))
   lut-mat))

(deftest lut-test
   (testing "Cat in bowl."
    (-> 
 	 "doc/cat_in_bowl.jpeg"
   	 (imread)
   	 (lut! (lookup-mat 1.2)))))