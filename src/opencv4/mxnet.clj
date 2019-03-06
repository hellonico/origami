(ns opencv4.mxnet
       (:require
    [org.apache.clojure-mxnet.ndarray :as ndarray]
     [org.apache.clojure-mxnet.shape :as mx-shape]
     [opencv4.core :as cv]))

(defn ndarray-to-mat [img]
    (let [ 
        shape (-> img (mx-shape/->vec)) 
        [h w _ _] (mx-shape/->vec (ndarray/shape img))
        bytes (byte-array shape)
        mat (cv/new-mat h w cv/CV_8UC3)]
    (.put mat 0 0 bytes)
    mat))