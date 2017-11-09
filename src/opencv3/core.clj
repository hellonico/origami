  (ns opencv3.core
  (:import
    [org.opencv.core MatOfInt MatOfKeyPoint MatOfPoint MatOfPoint2f MatOfRect Point Rect Mat Size Scalar Core CvType Mat MatOfByte]
    [org.opencv.photo Photo]
    [org.opencv.calib3d Calib3d]
    [org.opencv.imgcodecs Imgcodecs]
    [org.opencv.imgproc Imgproc]))

; NOT AUTO GENERATED YET

(defn imread
  ([string] (Imgcodecs/imread string))
  ([string type] (Imgcodecs/imread string type)))

(defn imwrite[mat string]
  (Imgcodecs/imwrite string mat)
  mat)

(declare new-arraylist)
(def new-list new-arraylist)

(defn clone[mat] (.clone mat))
(defn set-to[mat scalar] (.setTo mat scalar))
(defn copy-to
  ([src target] (.copyTo src target))
  ([src target mask] (.copyTo src target mask)))
(defn copy-to![src mask]
  (copy-to src src mask))

(defn submat[src rect] (.submat src rect))
(defn size[src] (.size src))
(defn rows[src] (.rows src))
(defn cols[src] (.cols src))

(defn convert-to
  ([src target a1] (.convertTo src target a1) target)
  ([src target type alpha beta] (.convertTo src target type alpha beta) target))

(defn convert-to!
  ([mat a1 a2 a3]
  (.convertTo mat mat a1 a2 a3) mat)
  ([mat a1 a2]
  (.convertTo mat mat a1 a2) mat)
  ([mat a1]
  (.convertTo mat mat a1) mat))


(declare put-text)
(declare hconcat)
(declare new-mat)
(declare vconcat)

(defn put-text!
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 ]
  (put-text org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 )
  org_opencv_core_mat_0
  )
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8 ]
  (put-text org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8)
  org_opencv_core_mat_0)
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 ]
  (put-text org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 )
  org_opencv_core_mat_0))

(defn hconcat! [mats]
  (let [ output (new-mat) ]
  (hconcat mats output)
  output))

(defn vconcat! [mats]
  (let [ output (new-mat) ]
  (vconcat mats output)
  output))


; AUTO GENERATED CONSTRUCTORS

(defn new-matoffloat
([array_f_0 ]
  (new org.opencv.core.MatOfFloat array_f_0 ))
([]
  (new org.opencv.core.MatOfFloat )))


(defn new-cascadeclassifier
([]
  (new org.opencv.objdetect.CascadeClassifier ))
([java_lang_string_0 ]
  (new org.opencv.objdetect.CascadeClassifier java_lang_string_0 )))


(defn new-matofrect
([array_lorg_opencv_core_rect_0 ]
  (new org.opencv.core.MatOfRect array_lorg_opencv_core_rect_0 ))
([]
  (new org.opencv.core.MatOfRect )))


(defn new-rotatedrect
([array_d_0 ]
  (new org.opencv.core.RotatedRect array_d_0 ))
([org_opencv_core_point_0 org_opencv_core_size_1 double_2 ]
  (new org.opencv.core.RotatedRect org_opencv_core_point_0 org_opencv_core_size_1 double_2 ))
([]
  (new org.opencv.core.RotatedRect )))

(defn new-matofdouble
([array_d_0 ]
  (new org.opencv.core.MatOfDouble array_d_0 ))
([]
  (new org.opencv.core.MatOfDouble )))


(defn new-matofbyte
([array_b_0 ]
  (new org.opencv.core.MatOfByte array_b_0 ))
([]
  (new org.opencv.core.MatOfByte )))

(defn new-matofdmatch
([array_lorg_opencv_core_dmatch_0 ]
  (new org.opencv.core.MatOfDMatch array_lorg_opencv_core_dmatch_0 ))
([]
  (new org.opencv.core.MatOfDMatch )))

(defn new-matofkeypoint
([array_lorg_opencv_core_keypoint_0 ]
  (new org.opencv.core.MatOfKeyPoint array_lorg_opencv_core_keypoint_0 ))
([]
  (new org.opencv.core.MatOfKeyPoint )))


(defn new-matofint
([array_i_0 ]
  (new org.opencv.core.MatOfInt array_i_0 ))
([]
  (new org.opencv.core.MatOfInt )))
(defn new-matofpoint2f
([array_lorg_opencv_core_point_0 ]
  (new org.opencv.core.MatOfPoint2f array_lorg_opencv_core_point_0 ))
([]
  (new org.opencv.core.MatOfPoint2f )))
(defn new-matofpoint
([array_lorg_opencv_core_point_0 ]
  (new org.opencv.core.MatOfPoint array_lorg_opencv_core_point_0 ))
([]
  (new org.opencv.core.MatOfPoint )))
(defn new-scalar
([array_d_0 ]
  (new org.opencv.core.Scalar array_d_0 ))
([double_0 double_1 ]
  (new org.opencv.core.Scalar double_0 double_1 ))
([double_0 double_1 double_2 ]
  (new org.opencv.core.Scalar double_0 double_1 double_2 ))
([double_0 double_1 double_2 double_3 ]
  (new org.opencv.core.Scalar double_0 double_1 double_2 double_3 )))
(defn new-rect
([array_d_0 ]
  (new org.opencv.core.Rect array_d_0 ))
([org_opencv_core_point_0 org_opencv_core_size_1 ]
  (new org.opencv.core.Rect org_opencv_core_point_0 org_opencv_core_size_1 ))
([]
  (new org.opencv.core.Rect ))
([int_0 int_1 int_2 int_3 ]
  (new org.opencv.core.Rect int_0 int_1 int_2 int_3 )))
(defn new-arraylist
([java_util_collection_0 ]
  (new java.util.ArrayList java_util_collection_0 ))
([]
  (new java.util.ArrayList )))
(defn new-size
([array_d_0 ]
  (new org.opencv.core.Size array_d_0 ))
([]
  (new org.opencv.core.Size ))
([double_0 double_1 ]
  (new org.opencv.core.Size double_0 double_1 )))

(defn new-mat
([int_0 int_1 int_2 org_opencv_core_scalar_3 ]
  (new org.opencv.core.Mat int_0 int_1 int_2 org_opencv_core_scalar_3 ))
([org_opencv_core_size_0 int_1 org_opencv_core_scalar_2 ]
  (new org.opencv.core.Mat org_opencv_core_size_0 int_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 org_opencv_core_range_1 ]
  (new org.opencv.core.Mat org_opencv_core_mat_0 org_opencv_core_range_1 ))
([long_0 ]
  (new org.opencv.core.Mat long_0 ))
([]
  (new org.opencv.core.Mat )))

(defn new-point
([array_d_0 ]
  (new org.opencv.core.Point array_d_0 ))
([]
  (new org.opencv.core.Point ))
([double_0 double_1 ]
  (new org.opencv.core.Point double_0 double_1 )))


; AUTO GENERATED

(defn threshold
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/threshold org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
)

(defn threshold!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/threshold org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn resize
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
)

(defn resize!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
)

(defn remap
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn remap!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
)

(defn circle
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 ))
)

(defn line
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ))
)

(defn get-affine-transform
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Imgproc/getAffineTransform org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
)

(defn get-default-new-camera-matrix
([org_opencv_core_mat_0 org_opencv_core_size_1 boolean_2 ]
  (Imgproc/getDefaultNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_size_1 boolean_2 ))
([org_opencv_core_mat_0 ]
  (Imgproc/getDefaultNewCameraMatrix org_opencv_core_mat_0 ))
)

(defn get-gabor-kernel
([org_opencv_core_size_0 double_1 double_2 double_3 double_4 ]
  (Imgproc/getGaborKernel org_opencv_core_size_0 double_1 double_2 double_3 double_4 ))
([org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 int_6 ]
  (Imgproc/getGaborKernel org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 int_6 ))
)

(defn get-gaussian-kernel
([int_0 double_1 ]
  (Imgproc/getGaussianKernel int_0 double_1 ))
([int_0 double_1 int_2 ]
  (Imgproc/getGaussianKernel int_0 double_1 int_2 ))
)

(defn get-perspective-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn get-perspective-transform!
([org_opencv_core_mat_0 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn get-rotation-matrix-2-d
([org_opencv_core_point_0 double_1 double_2 ]
  (Imgproc/getRotationMatrix2D org_opencv_core_point_0 double_1 double_2 ))
)

(defn get-structuring-element
([int_0 org_opencv_core_size_1 ]
  (Imgproc/getStructuringElement int_0 org_opencv_core_size_1 ))
([int_0 org_opencv_core_size_1 org_opencv_core_point_2 ]
  (Imgproc/getStructuringElement int_0 org_opencv_core_size_1 org_opencv_core_point_2 ))
)

(defn moments
([org_opencv_core_mat_0 boolean_1 ]
  (Imgproc/moments org_opencv_core_mat_0 boolean_1 ))
([org_opencv_core_mat_0 ]
  (Imgproc/moments org_opencv_core_mat_0 ))
)

(defn phase-correlate
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 array_d_3 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 array_d_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn phase-correlate!
([org_opencv_core_mat_0 org_opencv_core_mat_2 array_d_3 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 array_d_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn create-clahe
([]
  (Imgproc/createCLAHE ))
([double_0 org_opencv_core_size_1 ]
  (Imgproc/createCLAHE double_0 org_opencv_core_size_1 ))
)

(defn create-line-segment-detector
([]
  (Imgproc/createLineSegmentDetector ))
([int_0 double_1 double_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 double_4 double_5 double_6 int_7 ))
)

(defn bounding-rect
([org_opencv_core_matofpoint_0 ]
  (Imgproc/boundingRect org_opencv_core_matofpoint_0 ))
)

(defn fit-ellipse
([org_opencv_core_matofpoint2f_0 ]
  (Imgproc/fitEllipse org_opencv_core_matofpoint2f_0 ))
)

(defn min-area-rect
([org_opencv_core_matofpoint2f_0 ]
  (Imgproc/minAreaRect org_opencv_core_matofpoint2f_0 ))
)

(defn clip-line
([org_opencv_core_rect_0 org_opencv_core_point_1 org_opencv_core_point_2 ]
  (Imgproc/clipLine org_opencv_core_rect_0 org_opencv_core_point_1 org_opencv_core_point_2 ))
)

(defn is-contour-convex
([org_opencv_core_matofpoint_0 ]
  (Imgproc/isContourConvex org_opencv_core_matofpoint_0 ))
)

(defn arc-length
([org_opencv_core_matofpoint2f_0 boolean_1 ]
  (Imgproc/arcLength org_opencv_core_matofpoint2f_0 boolean_1 ))
)

(defn compare-hist
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/compareHist org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn compare-hist!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/compareHist org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn contour-area
([org_opencv_core_mat_0 ]
  (Imgproc/contourArea org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 boolean_1 ]
  (Imgproc/contourArea org_opencv_core_mat_0 boolean_1 ))
)

(defn match-shapes
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 ]
  (Imgproc/matchShapes org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 ))
)

(defn match-shapes!
([org_opencv_core_mat_0 int_2 double_3 ]
  (Imgproc/matchShapes org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 ) org_opencv_core_mat_0 )
)

(defn min-enclosing-triangle
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/minEnclosingTriangle org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn min-enclosing-triangle!
([org_opencv_core_mat_0 ]
  (Imgproc/minEnclosingTriangle org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn point-polygon-test
([org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 boolean_2 ]
  (Imgproc/pointPolygonTest org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 boolean_2 ))
)

(defn init-wide-angle-proj-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 double_8 ]
  (Imgproc/initWideAngleProjMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 double_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Imgproc/initWideAngleProjMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ))
)

(defn init-wide-angle-proj-map!
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 double_8 ]
  (Imgproc/initWideAngleProjMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 double_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Imgproc/initWideAngleProjMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 int_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
)

(defn intersect-convex-convex
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/intersectConvexConvex org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ]
  (Imgproc/intersectConvexConvex org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ))
)

(defn intersect-convex-convex!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/intersectConvexConvex org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ]
  (Imgproc/intersectConvexConvex org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ) org_opencv_core_mat_0 )
)

