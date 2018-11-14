(ns opencv4.dnn
  (:require [opencv4.core :only [new-arraylist]])
	(:import [org.opencv.dnn Dnn]))

; DNN
(defn read-net-from-caffee[protofile netfile]
  (Dnn/readNetFromCaffe protofile netfile))
(defn read-net-from-darknet[protofile netfile]
  (Dnn/readNetFromDarknet protofile netfile))
(defn read-net-from-tensorflow [protofiel netfile]
  (Dnn/readNetFromTensorflow netfile))

(defn output-layers[net]
  (opencv4.core/new-arraylist (map #(nth (.getLayerNames net) (dec %))
                      (.toList (.getUnconnectedOutLayers net)))))

;;; Dnn
(def DNN_BACKEND_DEFAULT Dnn/DNN_BACKEND_DEFAULT)
(def DNN_BACKEND_HALIDE Dnn/DNN_BACKEND_HALIDE)
(def DNN_BACKEND_INFERENCE_ENGINE Dnn/DNN_BACKEND_INFERENCE_ENGINE)
(def DNN_BACKEND_OPENCV Dnn/DNN_BACKEND_OPENCV)
(def DNN_TARGET_CPU Dnn/DNN_TARGET_CPU)
(def DNN_TARGET_OPENCL Dnn/DNN_TARGET_OPENCL)
(def DNN_TARGET_OPENCL_FP16 Dnn/DNN_TARGET_OPENCL_FP16)
(def DNN_TARGET_MYRIAD Dnn/DNN_TARGET_MYRIAD)
(defn blob-from-image
([org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_size_2 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 org_opencv_core_size_2 ))
([org_opencv_core_mat_0 double_1 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 ))
([org_opencv_core_mat_0 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 int_6 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 int_6 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 ] 
  (Dnn/blobFromImage org_opencv_core_mat_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 ))
)

(defn blob-from-images
([java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 ))
([java_util_list_0 double_1 org_opencv_core_size_2 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 org_opencv_core_size_2 ))
([java_util_list_0 double_1 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 ))
([java_util_list_0 ] 
  (Dnn/blobFromImages java_util_list_0 ))
([java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 int_6 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 int_6 ))
([java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 boolean_5 ))
([java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 ] 
  (Dnn/blobFromImages java_util_list_0 double_1 org_opencv_core_size_2 org_opencv_core_scalar_3 boolean_4 ))
)

(defn read-tensor-from-onnx
([java_lang_string_0 ] 
  (Dnn/readTensorFromONNX java_lang_string_0 ))
)

(defn read-torch-blob
([java_lang_string_0 ] 
  (Dnn/readTorchBlob java_lang_string_0 ))
([java_lang_string_0 boolean_1 ] 
  (Dnn/readTorchBlob java_lang_string_0 boolean_1 ))
)

(defn read-net
([java_lang_string_0 java_lang_string_1 java_lang_string_2 ] 
  (Dnn/readNet java_lang_string_0 java_lang_string_1 java_lang_string_2 ))
([java_lang_string_0 java_lang_string_1 ] 
  (Dnn/readNet java_lang_string_0 java_lang_string_1 ))
([java_lang_string_0 ] 
  (Dnn/readNet java_lang_string_0 ))
)

; (defn read-net-from-caffe
; ([org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ] 
;   (Dnn/readNetFromCaffe org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ))
; ([org_opencv_core_matofbyte_0 ] 
;   (Dnn/readNetFromCaffe org_opencv_core_matofbyte_0 ))
; )

; (defn read-net-from-darknet
; ([org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ] 
;   (Dnn/readNetFromDarknet org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ))
; ([org_opencv_core_matofbyte_0 ] 
;   (Dnn/readNetFromDarknet org_opencv_core_matofbyte_0 ))
; )

(defn read-net-from-model-optimizer
([java_lang_string_0 java_lang_string_1 ] 
  (Dnn/readNetFromModelOptimizer java_lang_string_0 java_lang_string_1 ))
)

(defn read-net-from-onnx
([java_lang_string_0 ] 
  (Dnn/readNetFromONNX java_lang_string_0 ))
)

; (defn read-net-from-tensorflow
; ([org_opencv_core_matofbyte_0 ] 
;   (Dnn/readNetFromTensorflow org_opencv_core_matofbyte_0 ))
; ([org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ] 
;   (Dnn/readNetFromTensorflow org_opencv_core_matofbyte_0 org_opencv_core_matofbyte_1 ))
; )

(defn read-net-from-torch
([java_lang_string_0 ] 
  (Dnn/readNetFromTorch java_lang_string_0 ))
([java_lang_string_0 boolean_1 ] 
  (Dnn/readNetFromTorch java_lang_string_0 boolean_1 ))
)

(defn nms-boxes
([org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 float_5 int_6 ] 
  (Dnn/NMSBoxes org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 float_5 int_6 ))
([org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 float_5 ] 
  (Dnn/NMSBoxes org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 float_5 ))
([org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 ] 
  (Dnn/NMSBoxes org_opencv_core_matofrect2d_0 org_opencv_core_matoffloat_1 float_2 float_3 org_opencv_core_matofint_4 ))
)

(defn images-from-blob
([org_opencv_core_mat_0 java_util_list_1 ] 
  (Dnn/imagesFromBlob org_opencv_core_mat_0 java_util_list_1 ))
)

(defn reset-myriad-device
([] 
  (Dnn/resetMyriadDevice ))
)

(defn shrink-caffe-model
([java_lang_string_0 java_lang_string_1 java_util_list_2 ] 
  (Dnn/shrinkCaffeModel java_lang_string_0 java_lang_string_1 java_util_list_2 ))
([java_lang_string_0 java_lang_string_1 ] 
  (Dnn/shrinkCaffeModel java_lang_string_0 java_lang_string_1 ))
)

(defn write-text-graph
([java_lang_string_0 java_lang_string_1 ] 
  (Dnn/writeTextGraph java_lang_string_0 java_lang_string_1 ))
)
