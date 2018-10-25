
# generate

```
# lein repl
 (load-file "dev/api.clj")
 (-main)
```

# opencv4 (still!) manual fixes

## mean! : Can't have 2 overloads with same arity

; line 2486
(defn mean!
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
; ([org_opencv_core_mat_0 ]
;   (Core/mean org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

## norm!

(defn norm!
([org_opencv_core_mat_0 int_2 ] 
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
; ([org_opencv_core_mat_0 ] 
;   (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ] 
  (Core/norm org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ] 
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

## two many parameters -> removed during generation
(defn rectify-3-collinear
; ([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ] 
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ))
; )

## not removed yet ??

; (defn rectify-3-collinear!
; ([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ] 
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ) org_opencv_core_mat_0 )
; )