(defn emd
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn emd!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn connected-components-with-algorithm
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/connectedComponentsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn connected-components-with-algorithm!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/connectedComponentsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn connected-components
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn connected-components!
([org_opencv_core_mat_0 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn connected-components-with-stats-with-algorithm
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 int_6 ]
  (Imgproc/connectedComponentsWithStatsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 int_6 ))
)

(defn connected-components-with-stats-with-algorithm!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 int_6 ]
  (Imgproc/connectedComponentsWithStatsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 int_6 ) org_opencv_core_mat_0 )
)

(defn connected-components-with-stats
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ))
)

(defn connected-components-with-stats!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ) org_opencv_core_mat_0 )
)

(defn flood-fill
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ))
)

(defn flood-fill!
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ) org_opencv_core_mat_0 )
)

(defn rotated-rectangle-intersection
([org_opencv_core_rotatedrect_0 org_opencv_core_rotatedrect_1 org_opencv_core_mat_2 ]
  (Imgproc/rotatedRectangleIntersection org_opencv_core_rotatedrect_0 org_opencv_core_rotatedrect_1 org_opencv_core_mat_2 ))
)

(defn canny
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 boolean_5 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 ))
)

(defn canny!
([org_opencv_core_mat_0 double_2 double_3 int_4 boolean_5 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 ) org_opencv_core_mat_0 )
)

(defn gaussian-blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ))
)

(defn gaussian-blur!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ) org_opencv_core_mat_0 )
)

(defn hough-circles
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ))
)

(defn hough-circles!
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 ) org_opencv_core_mat_0 )
)

(defn hough-lines
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ))
)

(defn hough-lines!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ) org_opencv_core_mat_0 )
)

(defn hough-lines-p
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ))
)

(defn hough-lines-p!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
)

(defn hu-moments
([org_opencv_imgproc_moments_0 org_opencv_core_mat_1 ]
  (Imgproc/HuMoments org_opencv_imgproc_moments_0 org_opencv_core_mat_1 ))
)

(defn laplacian
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 int_6 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn laplacian!
([org_opencv_core_mat_0 int_2 int_3 double_4 double_5 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 double_4 double_5 int_6 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 double_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn scharr
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 int_7 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 int_7 ))
)

(defn scharr!
([org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 int_7 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 int_7 ) org_opencv_core_mat_0 )
)

(defn sobel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 ))
)

(defn sobel!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 ) org_opencv_core_mat_0 )
)

(defn accumulate
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/accumulate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/accumulate org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn accumulate!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/accumulate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/accumulate org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn accumulate-product
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/accumulateProduct org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/accumulateProduct org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn accumulate-product!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/accumulateProduct org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/accumulateProduct org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn accumulate-square
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/accumulateSquare org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/accumulateSquare org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn accumulate-square!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/accumulateSquare org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/accumulateSquare org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn accumulate-weighted
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ]
  (Imgproc/accumulateWeighted org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 ]
  (Imgproc/accumulateWeighted org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 ))
)

(defn accumulate-weighted!
([org_opencv_core_mat_0 double_2 ]
  (Imgproc/accumulateWeighted org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 ]
  (Imgproc/accumulateWeighted org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn adaptive-threshold
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/adaptiveThreshold org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 int_3 int_4 int_5 double_6 ))
)

(defn adaptive-threshold!
([org_opencv_core_mat_0 double_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/adaptiveThreshold org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 int_3 int_4 int_5 double_6 ) org_opencv_core_mat_0 )
)

(defn apply-color-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/applyColorMap org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn apply-color-map!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/applyColorMap org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn approx-poly-dp
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 double_2 boolean_3 ]
  (Imgproc/approxPolyDP org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 double_2 boolean_3 ))
)

(defn arrowed-line
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 double_7 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 double_7 ))
)

(defn bilateral-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 int_5 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ))
)

(defn bilateral-filter!
([org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ]
  (let [ org_opencv_core_mat_1 (clone org_opencv_core_mat_0)]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 int_5 )
  org_opencv_core_mat_1))
([org_opencv_core_mat_0 int_2 double_3 double_4 ]
  (let [ org_opencv_core_mat_1 (clone org_opencv_core_mat_0)]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 )
  org_opencv_core_mat_1)))

; (defn bilateral-filter!
; ([org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ]
;   (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
; ([org_opencv_core_mat_0 int_2 double_3 double_4 ]
;   (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 ) org_opencv_core_mat_0 )
; )

(defn blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 ))
)

(defn blur!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 ) org_opencv_core_mat_0 )
)

(defn box-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ))
)

(defn box-filter!
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
)

(defn box-points
([org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 ]
  (Imgproc/boxPoints org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 ))
)

(defn calc-back-project
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matoffloat_4 double_5 ]
  (Imgproc/calcBackProject java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matoffloat_4 double_5 ))
)

(defn calc-hist
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 boolean_6 ]
  (Imgproc/calcHist java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 boolean_6 ))
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 ]
  (Imgproc/calcHist java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 ))
)

(defn convert-maps
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 boolean_5 ]
  (Imgproc/convertMaps org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/convertMaps org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn convert-maps!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 boolean_5 ]
  (Imgproc/convertMaps org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/convertMaps org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
)

(defn convex-hull
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 boolean_2 ]
  (Imgproc/convexHull org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 boolean_2 ))
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 ]
  (Imgproc/convexHull org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 ))
)

(defn convexity-defects
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 org_opencv_core_matofint4_2 ]
  (Imgproc/convexityDefects org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 org_opencv_core_matofint4_2 ))
)

(defn corner-eigen-vals-and-vecs
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn corner-eigen-vals-and-vecs!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn corner-harris
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 int_5 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ))
)

(defn corner-harris!
([org_opencv_core_mat_0 int_2 int_3 double_4 int_5 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 double_4 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 ) org_opencv_core_mat_0 )
)

(defn corner-min-eigen-val
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn corner-min-eigen-val!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn corner-sub-pix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ]
  (Imgproc/cornerSubPix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ))
)

(defn corner-sub-pix!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ]
  (Imgproc/cornerSubPix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ) org_opencv_core_mat_0 )
)

(defn create-hanning-window
([org_opencv_core_mat_0 org_opencv_core_size_1 int_2 ]
  (Imgproc/createHanningWindow org_opencv_core_mat_0 org_opencv_core_size_1 int_2 ))
)

(defn cvt-color
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn cvt-color!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn demosaicing
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/demosaicing org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/demosaicing org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn demosaicing!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/demosaicing org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/demosaicing org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn dilate
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn dilate!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn distance-transform-with-labels
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/distanceTransformWithLabels org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 int_5 ]
  (Imgproc/distanceTransformWithLabels org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 int_5 ))
)

(defn distance-transform-with-labels!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/distanceTransformWithLabels org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 int_5 ]
  (Imgproc/distanceTransformWithLabels org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 int_5 ) org_opencv_core_mat_0 )
)

(defn distance-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn distance-transform!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn draw-contours
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 org_opencv_core_point_8 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 org_opencv_core_point_8 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 ))
)

(defn draw-marker
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 int_6 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 int_6 ))
)

(defn ellipse
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 int_9 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 int_9 ))
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 ))
)

(defn ellipse-2-poly
([org_opencv_core_point_0 org_opencv_core_size_1 int_2 int_3 int_4 int_5 org_opencv_core_matofpoint_6 ]
  (Imgproc/ellipse2Poly org_opencv_core_point_0 org_opencv_core_size_1 int_2 int_3 int_4 int_5 org_opencv_core_matofpoint_6 ))
)

(defn equalize-hist
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/equalizeHist org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn equalize-hist!
([org_opencv_core_mat_0 ]
  (Imgproc/equalizeHist org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn erode
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ))
)

(defn erode!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
)

(defn fill-convex-poly
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 ]
  (Imgproc/fillConvexPoly org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/fillConvexPoly org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 int_4 ))
)

(defn fill-poly
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 org_opencv_core_point_5 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 org_opencv_core_point_5 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 ))
)

(defn filter-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
)

(defn filter-2-d!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn find-contours
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 org_opencv_core_point_5 ]
  (Imgproc/findContours org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 org_opencv_core_point_5 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/findContours org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn fit-line
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ]
  (Imgproc/fitLine org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ))
)

(defn fit-line!
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ]
  (Imgproc/fitLine org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ) org_opencv_core_mat_0 )
)

(defn get-deriv-kernels
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 int_6 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 int_6 ))
)

(defn get-deriv-kernels!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 int_6 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
)

(defn get-rect-sub-pix
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 ]
  (Imgproc/getRectSubPix org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/getRectSubPix org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 int_4 ))
)

(defn good-features-to-track
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 boolean_7 double_8 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 boolean_7 double_8 ))
)

(defn grab-cut
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ))
)

(defn grab-cut!
([org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ) org_opencv_core_mat_0 )
)

(defn init-undistort-rectify-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Imgproc/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn init-undistort-rectify-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Imgproc/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn integral-3
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn integral-3!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn integral-2
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn integral-2!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn integral
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/integral org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/integral org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn integral!
([org_opencv_core_mat_0 ]
  (Imgproc/integral org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/integral org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn invert-affine-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/invertAffineTransform org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn invert-affine-transform!
([org_opencv_core_mat_0 ]
  (Imgproc/invertAffineTransform org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn linear-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/linearPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ))
)

(defn linear-polar!
([org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/linearPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn log-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/logPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ))
)

(defn log-polar!
([org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/logPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn match-template
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/matchTemplate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Imgproc/matchTemplate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ))
)

(defn match-template!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/matchTemplate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Imgproc/matchTemplate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn median-blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/medianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn median-blur!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/medianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn min-enclosing-circle
([org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 array_f_2 ]
  (Imgproc/minEnclosingCircle org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 array_f_2 ))
)

(defn morphology-ex
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
)

(defn morphology-ex!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn polylines
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 ))
)

(defn pre-corner-detect
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/preCornerDetect org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/preCornerDetect org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn pre-corner-detect!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/preCornerDetect org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/preCornerDetect org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn put-text
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 ))
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8 ))
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 ))
)

(defn pyr-down
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn pyr-down!
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn pyr-mean-shift-filtering
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
)

(defn pyr-mean-shift-filtering!
([org_opencv_core_mat_0 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
)

(defn pyr-up
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
)

(defn pyr-up!
([org_opencv_core_mat_0 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
)

(defn rectangle
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
)

(defn sep-filter-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ))
)

(defn sep-filter-2-d!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ) org_opencv_core_mat_0 )
)

(defn spatial-gradient
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn spatial-gradient!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn sqr-box-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ))
)

(defn sqr-box-filter!
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
)

(defn undistort
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/undistort org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/undistort org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn undistort!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/undistort org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/undistort org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn undistort-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Imgproc/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn undistort-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Imgproc/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn warp-affine
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ))
)

(defn warp-affine!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
)

(defn warp-perspective
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ))
)

(defn warp-perspective!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
)

