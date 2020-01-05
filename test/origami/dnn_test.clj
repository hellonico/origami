(ns origami.dnn-test
 (:require 
    [opencv4.core :refer :all]
    [clojure.test :refer :all]
    [opencv4.utils :as u]
    [opencv4.dnn.core :as origami-dnn]))

(defn load-yolo []
(let [[net opts labels] (origami-dnn/read-net-from-repo "networks.yolo:yolov2-tiny:1.0.0")]))

(deftest a-test
  (testing "Loading Yolo."
  (load-yolo)))