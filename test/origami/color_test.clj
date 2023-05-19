(ns origami.color-test
  (:require
    [opencv4.colors.html :as html]
    [clojure.test :refer :all]))

(deftest bytes-round-trip
  (testing "Colors"
    (doseq [c ["#F51515" "#F51510" "#F51501" ]]
    (let [sc (html/->scalar c)]
      (is (= (html/->html sc) c))))))