(defn watershed
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/watershed org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn watershed!
([org_opencv_core_mat_0 ]
  (Imgproc/watershed org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn get-text-size
([java_lang_string_0 int_1 double_2 int_3 array_i_4 ]
  (Imgproc/getTextSize java_lang_string_0 int_1 double_2 int_3 array_i_4 ))
)

(def LINE_AA Imgproc/LINE_AA)
(def LINE_8 Imgproc/LINE_8)
(def LINE_4 Imgproc/LINE_4)
(def CV_BLUR_NO_SCALE Imgproc/CV_BLUR_NO_SCALE)
(def CV_BLUR Imgproc/CV_BLUR)
(def CV_GAUSSIAN Imgproc/CV_GAUSSIAN)
(def CV_MEDIAN Imgproc/CV_MEDIAN)
(def CV_BILATERAL Imgproc/CV_BILATERAL)
(def CV_GAUSSIAN_5x5 Imgproc/CV_GAUSSIAN_5x5)
(def CV_SCHARR Imgproc/CV_SCHARR)
(def CV_MAX_SOBEL_KSIZE Imgproc/CV_MAX_SOBEL_KSIZE)
(def CV_RGBA2mRGBA Imgproc/CV_RGBA2mRGBA)
(def CV_mRGBA2RGBA Imgproc/CV_mRGBA2RGBA)
(def CV_WARP_FILL_OUTLIERS Imgproc/CV_WARP_FILL_OUTLIERS)
(def CV_WARP_INVERSE_MAP Imgproc/CV_WARP_INVERSE_MAP)
(def CV_SHAPE_RECT Imgproc/CV_SHAPE_RECT)
(def CV_SHAPE_CROSS Imgproc/CV_SHAPE_CROSS)
(def CV_SHAPE_ELLIPSE Imgproc/CV_SHAPE_ELLIPSE)
(def CV_SHAPE_CUSTOM Imgproc/CV_SHAPE_CUSTOM)
(def CV_CHAIN_CODE Imgproc/CV_CHAIN_CODE)
(def CV_LINK_RUNS Imgproc/CV_LINK_RUNS)
(def CV_POLY_APPROX_DP Imgproc/CV_POLY_APPROX_DP)
(def CV_CONTOURS_MATCH_I1 Imgproc/CV_CONTOURS_MATCH_I1)
(def CV_CONTOURS_MATCH_I2 Imgproc/CV_CONTOURS_MATCH_I2)
(def CV_CONTOURS_MATCH_I3 Imgproc/CV_CONTOURS_MATCH_I3)
(def CV_CLOCKWISE Imgproc/CV_CLOCKWISE)
(def CV_COUNTER_CLOCKWISE Imgproc/CV_COUNTER_CLOCKWISE)
(def CV_COMP_CORREL Imgproc/CV_COMP_CORREL)
(def CV_COMP_CHISQR Imgproc/CV_COMP_CHISQR)
(def CV_COMP_INTERSECT Imgproc/CV_COMP_INTERSECT)
(def CV_COMP_BHATTACHARYYA Imgproc/CV_COMP_BHATTACHARYYA)
(def CV_COMP_HELLINGER Imgproc/CV_COMP_HELLINGER)
(def CV_COMP_CHISQR_ALT Imgproc/CV_COMP_CHISQR_ALT)
(def CV_COMP_KL_DIV Imgproc/CV_COMP_KL_DIV)
(def CV_DIST_MASK_3 Imgproc/CV_DIST_MASK_3)
(def CV_DIST_MASK_5 Imgproc/CV_DIST_MASK_5)
(def CV_DIST_MASK_PRECISE Imgproc/CV_DIST_MASK_PRECISE)
(def CV_DIST_LABEL_CCOMP Imgproc/CV_DIST_LABEL_CCOMP)
(def CV_DIST_LABEL_PIXEL Imgproc/CV_DIST_LABEL_PIXEL)
(def CV_DIST_USER Imgproc/CV_DIST_USER)
(def CV_DIST_L1 Imgproc/CV_DIST_L1)
(def CV_DIST_L2 Imgproc/CV_DIST_L2)
(def CV_DIST_C Imgproc/CV_DIST_C)
(def CV_DIST_L12 Imgproc/CV_DIST_L12)
(def CV_DIST_FAIR Imgproc/CV_DIST_FAIR)
(def CV_DIST_WELSCH Imgproc/CV_DIST_WELSCH)
(def CV_DIST_HUBER Imgproc/CV_DIST_HUBER)
(def CV_CANNY_L2_GRADIENT Imgproc/CV_CANNY_L2_GRADIENT)
(def CV_HOUGH_STANDARD Imgproc/CV_HOUGH_STANDARD)
(def CV_HOUGH_PROBABILISTIC Imgproc/CV_HOUGH_PROBABILISTIC)
(def CV_HOUGH_MULTI_SCALE Imgproc/CV_HOUGH_MULTI_SCALE)
(def CV_HOUGH_GRADIENT Imgproc/CV_HOUGH_GRADIENT)
(def MORPH_ERODE Imgproc/MORPH_ERODE)
(def MORPH_DILATE Imgproc/MORPH_DILATE)
(def MORPH_OPEN Imgproc/MORPH_OPEN)
(def MORPH_CLOSE Imgproc/MORPH_CLOSE)
(def MORPH_GRADIENT Imgproc/MORPH_GRADIENT)
(def MORPH_TOPHAT Imgproc/MORPH_TOPHAT)
(def MORPH_BLACKHAT Imgproc/MORPH_BLACKHAT)
(def MORPH_HITMISS Imgproc/MORPH_HITMISS)
(def MORPH_RECT Imgproc/MORPH_RECT)
(def MORPH_CROSS Imgproc/MORPH_CROSS)
(def MORPH_ELLIPSE Imgproc/MORPH_ELLIPSE)
(def INTER_NEAREST Imgproc/INTER_NEAREST)
(def INTER_LINEAR Imgproc/INTER_LINEAR)
(def INTER_CUBIC Imgproc/INTER_CUBIC)
(def INTER_AREA Imgproc/INTER_AREA)
(def INTER_LANCZOS4 Imgproc/INTER_LANCZOS4)
(def INTER_MAX Imgproc/INTER_MAX)
(def WARP_FILL_OUTLIERS Imgproc/WARP_FILL_OUTLIERS)
(def WARP_INVERSE_MAP Imgproc/WARP_INVERSE_MAP)
(def INTER_BITS Imgproc/INTER_BITS)
(def INTER_BITS2 Imgproc/INTER_BITS2)
(def INTER_TAB_SIZE Imgproc/INTER_TAB_SIZE)
(def INTER_TAB_SIZE2 Imgproc/INTER_TAB_SIZE2)
(def DIST_USER Imgproc/DIST_USER)
(def DIST_L1 Imgproc/DIST_L1)
(def DIST_L2 Imgproc/DIST_L2)
(def DIST_C Imgproc/DIST_C)
(def DIST_L12 Imgproc/DIST_L12)
(def DIST_FAIR Imgproc/DIST_FAIR)
(def DIST_WELSCH Imgproc/DIST_WELSCH)
(def DIST_HUBER Imgproc/DIST_HUBER)
(def DIST_MASK_3 Imgproc/DIST_MASK_3)
(def DIST_MASK_5 Imgproc/DIST_MASK_5)
(def DIST_MASK_PRECISE Imgproc/DIST_MASK_PRECISE)
(def THRESH_BINARY Imgproc/THRESH_BINARY)
(def THRESH_BINARY_INV Imgproc/THRESH_BINARY_INV)
(def THRESH_TRUNC Imgproc/THRESH_TRUNC)
(def THRESH_TOZERO Imgproc/THRESH_TOZERO)
(def THRESH_TOZERO_INV Imgproc/THRESH_TOZERO_INV)
(def THRESH_MASK Imgproc/THRESH_MASK)
(def THRESH_OTSU Imgproc/THRESH_OTSU)
(def THRESH_TRIANGLE Imgproc/THRESH_TRIANGLE)
(def ADAPTIVE_THRESH_MEAN_C Imgproc/ADAPTIVE_THRESH_MEAN_C)
(def ADAPTIVE_THRESH_GAUSSIAN_C Imgproc/ADAPTIVE_THRESH_GAUSSIAN_C)
(def PROJ_SPHERICAL_ORTHO Imgproc/PROJ_SPHERICAL_ORTHO)
(def PROJ_SPHERICAL_EQRECT Imgproc/PROJ_SPHERICAL_EQRECT)
(def GC_BGD Imgproc/GC_BGD)
(def GC_FGD Imgproc/GC_FGD)
(def GC_PR_BGD Imgproc/GC_PR_BGD)
(def GC_PR_FGD Imgproc/GC_PR_FGD)
(def GC_INIT_WITH_RECT Imgproc/GC_INIT_WITH_RECT)
(def GC_INIT_WITH_MASK Imgproc/GC_INIT_WITH_MASK)
(def GC_EVAL Imgproc/GC_EVAL)
(def DIST_LABEL_CCOMP Imgproc/DIST_LABEL_CCOMP)
(def DIST_LABEL_PIXEL Imgproc/DIST_LABEL_PIXEL)
(def FLOODFILL_FIXED_RANGE Imgproc/FLOODFILL_FIXED_RANGE)
(def FLOODFILL_MASK_ONLY Imgproc/FLOODFILL_MASK_ONLY)
(def CC_STAT_LEFT Imgproc/CC_STAT_LEFT)
(def CC_STAT_TOP Imgproc/CC_STAT_TOP)
(def CC_STAT_WIDTH Imgproc/CC_STAT_WIDTH)
(def CC_STAT_HEIGHT Imgproc/CC_STAT_HEIGHT)
(def CC_STAT_AREA Imgproc/CC_STAT_AREA)
(def CC_STAT_MAX Imgproc/CC_STAT_MAX)
(def CCL_WU Imgproc/CCL_WU)
(def CCL_DEFAULT Imgproc/CCL_DEFAULT)
(def CCL_GRANA Imgproc/CCL_GRANA)
(def RETR_EXTERNAL Imgproc/RETR_EXTERNAL)
(def RETR_LIST Imgproc/RETR_LIST)
(def RETR_CCOMP Imgproc/RETR_CCOMP)
(def RETR_TREE Imgproc/RETR_TREE)
(def RETR_FLOODFILL Imgproc/RETR_FLOODFILL)
(def CHAIN_APPROX_NONE Imgproc/CHAIN_APPROX_NONE)
(def CHAIN_APPROX_SIMPLE Imgproc/CHAIN_APPROX_SIMPLE)
(def CHAIN_APPROX_TC89_L1 Imgproc/CHAIN_APPROX_TC89_L1)
(def CHAIN_APPROX_TC89_KCOS Imgproc/CHAIN_APPROX_TC89_KCOS)
(def CONTOURS_MATCH_I1 Imgproc/CONTOURS_MATCH_I1)
(def CONTOURS_MATCH_I2 Imgproc/CONTOURS_MATCH_I2)
(def CONTOURS_MATCH_I3 Imgproc/CONTOURS_MATCH_I3)
(def HOUGH_STANDARD Imgproc/HOUGH_STANDARD)
(def HOUGH_PROBABILISTIC Imgproc/HOUGH_PROBABILISTIC)
(def HOUGH_MULTI_SCALE Imgproc/HOUGH_MULTI_SCALE)
(def HOUGH_GRADIENT Imgproc/HOUGH_GRADIENT)
(def LSD_REFINE_NONE Imgproc/LSD_REFINE_NONE)
(def LSD_REFINE_STD Imgproc/LSD_REFINE_STD)
(def LSD_REFINE_ADV Imgproc/LSD_REFINE_ADV)
(def HISTCMP_CORREL Imgproc/HISTCMP_CORREL)
(def HISTCMP_CHISQR Imgproc/HISTCMP_CHISQR)
(def HISTCMP_INTERSECT Imgproc/HISTCMP_INTERSECT)
(def HISTCMP_BHATTACHARYYA Imgproc/HISTCMP_BHATTACHARYYA)
(def HISTCMP_HELLINGER Imgproc/HISTCMP_HELLINGER)
(def HISTCMP_CHISQR_ALT Imgproc/HISTCMP_CHISQR_ALT)
(def HISTCMP_KL_DIV Imgproc/HISTCMP_KL_DIV)
(def COLOR_BGR2BGRA Imgproc/COLOR_BGR2BGRA)
(def COLOR_RGB2RGBA Imgproc/COLOR_RGB2RGBA)
(def COLOR_BGRA2BGR Imgproc/COLOR_BGRA2BGR)
(def COLOR_RGBA2RGB Imgproc/COLOR_RGBA2RGB)
(def COLOR_BGR2RGBA Imgproc/COLOR_BGR2RGBA)
(def COLOR_RGB2BGRA Imgproc/COLOR_RGB2BGRA)
(def COLOR_RGBA2BGR Imgproc/COLOR_RGBA2BGR)
(def COLOR_BGRA2RGB Imgproc/COLOR_BGRA2RGB)
(def COLOR_BGR2RGB Imgproc/COLOR_BGR2RGB)
(def COLOR_RGB2BGR Imgproc/COLOR_RGB2BGR)
(def COLOR_BGRA2RGBA Imgproc/COLOR_BGRA2RGBA)
(def COLOR_RGBA2BGRA Imgproc/COLOR_RGBA2BGRA)
(def COLOR_BGR2GRAY Imgproc/COLOR_BGR2GRAY)
(def COLOR_RGB2GRAY Imgproc/COLOR_RGB2GRAY)
(def COLOR_GRAY2BGR Imgproc/COLOR_GRAY2BGR)
(def COLOR_GRAY2RGB Imgproc/COLOR_GRAY2RGB)
(def COLOR_GRAY2BGRA Imgproc/COLOR_GRAY2BGRA)
(def COLOR_GRAY2RGBA Imgproc/COLOR_GRAY2RGBA)
(def COLOR_BGRA2GRAY Imgproc/COLOR_BGRA2GRAY)
(def COLOR_RGBA2GRAY Imgproc/COLOR_RGBA2GRAY)
(def COLOR_BGR2BGR565 Imgproc/COLOR_BGR2BGR565)
(def COLOR_RGB2BGR565 Imgproc/COLOR_RGB2BGR565)
(def COLOR_BGR5652BGR Imgproc/COLOR_BGR5652BGR)
(def COLOR_BGR5652RGB Imgproc/COLOR_BGR5652RGB)
(def COLOR_BGRA2BGR565 Imgproc/COLOR_BGRA2BGR565)
(def COLOR_RGBA2BGR565 Imgproc/COLOR_RGBA2BGR565)
(def COLOR_BGR5652BGRA Imgproc/COLOR_BGR5652BGRA)
(def COLOR_BGR5652RGBA Imgproc/COLOR_BGR5652RGBA)
(def COLOR_GRAY2BGR565 Imgproc/COLOR_GRAY2BGR565)
(def COLOR_BGR5652GRAY Imgproc/COLOR_BGR5652GRAY)
(def COLOR_BGR2BGR555 Imgproc/COLOR_BGR2BGR555)
(def COLOR_RGB2BGR555 Imgproc/COLOR_RGB2BGR555)
(def COLOR_BGR5552BGR Imgproc/COLOR_BGR5552BGR)
(def COLOR_BGR5552RGB Imgproc/COLOR_BGR5552RGB)
(def COLOR_BGRA2BGR555 Imgproc/COLOR_BGRA2BGR555)
(def COLOR_RGBA2BGR555 Imgproc/COLOR_RGBA2BGR555)
(def COLOR_BGR5552BGRA Imgproc/COLOR_BGR5552BGRA)
(def COLOR_BGR5552RGBA Imgproc/COLOR_BGR5552RGBA)
(def COLOR_GRAY2BGR555 Imgproc/COLOR_GRAY2BGR555)
(def COLOR_BGR5552GRAY Imgproc/COLOR_BGR5552GRAY)
(def COLOR_BGR2XYZ Imgproc/COLOR_BGR2XYZ)
(def COLOR_RGB2XYZ Imgproc/COLOR_RGB2XYZ)
(def COLOR_XYZ2BGR Imgproc/COLOR_XYZ2BGR)
(def COLOR_XYZ2RGB Imgproc/COLOR_XYZ2RGB)
(def COLOR_BGR2YCrCb Imgproc/COLOR_BGR2YCrCb)
(def COLOR_RGB2YCrCb Imgproc/COLOR_RGB2YCrCb)
(def COLOR_YCrCb2BGR Imgproc/COLOR_YCrCb2BGR)
(def COLOR_YCrCb2RGB Imgproc/COLOR_YCrCb2RGB)
(def COLOR_BGR2HSV Imgproc/COLOR_BGR2HSV)
(def COLOR_RGB2HSV Imgproc/COLOR_RGB2HSV)
(def COLOR_BGR2Lab Imgproc/COLOR_BGR2Lab)
(def COLOR_RGB2Lab Imgproc/COLOR_RGB2Lab)
(def COLOR_BGR2Luv Imgproc/COLOR_BGR2Luv)
(def COLOR_RGB2Luv Imgproc/COLOR_RGB2Luv)
(def COLOR_BGR2HLS Imgproc/COLOR_BGR2HLS)
(def COLOR_RGB2HLS Imgproc/COLOR_RGB2HLS)
(def COLOR_HSV2BGR Imgproc/COLOR_HSV2BGR)
(def COLOR_HSV2RGB Imgproc/COLOR_HSV2RGB)
(def COLOR_Lab2BGR Imgproc/COLOR_Lab2BGR)
(def COLOR_Lab2RGB Imgproc/COLOR_Lab2RGB)
(def COLOR_Luv2BGR Imgproc/COLOR_Luv2BGR)
(def COLOR_Luv2RGB Imgproc/COLOR_Luv2RGB)
(def COLOR_HLS2BGR Imgproc/COLOR_HLS2BGR)
(def COLOR_HLS2RGB Imgproc/COLOR_HLS2RGB)
(def COLOR_BGR2HSV_FULL Imgproc/COLOR_BGR2HSV_FULL)
(def COLOR_RGB2HSV_FULL Imgproc/COLOR_RGB2HSV_FULL)
(def COLOR_BGR2HLS_FULL Imgproc/COLOR_BGR2HLS_FULL)
(def COLOR_RGB2HLS_FULL Imgproc/COLOR_RGB2HLS_FULL)
(def COLOR_HSV2BGR_FULL Imgproc/COLOR_HSV2BGR_FULL)
(def COLOR_HSV2RGB_FULL Imgproc/COLOR_HSV2RGB_FULL)
(def COLOR_HLS2BGR_FULL Imgproc/COLOR_HLS2BGR_FULL)
(def COLOR_HLS2RGB_FULL Imgproc/COLOR_HLS2RGB_FULL)
(def COLOR_LBGR2Lab Imgproc/COLOR_LBGR2Lab)
(def COLOR_LRGB2Lab Imgproc/COLOR_LRGB2Lab)
(def COLOR_LBGR2Luv Imgproc/COLOR_LBGR2Luv)
(def COLOR_LRGB2Luv Imgproc/COLOR_LRGB2Luv)
(def COLOR_Lab2LBGR Imgproc/COLOR_Lab2LBGR)
(def COLOR_Lab2LRGB Imgproc/COLOR_Lab2LRGB)
(def COLOR_Luv2LBGR Imgproc/COLOR_Luv2LBGR)
(def COLOR_Luv2LRGB Imgproc/COLOR_Luv2LRGB)
(def COLOR_BGR2YUV Imgproc/COLOR_BGR2YUV)
(def COLOR_RGB2YUV Imgproc/COLOR_RGB2YUV)
(def COLOR_YUV2BGR Imgproc/COLOR_YUV2BGR)
(def COLOR_YUV2RGB Imgproc/COLOR_YUV2RGB)
(def COLOR_YUV2RGB_NV12 Imgproc/COLOR_YUV2RGB_NV12)
(def COLOR_YUV2BGR_NV12 Imgproc/COLOR_YUV2BGR_NV12)
(def COLOR_YUV2RGB_NV21 Imgproc/COLOR_YUV2RGB_NV21)
(def COLOR_YUV2BGR_NV21 Imgproc/COLOR_YUV2BGR_NV21)
(def COLOR_YUV420sp2RGB Imgproc/COLOR_YUV420sp2RGB)
(def COLOR_YUV420sp2BGR Imgproc/COLOR_YUV420sp2BGR)
(def COLOR_YUV2RGBA_NV12 Imgproc/COLOR_YUV2RGBA_NV12)
(def COLOR_YUV2BGRA_NV12 Imgproc/COLOR_YUV2BGRA_NV12)
(def COLOR_YUV2RGBA_NV21 Imgproc/COLOR_YUV2RGBA_NV21)
(def COLOR_YUV2BGRA_NV21 Imgproc/COLOR_YUV2BGRA_NV21)
(def COLOR_YUV420sp2RGBA Imgproc/COLOR_YUV420sp2RGBA)
(def COLOR_YUV420sp2BGRA Imgproc/COLOR_YUV420sp2BGRA)
(def COLOR_YUV2RGB_YV12 Imgproc/COLOR_YUV2RGB_YV12)
(def COLOR_YUV2BGR_YV12 Imgproc/COLOR_YUV2BGR_YV12)
(def COLOR_YUV2RGB_IYUV Imgproc/COLOR_YUV2RGB_IYUV)
(def COLOR_YUV2BGR_IYUV Imgproc/COLOR_YUV2BGR_IYUV)
(def COLOR_YUV2RGB_I420 Imgproc/COLOR_YUV2RGB_I420)
(def COLOR_YUV2BGR_I420 Imgproc/COLOR_YUV2BGR_I420)
(def COLOR_YUV420p2RGB Imgproc/COLOR_YUV420p2RGB)
(def COLOR_YUV420p2BGR Imgproc/COLOR_YUV420p2BGR)
(def COLOR_YUV2RGBA_YV12 Imgproc/COLOR_YUV2RGBA_YV12)
(def COLOR_YUV2BGRA_YV12 Imgproc/COLOR_YUV2BGRA_YV12)
(def COLOR_YUV2RGBA_IYUV Imgproc/COLOR_YUV2RGBA_IYUV)
(def COLOR_YUV2BGRA_IYUV Imgproc/COLOR_YUV2BGRA_IYUV)
(def COLOR_YUV2RGBA_I420 Imgproc/COLOR_YUV2RGBA_I420)
(def COLOR_YUV2BGRA_I420 Imgproc/COLOR_YUV2BGRA_I420)
(def COLOR_YUV420p2RGBA Imgproc/COLOR_YUV420p2RGBA)
(def COLOR_YUV420p2BGRA Imgproc/COLOR_YUV420p2BGRA)
(def COLOR_YUV2GRAY_420 Imgproc/COLOR_YUV2GRAY_420)
(def COLOR_YUV2GRAY_NV21 Imgproc/COLOR_YUV2GRAY_NV21)
(def COLOR_YUV2GRAY_NV12 Imgproc/COLOR_YUV2GRAY_NV12)
(def COLOR_YUV2GRAY_YV12 Imgproc/COLOR_YUV2GRAY_YV12)
(def COLOR_YUV2GRAY_IYUV Imgproc/COLOR_YUV2GRAY_IYUV)
(def COLOR_YUV2GRAY_I420 Imgproc/COLOR_YUV2GRAY_I420)
(def COLOR_YUV420sp2GRAY Imgproc/COLOR_YUV420sp2GRAY)
(def COLOR_YUV420p2GRAY Imgproc/COLOR_YUV420p2GRAY)
(def COLOR_YUV2RGB_UYVY Imgproc/COLOR_YUV2RGB_UYVY)
(def COLOR_YUV2BGR_UYVY Imgproc/COLOR_YUV2BGR_UYVY)
(def COLOR_YUV2RGB_Y422 Imgproc/COLOR_YUV2RGB_Y422)
(def COLOR_YUV2BGR_Y422 Imgproc/COLOR_YUV2BGR_Y422)
(def COLOR_YUV2RGB_UYNV Imgproc/COLOR_YUV2RGB_UYNV)
(def COLOR_YUV2BGR_UYNV Imgproc/COLOR_YUV2BGR_UYNV)
(def COLOR_YUV2RGBA_UYVY Imgproc/COLOR_YUV2RGBA_UYVY)
(def COLOR_YUV2BGRA_UYVY Imgproc/COLOR_YUV2BGRA_UYVY)
(def COLOR_YUV2RGBA_Y422 Imgproc/COLOR_YUV2RGBA_Y422)
(def COLOR_YUV2BGRA_Y422 Imgproc/COLOR_YUV2BGRA_Y422)
(def COLOR_YUV2RGBA_UYNV Imgproc/COLOR_YUV2RGBA_UYNV)
(def COLOR_YUV2BGRA_UYNV Imgproc/COLOR_YUV2BGRA_UYNV)
(def COLOR_YUV2RGB_YUY2 Imgproc/COLOR_YUV2RGB_YUY2)
(def COLOR_YUV2BGR_YUY2 Imgproc/COLOR_YUV2BGR_YUY2)
(def COLOR_YUV2RGB_YVYU Imgproc/COLOR_YUV2RGB_YVYU)
(def COLOR_YUV2BGR_YVYU Imgproc/COLOR_YUV2BGR_YVYU)
(def COLOR_YUV2RGB_YUYV Imgproc/COLOR_YUV2RGB_YUYV)
(def COLOR_YUV2BGR_YUYV Imgproc/COLOR_YUV2BGR_YUYV)
(def COLOR_YUV2RGB_YUNV Imgproc/COLOR_YUV2RGB_YUNV)
(def COLOR_YUV2BGR_YUNV Imgproc/COLOR_YUV2BGR_YUNV)
(def COLOR_YUV2RGBA_YUY2 Imgproc/COLOR_YUV2RGBA_YUY2)
(def COLOR_YUV2BGRA_YUY2 Imgproc/COLOR_YUV2BGRA_YUY2)
(def COLOR_YUV2RGBA_YVYU Imgproc/COLOR_YUV2RGBA_YVYU)
(def COLOR_YUV2BGRA_YVYU Imgproc/COLOR_YUV2BGRA_YVYU)
(def COLOR_YUV2RGBA_YUYV Imgproc/COLOR_YUV2RGBA_YUYV)
(def COLOR_YUV2BGRA_YUYV Imgproc/COLOR_YUV2BGRA_YUYV)
(def COLOR_YUV2RGBA_YUNV Imgproc/COLOR_YUV2RGBA_YUNV)
(def COLOR_YUV2BGRA_YUNV Imgproc/COLOR_YUV2BGRA_YUNV)
(def COLOR_YUV2GRAY_UYVY Imgproc/COLOR_YUV2GRAY_UYVY)
(def COLOR_YUV2GRAY_YUY2 Imgproc/COLOR_YUV2GRAY_YUY2)
(def COLOR_YUV2GRAY_Y422 Imgproc/COLOR_YUV2GRAY_Y422)
(def COLOR_YUV2GRAY_UYNV Imgproc/COLOR_YUV2GRAY_UYNV)
(def COLOR_YUV2GRAY_YVYU Imgproc/COLOR_YUV2GRAY_YVYU)
(def COLOR_YUV2GRAY_YUYV Imgproc/COLOR_YUV2GRAY_YUYV)
(def COLOR_YUV2GRAY_YUNV Imgproc/COLOR_YUV2GRAY_YUNV)
(def COLOR_RGBA2mRGBA Imgproc/COLOR_RGBA2mRGBA)
(def COLOR_mRGBA2RGBA Imgproc/COLOR_mRGBA2RGBA)
(def COLOR_RGB2YUV_I420 Imgproc/COLOR_RGB2YUV_I420)
(def COLOR_BGR2YUV_I420 Imgproc/COLOR_BGR2YUV_I420)
(def COLOR_RGB2YUV_IYUV Imgproc/COLOR_RGB2YUV_IYUV)
(def COLOR_BGR2YUV_IYUV Imgproc/COLOR_BGR2YUV_IYUV)
(def COLOR_RGBA2YUV_I420 Imgproc/COLOR_RGBA2YUV_I420)
(def COLOR_BGRA2YUV_I420 Imgproc/COLOR_BGRA2YUV_I420)
(def COLOR_RGBA2YUV_IYUV Imgproc/COLOR_RGBA2YUV_IYUV)
(def COLOR_BGRA2YUV_IYUV Imgproc/COLOR_BGRA2YUV_IYUV)
(def COLOR_RGB2YUV_YV12 Imgproc/COLOR_RGB2YUV_YV12)
(def COLOR_BGR2YUV_YV12 Imgproc/COLOR_BGR2YUV_YV12)
(def COLOR_RGBA2YUV_YV12 Imgproc/COLOR_RGBA2YUV_YV12)
(def COLOR_BGRA2YUV_YV12 Imgproc/COLOR_BGRA2YUV_YV12)
(def COLOR_BayerBG2BGR Imgproc/COLOR_BayerBG2BGR)
(def COLOR_BayerGB2BGR Imgproc/COLOR_BayerGB2BGR)
(def COLOR_BayerRG2BGR Imgproc/COLOR_BayerRG2BGR)
(def COLOR_BayerGR2BGR Imgproc/COLOR_BayerGR2BGR)
(def COLOR_BayerBG2RGB Imgproc/COLOR_BayerBG2RGB)
(def COLOR_BayerGB2RGB Imgproc/COLOR_BayerGB2RGB)
(def COLOR_BayerRG2RGB Imgproc/COLOR_BayerRG2RGB)
(def COLOR_BayerGR2RGB Imgproc/COLOR_BayerGR2RGB)
(def COLOR_BayerBG2GRAY Imgproc/COLOR_BayerBG2GRAY)
(def COLOR_BayerGB2GRAY Imgproc/COLOR_BayerGB2GRAY)
(def COLOR_BayerRG2GRAY Imgproc/COLOR_BayerRG2GRAY)
(def COLOR_BayerGR2GRAY Imgproc/COLOR_BayerGR2GRAY)
(def COLOR_BayerBG2BGR_VNG Imgproc/COLOR_BayerBG2BGR_VNG)
(def COLOR_BayerGB2BGR_VNG Imgproc/COLOR_BayerGB2BGR_VNG)
(def COLOR_BayerRG2BGR_VNG Imgproc/COLOR_BayerRG2BGR_VNG)
(def COLOR_BayerGR2BGR_VNG Imgproc/COLOR_BayerGR2BGR_VNG)
(def COLOR_BayerBG2RGB_VNG Imgproc/COLOR_BayerBG2RGB_VNG)
(def COLOR_BayerGB2RGB_VNG Imgproc/COLOR_BayerGB2RGB_VNG)
(def COLOR_BayerRG2RGB_VNG Imgproc/COLOR_BayerRG2RGB_VNG)
(def COLOR_BayerGR2RGB_VNG Imgproc/COLOR_BayerGR2RGB_VNG)
(def COLOR_BayerBG2BGR_EA Imgproc/COLOR_BayerBG2BGR_EA)
(def COLOR_BayerGB2BGR_EA Imgproc/COLOR_BayerGB2BGR_EA)
(def COLOR_BayerRG2BGR_EA Imgproc/COLOR_BayerRG2BGR_EA)
(def COLOR_BayerGR2BGR_EA Imgproc/COLOR_BayerGR2BGR_EA)
(def COLOR_BayerBG2RGB_EA Imgproc/COLOR_BayerBG2RGB_EA)
(def COLOR_BayerGB2RGB_EA Imgproc/COLOR_BayerGB2RGB_EA)
(def COLOR_BayerRG2RGB_EA Imgproc/COLOR_BayerRG2RGB_EA)
(def COLOR_BayerGR2RGB_EA Imgproc/COLOR_BayerGR2RGB_EA)
(def COLOR_BayerBG2BGRA Imgproc/COLOR_BayerBG2BGRA)
(def COLOR_BayerGB2BGRA Imgproc/COLOR_BayerGB2BGRA)
(def COLOR_BayerRG2BGRA Imgproc/COLOR_BayerRG2BGRA)
(def COLOR_BayerGR2BGRA Imgproc/COLOR_BayerGR2BGRA)
(def COLOR_BayerBG2RGBA Imgproc/COLOR_BayerBG2RGBA)
(def COLOR_BayerGB2RGBA Imgproc/COLOR_BayerGB2RGBA)
(def COLOR_BayerRG2RGBA Imgproc/COLOR_BayerRG2RGBA)
(def COLOR_BayerGR2RGBA Imgproc/COLOR_BayerGR2RGBA)
(def COLOR_COLORCVT_MAX Imgproc/COLOR_COLORCVT_MAX)
(def INTERSECT_NONE Imgproc/INTERSECT_NONE)
(def INTERSECT_PARTIAL Imgproc/INTERSECT_PARTIAL)
(def INTERSECT_FULL Imgproc/INTERSECT_FULL)
(def TM_SQDIFF Imgproc/TM_SQDIFF)
(def TM_SQDIFF_NORMED Imgproc/TM_SQDIFF_NORMED)
(def TM_CCORR Imgproc/TM_CCORR)
(def TM_CCORR_NORMED Imgproc/TM_CCORR_NORMED)
(def TM_CCOEFF Imgproc/TM_CCOEFF)
(def TM_CCOEFF_NORMED Imgproc/TM_CCOEFF_NORMED)
(def COLORMAP_AUTUMN Imgproc/COLORMAP_AUTUMN)
(def COLORMAP_BONE Imgproc/COLORMAP_BONE)
(def COLORMAP_JET Imgproc/COLORMAP_JET)
(def COLORMAP_WINTER Imgproc/COLORMAP_WINTER)
(def COLORMAP_RAINBOW Imgproc/COLORMAP_RAINBOW)
(def COLORMAP_OCEAN Imgproc/COLORMAP_OCEAN)
(def COLORMAP_SUMMER Imgproc/COLORMAP_SUMMER)
(def COLORMAP_SPRING Imgproc/COLORMAP_SPRING)
(def COLORMAP_COOL Imgproc/COLORMAP_COOL)
(def COLORMAP_HSV Imgproc/COLORMAP_HSV)
(def COLORMAP_PINK Imgproc/COLORMAP_PINK)
(def COLORMAP_HOT Imgproc/COLORMAP_HOT)
(def COLORMAP_PARULA Imgproc/COLORMAP_PARULA)
(def MARKER_CROSS Imgproc/MARKER_CROSS)
(def MARKER_TILTED_CROSS Imgproc/MARKER_TILTED_CROSS)
(def MARKER_STAR Imgproc/MARKER_STAR)
(def MARKER_DIAMOND Imgproc/MARKER_DIAMOND)
(def MARKER_SQUARE Imgproc/MARKER_SQUARE)
(def MARKER_TRIANGLE_UP Imgproc/MARKER_TRIANGLE_UP)
(def MARKER_TRIANGLE_DOWN Imgproc/MARKER_TRIANGLE_DOWN)
;;;
(def VERSION Core/VERSION)
(def NATIVE_LIBRARY_NAME Core/NATIVE_LIBRARY_NAME)
(def VERSION_MAJOR Core/VERSION_MAJOR)
(def VERSION_MINOR Core/VERSION_MINOR)
(def VERSION_REVISION Core/VERSION_REVISION)
(def VERSION_STATUS Core/VERSION_STATUS)
(def SVD_MODIFY_A Core/SVD_MODIFY_A)
(def SVD_NO_UV Core/SVD_NO_UV)
(def SVD_FULL_UV Core/SVD_FULL_UV)
(def FILLED Core/FILLED)
(def REDUCE_SUM Core/REDUCE_SUM)
(def REDUCE_AVG Core/REDUCE_AVG)
(def REDUCE_MAX Core/REDUCE_MAX)
(def REDUCE_MIN Core/REDUCE_MIN)
(def StsOk Core/StsOk)
(def StsBackTrace Core/StsBackTrace)
(def StsError Core/StsError)
(def StsInternal Core/StsInternal)
(def StsNoMem Core/StsNoMem)
(def StsBadArg Core/StsBadArg)
(def StsBadFunc Core/StsBadFunc)
(def StsNoConv Core/StsNoConv)
(def StsAutoTrace Core/StsAutoTrace)
(def HeaderIsNull Core/HeaderIsNull)
(def BadImageSize Core/BadImageSize)
(def BadOffset Core/BadOffset)
(def BadDataPtr Core/BadDataPtr)
(def BadStep Core/BadStep)
(def BadModelOrChSeq Core/BadModelOrChSeq)
(def BadNumChannels Core/BadNumChannels)
(def BadNumChannel1U Core/BadNumChannel1U)
(def BadDepth Core/BadDepth)
(def BadAlphaChannel Core/BadAlphaChannel)
(def BadOrder Core/BadOrder)
(def BadOrigin Core/BadOrigin)
(def BadAlign Core/BadAlign)
(def BadCallBack Core/BadCallBack)
(def BadTileSize Core/BadTileSize)
(def BadCOI Core/BadCOI)
(def BadROISize Core/BadROISize)
(def MaskIsTiled Core/MaskIsTiled)
(def StsNullPtr Core/StsNullPtr)
(def StsVecLengthErr Core/StsVecLengthErr)
(def StsFilterStructContentErr Core/StsFilterStructContentErr)
(def StsKernelStructContentErr Core/StsKernelStructContentErr)
(def StsFilterOffsetErr Core/StsFilterOffsetErr)
(def StsBadSize Core/StsBadSize)
(def StsDivByZero Core/StsDivByZero)
(def StsInplaceNotSupported Core/StsInplaceNotSupported)
(def StsObjectNotFound Core/StsObjectNotFound)
(def StsUnmatchedFormats Core/StsUnmatchedFormats)
(def StsBadFlag Core/StsBadFlag)
(def StsBadPoint Core/StsBadPoint)
(def StsBadMask Core/StsBadMask)
(def StsUnmatchedSizes Core/StsUnmatchedSizes)
(def StsUnsupportedFormat Core/StsUnsupportedFormat)
(def StsOutOfRange Core/StsOutOfRange)
(def StsParseError Core/StsParseError)
(def StsNotImplemented Core/StsNotImplemented)
(def StsBadMemBlock Core/StsBadMemBlock)
(def StsAssert Core/StsAssert)
(def GpuNotSupported Core/GpuNotSupported)
(def GpuApiCallError Core/GpuApiCallError)
(def OpenGlNotSupported Core/OpenGlNotSupported)
(def OpenGlApiCallError Core/OpenGlApiCallError)
(def OpenCLApiCallError Core/OpenCLApiCallError)
(def OpenCLDoubleNotSupported Core/OpenCLDoubleNotSupported)
(def OpenCLInitError Core/OpenCLInitError)
(def OpenCLNoAMDBlasFft Core/OpenCLNoAMDBlasFft)
(def DECOMP_LU Core/DECOMP_LU)
(def DECOMP_SVD Core/DECOMP_SVD)
(def DECOMP_EIG Core/DECOMP_EIG)
(def DECOMP_CHOLESKY Core/DECOMP_CHOLESKY)
(def DECOMP_QR Core/DECOMP_QR)
(def DECOMP_NORMAL Core/DECOMP_NORMAL)
(def NORM_INF Core/NORM_INF)
(def NORM_L1 Core/NORM_L1)
(def NORM_L2 Core/NORM_L2)
(def NORM_L2SQR Core/NORM_L2SQR)
(def NORM_HAMMING Core/NORM_HAMMING)
(def NORM_HAMMING2 Core/NORM_HAMMING2)
(def NORM_TYPE_MASK Core/NORM_TYPE_MASK)
(def NORM_RELATIVE Core/NORM_RELATIVE)
(def NORM_MINMAX Core/NORM_MINMAX)
(def CMP_EQ Core/CMP_EQ)
(def CMP_GT Core/CMP_GT)
(def CMP_GE Core/CMP_GE)
(def CMP_LT Core/CMP_LT)
(def CMP_LE Core/CMP_LE)
(def CMP_NE Core/CMP_NE)
(def GEMM_1_T Core/GEMM_1_T)
(def GEMM_2_T Core/GEMM_2_T)
(def GEMM_3_T Core/GEMM_3_T)
(def DFT_INVERSE Core/DFT_INVERSE)
(def DFT_SCALE Core/DFT_SCALE)
(def DFT_ROWS Core/DFT_ROWS)
(def DFT_COMPLEX_OUTPUT Core/DFT_COMPLEX_OUTPUT)
(def DFT_REAL_OUTPUT Core/DFT_REAL_OUTPUT)
(def DFT_COMPLEX_INPUT Core/DFT_COMPLEX_INPUT)
(def DCT_INVERSE Core/DCT_INVERSE)
(def DCT_ROWS Core/DCT_ROWS)
(def BORDER_CONSTANT Core/BORDER_CONSTANT)
(def BORDER_REPLICATE Core/BORDER_REPLICATE)
(def BORDER_REFLECT Core/BORDER_REFLECT)
(def BORDER_WRAP Core/BORDER_WRAP)
(def BORDER_REFLECT_101 Core/BORDER_REFLECT_101)
(def BORDER_TRANSPARENT Core/BORDER_TRANSPARENT)
(def BORDER_REFLECT101 Core/BORDER_REFLECT101)
(def BORDER_DEFAULT Core/BORDER_DEFAULT)
(def BORDER_ISOLATED Core/BORDER_ISOLATED)
(def SORT_EVERY_ROW Core/SORT_EVERY_ROW)
(def SORT_EVERY_COLUMN Core/SORT_EVERY_COLUMN)
(def SORT_ASCENDING Core/SORT_ASCENDING)
(def SORT_DESCENDING Core/SORT_DESCENDING)
(def COVAR_SCRAMBLED Core/COVAR_SCRAMBLED)
(def COVAR_NORMAL Core/COVAR_NORMAL)
(def COVAR_USE_AVG Core/COVAR_USE_AVG)
(def COVAR_SCALE Core/COVAR_SCALE)
(def COVAR_ROWS Core/COVAR_ROWS)
(def COVAR_COLS Core/COVAR_COLS)
(def KMEANS_RANDOM_CENTERS Core/KMEANS_RANDOM_CENTERS)
(def KMEANS_PP_CENTERS Core/KMEANS_PP_CENTERS)
(def KMEANS_USE_INITIAL_LABELS Core/KMEANS_USE_INITIAL_LABELS)
(def LINE_4 Core/LINE_4)
(def LINE_8 Core/LINE_8)
(def LINE_AA Core/LINE_AA)
(def FONT_HERSHEY_SIMPLEX Core/FONT_HERSHEY_SIMPLEX)
(def FONT_HERSHEY_PLAIN Core/FONT_HERSHEY_PLAIN)
(def FONT_HERSHEY_DUPLEX Core/FONT_HERSHEY_DUPLEX)
(def FONT_HERSHEY_COMPLEX Core/FONT_HERSHEY_COMPLEX)
(def FONT_HERSHEY_TRIPLEX Core/FONT_HERSHEY_TRIPLEX)
(def FONT_HERSHEY_COMPLEX_SMALL Core/FONT_HERSHEY_COMPLEX_SMALL)
(def FONT_HERSHEY_SCRIPT_SIMPLEX Core/FONT_HERSHEY_SCRIPT_SIMPLEX)
(def FONT_HERSHEY_SCRIPT_COMPLEX Core/FONT_HERSHEY_SCRIPT_COMPLEX)
(def FONT_ITALIC Core/FONT_ITALIC)
(def ROTATE_90_CLOCKWISE Core/ROTATE_90_CLOCKWISE)
(def ROTATE_180 Core/ROTATE_180)
(def ROTATE_90_COUNTERCLOCKWISE Core/ROTATE_90_COUNTERCLOCKWISE)
(def TYPE_GENERAL Core/TYPE_GENERAL)
(def TYPE_MARKER Core/TYPE_MARKER)
(def TYPE_WRAPPER Core/TYPE_WRAPPER)
(def TYPE_FUN Core/TYPE_FUN)
(def IMPL_PLAIN Core/IMPL_PLAIN)
(def IMPL_IPP Core/IMPL_IPP)
(def IMPL_OPENCL Core/IMPL_OPENCL)
(def FLAGS_NONE Core/FLAGS_NONE)
(def FLAGS_MAPPING Core/FLAGS_MAPPING)
(def FLAGS_EXPAND_SAME_NAMES Core/FLAGS_EXPAND_SAME_NAMES)
(defn add
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn sqrt
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/sqrt org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn sqrt!
([org_opencv_core_mat_0 ]
  (Core/sqrt org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn log
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/log org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn log!
([org_opencv_core_mat_0 ]
  (Core/log org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn pow
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 ]
  (Core/pow org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 ))
)

(defn exp
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/exp org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn exp!
([org_opencv_core_mat_0 ]
  (Core/exp org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn min
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ]
  (Core/min org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ))
)

(defn max
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ]
  (Core/max org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ))
)

(defn split
([org_opencv_core_mat_0 java_util_list_1 ]
  (Core/split org_opencv_core_mat_0 java_util_list_1 ))
)

(defn compare
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 int_3 ]
  (Core/compare org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 int_3 ))
)

