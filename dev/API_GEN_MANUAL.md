# TOC  for README.md

https://ecotrust-canada.github.io/markdown-toc/

# generate

```
lein api
```

# opencv4-beta (still!) manual fixes

## remove copy / copy-to line 2489

```
(defn copy-to
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ] 
  (Core/copyTo org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn copy-to!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ] 
  (Core/copyTo org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)
```

## divide!  missing because parameters are just crazy

```
(defn divide!
([org_opencv_core_mat_0 org_opencv_core_scalar_1 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 ) org_opencv_core_mat_0)
([org_opencv_core_mat_0 org_opencv_core_scalar_1 double_3 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0)
([org_opencv_core_mat_0 org_opencv_core_scalar_1 double_3 int_4 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0)
)
```

## multiply! parameters is fucked

```

(defn multiply!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)
```

## lut! parameters are in wrong order

```
(defn lut!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ] 
  (Core/LUT org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)
```

## bilateral-filter! cannot reuse same mat (so clone it)

```
(defn bilateral-filter!
([org_opencv_core_mat_0 int_2 double_3 double_4 ] 
  (let [out  (clone org_opencv_core_mat_0) ] 
  (Imgproc/bilateralFilter org_opencv_core_mat_0 out int_2 double_3 double_4 ) out ))
([org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ] 
  (let [out  (clone org_opencv_core_mat_0) ] 
  (Imgproc/bilateralFilter org_opencv_core_mat_0 out int_2 double_3 double_4 int_5 ) out ))
)
```

## mean! : Can't have 2 overloads with same arity disappeared ??

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

## not removed yet ?? (still not removed as of 11/10)

; (defn rectify-3-collinear!
; ([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ] 
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ) org_opencv_core_mat_0 )
; )
