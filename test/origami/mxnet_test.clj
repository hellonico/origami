(ns origami.mxnet-test
    (:require
     [opencv4.utils :as cvu]
     [opencv4.mxnet :as cvn]
     [opencv4.colors.rgb :as rgb]
     [org.apache.clojure-mxnet.image :as mx-img]
     [clojure.test :refer :all]
     [opencv4.core :as cv]))

(deftest chouffe-test-failing
    (->  "doc/book.jpg"
        (mx-img/read-image {:to-rgb true}) ;; NDArray a this point
        mx-img/to-image ;; BufferedImage at this point, but 
        cvu/buffered-image-to-mat ;; Fails to convert to `Mat`...
        (cv/imwrite "target/bookfailing.jpg")))

(deftest chouffe-test
    (-> "doc/book.jpg"
        (mx-img/read-image {:to-rgb false})
        (cvn/ndarray-to-mat)
        (cv/imwrite "target/book.jpg")))