(defn merge
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/merge java_util_list_0 org_opencv_core_mat_1 ))
)

(defn normalize
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ))
)

(defn normalize!
([org_opencv_core_mat_0 double_2 double_3 int_4 int_5 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
)

(defn flip
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/flip org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn flip!
([org_opencv_core_mat_0 int_2 ]
  (Core/flip org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn divide
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 double_3 int_4 ))
)

(defn divide!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn sort
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/sort org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn sort!
([org_opencv_core_mat_0 int_2 ]
  (Core/sort org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn rotate
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/rotate org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn rotate!
([org_opencv_core_mat_0 int_2 ]
  (Core/rotate org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn check-range
([org_opencv_core_mat_0 boolean_1 double_2 double_3 ]
  (Core/checkRange org_opencv_core_mat_0 boolean_1 double_2 double_3 ))
([org_opencv_core_mat_0 ]
  (Core/checkRange org_opencv_core_mat_0 ))
)

(defn reduce
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn reduce!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn repeat
([org_opencv_core_mat_0 int_1 int_2 org_opencv_core_mat_3 ]
  (Core/repeat org_opencv_core_mat_0 int_1 int_2 org_opencv_core_mat_3 ))
)

(defn mean
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 ))
)

(defn mean!
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
; ([org_opencv_core_mat_0 ]
;   (Core/mean org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn sum-elems
([org_opencv_core_mat_0 ]
  (Core/sumElems org_opencv_core_mat_0 ))
)

(defn get-build-information
([]
  (Core/getBuildInformation ))
)

(defn eigen
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn eigen!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn solve
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
)

(defn solve!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
)

(defn use-ipp
([]
  (Core/useIPP ))
)

(defn mahalanobis
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/Mahalanobis org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn mahalanobis!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/Mahalanobis org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn psnr
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn psnr!
([org_opencv_core_mat_0 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn determinant
([org_opencv_core_mat_0 ]
  (Core/determinant org_opencv_core_mat_0 ))
)

(defn get-tick-frequency
([]
  (Core/getTickFrequency ))
)

(defn invert
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn invert!
([org_opencv_core_mat_0 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn kmeans
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 ]
  (Core/kmeans org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 ))
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/kmeans org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 org_opencv_core_mat_6 ))
)

(defn norm
([org_opencv_core_mat_0 ]
  (Core/norm org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn solve-poly
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn solve-poly!
([org_opencv_core_mat_0 int_2 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn cube-root
([float_0 ]
  (Core/cubeRoot float_0 ))
)

(defn fast-atan-2
([float_0 float_1 ]
  (Core/fastAtan2 float_0 float_1 ))
)

(defn border-interpolate
([int_0 int_1 int_2 ]
  (Core/borderInterpolate int_0 int_1 int_2 ))
)

(defn count-non-zero
([org_opencv_core_mat_0 ]
  (Core/countNonZero org_opencv_core_mat_0 ))
)

(defn get-num-threads
([]
  (Core/getNumThreads ))
)

(defn get-number-of-cp-us
([]
  (Core/getNumberOfCPUs ))
)

(defn get-optimal-dft-size
([int_0 ]
  (Core/getOptimalDFTSize int_0 ))
)

(defn get-thread-num
([]
  (Core/getThreadNum ))
)

(defn solve-cubic
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/solveCubic org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn solve-cubic!
([org_opencv_core_mat_0 ]
  (Core/solveCubic org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn get-cpu-tick-count
([]
  (Core/getCPUTickCount ))
)

(defn get-tick-count
([]
  (Core/getTickCount ))
)

(defn lut
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/LUT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn lut!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/LUT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn pca-back-project
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCABackProject org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn pca-back-project!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCABackProject org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn pca-compute
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ]
  (Core/PCACompute org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/PCACompute org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn pca-compute!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ]
  (Core/PCACompute org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/PCACompute org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn pca-project
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCAProject org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn pca-project!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCAProject org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn sv-back-subst
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Core/SVBackSubst org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn sv-back-subst!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Core/SVBackSubst org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn sv-decomp
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/SVDecomp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/SVDecomp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn sv-decomp!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/SVDecomp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/SVDecomp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn absdiff
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/absdiff org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn absdiff!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/absdiff org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn add-weighted
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 ]
  (Core/addWeighted org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 int_6 ]
  (Core/addWeighted org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 int_6 ))
)

(defn batch-distance
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ))
)

(defn batch-distance!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ) org_opencv_core_mat_0 )
)

(defn bitwise-and
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn bitwise-and!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn bitwise-not
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_not org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/bitwise_not org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn bitwise-not!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_not org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/bitwise_not org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn bitwise-or
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_or org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_or org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn bitwise-or!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_or org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_or org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn bitwise-xor
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn bitwise-xor!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn calc-covar-matrix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Core/calcCovarMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Core/calcCovarMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn calc-covar-matrix!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Core/calcCovarMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Core/calcCovarMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn cart-to-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ))
)

(defn cart-to-polar!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ) org_opencv_core_mat_0 )
)

(defn complete-symm
([org_opencv_core_mat_0 ]
  (Core/completeSymm org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 boolean_1 ]
  (Core/completeSymm org_opencv_core_mat_0 boolean_1 ))
)

(defn convert-fp-16
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/convertFp16 org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-fp-16!
([org_opencv_core_mat_0 ]
  (Core/convertFp16 org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn convert-scale-abs
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
)

(defn convert-scale-abs!
([org_opencv_core_mat_0 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
)

(defn copy-make-border
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 int_6 ]
  (Core/copyMakeBorder org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Core/copyMakeBorder org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 int_6 org_opencv_core_scalar_7 ))
)

(defn copy-make-border!
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 int_6 ]
  (Core/copyMakeBorder org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Core/copyMakeBorder org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 int_6 org_opencv_core_scalar_7 ) org_opencv_core_mat_0 )
)

(defn dct
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/dct org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/dct org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn dct!
([org_opencv_core_mat_0 ]
  (Core/dct org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/dct org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn dft
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn dft!
([org_opencv_core_mat_0 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn extract-channel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/extractChannel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn extract-channel!
([org_opencv_core_mat_0 int_2 ]
  (Core/extractChannel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn find-non-zero
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/findNonZero org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn find-non-zero!
([org_opencv_core_mat_0 ]
  (Core/findNonZero org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn gemm
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 ]
  (Core/gemm org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 int_6 ]
  (Core/gemm org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 int_6 ))
)

(defn gemm!
([org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 ]
  (Core/gemm org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 int_6 ]
  (Core/gemm org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_mat_3 double_4 org_opencv_core_mat_5 int_6 ) org_opencv_core_mat_0 )
)

(defn hconcat
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/hconcat java_util_list_0 org_opencv_core_mat_1 ))
)

(defn idct
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn idct!
([org_opencv_core_mat_0 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn idft
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn idft!
([org_opencv_core_mat_0 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn insert-channel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/insertChannel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn insert-channel!
([org_opencv_core_mat_0 int_2 ]
  (Core/insertChannel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn mean-std-dev
([org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 ]
  (Core/meanStdDev org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 ))
([org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 org_opencv_core_mat_3 ]
  (Core/meanStdDev org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 org_opencv_core_mat_3 ))
)

(defn mix-channels
([java_util_list_0 java_util_list_1 org_opencv_core_matofint_2 ]
  (Core/mixChannels java_util_list_0 java_util_list_1 org_opencv_core_matofint_2 ))
)

(defn mul-spectrums
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Core/mulSpectrums org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 boolean_4 ]
  (Core/mulSpectrums org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 boolean_4 ))
)

(defn mul-spectrums!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Core/mulSpectrums org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 boolean_4 ]
  (Core/mulSpectrums org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 boolean_4 ) org_opencv_core_mat_0 )
)

(defn mul-transposed
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 int_5 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 ))
)

(defn mul-transposed!
([org_opencv_core_mat_0 boolean_2 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 int_5 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 ) org_opencv_core_mat_0 )
)

(defn patch-na-ns
([org_opencv_core_mat_0 double_1 ]
  (Core/patchNaNs org_opencv_core_mat_0 double_1 ))
([org_opencv_core_mat_0 ]
  (Core/patchNaNs org_opencv_core_mat_0 ))
)

(defn perspective-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/perspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn perspective-transform!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/perspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn phase
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ]
  (Core/phase org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/phase org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn phase!
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ]
  (Core/phase org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/phase org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn polar-to-cart
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn polar-to-cart!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn rand-shuffle
([org_opencv_core_mat_0 double_1 ]
  (Core/randShuffle org_opencv_core_mat_0 double_1 ))
([org_opencv_core_mat_0 ]
  (Core/randShuffle org_opencv_core_mat_0 ))
)

(defn randn
([org_opencv_core_mat_0 double_1 double_2 ]
  (Core/randn org_opencv_core_mat_0 double_1 double_2 ))
)

(defn randu
([org_opencv_core_mat_0 double_1 double_2 ]
  (Core/randu org_opencv_core_mat_0 double_1 double_2 ))
)

(defn scale-add
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/scaleAdd org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn set-error-verbosity
([boolean_0 ]
  (Core/setErrorVerbosity boolean_0 ))
)

(defn set-identity
([org_opencv_core_mat_0 ]
  (Core/setIdentity org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 ]
  (Core/setIdentity org_opencv_core_mat_0 org_opencv_core_scalar_1 ))
)

(defn set-num-threads
([int_0 ]
  (Core/setNumThreads int_0 ))
)

(defn set-rng-seed
([int_0 ]
  (Core/setRNGSeed int_0 ))
)

(defn sort-idx
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/sortIdx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn sort-idx!
([org_opencv_core_mat_0 int_2 ]
  (Core/sortIdx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/transform org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn transform!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/transform org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn transpose
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/transpose org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn transpose!
([org_opencv_core_mat_0 ]
  (Core/transpose org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn vconcat
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/vconcat java_util_list_0 org_opencv_core_mat_1 ))
)

(defn set-use-ipp
([boolean_0 ]
  (Core/setUseIPP boolean_0 ))
)

(defn min-max-loc
([org_opencv_core_mat_0 ]
  (Core/minMaxLoc org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/minMaxLoc org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn in-range
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_3 ]
  (Core/inRange org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_3 ))
)
(defn in-range!
  ([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2]
  (Core/inRange org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_0 )
  org_opencv_core_mat_0))

(defn subtract
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn subtract!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
)

(defn multiply
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn multiply!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn magnitude
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/magnitude org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn magnitude!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/magnitude org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn trace
([org_opencv_core_mat_0 ]
  (Core/trace org_opencv_core_mat_0 ))
)


(def CV_8U CvType/CV_8U)
(def CV_8S CvType/CV_8S)
(def CV_16U CvType/CV_16U)
(def CV_16S CvType/CV_16S)
(def CV_32S CvType/CV_32S)
(def CV_32F CvType/CV_32F)
(def CV_64F CvType/CV_64F)
(def CV_USRTYPE1 CvType/CV_USRTYPE1)
(def CV_8UC1 CvType/CV_8UC1)
(def CV_8UC2 CvType/CV_8UC2)
(def CV_8UC3 CvType/CV_8UC3)
(def CV_8UC4 CvType/CV_8UC4)
(def CV_8SC1 CvType/CV_8SC1)
(def CV_8SC2 CvType/CV_8SC2)
(def CV_8SC3 CvType/CV_8SC3)
(def CV_8SC4 CvType/CV_8SC4)
(def CV_16UC1 CvType/CV_16UC1)
(def CV_16UC2 CvType/CV_16UC2)
(def CV_16UC3 CvType/CV_16UC3)
(def CV_16UC4 CvType/CV_16UC4)
(def CV_16SC1 CvType/CV_16SC1)
(def CV_16SC2 CvType/CV_16SC2)
(def CV_16SC3 CvType/CV_16SC3)
(def CV_16SC4 CvType/CV_16SC4)
(def CV_32SC1 CvType/CV_32SC1)
(def CV_32SC2 CvType/CV_32SC2)
(def CV_32SC3 CvType/CV_32SC3)
(def CV_32SC4 CvType/CV_32SC4)
(def CV_32FC1 CvType/CV_32FC1)
(def CV_32FC2 CvType/CV_32FC2)
(def CV_32FC3 CvType/CV_32FC3)
(def CV_32FC4 CvType/CV_32FC4)
(def CV_64FC1 CvType/CV_64FC1)
(def CV_64FC2 CvType/CV_64FC2)
(def CV_64FC3 CvType/CV_64FC3)
(def CV_64FC4 CvType/CV_64FC4)

(defn create-align-mtb
([]
  (Photo/createAlignMTB ))
([int_0 int_1 boolean_2 ]
  (Photo/createAlignMTB int_0 int_1 boolean_2 ))
)

(defn create-calibrate-debevec
([]
  (Photo/createCalibrateDebevec ))
([int_0 float_1 boolean_2 ]
  (Photo/createCalibrateDebevec int_0 float_1 boolean_2 ))
)

(defn create-calibrate-robertson
([]
  (Photo/createCalibrateRobertson ))
([int_0 float_1 ]
  (Photo/createCalibrateRobertson int_0 float_1 ))
)

(defn create-merge-debevec
([]
  (Photo/createMergeDebevec ))
)

(defn create-merge-mertens
([]
  (Photo/createMergeMertens ))
([float_0 float_1 float_2 ]
  (Photo/createMergeMertens float_0 float_1 float_2 ))
)

(defn create-merge-robertson
([]
  (Photo/createMergeRobertson ))
)

(defn create-tonemap
([]
  (Photo/createTonemap ))
([float_0 ]
  (Photo/createTonemap float_0 ))
)

(defn create-tonemap-drago
([]
  (Photo/createTonemapDrago ))
([float_0 float_1 float_2 ]
  (Photo/createTonemapDrago float_0 float_1 float_2 ))
)

(defn create-tonemap-durand
([]
  (Photo/createTonemapDurand ))
([float_0 float_1 float_2 float_3 float_4 ]
  (Photo/createTonemapDurand float_0 float_1 float_2 float_3 float_4 ))
)

(defn create-tonemap-mantiuk
([]
  (Photo/createTonemapMantiuk ))
([float_0 float_1 float_2 ]
  (Photo/createTonemapMantiuk float_0 float_1 float_2 ))
)

(defn create-tonemap-reinhard
([]
  (Photo/createTonemapReinhard ))
([float_0 float_1 float_2 float_3 ]
  (Photo/createTonemapReinhard float_0 float_1 float_2 float_3 ))
)

(defn color-change
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ))
)

(defn color-change!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ) org_opencv_core_mat_0 )
)

(defn decolor
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/decolor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn decolor!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/decolor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn denoise-tvl-1
([java_util_list_0 org_opencv_core_mat_1 ]
  (Photo/denoise_TVL1 java_util_list_0 org_opencv_core_mat_1 ))
([java_util_list_0 org_opencv_core_mat_1 double_2 int_3 ]
  (Photo/denoise_TVL1 java_util_list_0 org_opencv_core_mat_1 double_2 int_3 ))
)

(defn detail-enhance
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ))
)

(defn detail-enhance!
([org_opencv_core_mat_0 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 ) org_opencv_core_mat_0 )
)

(defn edge-preserving-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 float_4 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 float_4 ))
)

