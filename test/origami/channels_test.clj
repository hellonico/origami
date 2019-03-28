(ns origami.channels-test
  (:require
    [opencv4.utils :as u]
    [clojure.pprint]
    [opencv4.colors.rgb :as rgb]
    [clojure.test :refer :all]
    [opencv4.core :as cv]))


(deftest multiply
	(let [m (cv/new-mat 2 2 cv/CV_8UC3 (cv/new-scalar 10 20 30))]
	 (cv/multiply! m (u/matrix-to-mat-of-double [[1.0 0.0 0.0]]))
	 (is (= (cv/->string m)
        [[10 0 0 10 0 0]
         [10 0 0 10 0 0]]))))

(deftest divide
	(let [m (cv/new-mat 2 2 cv/CV_8UC3 (cv/new-scalar 10 20 30))]
	 (cv/multiply! m (u/matrix-to-mat-of-double [[1/5 1/10 1/30]]))
	 (is (= (cv/->string m)
        [[2 2 1 2 2 1]
         [2 2 1 2 2 1]]))))

(deftest divide-bikkuri 
		(let [m (cv/new-mat 2 2 cv/CV_8UC3 (cv/new-scalar 10 20 30))]
	 (cv/divide! m (cv/new-scalar 10.0 20.0 30.0))
	 (is (= (cv/->string m)
        [[1 1 1 1 1 1]
         [1 1 1 1 1 1]]))))

(deftest transform
	 (let [m (cv/new-mat 2 2 cv/CV_8UC3 (cv/new-scalar 1 2 3))]
		
		(cv/transform! m (u/matrix-to-mat [[4 0 0]
                                     [1 1 0]
                                     [0 0 2]]))
	(is (= (cv/->string m)
        [[4 3 6 4 3 6]
         [4 3 6 4 3 6]]))))

(deftest pixel-mapping
 (let [m (cv/new-mat 2 2 cv/CV_8UC3 (cv/new-scalar 1 2 3))]
	(u/pixel-map! m (fn [[r g b]] [ (+ r r) (+ r g b) (* b g)]))
	(is (= (cv/->string m)
         [[2 6 6 2 6 6] 
          [2 6 6 2 6 6]]))))