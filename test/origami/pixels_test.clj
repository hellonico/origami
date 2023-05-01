(ns origami.pixels-test
  (:require
    [opencv4.utils :as u]
    [clojure.pprint]
    [opencv4.colors.rgb :as rgb]
    [clojure.test :refer :all]
    [opencv4.core :as cv]))

(deftest blue-signed
  (let [m (cv/new-mat 1 1 cv/CV_8SC3 rgb/blue)]
    (is (= [[127 0 0]] (cv/->string m)))))

(deftest blue-signed-map!
  (let [myt (fn [[b g r]] [(- b 100) g r])
        m (cv/new-mat 1 1 cv/CV_8SC3 rgb/blue)]
    (is (=
          [[27 0 0]]
          (cv/->string (u/pixel-map! m myt))))))

(deftest blue-signed-map!
  (let [myt (fn [[b g r]] [(max -127 (- b 300)) g r])
        m (cv/new-mat 1 1 cv/CV_8SC3 rgb/blue)]
    (is (=
          [[-127 0 0]]
          (cv/->string (u/pixel-map! m myt))))))

(deftest blue-unsigned-map!
  (let [myt (fn [[b g r]] [(max 0 (- b 300)) g r])
        m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)]
    (is (=
          [[0 0 0]]
          (cv/->string (u/pixel-map! m myt))))))

(deftest blue-unsigned
  (let [m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)]
    (is (= [[255 0 0]] (cv/->string m)))))

(deftest splitting
  (let [m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)
        splitted (cv/split! m)]
    (is (= 3 (count splitted)))
    ; check blue comes first
    (is (= [[255]] (cv/->string (first splitted))))
    (is (= [[0]] (cv/->string (second splitted))))
    (is (= [[0]] (cv/->string (last splitted))))
    (is (=
          (cv/->string (cv/merge! splitted))
          (cv/->string m)))))

(deftest blue-and-add-unsigned
  (let [m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)]
    (is (= [[255 0 0]] (-> m cv/->string)))
    (is (= [[255 10 10]]
           (-> m
               (cv/add! (cv/new-scalar 0 10 10))
               (cv/->string))))))

(deftest blue-and-add-with-max
  (let [m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)]
    (is (= [[255 0 0]]
           (-> m
               (cv/add! (cv/new-scalar 10 0 0))
               (cv/->string))))))

(deftest blue-and-add-with-min
  (let [m (cv/new-mat 1 1 cv/CV_8UC3 rgb/blue)]
    (is (= [[255 0 0]]
           (-> m
               (cv/add! (cv/new-scalar 0 -10 -10))
               (cv/->string))))))

(deftest blue-picture
  (-> "doc/lena.png"
      (cv/imread)
      (cv/add! (cv/new-scalar 100 0 0))
      (cv/imwrite "target/bluelena.png")))

(deftest merge-test
  (let [expected (cv/new-mat 1 1 opencv4.core/CV_8UC3 (cv/new-scalar 0 0 0))
        one (cv/new-matofbyte (byte-array [0]))
        merged (cv/merge! [one one one])]
    (is (= (cv/->string expected) (cv/->string merged)))))

(deftest flipping-test
  (let [m (cv/new-mat 2 2 cv/CV_8UC3 rgb/black)]
    (.put m 0 0 (byte-array [0 255 0]))
    (is (= (cv/->string m)
           [[0 255 0 0 0 0]
            [0 0 0 0 0 0]]))
    (cv/flip! m 1)
    (is (= (cv/->string m)
           [[0 0 0 0 255 0]
            [0 0 0 0 0 0]]))
    (cv/flip! m -1)
    (is (= (cv/->string m)
           [[0 0 0 0 0 0]
            [0 255 0 0 0 0]]))
    (cv/flip! m 0)
    (is (= (cv/->string m)
           [[0 255 0 0 0 0]
            [0 0 0 0 0 0]]))))