(defn edge-preserving-filter!
([org_opencv_core_mat_0 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 float_3 float_4 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 float_3 float_4 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 int_3 int_4 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 int_3 int_4 ))
)

(defn fast-nl-means-denoising!
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 int_3 int_4 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising-colored
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 int_5 ))
)

(defn fast-nl-means-denoising-colored!
([org_opencv_core_mat_0 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 int_4 int_5 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising-colored-multi
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 int_7 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 int_7 ))
)

(defn fast-nl-means-denoising-multi
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 int_7 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 int_7 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 int_5 int_6 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 int_5 int_6 ))
)

(defn illumination-change
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ))
)

(defn illumination-change!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ) org_opencv_core_mat_0 )
)

(defn inpaint
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Photo/inpaint org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ))
)

(defn inpaint!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ]
  (Photo/inpaint org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn pencil-sketch
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ))
)

(defn pencil-sketch!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ) org_opencv_core_mat_0 )
)

(defn seamless-clone
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ]
  (Photo/seamlessClone org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ))
)

(defn seamless-clone!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ]
  (Photo/seamlessClone org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ) org_opencv_core_mat_0 )
)

(defn stylization
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ))
)

(defn stylization!
([org_opencv_core_mat_0 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 ) org_opencv_core_mat_0 )
)

(defn texture-flattening
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 int_5 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 int_5 ))
)

