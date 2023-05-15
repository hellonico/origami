(ns origami.color-test
  (:require
    [opencv4.colors.html :as html]
    [clojure.test :refer :all]))

(deftest bytes-round-trip
  (testing "Colors"
    (let [c "#F51515" sc  (html/->scalar c)]
      (is (= (html/->html sc) c)))))
