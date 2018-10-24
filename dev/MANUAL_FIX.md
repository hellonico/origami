# DOES NOT COMPILE

## flood-fill!

does not work .. second parameter is a mat used for mask.

## bilateral filter!

DOES NOT WORK SINCE CANNOT BE THE SAME MAT.
USING CLONE INTERNALLY

(defn bilateral-filter!
([org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 ) org_opencv_core_mat_0 )
)

## wrong method in multiply!

parameters are in the wrong order

(defn multiply!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)


# mean! : Can't have 2 overloads with same arity

(defn mean!
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
; ([org_opencv_core_mat_0 ]
;   (Core/mean org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

# norm! : Can't have 2 overloads with same arity


# rectify-3-collinear: Can't specify more than 20 params

; (defn rectify-3-collinear
; ([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ]
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ))
; )

; (defn rectify-3-collinear!
; ([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ]
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ) org_opencv_core_mat_0 )
; )


# missing method

(defn in-range!
  ([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2]
  (Core/inRange org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_0 )
  ))


# renaming

:rename '{capitalize cap, trim trm}

WARNING: min already refers to: #'clojure.core/min in namespace: opencv3.core, being replaced by: #'opencv3.core/min
WARNING: max already refers to: #'clojure.core/max in namespace: opencv3.core, being replaced by: #'opencv3.core/max
WARNING: compare already refers to: #'clojure.core/compare in namespace: opencv3.core, being replaced by: #'opencv3.core/compare
WARNING: merge already refers to: #'clojure.core/merge in namespace: opencv3.core, being replaced by: #'opencv3.core/merge
WARNING: sort already refers to: #'clojure.core/sort in namespace: opencv3.core, being replaced by: #'opencv3.core/sort
WARNING: reduce already refers to: #'clojure.core/reduce in namespace: opencv3.core, being replaced by: #'opencv3.core/reduce
WARNING: repeat already refers to: #'clojure.core/repeat in namespace: opencv3.core, being replaced by: #'opencv3.core/repeat
WARNING: reduce already refers to: #'clojure.core/reduce in namespace: opencv3.ok, being replaced by: #'opencv3.core/reduce
WARNING: sort already refers to: #'clojure.core/sort in namespace: opencv3.ok, being replaced by: #'opencv3.core/sort
WARNING: min already refers to: #'clojure.core/min in namespace: opencv3.ok, being replaced by: #'opencv3.core/min
WARNING: merge already refers to: #'clojure.core/merge in namespace: opencv3.ok, being replaced by: #'opencv3.core/merge
WARNING: max already refers to: #'clojure.core/max in namespace: opencv3.ok, being replaced by: #'opencv3.core/max
WARNING: compare already refers to: #'clojure.core/compare in namespace: opencv3.ok, being replaced by: #'opencv3.core/compare
WARNING: repeat already refers to: #'clojure.core/repeat in namespace: opencv3.ok, being replaced by: #'opencv3.core/repeat