(defn texture-flattening!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 int_5 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 int_5 ) org_opencv_core_mat_0 )
)

(defn init-undistort-rectify-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn init-undistort-rectify-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn undistort-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn undistort-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ))
)

(defn estimate-affine-2-d!
([org_opencv_core_mat_0 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-partial-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ))
)

(defn estimate-affine-partial-2-d!
([org_opencv_core_mat_0 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ) org_opencv_core_mat_0 )
)

(defn find-essential-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 double_5 double_6 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 double_5 double_6 org_opencv_core_mat_7 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 double_5 double_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 double_5 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 double_5 ))
)

(defn find-essential-mat!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 double_5 double_6 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 double_5 double_6 org_opencv_core_mat_7 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 double_5 double_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 double_5 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 double_5 ) org_opencv_core_mat_0 )
)

(defn find-fundamental-mat
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 org_opencv_core_mat_5 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 org_opencv_core_mat_5 ))
)

(defn find-homography
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 double_6 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 double_6 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 ))
)

(defn get-optimal-new-camera-matrix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ))
)

(defn get-optimal-new-camera-matrix!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ) org_opencv_core_mat_0 )
)

(defn init-camera-matrix-2-d
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 double_3 ]
  (Calib3d/initCameraMatrix2D java_util_list_0 java_util_list_1 org_opencv_core_size_2 double_3 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 ]
  (Calib3d/initCameraMatrix2D java_util_list_0 java_util_list_1 org_opencv_core_size_2 ))
)

