(ns origami.ndarray-test
  (:require
   [opencv4.utils :as u]
   [opencv4.colors.rgb :as rgb]
   [org.apache.clojure-mxnet.ndarray :as ndarray]
   [org.apache.clojure-mxnet.shape :as mx-shape]
   [clojure.test :refer :all]
   [opencv4.core :as cv]))

(deftest simple-ndarray
  (let [cvimg (cv/new-mat 1 1 cv/CV_8SC3 rgb/white)
        img (ndarray/array (cv/->bytes cvimg) [1 3 1 1])]
    (is (= (cv/->string cvimg) 
          [[127 127 127]]))
    (is (= [127.0 127.0 127.0] 
          (mx-shape/->vec img)))
    (is (=  [1 3 1 1] 
            (mx-shape/->vec (ndarray/shape img))))))

(deftest cv-ndarray-cv-image
  (let [expected (cv/new-mat 10 10 cv/CV_8SC3 rgb/red-2)
        cvimg (cv/clone expected)
        _ (cv/add! cvimg (cv/new-scalar -103.939 -116.779 -123.68)) ; b g r
        ndarray (ndarray/array (cv/->bytes cvimg) [1 3 10 10])]
    (.put cvimg 0 0 (byte-array (mx-shape/->vec ndarray)))
    (cv/add! cvimg (cv/new-scalar 103.939 116.779 123.68))
    (is (= (cv/->string expected) (cv/->string cvimg) ))))

(deftest pre-post-process-image
  (let [expected (cv/new-mat 3 3 cv/CV_8SC3 rgb/red-2)
        cvimg (cv/clone expected)
        _ (cv/add! cvimg (cv/new-scalar -103.939 -116.779 -123.68)) ; b g r
        nd (-> cvimg
               (cv/->bytes)
               (ndarray/array [1 3 3 3])
               (ndarray/- 10)
               (ndarray/+ 10))]
    (.put cvimg 0 0 (byte-array (mx-shape/->vec nd)))
    (cv/add! cvimg (cv/new-scalar 103.939 116.779 123.68))
    (is (=
         (cv/->string expected)
         (cv/->string cvimg)))))

; TEST FOR:
; actual: org.opencv.core.CvException: cv::Exception: OpenCV(4.0.0) 
; opencv/modules/imgproc/src/box_filter.cpp:1433: error: (-213 
; The function/feature is not implemented) Unsupported combination of source format (=17), 
; and buffer format (=20) in function 'getRowSumFilter'
; 
; just happy to pass the sequence of functions here

(defn- apb "apply gaussian" [mat]
  (cv/gaussian-blur!  mat (cv/new-size 3 3) 21))

(deftest myeyesareblurred
  (let [size 50
        test (cv/new-mat size size cv/CV_8UC3 rgb/red-1-) ; 255
        org (cv/new-mat size size cv/CV_8SC3 (cv/new-scalar 0 0 127)) ;max is 127
        cvimg (cv/clone org)
        ndarray (ndarray/array (cv/->bytes cvimg) [1 3 size size])]
    (apb test)

    (.put cvimg 0 0 (byte-array (mx-shape/->vec ndarray)))
    (cv/convert-to! cvimg cv/CV_8UC3 cv/CV_8UC3)
    (apb cvimg)

    ; source format / buffer format    
    (cv/convert-to! org cv/CV_8UC3 cv/CV_8UC3) 
    (apb org)

    (is (=
         ; 253 after blur
         (cv/->string test) 
         (cv/->string org)
         (cv/->string cvimg)))))

(deftest loop-with-lena
  (let [org (-> "doc/origami.jpg" (cv/imread) )
        img (cv/convert-to! (cv/clone org) cv/CV_8SC3 0.5)
        _ (cv/add! img (cv/new-scalar -103.939 -116.779 -123.68))
        ndarray (ndarray/array (cv/->bytes img) [1 3  (.height img) (.width img)])
        ]
    (.put img 0 0 (byte-array (mx-shape/->vec ndarray)))
    _ (cv/add! img (cv/new-scalar 103.939 116.779 123.68))
    (cv/convert-to! img cv/CV_8UC3 2)
    (cv/imwrite img "target/hello.png")))

(deftest split-merge 
   (let [org (-> "doc/origami.jpg" (cv/imread))
         bytes (u/split3! org)
         target (cv/new-mat (.height org) (.width org) cv/CV_8UC3)
         mat (u/merge3! target bytes)] 
     (cv/imwrite target "target/output.png")
     (is (= (cv/->string target)  (cv/->string org)))))