(defn get-valid-disparity-roi
([org_opencv_core_rect_0 org_opencv_core_rect_1 int_2 int_3 int_4 ]
  (Calib3d/getValidDisparityROI org_opencv_core_rect_0 org_opencv_core_rect_1 int_2 int_3 int_4 ))
)

(defn rq-decomp-3x-3
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn rq-decomp-3x-3!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn find-chessboard-corners
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 ]
  (Calib3d/findChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 int_3 ]
  (Calib3d/findChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 int_3 ))
)

(defn find-circles-grid
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ]
  (Calib3d/findCirclesGrid org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/findCirclesGrid org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ))
)

(defn solve-pn-p-ransac
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn stereo-rectify-uncalibrated
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/stereoRectifyUncalibrated org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/stereoRectifyUncalibrated org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ))
)

(defn stereo-rectify-uncalibrated!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/stereoRectifyUncalibrated org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/stereoRectifyUncalibrated org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ) org_opencv_core_mat_0 )
)

(defn calibrate-camera-extended
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/calibrateCameraExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ]
  (Calib3d/calibrateCameraExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ]
  (Calib3d/calibrateCameraExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ))
)

(defn calibrate-camera
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ))
)

(defn stereo-calibrate
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_termcriteria_13 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_termcriteria_13 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ))
)

(defn calibrate
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ]
  (Calib3d/calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ]
  (Calib3d/calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ))
)

(defn sampson-distance
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/sampsonDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn sampson-distance!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/sampsonDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn triangulate-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/triangulatePoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn triangulate-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/triangulatePoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn distort-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/distortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/distortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn distort-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/distortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/distortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn estimate-new-camera-matrix-for-undistort-rectify
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ]
  (Calib3d/estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn estimate-new-camera-matrix-for-undistort-rectify!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ]
  (Calib3d/estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn undistort-image
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortImage org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ]
  (Calib3d/undistortImage org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ))
)

(defn undistort-image!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortImage org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ]
  (Calib3d/undistortImage org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ) org_opencv_core_mat_0 )
)

(defn compose-rt
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn compose-rt!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn compute-correspond-epilines
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/computeCorrespondEpilines org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

; (defn rectify-3-collinear
; ([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ]
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ))
; )

; (defn rectify-3-collinear!
; ([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ]
;   (Calib3d/rectify3Collinear org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_size_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 org_opencv_core_mat_14 org_opencv_core_mat_15 org_opencv_core_mat_16 org_opencv_core_mat_17 org_opencv_core_mat_18 org_opencv_core_mat_19 double_20 org_opencv_core_size_21 org_opencv_core_rect_22 org_opencv_core_rect_23 int_24 ) org_opencv_core_mat_0 )
; )

(defn convert-points-from-homogeneous
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/convertPointsFromHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-points-from-homogeneous!
([org_opencv_core_mat_0 ]
  (Calib3d/convertPointsFromHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn convert-points-to-homogeneous
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/convertPointsToHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-points-to-homogeneous!
([org_opencv_core_mat_0 ]
  (Calib3d/convertPointsToHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn correct-matches
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/correctMatches org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn correct-matches!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/correctMatches org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn decompose-essential-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn decompose-essential-mat!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn decompose-projection-matrix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn decompose-projection-matrix!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn draw-chessboard-corners
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 boolean_3 ]
  (Calib3d/drawChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 boolean_3 ))
)

(defn filter-speckles
([org_opencv_core_mat_0 double_1 int_2 double_3 ]
  (Calib3d/filterSpeckles org_opencv_core_mat_0 double_1 int_2 double_3 ))
([org_opencv_core_mat_0 double_1 int_2 double_3 org_opencv_core_mat_4 ]
  (Calib3d/filterSpeckles org_opencv_core_mat_0 double_1 int_2 double_3 org_opencv_core_mat_4 ))
)

(defn mat-mul-deriv
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/matMulDeriv org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn mat-mul-deriv!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/matMulDeriv org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn project-points
([org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 double_7 ]
  (Calib3d/projectPoints org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 double_7 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/projectPoints org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn reproject-image-to-3-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 int_4 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 int_4 ))
)

(defn reproject-image-to-3-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 int_4 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 int_4 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-3-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn estimate-affine-3-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn recover-pose
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn recover-pose!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn decompose-homography-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 java_util_list_2 java_util_list_3 java_util_list_4 ]
  (Calib3d/decomposeHomographyMat org_opencv_core_mat_0 org_opencv_core_mat_1 java_util_list_2 java_util_list_3 java_util_list_4 ))
)

(defn decompose-homography-mat!
([org_opencv_core_mat_0 java_util_list_2 java_util_list_3 java_util_list_4 ]
  (Calib3d/decomposeHomographyMat org_opencv_core_mat_0 org_opencv_core_mat_0 java_util_list_2 java_util_list_3 java_util_list_4 ) org_opencv_core_mat_0 )
)

(defn solve-p-3-p
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ]
  (Calib3d/solveP3P org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ))
)

(defn solve-p-3-p!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ]
  (Calib3d/solveP3P org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ) org_opencv_core_mat_0 )
)

(defn stereo-rectify
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ))
)

(defn stereo-rectify!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ) org_opencv_core_mat_0 )
)

(defn validate-disparity
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Calib3d/validateDisparity org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Calib3d/validateDisparity org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn validate-disparity!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Calib3d/validateDisparity org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Calib3d/validateDisparity org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn rodrigues
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/Rodrigues org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/Rodrigues org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn rodrigues!
([org_opencv_core_mat_0 ]
  (Calib3d/Rodrigues org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/Rodrigues org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn calibration-matrix-values
([org_opencv_core_mat_0 org_opencv_core_size_1 double_2 double_3 array_d_4 array_d_5 array_d_6 org_opencv_core_point_7 array_d_8 ]
  (Calib3d/calibrationMatrixValues org_opencv_core_mat_0 org_opencv_core_size_1 double_2 double_3 array_d_4 array_d_5 array_d_6 org_opencv_core_point_7 array_d_8 ))
)

(defn solve-pn-p
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/solvePnP org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnP org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(def CALIB_USE_INTRINSIC_GUESS Calib3d/CALIB_USE_INTRINSIC_GUESS)
(def CALIB_RECOMPUTE_EXTRINSIC Calib3d/CALIB_RECOMPUTE_EXTRINSIC)
(def CALIB_CHECK_COND Calib3d/CALIB_CHECK_COND)
(def CALIB_FIX_SKEW Calib3d/CALIB_FIX_SKEW)
(def CALIB_FIX_K1 Calib3d/CALIB_FIX_K1)
(def CALIB_FIX_K2 Calib3d/CALIB_FIX_K2)
(def CALIB_FIX_K3 Calib3d/CALIB_FIX_K3)
(def CALIB_FIX_K4 Calib3d/CALIB_FIX_K4)
(def CALIB_FIX_INTRINSIC Calib3d/CALIB_FIX_INTRINSIC)
(def CV_ITERATIVE Calib3d/CV_ITERATIVE)
(def CV_EPNP Calib3d/CV_EPNP)
(def CV_P3P Calib3d/CV_P3P)
(def CV_DLS Calib3d/CV_DLS)
(def LMEDS Calib3d/LMEDS)
(def RANSAC Calib3d/RANSAC)
(def RHO Calib3d/RHO)
(def SOLVEPNP_ITERATIVE Calib3d/SOLVEPNP_ITERATIVE)
(def SOLVEPNP_EPNP Calib3d/SOLVEPNP_EPNP)
(def SOLVEPNP_P3P Calib3d/SOLVEPNP_P3P)
(def SOLVEPNP_DLS Calib3d/SOLVEPNP_DLS)
(def SOLVEPNP_UPNP Calib3d/SOLVEPNP_UPNP)
(def SOLVEPNP_AP3P Calib3d/SOLVEPNP_AP3P)
(def CALIB_CB_ADAPTIVE_THRESH Calib3d/CALIB_CB_ADAPTIVE_THRESH)
(def CALIB_CB_NORMALIZE_IMAGE Calib3d/CALIB_CB_NORMALIZE_IMAGE)
(def CALIB_CB_FILTER_QUADS Calib3d/CALIB_CB_FILTER_QUADS)
(def CALIB_CB_FAST_CHECK Calib3d/CALIB_CB_FAST_CHECK)
(def CALIB_CB_SYMMETRIC_GRID Calib3d/CALIB_CB_SYMMETRIC_GRID)
(def CALIB_CB_ASYMMETRIC_GRID Calib3d/CALIB_CB_ASYMMETRIC_GRID)
(def CALIB_CB_CLUSTERING Calib3d/CALIB_CB_CLUSTERING)
(def CALIB_FIX_ASPECT_RATIO Calib3d/CALIB_FIX_ASPECT_RATIO)
(def CALIB_FIX_PRINCIPAL_POINT Calib3d/CALIB_FIX_PRINCIPAL_POINT)
(def CALIB_ZERO_TANGENT_DIST Calib3d/CALIB_ZERO_TANGENT_DIST)
(def CALIB_FIX_FOCAL_LENGTH Calib3d/CALIB_FIX_FOCAL_LENGTH)
(def CALIB_FIX_K5 Calib3d/CALIB_FIX_K5)
(def CALIB_FIX_K6 Calib3d/CALIB_FIX_K6)
(def CALIB_RATIONAL_MODEL Calib3d/CALIB_RATIONAL_MODEL)
(def CALIB_THIN_PRISM_MODEL Calib3d/CALIB_THIN_PRISM_MODEL)
(def CALIB_FIX_S1_S2_S3_S4 Calib3d/CALIB_FIX_S1_S2_S3_S4)
(def CALIB_TILTED_MODEL Calib3d/CALIB_TILTED_MODEL)
(def CALIB_FIX_TAUX_TAUY Calib3d/CALIB_FIX_TAUX_TAUY)
(def CALIB_USE_QR Calib3d/CALIB_USE_QR)
(def CALIB_FIX_TANGENT_DIST Calib3d/CALIB_FIX_TANGENT_DIST)
(def CALIB_SAME_FOCAL_LENGTH Calib3d/CALIB_SAME_FOCAL_LENGTH)
(def CALIB_ZERO_DISPARITY Calib3d/CALIB_ZERO_DISPARITY)
(def CALIB_USE_LU Calib3d/CALIB_USE_LU)
(def FM_7POINT Calib3d/FM_7POINT)
(def FM_8POINT Calib3d/FM_8POINT)
(def FM_LMEDS Calib3d/FM_LMEDS)
(def FM_RANSAC Calib3d/FM_RANSAC)
