  (ns opencv4.core
  (:refer-clojure :exclude [min max compare merge sort reduce repeat])
  (:import
    [org.opencv.core MatOfInt MatOfKeyPoint MatOfPoint MatOfPoint2f MatOfRect Point Rect Mat Size Scalar Core CvType Mat MatOfByte]
    [org.opencv.photo Photo]
    [org.opencv.calib3d Calib3d]
    [org.opencv.imgcodecs Imgcodecs]
    [org.opencv.imgproc Imgproc]))

(origami.Origami/init)

; NOT AUTO GENERATED YET

(defrecord InfoM [name class dims channels width height type submatrix])

(defn- info1[debug-name out]
  (->InfoM debug-name
   (.getSimpleName (.getClass out))
   (.dims out)
   (.channels out)
   (int (.-height (.size out)))
   (int (.-width (.size out)))
   (.type out)
   (.isSubmatrix out)))

(defn infos [outs]
  (clojure.pprint/print-table
    (map #(info1 (first %) (second %)) outs)))

; (defn info
;  ([out] (info out "mat" false))
;  ([out debug-name] (info out debug-name false))
;  ([out debug-name _]
;  (clojure.pprint/print-table
;    [(info1 out debug-name)])))

(defn imread
  ([string] (Imgcodecs/imread string))
  ([string type] (Imgcodecs/imread string type)))

(defn imwrite[mat string]
  (Imgcodecs/imwrite string mat)
  mat)

(declare put-text)
(declare hconcat)
(declare new-mat)
(declare vconcat)
(declare add)
(declare new-arraylist)

(def new-list new-arraylist)

(defn clone[mat] (.clone mat))

(defn- pr-seq [seq]
   (letfn [(lineify-seq [items]
       (apply str (interpose "\n" items)))]
     (println (lineify-seq seq))))

(defn ->string [ _mat ]
  (-> 
  _mat
  (.dump)
  (clojure.string/replace  #";" "]")
  (clojure.string/replace  #"\n" "[")
  (#(str "[" % "]"))
  (read-string)))

(defn ->bytes [mat]
  (let [bytes (byte-array (* (.total mat) (.channels mat)))]
    (.get mat 0 0 bytes)
    bytes))

(defn dump[ _mat ]
  (-> _mat ->string pr-seq))

(defn merge!
([java_util_list_0] (merge! java_util_list_0 (Mat.)))
([java_util_list_0 output] 
 (Core/merge java_util_list_0 output )
 output))

(defn add!
  [mat val]
    (Core/add mat val mat)
    mat)

(defn split!
  [org_opencv_core_mat_0]
   (let [java_util_list_1 (new-arraylist)]
     (Core/split org_opencv_core_mat_0 java_util_list_1)
     java_util_list_1))

(defn set-to
  ([mat scalar] (.setTo mat scalar))
  ([mat scalar mask] (.setTo mat scalar mask)))
(defn set-to!
  ([mat scalar] (.setTo mat scalar) mat)
  ([mat scalar mask] (.setTo mat scalar mask) mat))
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


(defn >> [mat b]
  (.put mat 0 0 b) mat)
(defn << [mat]
  (->bytes mat))

(defn divide!
([org_opencv_core_mat_0 org_opencv_core_scalar_1 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 ) org_opencv_core_mat_0)
([org_opencv_core_mat_0 org_opencv_core_scalar_1 double_3 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0)
([org_opencv_core_mat_0 org_opencv_core_scalar_1 double_3 int_4 ] 
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0)
)

(defn multiply!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ] 
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn lut!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ] 
  (Core/LUT org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn bilateral-filter!
([org_opencv_core_mat_0 int_2 double_3 double_4 ] 
  (let [out  (clone org_opencv_core_mat_0) ] 
  (Imgproc/bilateralFilter org_opencv_core_mat_0 out int_2 double_3 double_4 ) out ))
([org_opencv_core_mat_0 int_2 double_3 double_4 int_5 ] 
  (let [out  (clone org_opencv_core_mat_0) ] 
  (Imgproc/bilateralFilter org_opencv_core_mat_0 out int_2 double_3 double_4 int_5 ) out ))
)

(defn mean!
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn norm!
([org_opencv_core_mat_0 int_2 ] 
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ] 
  (Core/norm org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ] 
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

;; END OF HEADER
(defn new-matoffloat 
([] 
  (new org.opencv.core.MatOfFloat ))
([array_f_0 ] 
  (new org.opencv.core.MatOfFloat array_f_0 )))
(defn new-matofrect2d 
([] 
  (new org.opencv.core.MatOfRect2d ))
([array_lorg_opencv_core_rect2d_0 ] 
  (new org.opencv.core.MatOfRect2d array_lorg_opencv_core_rect2d_0 )))
(defn new-matofrect 
([] 
  (new org.opencv.core.MatOfRect ))
([array_lorg_opencv_core_rect_0 ] 
  (new org.opencv.core.MatOfRect array_lorg_opencv_core_rect_0 )))
(defn new-matofpoint2f 
([] 
  (new org.opencv.core.MatOfPoint2f ))
([array_lorg_opencv_core_point_0 ] 
  (new org.opencv.core.MatOfPoint2f array_lorg_opencv_core_point_0 )))
(defn new-arraylist 
([java_util_collection_0 ] 
  (new java.util.ArrayList java_util_collection_0 ))
([] 
  (new java.util.ArrayList )))
(defn new-rect2d 
([org_opencv_core_point_0 org_opencv_core_size_1 ] 
  (new org.opencv.core.Rect2d org_opencv_core_point_0 org_opencv_core_size_1 ))
([array_d_0 ] 
  (new org.opencv.core.Rect2d array_d_0 ))
([double_0 double_1 double_2 double_3 ] 
  (new org.opencv.core.Rect2d double_0 double_1 double_2 double_3 ))
([] 
  (new org.opencv.core.Rect2d )))
(defn new-rotatedrect 
([] 
  (new org.opencv.core.RotatedRect ))
([org_opencv_core_point_0 org_opencv_core_size_1 double_2 ] 
  (new org.opencv.core.RotatedRect org_opencv_core_point_0 org_opencv_core_size_1 double_2 ))
([array_d_0 ] 
  (new org.opencv.core.RotatedRect array_d_0 )))
(defn new-mat 
([org_opencv_core_size_0 int_1 org_opencv_core_scalar_2 ] 
  (new org.opencv.core.Mat org_opencv_core_size_0 int_1 org_opencv_core_scalar_2 ))
([int_0 int_1 int_2 org_opencv_core_scalar_3 ] 
  (new org.opencv.core.Mat int_0 int_1 int_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_rect_1 ] 
  (new org.opencv.core.Mat org_opencv_core_mat_0 org_opencv_core_rect_1 ))
([long_0 ] 
  (new org.opencv.core.Mat long_0 ))
([] 
  (new org.opencv.core.Mat ))
([int_0 int_1 int_2 java_nio_bytebuffer_3 long_4 ] 
  (new org.opencv.core.Mat int_0 int_1 int_2 java_nio_bytebuffer_3 long_4 )))
(defn new-point 
([double_0 double_1 ] 
  (new org.opencv.core.Point double_0 double_1 ))
([array_d_0 ] 
  (new org.opencv.core.Point array_d_0 ))
([] 
  (new org.opencv.core.Point )))
(defn new-videocapture 
([java_lang_string_0 ] 
  (new org.opencv.videoio.VideoCapture java_lang_string_0 ))
([java_lang_string_0 int_1 org_opencv_core_matofint_2 ] 
  (new org.opencv.videoio.VideoCapture java_lang_string_0 int_1 org_opencv_core_matofint_2 ))
([int_0 int_1 ] 
  (new org.opencv.videoio.VideoCapture int_0 int_1 ))
([] 
  (new org.opencv.videoio.VideoCapture )))
(defn new-cascadeclassifier 
([] 
  (new org.opencv.objdetect.CascadeClassifier ))
([java_lang_string_0 ] 
  (new org.opencv.objdetect.CascadeClassifier java_lang_string_0 )))
(defn new-rect 
([org_opencv_core_point_0 org_opencv_core_size_1 ] 
  (new org.opencv.core.Rect org_opencv_core_point_0 org_opencv_core_size_1 ))
([array_d_0 ] 
  (new org.opencv.core.Rect array_d_0 ))
([int_0 int_1 int_2 int_3 ] 
  (new org.opencv.core.Rect int_0 int_1 int_2 int_3 ))
([] 
  (new org.opencv.core.Rect )))
(defn new-scalar 
([double_0 ] 
  (new org.opencv.core.Scalar double_0 ))
([double_0 double_1 double_2 double_3 ] 
  (new org.opencv.core.Scalar double_0 double_1 double_2 double_3 ))
([double_0 double_1 double_2 ] 
  (new org.opencv.core.Scalar double_0 double_1 double_2 ))
([double_0 double_1 ] 
  (new org.opencv.core.Scalar double_0 double_1 )))
(defn new-matofbyte 
([] 
  (new org.opencv.core.MatOfByte ))
([int_0 int_1 array_b_2 ] 
  (new org.opencv.core.MatOfByte int_0 int_1 array_b_2 ))
([org_opencv_core_mat_0 ] 
  (new org.opencv.core.MatOfByte org_opencv_core_mat_0 )))
(defn new-matofpoint 
([] 
  (new org.opencv.core.MatOfPoint ))
([array_lorg_opencv_core_point_0 ] 
  (new org.opencv.core.MatOfPoint array_lorg_opencv_core_point_0 )))
(defn new-size 
([double_0 double_1 ] 
  (new org.opencv.core.Size double_0 double_1 ))
([array_d_0 ] 
  (new org.opencv.core.Size array_d_0 ))
([] 
  (new org.opencv.core.Size )))
(defn new-matofdouble 
([] 
  (new org.opencv.core.MatOfDouble ))
([array_d_0 ] 
  (new org.opencv.core.MatOfDouble array_d_0 )))
(defn new-matofint 
([] 
  (new org.opencv.core.MatOfInt ))
([array_i_0 ] 
  (new org.opencv.core.MatOfInt array_i_0 )))
;;; Imgcodecs
(def IMAGE_METADATA_UNKNOWN Imgcodecs/IMAGE_METADATA_UNKNOWN)
(def IMAGE_METADATA_EXIF Imgcodecs/IMAGE_METADATA_EXIF)
(def IMAGE_METADATA_XMP Imgcodecs/IMAGE_METADATA_XMP)
(def IMAGE_METADATA_ICCP Imgcodecs/IMAGE_METADATA_ICCP)
(def IMAGE_METADATA_CICP Imgcodecs/IMAGE_METADATA_CICP)
(def IMAGE_METADATA_MAX Imgcodecs/IMAGE_METADATA_MAX)
(def IMREAD_UNCHANGED Imgcodecs/IMREAD_UNCHANGED)
(def IMREAD_GRAYSCALE Imgcodecs/IMREAD_GRAYSCALE)
(def IMREAD_COLOR_BGR Imgcodecs/IMREAD_COLOR_BGR)
(def IMREAD_COLOR Imgcodecs/IMREAD_COLOR)
(def IMREAD_ANYDEPTH Imgcodecs/IMREAD_ANYDEPTH)
(def IMREAD_ANYCOLOR Imgcodecs/IMREAD_ANYCOLOR)
(def IMREAD_LOAD_GDAL Imgcodecs/IMREAD_LOAD_GDAL)
(def IMREAD_REDUCED_GRAYSCALE_2 Imgcodecs/IMREAD_REDUCED_GRAYSCALE_2)
(def IMREAD_REDUCED_COLOR_2 Imgcodecs/IMREAD_REDUCED_COLOR_2)
(def IMREAD_REDUCED_GRAYSCALE_4 Imgcodecs/IMREAD_REDUCED_GRAYSCALE_4)
(def IMREAD_REDUCED_COLOR_4 Imgcodecs/IMREAD_REDUCED_COLOR_4)
(def IMREAD_REDUCED_GRAYSCALE_8 Imgcodecs/IMREAD_REDUCED_GRAYSCALE_8)
(def IMREAD_REDUCED_COLOR_8 Imgcodecs/IMREAD_REDUCED_COLOR_8)
(def IMREAD_IGNORE_ORIENTATION Imgcodecs/IMREAD_IGNORE_ORIENTATION)
(def IMREAD_COLOR_RGB Imgcodecs/IMREAD_COLOR_RGB)
(def IMWRITE_BMP_COMPRESSION_RGB Imgcodecs/IMWRITE_BMP_COMPRESSION_RGB)
(def IMWRITE_BMP_COMPRESSION_BITFIELDS Imgcodecs/IMWRITE_BMP_COMPRESSION_BITFIELDS)
(def IMWRITE_EXR_COMPRESSION_NO Imgcodecs/IMWRITE_EXR_COMPRESSION_NO)
(def IMWRITE_EXR_COMPRESSION_RLE Imgcodecs/IMWRITE_EXR_COMPRESSION_RLE)
(def IMWRITE_EXR_COMPRESSION_ZIPS Imgcodecs/IMWRITE_EXR_COMPRESSION_ZIPS)
(def IMWRITE_EXR_COMPRESSION_ZIP Imgcodecs/IMWRITE_EXR_COMPRESSION_ZIP)
(def IMWRITE_EXR_COMPRESSION_PIZ Imgcodecs/IMWRITE_EXR_COMPRESSION_PIZ)
(def IMWRITE_EXR_COMPRESSION_PXR24 Imgcodecs/IMWRITE_EXR_COMPRESSION_PXR24)
(def IMWRITE_EXR_COMPRESSION_B44 Imgcodecs/IMWRITE_EXR_COMPRESSION_B44)
(def IMWRITE_EXR_COMPRESSION_B44A Imgcodecs/IMWRITE_EXR_COMPRESSION_B44A)
(def IMWRITE_EXR_COMPRESSION_DWAA Imgcodecs/IMWRITE_EXR_COMPRESSION_DWAA)
(def IMWRITE_EXR_COMPRESSION_DWAB Imgcodecs/IMWRITE_EXR_COMPRESSION_DWAB)
(def IMWRITE_EXR_TYPE_HALF Imgcodecs/IMWRITE_EXR_TYPE_HALF)
(def IMWRITE_EXR_TYPE_FLOAT Imgcodecs/IMWRITE_EXR_TYPE_FLOAT)
(def IMWRITE_JPEG_QUALITY Imgcodecs/IMWRITE_JPEG_QUALITY)
(def IMWRITE_JPEG_PROGRESSIVE Imgcodecs/IMWRITE_JPEG_PROGRESSIVE)
(def IMWRITE_JPEG_OPTIMIZE Imgcodecs/IMWRITE_JPEG_OPTIMIZE)
(def IMWRITE_JPEG_RST_INTERVAL Imgcodecs/IMWRITE_JPEG_RST_INTERVAL)
(def IMWRITE_JPEG_LUMA_QUALITY Imgcodecs/IMWRITE_JPEG_LUMA_QUALITY)
(def IMWRITE_JPEG_CHROMA_QUALITY Imgcodecs/IMWRITE_JPEG_CHROMA_QUALITY)
(def IMWRITE_JPEG_SAMPLING_FACTOR Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR)
(def IMWRITE_PNG_COMPRESSION Imgcodecs/IMWRITE_PNG_COMPRESSION)
(def IMWRITE_PNG_STRATEGY Imgcodecs/IMWRITE_PNG_STRATEGY)
(def IMWRITE_PNG_BILEVEL Imgcodecs/IMWRITE_PNG_BILEVEL)
(def IMWRITE_PNG_FILTER Imgcodecs/IMWRITE_PNG_FILTER)
(def IMWRITE_PNG_ZLIBBUFFER_SIZE Imgcodecs/IMWRITE_PNG_ZLIBBUFFER_SIZE)
(def IMWRITE_PXM_BINARY Imgcodecs/IMWRITE_PXM_BINARY)
(def IMWRITE_EXR_TYPE Imgcodecs/IMWRITE_EXR_TYPE)
(def IMWRITE_EXR_COMPRESSION Imgcodecs/IMWRITE_EXR_COMPRESSION)
(def IMWRITE_EXR_DWA_COMPRESSION_LEVEL Imgcodecs/IMWRITE_EXR_DWA_COMPRESSION_LEVEL)
(def IMWRITE_WEBP_QUALITY Imgcodecs/IMWRITE_WEBP_QUALITY)
(def IMWRITE_HDR_COMPRESSION Imgcodecs/IMWRITE_HDR_COMPRESSION)
(def IMWRITE_PAM_TUPLETYPE Imgcodecs/IMWRITE_PAM_TUPLETYPE)
(def IMWRITE_TIFF_RESUNIT Imgcodecs/IMWRITE_TIFF_RESUNIT)
(def IMWRITE_TIFF_XDPI Imgcodecs/IMWRITE_TIFF_XDPI)
(def IMWRITE_TIFF_YDPI Imgcodecs/IMWRITE_TIFF_YDPI)
(def IMWRITE_TIFF_COMPRESSION Imgcodecs/IMWRITE_TIFF_COMPRESSION)
(def IMWRITE_TIFF_ROWSPERSTRIP Imgcodecs/IMWRITE_TIFF_ROWSPERSTRIP)
(def IMWRITE_TIFF_PREDICTOR Imgcodecs/IMWRITE_TIFF_PREDICTOR)
(def IMWRITE_JPEG2000_COMPRESSION_X1000 Imgcodecs/IMWRITE_JPEG2000_COMPRESSION_X1000)
(def IMWRITE_AVIF_QUALITY Imgcodecs/IMWRITE_AVIF_QUALITY)
(def IMWRITE_AVIF_DEPTH Imgcodecs/IMWRITE_AVIF_DEPTH)
(def IMWRITE_AVIF_SPEED Imgcodecs/IMWRITE_AVIF_SPEED)
(def IMWRITE_JPEGXL_QUALITY Imgcodecs/IMWRITE_JPEGXL_QUALITY)
(def IMWRITE_JPEGXL_EFFORT Imgcodecs/IMWRITE_JPEGXL_EFFORT)
(def IMWRITE_JPEGXL_DISTANCE Imgcodecs/IMWRITE_JPEGXL_DISTANCE)
(def IMWRITE_JPEGXL_DECODING_SPEED Imgcodecs/IMWRITE_JPEGXL_DECODING_SPEED)
(def IMWRITE_BMP_COMPRESSION Imgcodecs/IMWRITE_BMP_COMPRESSION)
(def IMWRITE_GIF_LOOP Imgcodecs/IMWRITE_GIF_LOOP)
(def IMWRITE_GIF_SPEED Imgcodecs/IMWRITE_GIF_SPEED)
(def IMWRITE_GIF_QUALITY Imgcodecs/IMWRITE_GIF_QUALITY)
(def IMWRITE_GIF_DITHER Imgcodecs/IMWRITE_GIF_DITHER)
(def IMWRITE_GIF_TRANSPARENCY Imgcodecs/IMWRITE_GIF_TRANSPARENCY)
(def IMWRITE_GIF_COLORTABLE Imgcodecs/IMWRITE_GIF_COLORTABLE)
(def IMWRITE_GIF_FAST_NO_DITHER Imgcodecs/IMWRITE_GIF_FAST_NO_DITHER)
(def IMWRITE_GIF_FAST_FLOYD_DITHER Imgcodecs/IMWRITE_GIF_FAST_FLOYD_DITHER)
(def IMWRITE_GIF_COLORTABLE_SIZE_8 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_8)
(def IMWRITE_GIF_COLORTABLE_SIZE_16 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_16)
(def IMWRITE_GIF_COLORTABLE_SIZE_32 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_32)
(def IMWRITE_GIF_COLORTABLE_SIZE_64 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_64)
(def IMWRITE_GIF_COLORTABLE_SIZE_128 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_128)
(def IMWRITE_GIF_COLORTABLE_SIZE_256 Imgcodecs/IMWRITE_GIF_COLORTABLE_SIZE_256)
(def IMWRITE_HDR_COMPRESSION_NONE Imgcodecs/IMWRITE_HDR_COMPRESSION_NONE)
(def IMWRITE_HDR_COMPRESSION_RLE Imgcodecs/IMWRITE_HDR_COMPRESSION_RLE)
(def IMWRITE_JPEG_SAMPLING_FACTOR_411 Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR_411)
(def IMWRITE_JPEG_SAMPLING_FACTOR_420 Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR_420)
(def IMWRITE_JPEG_SAMPLING_FACTOR_422 Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR_422)
(def IMWRITE_JPEG_SAMPLING_FACTOR_440 Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR_440)
(def IMWRITE_JPEG_SAMPLING_FACTOR_444 Imgcodecs/IMWRITE_JPEG_SAMPLING_FACTOR_444)
(def IMWRITE_PAM_FORMAT_NULL Imgcodecs/IMWRITE_PAM_FORMAT_NULL)
(def IMWRITE_PAM_FORMAT_BLACKANDWHITE Imgcodecs/IMWRITE_PAM_FORMAT_BLACKANDWHITE)
(def IMWRITE_PAM_FORMAT_GRAYSCALE Imgcodecs/IMWRITE_PAM_FORMAT_GRAYSCALE)
(def IMWRITE_PAM_FORMAT_GRAYSCALE_ALPHA Imgcodecs/IMWRITE_PAM_FORMAT_GRAYSCALE_ALPHA)
(def IMWRITE_PAM_FORMAT_RGB Imgcodecs/IMWRITE_PAM_FORMAT_RGB)
(def IMWRITE_PAM_FORMAT_RGB_ALPHA Imgcodecs/IMWRITE_PAM_FORMAT_RGB_ALPHA)
(def IMWRITE_PNG_FILTER_NONE Imgcodecs/IMWRITE_PNG_FILTER_NONE)
(def IMWRITE_PNG_FILTER_SUB Imgcodecs/IMWRITE_PNG_FILTER_SUB)
(def IMWRITE_PNG_FILTER_UP Imgcodecs/IMWRITE_PNG_FILTER_UP)
(def IMWRITE_PNG_FILTER_AVG Imgcodecs/IMWRITE_PNG_FILTER_AVG)
(def IMWRITE_PNG_FILTER_PAETH Imgcodecs/IMWRITE_PNG_FILTER_PAETH)
(def IMWRITE_PNG_FAST_FILTERS Imgcodecs/IMWRITE_PNG_FAST_FILTERS)
(def IMWRITE_PNG_ALL_FILTERS Imgcodecs/IMWRITE_PNG_ALL_FILTERS)
(def IMWRITE_PNG_STRATEGY_DEFAULT Imgcodecs/IMWRITE_PNG_STRATEGY_DEFAULT)
(def IMWRITE_PNG_STRATEGY_FILTERED Imgcodecs/IMWRITE_PNG_STRATEGY_FILTERED)
(def IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY Imgcodecs/IMWRITE_PNG_STRATEGY_HUFFMAN_ONLY)
(def IMWRITE_PNG_STRATEGY_RLE Imgcodecs/IMWRITE_PNG_STRATEGY_RLE)
(def IMWRITE_PNG_STRATEGY_FIXED Imgcodecs/IMWRITE_PNG_STRATEGY_FIXED)
(def IMWRITE_TIFF_COMPRESSION_NONE Imgcodecs/IMWRITE_TIFF_COMPRESSION_NONE)
(def IMWRITE_TIFF_COMPRESSION_CCITTRLE Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITTRLE)
(def IMWRITE_TIFF_COMPRESSION_CCITTFAX3 Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITTFAX3)
(def IMWRITE_TIFF_COMPRESSION_CCITT_T4 Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITT_T4)
(def IMWRITE_TIFF_COMPRESSION_CCITTFAX4 Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITTFAX4)
(def IMWRITE_TIFF_COMPRESSION_CCITT_T6 Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITT_T6)
(def IMWRITE_TIFF_COMPRESSION_LZW Imgcodecs/IMWRITE_TIFF_COMPRESSION_LZW)
(def IMWRITE_TIFF_COMPRESSION_OJPEG Imgcodecs/IMWRITE_TIFF_COMPRESSION_OJPEG)
(def IMWRITE_TIFF_COMPRESSION_JPEG Imgcodecs/IMWRITE_TIFF_COMPRESSION_JPEG)
(def IMWRITE_TIFF_COMPRESSION_T85 Imgcodecs/IMWRITE_TIFF_COMPRESSION_T85)
(def IMWRITE_TIFF_COMPRESSION_T43 Imgcodecs/IMWRITE_TIFF_COMPRESSION_T43)
(def IMWRITE_TIFF_COMPRESSION_NEXT Imgcodecs/IMWRITE_TIFF_COMPRESSION_NEXT)
(def IMWRITE_TIFF_COMPRESSION_CCITTRLEW Imgcodecs/IMWRITE_TIFF_COMPRESSION_CCITTRLEW)
(def IMWRITE_TIFF_COMPRESSION_PACKBITS Imgcodecs/IMWRITE_TIFF_COMPRESSION_PACKBITS)
(def IMWRITE_TIFF_COMPRESSION_THUNDERSCAN Imgcodecs/IMWRITE_TIFF_COMPRESSION_THUNDERSCAN)
(def IMWRITE_TIFF_COMPRESSION_IT8CTPAD Imgcodecs/IMWRITE_TIFF_COMPRESSION_IT8CTPAD)
(def IMWRITE_TIFF_COMPRESSION_IT8LW Imgcodecs/IMWRITE_TIFF_COMPRESSION_IT8LW)
(def IMWRITE_TIFF_COMPRESSION_IT8MP Imgcodecs/IMWRITE_TIFF_COMPRESSION_IT8MP)
(def IMWRITE_TIFF_COMPRESSION_IT8BL Imgcodecs/IMWRITE_TIFF_COMPRESSION_IT8BL)
(def IMWRITE_TIFF_COMPRESSION_PIXARFILM Imgcodecs/IMWRITE_TIFF_COMPRESSION_PIXARFILM)
(def IMWRITE_TIFF_COMPRESSION_PIXARLOG Imgcodecs/IMWRITE_TIFF_COMPRESSION_PIXARLOG)
(def IMWRITE_TIFF_COMPRESSION_DEFLATE Imgcodecs/IMWRITE_TIFF_COMPRESSION_DEFLATE)
(def IMWRITE_TIFF_COMPRESSION_ADOBE_DEFLATE Imgcodecs/IMWRITE_TIFF_COMPRESSION_ADOBE_DEFLATE)
(def IMWRITE_TIFF_COMPRESSION_DCS Imgcodecs/IMWRITE_TIFF_COMPRESSION_DCS)
(def IMWRITE_TIFF_COMPRESSION_JBIG Imgcodecs/IMWRITE_TIFF_COMPRESSION_JBIG)
(def IMWRITE_TIFF_COMPRESSION_SGILOG Imgcodecs/IMWRITE_TIFF_COMPRESSION_SGILOG)
(def IMWRITE_TIFF_COMPRESSION_SGILOG24 Imgcodecs/IMWRITE_TIFF_COMPRESSION_SGILOG24)
(def IMWRITE_TIFF_COMPRESSION_JP2000 Imgcodecs/IMWRITE_TIFF_COMPRESSION_JP2000)
(def IMWRITE_TIFF_COMPRESSION_LERC Imgcodecs/IMWRITE_TIFF_COMPRESSION_LERC)
(def IMWRITE_TIFF_COMPRESSION_LZMA Imgcodecs/IMWRITE_TIFF_COMPRESSION_LZMA)
(def IMWRITE_TIFF_COMPRESSION_ZSTD Imgcodecs/IMWRITE_TIFF_COMPRESSION_ZSTD)
(def IMWRITE_TIFF_COMPRESSION_WEBP Imgcodecs/IMWRITE_TIFF_COMPRESSION_WEBP)
(def IMWRITE_TIFF_COMPRESSION_JXL Imgcodecs/IMWRITE_TIFF_COMPRESSION_JXL)
(def IMWRITE_TIFF_PREDICTOR_NONE Imgcodecs/IMWRITE_TIFF_PREDICTOR_NONE)
(def IMWRITE_TIFF_PREDICTOR_HORIZONTAL Imgcodecs/IMWRITE_TIFF_PREDICTOR_HORIZONTAL)
(def IMWRITE_TIFF_PREDICTOR_FLOATINGPOINT Imgcodecs/IMWRITE_TIFF_PREDICTOR_FLOATINGPOINT)
(def IMWRITE_TIFF_RESOLUTION_UNIT_NONE Imgcodecs/IMWRITE_TIFF_RESOLUTION_UNIT_NONE)
(def IMWRITE_TIFF_RESOLUTION_UNIT_INCH Imgcodecs/IMWRITE_TIFF_RESOLUTION_UNIT_INCH)
(def IMWRITE_TIFF_RESOLUTION_UNIT_CENTIMETER Imgcodecs/IMWRITE_TIFF_RESOLUTION_UNIT_CENTIMETER)
;;; ImgProc
(defn bounding-rect
([org_opencv_core_mat_0 ]
  (Imgproc/boundingRect org_opencv_core_mat_0 ))
)

(defn create-line-segment-detector
([int_0 double_1 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 ))
([int_0 double_1 double_2 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 ))
([int_0 double_1 double_2 double_3 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 ))
([int_0 ]
  (Imgproc/createLineSegmentDetector int_0 ))
([]
  (Imgproc/createLineSegmentDetector ))
([int_0 double_1 double_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 double_4 double_5 double_6 int_7 ))
([int_0 double_1 double_2 double_3 double_4 double_5 double_6 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 double_4 double_5 double_6 ))
([int_0 double_1 double_2 double_3 double_4 double_5 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 double_4 double_5 ))
([int_0 double_1 double_2 double_3 double_4 ]
  (Imgproc/createLineSegmentDetector int_0 double_1 double_2 double_3 double_4 ))
)

(defn get-gaussian-kernel
([int_0 double_1 ]
  (Imgproc/getGaussianKernel int_0 double_1 ))
([int_0 double_1 int_2 ]
  (Imgproc/getGaussianKernel int_0 double_1 int_2 ))
)

(defn get-deriv-kernels
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 int_6 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 boolean_5 int_6 ))
)

(defn get-deriv-kernels!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 int_6 ]
  (Imgproc/getDerivKernels org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
)

(defn get-gabor-kernel
([org_opencv_core_size_0 double_1 double_2 double_3 double_4 ]
  (Imgproc/getGaborKernel org_opencv_core_size_0 double_1 double_2 double_3 double_4 ))
([org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 ]
  (Imgproc/getGaborKernel org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 ))
([org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 int_6 ]
  (Imgproc/getGaborKernel org_opencv_core_size_0 double_1 double_2 double_3 double_4 double_5 int_6 ))
)

(defn get-structuring-element
([int_0 org_opencv_core_size_1 ]
  (Imgproc/getStructuringElement int_0 org_opencv_core_size_1 ))
([int_0 org_opencv_core_size_1 org_opencv_core_point_2 ]
  (Imgproc/getStructuringElement int_0 org_opencv_core_size_1 org_opencv_core_point_2 ))
)

(defn median-blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/medianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn median-blur!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/medianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn gaussian-blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 int_6 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 int_5 int_6 ))
)

(defn gaussian-blur!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 int_6 ]
  (Imgproc/GaussianBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 int_6 ) org_opencv_core_mat_0 )
)

(defn bilateral-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 int_5 ]
  (Imgproc/bilateralFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 int_5 ))
)

(defn box-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ))
)

(defn box-filter!
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/boxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
)

(defn sqr-box-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ))
)

(defn sqr-box-filter!
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ]
  (Imgproc/sqrBoxFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_size_3 org_opencv_core_point_4 boolean_5 int_6 ) org_opencv_core_mat_0 )
)

(defn blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ))
)

(defn blur!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/blur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
)

(defn stack-blur
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/stackBlur org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
)

(defn stack-blur!
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/stackBlur org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
)

(defn filter-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ))
)

(defn filter-2-d!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ]
  (Imgproc/filter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 double_5 int_6 ) org_opencv_core_mat_0 )
)

(defn sep-filter-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ))
)

(defn sep-filter-2-d!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ]
  (Imgproc/sepFilter2D org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_point_5 double_6 int_7 ) org_opencv_core_mat_0 )
)

(defn sobel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ))
)

(defn sobel!
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ]
  (Imgproc/Sobel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 int_5 double_6 double_7 int_8 ) org_opencv_core_mat_0 )
)

(defn spatial-gradient
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn spatial-gradient!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/spatialGradient org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn scharr
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 int_7 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 double_5 double_6 int_7 ))
)

(defn scharr!
([org_opencv_core_mat_0 int_2 int_3 int_4 double_5 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 int_7 ]
  (Imgproc/Scharr org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 double_5 double_6 int_7 ) org_opencv_core_mat_0 )
)

(defn laplacian
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 int_6 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 int_6 ))
)

(defn laplacian!
([org_opencv_core_mat_0 int_2 int_3 double_4 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 double_4 double_5 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 double_4 double_5 int_6 ]
  (Imgproc/Laplacian org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 double_5 int_6 ) org_opencv_core_mat_0 )
)

(defn canny
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 boolean_5 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 boolean_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 ))
)

(defn canny!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 boolean_5 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 boolean_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 ]
  (Imgproc/Canny org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 ) org_opencv_core_mat_0 )
)

(defn corner-min-eigen-val
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn corner-min-eigen-val!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/cornerMinEigenVal org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn corner-harris
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 int_5 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 int_5 ))
)

(defn corner-harris!
([org_opencv_core_mat_0 int_2 int_3 double_4 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 double_4 int_5 ]
  (Imgproc/cornerHarris org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 int_5 ) org_opencv_core_mat_0 )
)

(defn corner-eigen-vals-and-vecs
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn corner-eigen-vals-and-vecs!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/cornerEigenValsAndVecs org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
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

(defn corner-sub-pix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ]
  (Imgproc/cornerSubPix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ))
)

(defn corner-sub-pix!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ]
  (Imgproc/cornerSubPix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_size_3 org_opencv_core_termcriteria_4 ) org_opencv_core_mat_0 )
)

(defn good-features-to-track
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 boolean_8 double_9 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 boolean_8 double_9 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 boolean_8 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 boolean_8 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 ]
  (Imgproc/goodFeaturesToTrack org_opencv_core_mat_0 org_opencv_core_matofpoint_1 int_2 double_3 double_4 org_opencv_core_mat_5 ))
)

(defn good-features-to-track-with-quality
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 double_10 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 double_10 ))
)

(defn good-features-to-track-with-quality!
([org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 double_10 ]
  (Imgproc/goodFeaturesToTrackWithQuality org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 org_opencv_core_mat_5 org_opencv_core_mat_6 int_7 int_8 boolean_9 double_10 ) org_opencv_core_mat_0 )
)

(defn hough-lines
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ))
)

(defn hough-lines!
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLines org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ) org_opencv_core_mat_0 )
)

(defn hough-lines-p
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ))
)

(defn hough-lines-p!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesP org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
)

(defn hough-lines-point-set
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 double_6 double_7 double_8 double_9 ]
  (Imgproc/HoughLinesPointSet org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 double_4 double_5 double_6 double_7 double_8 double_9 ))
)

(defn hough-lines-point-set!
([org_opencv_core_mat_0 int_2 int_3 double_4 double_5 double_6 double_7 double_8 double_9 ]
  (Imgproc/HoughLinesPointSet org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 double_4 double_5 double_6 double_7 double_8 double_9 ) org_opencv_core_mat_0 )
)

(defn hough-circles
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ))
)

(defn hough-circles!
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCircles org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ) org_opencv_core_mat_0 )
)

(defn erode
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ))
)

(defn erode!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ]
  (Imgproc/erode org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ) org_opencv_core_mat_0 )
)

(defn dilate
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ))
)

(defn dilate!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/dilate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
)

(defn morphology-ex
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ))
)

(defn morphology-ex!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ]
  (Imgproc/morphologyEx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_point_4 int_5 int_6 org_opencv_core_scalar_7 ) org_opencv_core_mat_0 )
)

(defn warp-affine
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ))
)

(defn warp-affine!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpAffine org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
)

(defn warp-perspective
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_size_3 ))
)

(defn warp-perspective!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ]
  (Imgproc/warpPerspective org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_size_3 ) org_opencv_core_mat_0 )
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

(defn get-rotation-matrix-2-d
([org_opencv_core_point_0 double_1 double_2 ]
  (Imgproc/getRotationMatrix2D org_opencv_core_point_0 double_1 double_2 ))
)

(defn invert-affine-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/invertAffineTransform org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn invert-affine-transform!
([org_opencv_core_mat_0 ]
  (Imgproc/invertAffineTransform org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn get-perspective-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn get-perspective-transform!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/getPerspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn get-affine-transform
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Imgproc/getAffineTransform org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
)

(defn get-rect-sub-pix
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 ]
  (Imgproc/getRectSubPix org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/getRectSubPix org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_point_2 org_opencv_core_mat_3 int_4 ))
)

(defn log-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/logPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ))
)

(defn log-polar!
([org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/logPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn linear-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/linearPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 double_3 int_4 ))
)

(defn linear-polar!
([org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ]
  (Imgproc/linearPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn warp-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 double_4 int_5 ]
  (Imgproc/warpPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_point_3 double_4 int_5 ))
)

(defn warp-polar!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 double_4 int_5 ]
  (Imgproc/warpPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_point_3 double_4 int_5 ) org_opencv_core_mat_0 )
)

(defn integral-3
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ))
)

(defn integral-3!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/integral3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ) org_opencv_core_mat_0 )
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

(defn integral-2
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn integral-2!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/integral2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
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

(defn phase-correlate
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 array_d_3 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 array_d_3 ))
)

(defn phase-correlate!
([org_opencv_core_mat_0 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 array_d_3 ]
  (Imgproc/phaseCorrelate org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 array_d_3 ) org_opencv_core_mat_0 )
)

(defn phase-correlate-iterative
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn phase-correlate-iterative!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/phaseCorrelateIterative org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn create-hanning-window
([org_opencv_core_mat_0 org_opencv_core_size_1 int_2 ]
  (Imgproc/createHanningWindow org_opencv_core_mat_0 org_opencv_core_size_1 int_2 ))
)

(defn div-spectrums
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/divSpectrums org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 boolean_4 ]
  (Imgproc/divSpectrums org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 boolean_4 ))
)

(defn div-spectrums!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/divSpectrums org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 boolean_4 ]
  (Imgproc/divSpectrums org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 boolean_4 ) org_opencv_core_mat_0 )
)

(defn threshold-with-mask
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 int_5 ]
  (Imgproc/thresholdWithMask org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 double_4 int_5 ))
)

(defn threshold-with-mask!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 int_5 ]
  (Imgproc/thresholdWithMask org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
)

(defn adaptive-threshold
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/adaptiveThreshold org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 int_3 int_4 int_5 double_6 ))
)

(defn adaptive-threshold!
([org_opencv_core_mat_0 double_2 int_3 int_4 int_5 double_6 ]
  (Imgproc/adaptiveThreshold org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 int_3 int_4 int_5 double_6 ) org_opencv_core_mat_0 )
)

(defn pyr-down
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
)

(defn pyr-down!
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/pyrDown org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
)

(defn pyr-up
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn pyr-up!
([org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/pyrUp org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn calc-hist
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 ]
  (Imgproc/calcHist java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 ))
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 boolean_6 ]
  (Imgproc/calcHist java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofint_4 org_opencv_core_matoffloat_5 boolean_6 ))
)

(defn calc-back-project
([java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matoffloat_4 double_5 ]
  (Imgproc/calcBackProject java_util_list_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matoffloat_4 double_5 ))
)

(defn compare-hist
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/compareHist org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn compare-hist!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/compareHist org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn equalize-hist
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/equalizeHist org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn equalize-hist!
([org_opencv_core_mat_0 ]
  (Imgproc/equalizeHist org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn create-clahe
([double_0 org_opencv_core_size_1 ]
  (Imgproc/createCLAHE double_0 org_opencv_core_size_1 ))
([]
  (Imgproc/createCLAHE ))
([double_0 ]
  (Imgproc/createCLAHE double_0 ))
)

(defn emd
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn emd!
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/EMD org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn watershed
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/watershed org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn watershed!
([org_opencv_core_mat_0 ]
  (Imgproc/watershed org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn pyr-mean-shift-filtering
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
)

(defn pyr-mean-shift-filtering!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 org_opencv_core_termcriteria_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Imgproc/pyrMeanShiftFiltering org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
)

(defn grab-cut
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ))
)

(defn grab-cut!
([org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Imgproc/grabCut org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_rect_2 org_opencv_core_mat_3 org_opencv_core_mat_4 int_5 int_6 ) org_opencv_core_mat_0 )
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
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn distance-transform!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/distanceTransform org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn flood-fill
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 ))
)

(defn flood-fill!
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 ]
  (Imgproc/floodFill org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_point_2 org_opencv_core_scalar_3 org_opencv_core_rect_4 org_opencv_core_scalar_5 ) org_opencv_core_mat_0 )
)

(defn blend-linear
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/blendLinear org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn blend-linear!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Imgproc/blendLinear org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn cvt-color
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn cvt-color!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/cvtColor org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn cvt-color-two-plane
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Imgproc/cvtColorTwoPlane org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/cvtColorTwoPlane org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn cvt-color-two-plane!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Imgproc/cvtColorTwoPlane org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/cvtColorTwoPlane org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 int_4 ) org_opencv_core_mat_0 )
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

(defn moments
([org_opencv_core_mat_0 boolean_1 ]
  (Imgproc/moments org_opencv_core_mat_0 boolean_1 ))
([org_opencv_core_mat_0 ]
  (Imgproc/moments org_opencv_core_mat_0 ))
)

(defn hu-moments
([org_opencv_imgproc_moments_0 org_opencv_core_mat_1 ]
  (Imgproc/HuMoments org_opencv_imgproc_moments_0 org_opencv_core_mat_1 ))
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

(defn connected-components-with-algorithm
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Imgproc/connectedComponentsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
)

(defn connected-components-with-algorithm!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Imgproc/connectedComponentsWithAlgorithm org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
)

(defn connected-components
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn connected-components!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/connectedComponents org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
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
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn connected-components-with-stats!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Imgproc/connectedComponentsWithStats org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn find-contours
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 org_opencv_core_point_5 ]
  (Imgproc/findContours org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 org_opencv_core_point_5 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 ]
  (Imgproc/findContours org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 int_3 int_4 ))
)

(defn find-contours-link-runs
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 ]
  (Imgproc/findContoursLinkRuns org_opencv_core_mat_0 java_util_list_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 java_util_list_1 ]
  (Imgproc/findContoursLinkRuns org_opencv_core_mat_0 java_util_list_1 ))
)

(defn approx-poly-dp
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 double_2 boolean_3 ]
  (Imgproc/approxPolyDP org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 double_2 boolean_3 ))
)

(defn approx-poly-n
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 boolean_4 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 boolean_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 ))
)

(defn approx-poly-n!
([org_opencv_core_mat_0 int_2 float_3 boolean_4 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 float_3 boolean_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 float_3 ]
  (Imgproc/approxPolyN org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 float_3 ) org_opencv_core_mat_0 )
)

(defn arc-length
([org_opencv_core_matofpoint2f_0 boolean_1 ]
  (Imgproc/arcLength org_opencv_core_matofpoint2f_0 boolean_1 ))
)

(defn contour-area
([org_opencv_core_mat_0 ]
  (Imgproc/contourArea org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 boolean_1 ]
  (Imgproc/contourArea org_opencv_core_mat_0 boolean_1 ))
)

(defn min-area-rect
([org_opencv_core_matofpoint2f_0 ]
  (Imgproc/minAreaRect org_opencv_core_matofpoint2f_0 ))
)

(defn box-points
([org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 ]
  (Imgproc/boxPoints org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 ))
)

(defn min-enclosing-circle
([org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 array_f_2 ]
  (Imgproc/minEnclosingCircle org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 array_f_2 ))
)

(defn min-enclosing-triangle
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Imgproc/minEnclosingTriangle org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn min-enclosing-triangle!
([org_opencv_core_mat_0 ]
  (Imgproc/minEnclosingTriangle org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn min-enclosing-convex-polygon
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Imgproc/minEnclosingConvexPolygon org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn min-enclosing-convex-polygon!
([org_opencv_core_mat_0 int_2 ]
  (Imgproc/minEnclosingConvexPolygon org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn match-shapes
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 ]
  (Imgproc/matchShapes org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 ))
)

(defn match-shapes!
([org_opencv_core_mat_0 int_2 double_3 ]
  (Imgproc/matchShapes org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 ) org_opencv_core_mat_0 )
)

(defn convex-hull
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 ]
  (Imgproc/convexHull org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 ))
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 boolean_2 ]
  (Imgproc/convexHull org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 boolean_2 ))
)

(defn convexity-defects
([org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 org_opencv_core_matofint4_2 ]
  (Imgproc/convexityDefects org_opencv_core_matofpoint_0 org_opencv_core_matofint_1 org_opencv_core_matofint4_2 ))
)

(defn is-contour-convex
([org_opencv_core_matofpoint_0 ]
  (Imgproc/isContourConvex org_opencv_core_matofpoint_0 ))
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

(defn fit-ellipse
([org_opencv_core_matofpoint2f_0 ]
  (Imgproc/fitEllipse org_opencv_core_matofpoint2f_0 ))
)

(defn fit-ellipse-ams
([org_opencv_core_mat_0 ]
  (Imgproc/fitEllipseAMS org_opencv_core_mat_0 ))
)

(defn fit-ellipse-direct
([org_opencv_core_mat_0 ]
  (Imgproc/fitEllipseDirect org_opencv_core_mat_0 ))
)

(defn get-closest-ellipse-points
([org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/getClosestEllipsePoints org_opencv_core_rotatedrect_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn fit-line
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ]
  (Imgproc/fitLine org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ))
)

(defn fit-line!
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ]
  (Imgproc/fitLine org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ) org_opencv_core_mat_0 )
)

(defn point-polygon-test
([org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 boolean_2 ]
  (Imgproc/pointPolygonTest org_opencv_core_matofpoint2f_0 org_opencv_core_point_1 boolean_2 ))
)

(defn rotated-rectangle-intersection
([org_opencv_core_rotatedrect_0 org_opencv_core_rotatedrect_1 org_opencv_core_mat_2 ]
  (Imgproc/rotatedRectangleIntersection org_opencv_core_rotatedrect_0 org_opencv_core_rotatedrect_1 org_opencv_core_mat_2 ))
)

(defn create-generalized-hough-ballard
([]
  (Imgproc/createGeneralizedHoughBallard ))
)

(defn create-generalized-hough-guil
([]
  (Imgproc/createGeneralizedHoughGuil ))
)

(defn apply-color-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Imgproc/applyColorMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn apply-color-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Imgproc/applyColorMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn arrowed-line
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 double_7 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 double_7 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/arrowedLine org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
)

(defn rectangle
([org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 int_4 int_5 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_rect_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/rectangle org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
)

(defn circle
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 ]
  (Imgproc/circle org_opencv_core_mat_0 org_opencv_core_point_1 int_2 org_opencv_core_scalar_3 int_4 int_5 ))
)

(defn ellipse
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_rotatedrect_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 int_9 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 int_9 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 int_8 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 ]
  (Imgproc/ellipse org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_size_2 double_3 double_4 double_5 org_opencv_core_scalar_6 int_7 ))
)

(defn draw-marker
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 int_6 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 ]
  (Imgproc/drawMarker org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_scalar_2 ))
)

(defn fill-convex-poly
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/fillConvexPoly org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/fillConvexPoly org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 ]
  (Imgproc/fillConvexPoly org_opencv_core_mat_0 org_opencv_core_matofpoint_1 org_opencv_core_scalar_2 ))
)

(defn fill-poly
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 ))
([org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 org_opencv_core_point_5 ]
  (Imgproc/fillPoly org_opencv_core_mat_0 java_util_list_1 org_opencv_core_scalar_2 int_3 int_4 org_opencv_core_point_5 ))
)

(defn polylines
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 ))
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 ]
  (Imgproc/polylines org_opencv_core_mat_0 java_util_list_1 boolean_2 org_opencv_core_scalar_3 ))
)

(defn draw-contours
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 ))
([org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 org_opencv_core_point_8 ]
  (Imgproc/drawContours org_opencv_core_mat_0 java_util_list_1 int_2 org_opencv_core_scalar_3 int_4 int_5 org_opencv_core_mat_6 int_7 org_opencv_core_point_8 ))
)

(defn clip-line
([org_opencv_core_rect_0 org_opencv_core_point_1 org_opencv_core_point_2 ]
  (Imgproc/clipLine org_opencv_core_rect_0 org_opencv_core_point_1 org_opencv_core_point_2 ))
)

(defn ellipse-2-poly
([org_opencv_core_point_0 org_opencv_core_size_1 int_2 int_3 int_4 int_5 org_opencv_core_matofpoint_6 ]
  (Imgproc/ellipse2Poly org_opencv_core_point_0 org_opencv_core_size_1 int_2 int_3 int_4 int_5 org_opencv_core_matofpoint_6 ))
)

(defn put-text
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 ))
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 ))
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 ))
([org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8 ]
  (Imgproc/putText org_opencv_core_mat_0 java_lang_string_1 org_opencv_core_point_2 int_3 double_4 org_opencv_core_scalar_5 int_6 int_7 boolean_8 ))
)

(defn get-font-scale-from-height
([int_0 int_1 ]
  (Imgproc/getFontScaleFromHeight int_0 int_1 ))
([int_0 int_1 int_2 ]
  (Imgproc/getFontScaleFromHeight int_0 int_1 int_2 ))
)

(defn hough-lines-with-accumulator
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 double_5 double_6 double_7 ))
)

(defn hough-lines-with-accumulator!
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 boolean_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 double_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 ]
  (Imgproc/HoughLinesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 double_5 double_6 double_7 ) org_opencv_core_mat_0 )
)

(defn hough-circles-with-accumulator
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 double_3 double_4 double_5 double_6 ))
)

(defn hough-circles-with-accumulator!
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 int_7 int_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 ]
  (Imgproc/HoughCirclesWithAccumulator org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 double_3 double_4 double_5 double_6 ) org_opencv_core_mat_0 )
)

(defn get-text-size
([java_lang_string_0 int_1 double_2 int_3 array_i_4 ]
  (Imgproc/getTextSize java_lang_string_0 int_1 double_2 int_3 array_i_4 ))
)

(defn remap
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ))
)

(defn remap!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ]
  (Imgproc/remap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 int_5 org_opencv_core_scalar_6 ) org_opencv_core_mat_0 )
)

(defn line
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 ]
  (Imgproc/line org_opencv_core_mat_0 org_opencv_core_point_1 org_opencv_core_point_2 org_opencv_core_scalar_3 int_4 int_5 ))
)

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
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ))
)

(defn resize!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ]
  (Imgproc/resize org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ) org_opencv_core_mat_0 )
)

(def CV_GAUSSIAN_5x5 Imgproc/CV_GAUSSIAN_5x5)
(def CV_SCHARR Imgproc/CV_SCHARR)
(def CV_MAX_SOBEL_KSIZE Imgproc/CV_MAX_SOBEL_KSIZE)
(def CV_RGBA2mRGBA Imgproc/CV_RGBA2mRGBA)
(def CV_mRGBA2RGBA Imgproc/CV_mRGBA2RGBA)
(def CV_WARP_FILL_OUTLIERS Imgproc/CV_WARP_FILL_OUTLIERS)
(def CV_WARP_INVERSE_MAP Imgproc/CV_WARP_INVERSE_MAP)
(def CV_WARP_RELATIVE_MAP Imgproc/CV_WARP_RELATIVE_MAP)
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
(def CV_SHAPE_RECT Imgproc/CV_SHAPE_RECT)
(def CV_SHAPE_CROSS Imgproc/CV_SHAPE_CROSS)
(def CV_SHAPE_ELLIPSE Imgproc/CV_SHAPE_ELLIPSE)
(def CV_SHAPE_DIAMOND Imgproc/CV_SHAPE_DIAMOND)
(def CV_SHAPE_CUSTOM Imgproc/CV_SHAPE_CUSTOM)
(def CV_BLUR_NO_SCALE Imgproc/CV_BLUR_NO_SCALE)
(def CV_BLUR Imgproc/CV_BLUR)
(def CV_GAUSSIAN Imgproc/CV_GAUSSIAN)
(def CV_MEDIAN Imgproc/CV_MEDIAN)
(def CV_BILATERAL Imgproc/CV_BILATERAL)
(def ADAPTIVE_THRESH_MEAN_C Imgproc/ADAPTIVE_THRESH_MEAN_C)
(def ADAPTIVE_THRESH_GAUSSIAN_C Imgproc/ADAPTIVE_THRESH_GAUSSIAN_C)
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
(def COLOR_BayerRGGB2BGR Imgproc/COLOR_BayerRGGB2BGR)
(def COLOR_BayerGRBG2BGR Imgproc/COLOR_BayerGRBG2BGR)
(def COLOR_BayerBGGR2BGR Imgproc/COLOR_BayerBGGR2BGR)
(def COLOR_BayerGBRG2BGR Imgproc/COLOR_BayerGBRG2BGR)
(def COLOR_BayerRGGB2RGB Imgproc/COLOR_BayerRGGB2RGB)
(def COLOR_BayerGRBG2RGB Imgproc/COLOR_BayerGRBG2RGB)
(def COLOR_BayerBGGR2RGB Imgproc/COLOR_BayerBGGR2RGB)
(def COLOR_BayerGBRG2RGB Imgproc/COLOR_BayerGBRG2RGB)
(def COLOR_BayerBG2RGB Imgproc/COLOR_BayerBG2RGB)
(def COLOR_BayerGB2RGB Imgproc/COLOR_BayerGB2RGB)
(def COLOR_BayerRG2RGB Imgproc/COLOR_BayerRG2RGB)
(def COLOR_BayerGR2RGB Imgproc/COLOR_BayerGR2RGB)
(def COLOR_BayerBG2GRAY Imgproc/COLOR_BayerBG2GRAY)
(def COLOR_BayerGB2GRAY Imgproc/COLOR_BayerGB2GRAY)
(def COLOR_BayerRG2GRAY Imgproc/COLOR_BayerRG2GRAY)
(def COLOR_BayerGR2GRAY Imgproc/COLOR_BayerGR2GRAY)
(def COLOR_BayerRGGB2GRAY Imgproc/COLOR_BayerRGGB2GRAY)
(def COLOR_BayerGRBG2GRAY Imgproc/COLOR_BayerGRBG2GRAY)
(def COLOR_BayerBGGR2GRAY Imgproc/COLOR_BayerBGGR2GRAY)
(def COLOR_BayerGBRG2GRAY Imgproc/COLOR_BayerGBRG2GRAY)
(def COLOR_BayerBG2BGR_VNG Imgproc/COLOR_BayerBG2BGR_VNG)
(def COLOR_BayerGB2BGR_VNG Imgproc/COLOR_BayerGB2BGR_VNG)
(def COLOR_BayerRG2BGR_VNG Imgproc/COLOR_BayerRG2BGR_VNG)
(def COLOR_BayerGR2BGR_VNG Imgproc/COLOR_BayerGR2BGR_VNG)
(def COLOR_BayerRGGB2BGR_VNG Imgproc/COLOR_BayerRGGB2BGR_VNG)
(def COLOR_BayerGRBG2BGR_VNG Imgproc/COLOR_BayerGRBG2BGR_VNG)
(def COLOR_BayerBGGR2BGR_VNG Imgproc/COLOR_BayerBGGR2BGR_VNG)
(def COLOR_BayerGBRG2BGR_VNG Imgproc/COLOR_BayerGBRG2BGR_VNG)
(def COLOR_BayerRGGB2RGB_VNG Imgproc/COLOR_BayerRGGB2RGB_VNG)
(def COLOR_BayerGRBG2RGB_VNG Imgproc/COLOR_BayerGRBG2RGB_VNG)
(def COLOR_BayerBGGR2RGB_VNG Imgproc/COLOR_BayerBGGR2RGB_VNG)
(def COLOR_BayerGBRG2RGB_VNG Imgproc/COLOR_BayerGBRG2RGB_VNG)
(def COLOR_BayerBG2RGB_VNG Imgproc/COLOR_BayerBG2RGB_VNG)
(def COLOR_BayerGB2RGB_VNG Imgproc/COLOR_BayerGB2RGB_VNG)
(def COLOR_BayerRG2RGB_VNG Imgproc/COLOR_BayerRG2RGB_VNG)
(def COLOR_BayerGR2RGB_VNG Imgproc/COLOR_BayerGR2RGB_VNG)
(def COLOR_BayerBG2BGR_EA Imgproc/COLOR_BayerBG2BGR_EA)
(def COLOR_BayerGB2BGR_EA Imgproc/COLOR_BayerGB2BGR_EA)
(def COLOR_BayerRG2BGR_EA Imgproc/COLOR_BayerRG2BGR_EA)
(def COLOR_BayerGR2BGR_EA Imgproc/COLOR_BayerGR2BGR_EA)
(def COLOR_BayerRGGB2BGR_EA Imgproc/COLOR_BayerRGGB2BGR_EA)
(def COLOR_BayerGRBG2BGR_EA Imgproc/COLOR_BayerGRBG2BGR_EA)
(def COLOR_BayerBGGR2BGR_EA Imgproc/COLOR_BayerBGGR2BGR_EA)
(def COLOR_BayerGBRG2BGR_EA Imgproc/COLOR_BayerGBRG2BGR_EA)
(def COLOR_BayerRGGB2RGB_EA Imgproc/COLOR_BayerRGGB2RGB_EA)
(def COLOR_BayerGRBG2RGB_EA Imgproc/COLOR_BayerGRBG2RGB_EA)
(def COLOR_BayerBGGR2RGB_EA Imgproc/COLOR_BayerBGGR2RGB_EA)
(def COLOR_BayerGBRG2RGB_EA Imgproc/COLOR_BayerGBRG2RGB_EA)
(def COLOR_BayerBG2RGB_EA Imgproc/COLOR_BayerBG2RGB_EA)
(def COLOR_BayerGB2RGB_EA Imgproc/COLOR_BayerGB2RGB_EA)
(def COLOR_BayerRG2RGB_EA Imgproc/COLOR_BayerRG2RGB_EA)
(def COLOR_BayerGR2RGB_EA Imgproc/COLOR_BayerGR2RGB_EA)
(def COLOR_BayerBG2BGRA Imgproc/COLOR_BayerBG2BGRA)
(def COLOR_BayerGB2BGRA Imgproc/COLOR_BayerGB2BGRA)
(def COLOR_BayerRG2BGRA Imgproc/COLOR_BayerRG2BGRA)
(def COLOR_BayerGR2BGRA Imgproc/COLOR_BayerGR2BGRA)
(def COLOR_BayerRGGB2BGRA Imgproc/COLOR_BayerRGGB2BGRA)
(def COLOR_BayerGRBG2BGRA Imgproc/COLOR_BayerGRBG2BGRA)
(def COLOR_BayerBGGR2BGRA Imgproc/COLOR_BayerBGGR2BGRA)
(def COLOR_BayerGBRG2BGRA Imgproc/COLOR_BayerGBRG2BGRA)
(def COLOR_BayerRGGB2RGBA Imgproc/COLOR_BayerRGGB2RGBA)
(def COLOR_BayerGRBG2RGBA Imgproc/COLOR_BayerGRBG2RGBA)
(def COLOR_BayerBGGR2RGBA Imgproc/COLOR_BayerBGGR2RGBA)
(def COLOR_BayerGBRG2RGBA Imgproc/COLOR_BayerGBRG2RGBA)
(def COLOR_BayerBG2RGBA Imgproc/COLOR_BayerBG2RGBA)
(def COLOR_BayerGB2RGBA Imgproc/COLOR_BayerGB2RGBA)
(def COLOR_BayerRG2RGBA Imgproc/COLOR_BayerRG2RGBA)
(def COLOR_BayerGR2RGBA Imgproc/COLOR_BayerGR2RGBA)
(def COLOR_RGB2YUV_UYVY Imgproc/COLOR_RGB2YUV_UYVY)
(def COLOR_BGR2YUV_UYVY Imgproc/COLOR_BGR2YUV_UYVY)
(def COLOR_RGB2YUV_Y422 Imgproc/COLOR_RGB2YUV_Y422)
(def COLOR_BGR2YUV_Y422 Imgproc/COLOR_BGR2YUV_Y422)
(def COLOR_RGB2YUV_UYNV Imgproc/COLOR_RGB2YUV_UYNV)
(def COLOR_BGR2YUV_UYNV Imgproc/COLOR_BGR2YUV_UYNV)
(def COLOR_RGBA2YUV_UYVY Imgproc/COLOR_RGBA2YUV_UYVY)
(def COLOR_BGRA2YUV_UYVY Imgproc/COLOR_BGRA2YUV_UYVY)
(def COLOR_RGBA2YUV_Y422 Imgproc/COLOR_RGBA2YUV_Y422)
(def COLOR_BGRA2YUV_Y422 Imgproc/COLOR_BGRA2YUV_Y422)
(def COLOR_RGBA2YUV_UYNV Imgproc/COLOR_RGBA2YUV_UYNV)
(def COLOR_BGRA2YUV_UYNV Imgproc/COLOR_BGRA2YUV_UYNV)
(def COLOR_RGB2YUV_YUY2 Imgproc/COLOR_RGB2YUV_YUY2)
(def COLOR_BGR2YUV_YUY2 Imgproc/COLOR_BGR2YUV_YUY2)
(def COLOR_RGB2YUV_YVYU Imgproc/COLOR_RGB2YUV_YVYU)
(def COLOR_BGR2YUV_YVYU Imgproc/COLOR_BGR2YUV_YVYU)
(def COLOR_RGB2YUV_YUYV Imgproc/COLOR_RGB2YUV_YUYV)
(def COLOR_BGR2YUV_YUYV Imgproc/COLOR_BGR2YUV_YUYV)
(def COLOR_RGB2YUV_YUNV Imgproc/COLOR_RGB2YUV_YUNV)
(def COLOR_BGR2YUV_YUNV Imgproc/COLOR_BGR2YUV_YUNV)
(def COLOR_RGBA2YUV_YUY2 Imgproc/COLOR_RGBA2YUV_YUY2)
(def COLOR_BGRA2YUV_YUY2 Imgproc/COLOR_BGRA2YUV_YUY2)
(def COLOR_RGBA2YUV_YVYU Imgproc/COLOR_RGBA2YUV_YVYU)
(def COLOR_BGRA2YUV_YVYU Imgproc/COLOR_BGRA2YUV_YVYU)
(def COLOR_RGBA2YUV_YUYV Imgproc/COLOR_RGBA2YUV_YUYV)
(def COLOR_BGRA2YUV_YUYV Imgproc/COLOR_BGRA2YUV_YUYV)
(def COLOR_RGBA2YUV_YUNV Imgproc/COLOR_RGBA2YUV_YUNV)
(def COLOR_BGRA2YUV_YUNV Imgproc/COLOR_BGRA2YUV_YUNV)
(def COLOR_COLORCVT_MAX Imgproc/COLOR_COLORCVT_MAX)
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
(def COLORMAP_MAGMA Imgproc/COLORMAP_MAGMA)
(def COLORMAP_INFERNO Imgproc/COLORMAP_INFERNO)
(def COLORMAP_PLASMA Imgproc/COLORMAP_PLASMA)
(def COLORMAP_VIRIDIS Imgproc/COLORMAP_VIRIDIS)
(def COLORMAP_CIVIDIS Imgproc/COLORMAP_CIVIDIS)
(def COLORMAP_TWILIGHT Imgproc/COLORMAP_TWILIGHT)
(def COLORMAP_TWILIGHT_SHIFTED Imgproc/COLORMAP_TWILIGHT_SHIFTED)
(def COLORMAP_TURBO Imgproc/COLORMAP_TURBO)
(def COLORMAP_DEEPGREEN Imgproc/COLORMAP_DEEPGREEN)
(def CCL_DEFAULT Imgproc/CCL_DEFAULT)
(def CCL_WU Imgproc/CCL_WU)
(def CCL_GRANA Imgproc/CCL_GRANA)
(def CCL_BOLELLI Imgproc/CCL_BOLELLI)
(def CCL_SAUF Imgproc/CCL_SAUF)
(def CCL_BBDT Imgproc/CCL_BBDT)
(def CCL_SPAGHETTI Imgproc/CCL_SPAGHETTI)
(def CC_STAT_LEFT Imgproc/CC_STAT_LEFT)
(def CC_STAT_TOP Imgproc/CC_STAT_TOP)
(def CC_STAT_WIDTH Imgproc/CC_STAT_WIDTH)
(def CC_STAT_HEIGHT Imgproc/CC_STAT_HEIGHT)
(def CC_STAT_AREA Imgproc/CC_STAT_AREA)
(def CC_STAT_MAX Imgproc/CC_STAT_MAX)
(def CHAIN_APPROX_NONE Imgproc/CHAIN_APPROX_NONE)
(def CHAIN_APPROX_SIMPLE Imgproc/CHAIN_APPROX_SIMPLE)
(def CHAIN_APPROX_TC89_L1 Imgproc/CHAIN_APPROX_TC89_L1)
(def CHAIN_APPROX_TC89_KCOS Imgproc/CHAIN_APPROX_TC89_KCOS)
(def DIST_LABEL_CCOMP Imgproc/DIST_LABEL_CCOMP)
(def DIST_LABEL_PIXEL Imgproc/DIST_LABEL_PIXEL)
(def DIST_MASK_3 Imgproc/DIST_MASK_3)
(def DIST_MASK_5 Imgproc/DIST_MASK_5)
(def DIST_MASK_PRECISE Imgproc/DIST_MASK_PRECISE)
(def DIST_USER Imgproc/DIST_USER)
(def DIST_L1 Imgproc/DIST_L1)
(def DIST_L2 Imgproc/DIST_L2)
(def DIST_C Imgproc/DIST_C)
(def DIST_L12 Imgproc/DIST_L12)
(def DIST_FAIR Imgproc/DIST_FAIR)
(def DIST_WELSCH Imgproc/DIST_WELSCH)
(def DIST_HUBER Imgproc/DIST_HUBER)
(def FLOODFILL_FIXED_RANGE Imgproc/FLOODFILL_FIXED_RANGE)
(def FLOODFILL_MASK_ONLY Imgproc/FLOODFILL_MASK_ONLY)
(def GC_BGD Imgproc/GC_BGD)
(def GC_FGD Imgproc/GC_FGD)
(def GC_PR_BGD Imgproc/GC_PR_BGD)
(def GC_PR_FGD Imgproc/GC_PR_FGD)
(def GC_INIT_WITH_RECT Imgproc/GC_INIT_WITH_RECT)
(def GC_INIT_WITH_MASK Imgproc/GC_INIT_WITH_MASK)
(def GC_EVAL Imgproc/GC_EVAL)
(def GC_EVAL_FREEZE_MODEL Imgproc/GC_EVAL_FREEZE_MODEL)
(def FONT_HERSHEY_SIMPLEX Imgproc/FONT_HERSHEY_SIMPLEX)
(def FONT_HERSHEY_PLAIN Imgproc/FONT_HERSHEY_PLAIN)
(def FONT_HERSHEY_DUPLEX Imgproc/FONT_HERSHEY_DUPLEX)
(def FONT_HERSHEY_COMPLEX Imgproc/FONT_HERSHEY_COMPLEX)
(def FONT_HERSHEY_TRIPLEX Imgproc/FONT_HERSHEY_TRIPLEX)
(def FONT_HERSHEY_COMPLEX_SMALL Imgproc/FONT_HERSHEY_COMPLEX_SMALL)
(def FONT_HERSHEY_SCRIPT_SIMPLEX Imgproc/FONT_HERSHEY_SCRIPT_SIMPLEX)
(def FONT_HERSHEY_SCRIPT_COMPLEX Imgproc/FONT_HERSHEY_SCRIPT_COMPLEX)
(def FONT_ITALIC Imgproc/FONT_ITALIC)
(def HISTCMP_CORREL Imgproc/HISTCMP_CORREL)
(def HISTCMP_CHISQR Imgproc/HISTCMP_CHISQR)
(def HISTCMP_INTERSECT Imgproc/HISTCMP_INTERSECT)
(def HISTCMP_BHATTACHARYYA Imgproc/HISTCMP_BHATTACHARYYA)
(def HISTCMP_HELLINGER Imgproc/HISTCMP_HELLINGER)
(def HISTCMP_CHISQR_ALT Imgproc/HISTCMP_CHISQR_ALT)
(def HISTCMP_KL_DIV Imgproc/HISTCMP_KL_DIV)
(def HOUGH_STANDARD Imgproc/HOUGH_STANDARD)
(def HOUGH_PROBABILISTIC Imgproc/HOUGH_PROBABILISTIC)
(def HOUGH_MULTI_SCALE Imgproc/HOUGH_MULTI_SCALE)
(def HOUGH_GRADIENT Imgproc/HOUGH_GRADIENT)
(def HOUGH_GRADIENT_ALT Imgproc/HOUGH_GRADIENT_ALT)
(def INTER_NEAREST Imgproc/INTER_NEAREST)
(def INTER_LINEAR Imgproc/INTER_LINEAR)
(def INTER_CUBIC Imgproc/INTER_CUBIC)
(def INTER_AREA Imgproc/INTER_AREA)
(def INTER_LANCZOS4 Imgproc/INTER_LANCZOS4)
(def INTER_LINEAR_EXACT Imgproc/INTER_LINEAR_EXACT)
(def INTER_NEAREST_EXACT Imgproc/INTER_NEAREST_EXACT)
(def INTER_MAX Imgproc/INTER_MAX)
(def WARP_FILL_OUTLIERS Imgproc/WARP_FILL_OUTLIERS)
(def WARP_INVERSE_MAP Imgproc/WARP_INVERSE_MAP)
(def WARP_RELATIVE_MAP Imgproc/WARP_RELATIVE_MAP)
(def INTER_BITS Imgproc/INTER_BITS)
(def INTER_BITS2 Imgproc/INTER_BITS2)
(def INTER_TAB_SIZE Imgproc/INTER_TAB_SIZE)
(def INTER_TAB_SIZE2 Imgproc/INTER_TAB_SIZE2)
(def LSD_REFINE_NONE Imgproc/LSD_REFINE_NONE)
(def LSD_REFINE_STD Imgproc/LSD_REFINE_STD)
(def LSD_REFINE_ADV Imgproc/LSD_REFINE_ADV)
(def FILLED Imgproc/FILLED)
(def LINE_4 Imgproc/LINE_4)
(def LINE_8 Imgproc/LINE_8)
(def LINE_AA Imgproc/LINE_AA)
(def MARKER_CROSS Imgproc/MARKER_CROSS)
(def MARKER_TILTED_CROSS Imgproc/MARKER_TILTED_CROSS)
(def MARKER_STAR Imgproc/MARKER_STAR)
(def MARKER_DIAMOND Imgproc/MARKER_DIAMOND)
(def MARKER_SQUARE Imgproc/MARKER_SQUARE)
(def MARKER_TRIANGLE_UP Imgproc/MARKER_TRIANGLE_UP)
(def MARKER_TRIANGLE_DOWN Imgproc/MARKER_TRIANGLE_DOWN)
(def MORPH_RECT Imgproc/MORPH_RECT)
(def MORPH_CROSS Imgproc/MORPH_CROSS)
(def MORPH_ELLIPSE Imgproc/MORPH_ELLIPSE)
(def MORPH_DIAMOND Imgproc/MORPH_DIAMOND)
(def MORPH_ERODE Imgproc/MORPH_ERODE)
(def MORPH_DILATE Imgproc/MORPH_DILATE)
(def MORPH_OPEN Imgproc/MORPH_OPEN)
(def MORPH_CLOSE Imgproc/MORPH_CLOSE)
(def MORPH_GRADIENT Imgproc/MORPH_GRADIENT)
(def MORPH_TOPHAT Imgproc/MORPH_TOPHAT)
(def MORPH_BLACKHAT Imgproc/MORPH_BLACKHAT)
(def MORPH_HITMISS Imgproc/MORPH_HITMISS)
(def INTERSECT_NONE Imgproc/INTERSECT_NONE)
(def INTERSECT_PARTIAL Imgproc/INTERSECT_PARTIAL)
(def INTERSECT_FULL Imgproc/INTERSECT_FULL)
(def RETR_EXTERNAL Imgproc/RETR_EXTERNAL)
(def RETR_LIST Imgproc/RETR_LIST)
(def RETR_CCOMP Imgproc/RETR_CCOMP)
(def RETR_TREE Imgproc/RETR_TREE)
(def RETR_FLOODFILL Imgproc/RETR_FLOODFILL)
(def CONTOURS_MATCH_I1 Imgproc/CONTOURS_MATCH_I1)
(def CONTOURS_MATCH_I2 Imgproc/CONTOURS_MATCH_I2)
(def CONTOURS_MATCH_I3 Imgproc/CONTOURS_MATCH_I3)
(def FILTER_SCHARR Imgproc/FILTER_SCHARR)
(def TM_SQDIFF Imgproc/TM_SQDIFF)
(def TM_SQDIFF_NORMED Imgproc/TM_SQDIFF_NORMED)
(def TM_CCORR Imgproc/TM_CCORR)
(def TM_CCORR_NORMED Imgproc/TM_CCORR_NORMED)
(def TM_CCOEFF Imgproc/TM_CCOEFF)
(def TM_CCOEFF_NORMED Imgproc/TM_CCOEFF_NORMED)
(def THRESH_BINARY Imgproc/THRESH_BINARY)
(def THRESH_BINARY_INV Imgproc/THRESH_BINARY_INV)
(def THRESH_TRUNC Imgproc/THRESH_TRUNC)
(def THRESH_TOZERO Imgproc/THRESH_TOZERO)
(def THRESH_TOZERO_INV Imgproc/THRESH_TOZERO_INV)
(def THRESH_MASK Imgproc/THRESH_MASK)
(def THRESH_OTSU Imgproc/THRESH_OTSU)
(def THRESH_TRIANGLE Imgproc/THRESH_TRIANGLE)
(def THRESH_DRYRUN Imgproc/THRESH_DRYRUN)
(def WARP_POLAR_LINEAR Imgproc/WARP_POLAR_LINEAR)
(def WARP_POLAR_LOG Imgproc/WARP_POLAR_LOG)
;;; Core
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
(def RNG_UNIFORM Core/RNG_UNIFORM)
(def RNG_NORMAL Core/RNG_NORMAL)
(def ALGO_HINT_DEFAULT Core/ALGO_HINT_DEFAULT)
(def ALGO_HINT_ACCURATE Core/ALGO_HINT_ACCURATE)
(def ALGO_HINT_APPROX Core/ALGO_HINT_APPROX)
(def BORDER_CONSTANT Core/BORDER_CONSTANT)
(def BORDER_REPLICATE Core/BORDER_REPLICATE)
(def BORDER_REFLECT Core/BORDER_REFLECT)
(def BORDER_WRAP Core/BORDER_WRAP)
(def BORDER_REFLECT_101 Core/BORDER_REFLECT_101)
(def BORDER_TRANSPARENT Core/BORDER_TRANSPARENT)
(def BORDER_REFLECT101 Core/BORDER_REFLECT101)
(def BORDER_DEFAULT Core/BORDER_DEFAULT)
(def BORDER_ISOLATED Core/BORDER_ISOLATED)
(def CMP_EQ Core/CMP_EQ)
(def CMP_GT Core/CMP_GT)
(def CMP_GE Core/CMP_GE)
(def CMP_LT Core/CMP_LT)
(def CMP_LE Core/CMP_LE)
(def CMP_NE Core/CMP_NE)
(def COVAR_SCRAMBLED Core/COVAR_SCRAMBLED)
(def COVAR_NORMAL Core/COVAR_NORMAL)
(def COVAR_USE_AVG Core/COVAR_USE_AVG)
(def COVAR_SCALE Core/COVAR_SCALE)
(def COVAR_ROWS Core/COVAR_ROWS)
(def COVAR_COLS Core/COVAR_COLS)
(def DECOMP_LU Core/DECOMP_LU)
(def DECOMP_SVD Core/DECOMP_SVD)
(def DECOMP_EIG Core/DECOMP_EIG)
(def DECOMP_CHOLESKY Core/DECOMP_CHOLESKY)
(def DECOMP_QR Core/DECOMP_QR)
(def DECOMP_NORMAL Core/DECOMP_NORMAL)
(def DFT_INVERSE Core/DFT_INVERSE)
(def DFT_SCALE Core/DFT_SCALE)
(def DFT_ROWS Core/DFT_ROWS)
(def DFT_COMPLEX_OUTPUT Core/DFT_COMPLEX_OUTPUT)
(def DFT_REAL_OUTPUT Core/DFT_REAL_OUTPUT)
(def DFT_COMPLEX_INPUT Core/DFT_COMPLEX_INPUT)
(def DCT_INVERSE Core/DCT_INVERSE)
(def DCT_ROWS Core/DCT_ROWS)
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
(def Formatter_FMT_DEFAULT Core/Formatter_FMT_DEFAULT)
(def Formatter_FMT_MATLAB Core/Formatter_FMT_MATLAB)
(def Formatter_FMT_CSV Core/Formatter_FMT_CSV)
(def Formatter_FMT_PYTHON Core/Formatter_FMT_PYTHON)
(def Formatter_FMT_NUMPY Core/Formatter_FMT_NUMPY)
(def Formatter_FMT_C Core/Formatter_FMT_C)
(def GEMM_1_T Core/GEMM_1_T)
(def GEMM_2_T Core/GEMM_2_T)
(def GEMM_3_T Core/GEMM_3_T)
(def KMEANS_RANDOM_CENTERS Core/KMEANS_RANDOM_CENTERS)
(def KMEANS_PP_CENTERS Core/KMEANS_PP_CENTERS)
(def KMEANS_USE_INITIAL_LABELS Core/KMEANS_USE_INITIAL_LABELS)
(def NORM_INF Core/NORM_INF)
(def NORM_L1 Core/NORM_L1)
(def NORM_L2 Core/NORM_L2)
(def NORM_L2SQR Core/NORM_L2SQR)
(def NORM_HAMMING Core/NORM_HAMMING)
(def NORM_HAMMING2 Core/NORM_HAMMING2)
(def NORM_TYPE_MASK Core/NORM_TYPE_MASK)
(def NORM_RELATIVE Core/NORM_RELATIVE)
(def NORM_MINMAX Core/NORM_MINMAX)
(def PCA_DATA_AS_ROW Core/PCA_DATA_AS_ROW)
(def PCA_DATA_AS_COL Core/PCA_DATA_AS_COL)
(def PCA_USE_AVG Core/PCA_USE_AVG)
(def Param_INT Core/Param_INT)
(def Param_BOOLEAN Core/Param_BOOLEAN)
(def Param_REAL Core/Param_REAL)
(def Param_STRING Core/Param_STRING)
(def Param_MAT Core/Param_MAT)
(def Param_MAT_VECTOR Core/Param_MAT_VECTOR)
(def Param_ALGORITHM Core/Param_ALGORITHM)
(def Param_FLOAT Core/Param_FLOAT)
(def Param_UNSIGNED_INT Core/Param_UNSIGNED_INT)
(def Param_UINT64 Core/Param_UINT64)
(def Param_UCHAR Core/Param_UCHAR)
(def Param_SCALAR Core/Param_SCALAR)
(def REDUCE_SUM2 Core/REDUCE_SUM2)
(def ROTATE_90_CLOCKWISE Core/ROTATE_90_CLOCKWISE)
(def ROTATE_180 Core/ROTATE_180)
(def ROTATE_90_COUNTERCLOCKWISE Core/ROTATE_90_COUNTERCLOCKWISE)
(def SORT_EVERY_ROW Core/SORT_EVERY_ROW)
(def SORT_EVERY_COLUMN Core/SORT_EVERY_COLUMN)
(def SORT_ASCENDING Core/SORT_ASCENDING)
(def SORT_DESCENDING Core/SORT_DESCENDING)
(defn cube-root
([float_0 ]
  (Core/cubeRoot float_0 ))
)

(defn fast-atan-2
([float_0 float_1 ]
  (Core/fastAtan2 float_0 float_1 ))
)

(defn use-ipp
([]
  (Core/useIPP ))
)

(defn set-use-ipp
([boolean_0 ]
  (Core/setUseIPP boolean_0 ))
)

(defn get-ipp-version
([]
  (Core/getIppVersion ))
)

(defn use-ipp-not-exact
([]
  (Core/useIPP_NotExact ))
)

(defn set-use-ipp-not-exact
([boolean_0 ]
  (Core/setUseIPP_NotExact boolean_0 ))
)

(defn border-interpolate
([int_0 int_1 int_2 ]
  (Core/borderInterpolate int_0 int_1 int_2 ))
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

(defn scale-add
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/scaleAdd org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn add-weighted
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 ]
  (Core/addWeighted org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 int_6 ]
  (Core/addWeighted org_opencv_core_mat_0 double_1 org_opencv_core_mat_2 double_3 double_4 org_opencv_core_mat_5 int_6 ))
)

(defn convert-scale-abs
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
)

(defn convert-scale-abs!
([org_opencv_core_mat_0 double_2 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Core/convertScaleAbs org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
)

(defn convert-fp-16
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/convertFp16 org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-fp-16!
([org_opencv_core_mat_0 ]
  (Core/convertFp16 org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn lut
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/LUT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn sum-elems
([org_opencv_core_mat_0 ]
  (Core/sumElems org_opencv_core_mat_0 ))
)

(defn has-non-zero
([org_opencv_core_mat_0 ]
  (Core/hasNonZero org_opencv_core_mat_0 ))
)

(defn count-non-zero
([org_opencv_core_mat_0 ]
  (Core/countNonZero org_opencv_core_mat_0 ))
)

(defn find-non-zero
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/findNonZero org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn find-non-zero!
([org_opencv_core_mat_0 ]
  (Core/findNonZero org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn mean-std-dev
([org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 ]
  (Core/meanStdDev org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 ))
([org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 org_opencv_core_mat_3 ]
  (Core/meanStdDev org_opencv_core_mat_0 org_opencv_core_matofdouble_1 org_opencv_core_matofdouble_2 org_opencv_core_mat_3 ))
)

(defn norm
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ]
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/norm org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 int_1 ]
  (Core/norm org_opencv_core_mat_0 int_1 ))
([org_opencv_core_mat_0 ]
  (Core/norm org_opencv_core_mat_0 ))
)

(defn psnr
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn psnr!
([org_opencv_core_mat_0 double_2 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/PSNR org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn batch-distance
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 ))
)

(defn batch-distance!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 boolean_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 ]
  (Core/batchDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 int_5 int_6 org_opencv_core_mat_7 int_8 ) org_opencv_core_mat_0 )
)

(defn reduce-arg-min
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/reduceArgMin org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 boolean_3 ]
  (Core/reduceArgMin org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 boolean_3 ))
)

(defn reduce-arg-min!
([org_opencv_core_mat_0 int_2 ]
  (Core/reduceArgMin org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 boolean_3 ]
  (Core/reduceArgMin org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 boolean_3 ) org_opencv_core_mat_0 )
)

(defn reduce-arg-max
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 boolean_3 ]
  (Core/reduceArgMax org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 boolean_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/reduceArgMax org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn reduce-arg-max!
([org_opencv_core_mat_0 int_2 boolean_3 ]
  (Core/reduceArgMax org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 boolean_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/reduceArgMax org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn mix-channels
([java_util_list_0 java_util_list_1 org_opencv_core_matofint_2 ]
  (Core/mixChannels java_util_list_0 java_util_list_1 org_opencv_core_matofint_2 ))
)

(defn extract-channel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/extractChannel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn extract-channel!
([org_opencv_core_mat_0 int_2 ]
  (Core/extractChannel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn insert-channel
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/insertChannel org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn insert-channel!
([org_opencv_core_mat_0 int_2 ]
  (Core/insertChannel org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn flip-nd
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/flipND org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn flip-nd!
([org_opencv_core_mat_0 int_2 ]
  (Core/flipND org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn hconcat
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/hconcat java_util_list_0 org_opencv_core_mat_1 ))
)

(defn vconcat
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/vconcat java_util_list_0 org_opencv_core_mat_1 ))
)

(defn bitwise-and
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn bitwise-and!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_and org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
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
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn bitwise-xor!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/bitwise_xor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
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

(defn absdiff
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/absdiff org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn absdiff!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/absdiff org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn polar-to-cart
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ))
)

(defn polar-to-cart!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/polarToCart org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ) org_opencv_core_mat_0 )
)

(defn cart-to-polar
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn cart-to-polar!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 boolean_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/cartToPolar org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn patch-na-ns
([org_opencv_core_mat_0 double_1 ]
  (Core/patchNaNs org_opencv_core_mat_0 double_1 ))
([org_opencv_core_mat_0 ]
  (Core/patchNaNs org_opencv_core_mat_0 ))
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

(defn mul-transposed
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 int_5 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_1 boolean_2 org_opencv_core_mat_3 double_4 int_5 ))
)

(defn mul-transposed!
([org_opencv_core_mat_0 boolean_2 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 int_5 ]
  (Core/mulTransposed org_opencv_core_mat_0 org_opencv_core_mat_0 boolean_2 org_opencv_core_mat_3 double_4 int_5 ) org_opencv_core_mat_0 )
)

(defn transpose
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/transpose org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn transpose!
([org_opencv_core_mat_0 ]
  (Core/transpose org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn transpose-nd
([org_opencv_core_mat_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 ]
  (Core/transposeND org_opencv_core_mat_0 org_opencv_core_matofint_1 org_opencv_core_mat_2 ))
)

(defn perspective-transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/perspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn perspective-transform!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/perspectiveTransform org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn complete-symm
([org_opencv_core_mat_0 boolean_1 ]
  (Core/completeSymm org_opencv_core_mat_0 boolean_1 ))
([org_opencv_core_mat_0 ]
  (Core/completeSymm org_opencv_core_mat_0 ))
)

(defn set-identity
([org_opencv_core_mat_0 ]
  (Core/setIdentity org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 ]
  (Core/setIdentity org_opencv_core_mat_0 org_opencv_core_scalar_1 ))
)

(defn determinant
([org_opencv_core_mat_0 ]
  (Core/determinant org_opencv_core_mat_0 ))
)

(defn invert
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn invert!
([org_opencv_core_mat_0 int_2 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/invert org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn solve
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn solve!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/solve org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn sort-idx
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/sortIdx org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn sort-idx!
([org_opencv_core_mat_0 int_2 ]
  (Core/sortIdx org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn solve-cubic
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/solveCubic org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn solve-cubic!
([org_opencv_core_mat_0 ]
  (Core/solveCubic org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn solve-poly
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn solve-poly!
([org_opencv_core_mat_0 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/solvePoly org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn eigen
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn eigen!
([org_opencv_core_mat_0 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/eigen org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn eigen-non-symmetric
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/eigenNonSymmetric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn eigen-non-symmetric!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/eigenNonSymmetric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
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

(defn pca-compute-2
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCACompute2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/PCACompute2 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn pca-compute-2!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCACompute2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/PCACompute2 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ) org_opencv_core_mat_0 )
)

(defn pca-project
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCAProject org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn pca-project!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCAProject org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn pca-back-project
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCABackProject org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn pca-back-project!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/PCABackProject org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
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

(defn sv-back-subst
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Core/SVBackSubst org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn sv-back-subst!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Core/SVBackSubst org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn mahalanobis
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/Mahalanobis org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn mahalanobis!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/Mahalanobis org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn dft
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn dft!
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/dft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn idft
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn idft!
([org_opencv_core_mat_0 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/idft org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
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

(defn idct
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn idct!
([org_opencv_core_mat_0 int_2 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/idct org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
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

(defn get-optimal-dft-size
([int_0 ]
  (Core/getOptimalDFTSize int_0 ))
)

(defn set-rng-seed
([int_0 ]
  (Core/setRNGSeed int_0 ))
)

(defn randu
([org_opencv_core_mat_0 double_1 double_2 ]
  (Core/randu org_opencv_core_mat_0 double_1 double_2 ))
)

(defn randn
([org_opencv_core_mat_0 double_1 double_2 ]
  (Core/randn org_opencv_core_mat_0 double_1 double_2 ))
)

(defn rand-shuffle
([org_opencv_core_mat_0 ]
  (Core/randShuffle org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 double_1 ]
  (Core/randShuffle org_opencv_core_mat_0 double_1 ))
)

(defn kmeans
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/kmeans org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 ]
  (Core/kmeans org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_termcriteria_3 int_4 int_5 ))
)

(defn set-num-threads
([int_0 ]
  (Core/setNumThreads int_0 ))
)

(defn get-num-threads
([]
  (Core/getNumThreads ))
)

(defn get-thread-num
([]
  (Core/getThreadNum ))
)

(defn get-build-information
([]
  (Core/getBuildInformation ))
)

(defn get-version-string
([]
  (Core/getVersionString ))
)

(defn get-version-major
([]
  (Core/getVersionMajor ))
)

(defn get-version-minor
([]
  (Core/getVersionMinor ))
)

(defn get-version-revision
([]
  (Core/getVersionRevision ))
)

(defn get-tick-count
([]
  (Core/getTickCount ))
)

(defn get-tick-frequency
([]
  (Core/getTickFrequency ))
)

(defn get-cpu-tick-count
([]
  (Core/getCPUTickCount ))
)

(defn check-hardware-support
([int_0 ]
  (Core/checkHardwareSupport int_0 ))
)

(defn get-hardware-feature-name
([int_0 ]
  (Core/getHardwareFeatureName int_0 ))
)

(defn get-cpu-features-line
([]
  (Core/getCPUFeaturesLine ))
)

(defn get-number-of-cp-us
([]
  (Core/getNumberOfCPUs ))
)

(defn get-default-algorithm-hint
([]
  (Core/getDefaultAlgorithmHint ))
)

(defn set-use-optimized
([boolean_0 ]
  (Core/setUseOptimized boolean_0 ))
)

(defn use-optimized
([]
  (Core/useOptimized ))
)

(defn find-file
([java_lang_string_0 ]
  (Core/findFile java_lang_string_0 ))
([java_lang_string_0 boolean_1 ]
  (Core/findFile java_lang_string_0 boolean_1 ))
([java_lang_string_0 boolean_1 boolean_2 ]
  (Core/findFile java_lang_string_0 boolean_1 boolean_2 ))
)

(defn find-file-or-keep
([java_lang_string_0 ]
  (Core/findFileOrKeep java_lang_string_0 ))
([java_lang_string_0 boolean_1 ]
  (Core/findFileOrKeep java_lang_string_0 boolean_1 ))
)

(defn add-samples-data-search-path
([java_lang_string_0 ]
  (Core/addSamplesDataSearchPath java_lang_string_0 ))
)

(defn add-samples-data-search-sub-directory
([java_lang_string_0 ]
  (Core/addSamplesDataSearchSubDirectory java_lang_string_0 ))
)

(defn set-error-verbosity
([boolean_0 ]
  (Core/setErrorVerbosity boolean_0 ))
)

(defn min-max-loc
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/minMaxLoc org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 ]
  (Core/minMaxLoc org_opencv_core_mat_0 ))
)

(defn min-max-loc!
([org_opencv_core_mat_0 ]
  (Core/minMaxLoc org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
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
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/max org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn max!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/max org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn sort
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/sort org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn sort!
([org_opencv_core_mat_0 int_2 ]
  (Core/sort org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn compare
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Core/compare org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
)

(defn compare!
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Core/compare org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
)

(defn split
([org_opencv_core_mat_0 java_util_list_1 ]
  (Core/split org_opencv_core_mat_0 java_util_list_1 ))
)

(defn add
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/add org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn repeat
([org_opencv_core_mat_0 int_1 int_2 org_opencv_core_mat_3 ]
  (Core/repeat org_opencv_core_mat_0 int_1 int_2 org_opencv_core_mat_3 ))
)

(defn transform
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/transform org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn transform!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/transform org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn merge
([java_util_list_0 org_opencv_core_mat_1 ]
  (Core/merge java_util_list_0 org_opencv_core_mat_1 ))
)

(defn trace
([org_opencv_core_mat_0 ]
  (Core/trace org_opencv_core_mat_0 ))
)

(defn reduce
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 int_3 ))
)

(defn reduce!
([org_opencv_core_mat_0 int_2 int_3 int_4 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 int_3 ]
  (Core/reduce org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 int_3 ) org_opencv_core_mat_0 )
)

(defn flip
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/flip org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn flip!
([org_opencv_core_mat_0 int_2 ]
  (Core/flip org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn in-range
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_3 ]
  (Core/inRange org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_scalar_2 org_opencv_core_mat_3 ))
)

(defn multiply
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ]
  (Core/multiply org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ))
)

(defn magnitude
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/magnitude org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn magnitude!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/magnitude org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn rotate
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Core/rotate org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
)

(defn rotate!
([org_opencv_core_mat_0 int_2 ]
  (Core/rotate org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
)

(defn normalize
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn normalize!
([org_opencv_core_mat_0 double_2 double_3 int_4 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 int_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 int_4 int_5 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 double_3 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Core/normalize org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn check-range
([org_opencv_core_mat_0 ]
  (Core/checkRange org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 boolean_1 double_2 ]
  (Core/checkRange org_opencv_core_mat_0 boolean_1 double_2 ))
([org_opencv_core_mat_0 boolean_1 ]
  (Core/checkRange org_opencv_core_mat_0 boolean_1 ))
([org_opencv_core_mat_0 boolean_1 double_2 double_3 ]
  (Core/checkRange org_opencv_core_mat_0 boolean_1 double_2 double_3 ))
)

(defn subtract
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ]
  (Core/subtract org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 org_opencv_core_mat_3 int_4 ))
)

(defn divide
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 double_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ]
  (Core/divide org_opencv_core_mat_0 org_opencv_core_scalar_1 org_opencv_core_mat_2 ))
)

(defn broadcast
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Core/broadcast org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn broadcast!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Core/broadcast org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
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

(defn mean
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Core/mean org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 ]
  (Core/mean org_opencv_core_mat_0 ))
)

;;; CvType 
(def CV_8U CvType/CV_8U)
(def CV_8S CvType/CV_8S)
(def CV_16U CvType/CV_16U)
(def CV_16S CvType/CV_16S)
(def CV_32S CvType/CV_32S)
(def CV_32F CvType/CV_32F)
(def CV_64F CvType/CV_64F)
(def CV_16F CvType/CV_16F)
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
(def CV_16FC1 CvType/CV_16FC1)
(def CV_16FC2 CvType/CV_16FC2)
(def CV_16FC3 CvType/CV_16FC3)
(def CV_16FC4 CvType/CV_16FC4)
;;; Photo
(defn inpaint
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ]
  (Photo/inpaint org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 double_3 int_4 ))
)

(defn inpaint!
([org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ]
  (Photo/inpaint org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 double_3 int_4 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_matoffloat_2 ))
)

(defn fast-nl-means-denoising!
([org_opencv_core_mat_0 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 int_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_matoffloat_2 ]
  (Photo/fastNlMeansDenoising org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_matoffloat_2 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising-colored
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 int_4 int_5 ))
)

(defn fast-nl-means-denoising-colored!
([org_opencv_core_mat_0 float_2 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 int_4 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 int_4 int_5 ]
  (Photo/fastNlMeansDenoisingColored org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 int_4 int_5 ) org_opencv_core_mat_0 )
)

(defn fast-nl-means-denoising-multi
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 int_7 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 int_7 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 int_6 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 ]
  (Photo/fastNlMeansDenoisingMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 org_opencv_core_matoffloat_4 int_5 ))
)

(defn fast-nl-means-denoising-colored-multi
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 ))
([java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 int_7 ]
  (Photo/fastNlMeansDenoisingColoredMulti java_util_list_0 org_opencv_core_mat_1 int_2 int_3 float_4 float_5 int_6 int_7 ))
)

(defn denoise-tvl-1
([java_util_list_0 org_opencv_core_mat_1 double_2 ]
  (Photo/denoise_TVL1 java_util_list_0 org_opencv_core_mat_1 double_2 ))
([java_util_list_0 org_opencv_core_mat_1 ]
  (Photo/denoise_TVL1 java_util_list_0 org_opencv_core_mat_1 ))
([java_util_list_0 org_opencv_core_mat_1 double_2 int_3 ]
  (Photo/denoise_TVL1 java_util_list_0 org_opencv_core_mat_1 double_2 int_3 ))
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
([float_0 ]
  (Photo/createTonemapDrago float_0 ))
([float_0 float_1 ]
  (Photo/createTonemapDrago float_0 float_1 ))
([float_0 float_1 float_2 ]
  (Photo/createTonemapDrago float_0 float_1 float_2 ))
)

(defn create-tonemap-reinhard
([float_0 float_1 float_2 ]
  (Photo/createTonemapReinhard float_0 float_1 float_2 ))
([float_0 float_1 ]
  (Photo/createTonemapReinhard float_0 float_1 ))
([float_0 ]
  (Photo/createTonemapReinhard float_0 ))
([float_0 float_1 float_2 float_3 ]
  (Photo/createTonemapReinhard float_0 float_1 float_2 float_3 ))
([]
  (Photo/createTonemapReinhard ))
)

(defn create-tonemap-mantiuk
([float_0 float_1 ]
  (Photo/createTonemapMantiuk float_0 float_1 ))
([]
  (Photo/createTonemapMantiuk ))
([float_0 ]
  (Photo/createTonemapMantiuk float_0 ))
([float_0 float_1 float_2 ]
  (Photo/createTonemapMantiuk float_0 float_1 float_2 ))
)

(defn create-align-mtb
([int_0 int_1 ]
  (Photo/createAlignMTB int_0 int_1 ))
([int_0 ]
  (Photo/createAlignMTB int_0 ))
([]
  (Photo/createAlignMTB ))
([int_0 int_1 boolean_2 ]
  (Photo/createAlignMTB int_0 int_1 boolean_2 ))
)

(defn create-calibrate-debevec
([int_0 float_1 ]
  (Photo/createCalibrateDebevec int_0 float_1 ))
([int_0 ]
  (Photo/createCalibrateDebevec int_0 ))
([]
  (Photo/createCalibrateDebevec ))
([int_0 float_1 boolean_2 ]
  (Photo/createCalibrateDebevec int_0 float_1 boolean_2 ))
)

(defn create-calibrate-robertson
([]
  (Photo/createCalibrateRobertson ))
([int_0 ]
  (Photo/createCalibrateRobertson int_0 ))
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
([float_0 ]
  (Photo/createMergeMertens float_0 ))
([float_0 float_1 ]
  (Photo/createMergeMertens float_0 float_1 ))
([float_0 float_1 float_2 ]
  (Photo/createMergeMertens float_0 float_1 float_2 ))
)

(defn create-merge-robertson
([]
  (Photo/createMergeRobertson ))
)

(defn decolor
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/decolor org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn decolor!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/decolor org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn seamless-clone
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ]
  (Photo/seamlessClone org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ))
)

(defn seamless-clone!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ]
  (Photo/seamlessClone org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_point_3 org_opencv_core_mat_4 int_5 ) org_opencv_core_mat_0 )
)

(defn color-change
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ))
)

(defn color-change!
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/colorChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ) org_opencv_core_mat_0 )
)

(defn illumination-change
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ))
)

(defn illumination-change!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/illuminationChange org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ) org_opencv_core_mat_0 )
)

(defn texture-flattening
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 int_5 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 int_5 ))
)

(defn texture-flattening!
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 int_5 ]
  (Photo/textureFlattening org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 int_5 ) org_opencv_core_mat_0 )
)

(defn edge-preserving-filter
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 float_4 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_1 int_2 float_3 float_4 ))
)

(defn edge-preserving-filter!
([org_opencv_core_mat_0 int_2 float_3 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 int_2 float_3 float_4 ]
  (Photo/edgePreservingFilter org_opencv_core_mat_0 org_opencv_core_mat_0 int_2 float_3 float_4 ) org_opencv_core_mat_0 )
)

(defn detail-enhance
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ))
)

(defn detail-enhance!
([org_opencv_core_mat_0 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 float_3 ]
  (Photo/detailEnhance org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 ) org_opencv_core_mat_0 )
)

(defn pencil-sketch
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 float_3 float_4 float_5 ))
)

(defn pencil-sketch!
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ]
  (Photo/pencilSketch org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 float_3 float_4 float_5 ) org_opencv_core_mat_0 )
)

(defn stylization
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_1 float_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn stylization!
([org_opencv_core_mat_0 float_2 float_3 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 float_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 float_2 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_0 float_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Photo/stylization org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

;;; Calib3d
(defn init-undistort-rectify-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn init-undistort-rectify-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
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

(defn find-homography
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_calib3d_usacparams_3 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_calib3d_usacparams_3 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 double_6 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 double_6 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 int_5 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 ]
  (Calib3d/findHomography org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 org_opencv_core_mat_4 ))
)

(defn rq-decomp-3x-3
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn rq-decomp-3x-3!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/RQDecomp3x3 org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn decompose-projection-matrix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn decompose-projection-matrix!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/decomposeProjectionMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn mat-mul-deriv
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/matMulDeriv org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn mat-mul-deriv!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/matMulDeriv org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn compose-rt
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ))
)

(defn compose-rt!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 org_opencv_core_mat_13 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/composeRT org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ) org_opencv_core_mat_0 )
)

(defn project-points
([org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 ]
  (Calib3d/projectPoints org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 ]
  (Calib3d/projectPoints org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 double_7 ]
  (Calib3d/projectPoints org_opencv_core_matofpoint3f_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_matofdouble_4 org_opencv_core_matofpoint2f_5 org_opencv_core_mat_6 double_7 ))
)

(defn solve-pn-p
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnP org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/solvePnP org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/solvePnP org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ))
)

(defn solve-pn-p-ransac
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ))
([org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ]
  (Calib3d/solvePnPRansac org_opencv_core_matofpoint3f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_matofdouble_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ))
)

(defn solve-p-3-p
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ]
  (Calib3d/solveP3P org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ))
)

(defn solve-p-3-p!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ]
  (Calib3d/solveP3P org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 int_6 ) org_opencv_core_mat_0 )
)

(defn solve-pn-p-refine-lm
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/solvePnPRefineLM org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRefineLM org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn solve-pn-p-refine-lm!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/solvePnPRefineLM org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRefineLM org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
)

(defn solve-pn-p-refine-vvs
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 double_7 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 double_7 ))
)

(defn solve-pn-p-refine-vvs!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 double_7 ]
  (Calib3d/solvePnPRefineVVS org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 double_7 ) org_opencv_core_mat_0 )
)

(defn solve-pn-p-generic
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 ))
)

(defn solve-pn-p-generic!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 ]
  (Calib3d/solvePnPGeneric org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 java_util_list_4 java_util_list_5 boolean_6 int_7 org_opencv_core_mat_8 ) org_opencv_core_mat_0 )
)

(defn init-camera-matrix-2-d
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 ]
  (Calib3d/initCameraMatrix2D java_util_list_0 java_util_list_1 org_opencv_core_size_2 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 double_3 ]
  (Calib3d/initCameraMatrix2D java_util_list_0 java_util_list_1 org_opencv_core_size_2 double_3 ))
)

(defn find-chessboard-corners
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 ]
  (Calib3d/findChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 int_3 ]
  (Calib3d/findChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 int_3 ))
)

(defn check-chessboard
([org_opencv_core_mat_0 org_opencv_core_size_1 ]
  (Calib3d/checkChessboard org_opencv_core_mat_0 org_opencv_core_size_1 ))
)

(defn find-chessboard-corners-sb-with-meta
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ]
  (Calib3d/findChessboardCornersSBWithMeta org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 org_opencv_core_mat_4 ))
)

(defn find-chessboard-corners-sb
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ]
  (Calib3d/findChessboardCornersSB org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/findChessboardCornersSB org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ))
)

(defn estimate-chessboard-sharpness
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 ]
  (Calib3d/estimateChessboardSharpness org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ]
  (Calib3d/estimateChessboardSharpness org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 boolean_4 ]
  (Calib3d/estimateChessboardSharpness org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 boolean_4 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 boolean_4 org_opencv_core_mat_5 ]
  (Calib3d/estimateChessboardSharpness org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 float_3 boolean_4 org_opencv_core_mat_5 ))
)

(defn find-4-quad-corner-subpix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ]
  (Calib3d/find4QuadCornerSubpix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 ))
)

(defn find-4-quad-corner-subpix!
([org_opencv_core_mat_0 org_opencv_core_size_2 ]
  (Calib3d/find4QuadCornerSubpix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 ) org_opencv_core_mat_0 )
)

(defn draw-chessboard-corners
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 boolean_3 ]
  (Calib3d/drawChessboardCorners org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_matofpoint2f_2 boolean_3 ))
)

(defn draw-frame-axes
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 ]
  (Calib3d/drawFrameAxes org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 int_6 ]
  (Calib3d/drawFrameAxes org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 int_6 ))
)

(defn draw-frame-axes!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 ]
  (Calib3d/drawFrameAxes org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 int_6 ]
  (Calib3d/drawFrameAxes org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 float_5 int_6 ) org_opencv_core_mat_0 )
)

(defn find-circles-grid
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/findCirclesGrid org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ]
  (Calib3d/findCirclesGrid org_opencv_core_mat_0 org_opencv_core_size_1 org_opencv_core_mat_2 ))
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
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/calibrateCamera java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ))
)

(defn calibrate-camera-ro-extended
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ]
  (Calib3d/calibrateCameraROExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 ]
  (Calib3d/calibrateCameraROExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 org_opencv_core_termcriteria_14 ]
  (Calib3d/calibrateCameraROExtended java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 org_opencv_core_termcriteria_14 ))
)

(defn calibrate-camera-ro
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 ]
  (Calib3d/calibrateCameraRO java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 int_9 org_opencv_core_termcriteria_10 ]
  (Calib3d/calibrateCameraRO java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 int_9 org_opencv_core_termcriteria_10 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 int_9 ]
  (Calib3d/calibrateCameraRO java_util_list_0 java_util_list_1 org_opencv_core_size_2 int_3 org_opencv_core_mat_4 org_opencv_core_mat_5 java_util_list_6 java_util_list_7 org_opencv_core_mat_8 int_9 ))
)

(defn calibration-matrix-values
([org_opencv_core_mat_0 org_opencv_core_size_1 double_2 double_3 array_d_4 array_d_5 array_d_6 org_opencv_core_point_7 array_d_8 ]
  (Calib3d/calibrationMatrixValues org_opencv_core_mat_0 org_opencv_core_size_1 double_2 double_3 array_d_4 array_d_5 array_d_6 org_opencv_core_point_7 array_d_8 ))
)

(defn stereo-calibrate-extended
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 ]
  (Calib3d/stereoCalibrateExtended java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 int_15 ]
  (Calib3d/stereoCalibrateExtended java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 int_15 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 int_15 org_opencv_core_termcriteria_16 ]
  (Calib3d/stereoCalibrateExtended java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 java_util_list_12 java_util_list_13 org_opencv_core_mat_14 int_15 org_opencv_core_termcriteria_16 ))
)

(defn stereo-calibrate
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 org_opencv_core_termcriteria_14 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 int_13 org_opencv_core_termcriteria_14 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 org_opencv_core_mat_12 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ))
)

(defn stereo-rectify
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 ))
)

(defn stereo-rectify!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 org_opencv_core_rect_16 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 org_opencv_core_rect_15 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 ]
  (Calib3d/stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 double_13 org_opencv_core_size_14 ) org_opencv_core_mat_0 )
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

(defn get-optimal-new-camera-matrix
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ))
)

(defn get-optimal-new-camera-matrix!
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ]
  (Calib3d/getOptimalNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 double_3 org_opencv_core_size_4 org_opencv_core_rect_5 boolean_6 ) org_opencv_core_mat_0 )
)

(defn calibrate-hand-eye
([java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/calibrateHandEye java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ]
  (Calib3d/calibrateHandEye java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ))
)

(defn calibrate-robot-world-hand-eye
([java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 int_8 ]
  (Calib3d/calibrateRobotWorldHandEye java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 int_8 ))
([java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/calibrateRobotWorldHandEye java_util_list_0 java_util_list_1 java_util_list_2 java_util_list_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn convert-points-to-homogeneous
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/convertPointsToHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-points-to-homogeneous!
([org_opencv_core_mat_0 ]
  (Calib3d/convertPointsToHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn convert-points-from-homogeneous
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/convertPointsFromHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_1 ))
)

(defn convert-points-from-homogeneous!
([org_opencv_core_mat_0 ]
  (Calib3d/convertPointsFromHomogeneous org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
)

(defn find-fundamental-mat
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 int_5 org_opencv_core_mat_6 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 int_5 org_opencv_core_mat_6 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 int_5 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 int_5 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 ]
  (Calib3d/findFundamentalMat org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 int_2 double_3 double_4 ))
)

(defn find-essential-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 org_opencv_core_mat_9 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 org_opencv_core_mat_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 double_2 org_opencv_core_point_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 ))
)

(defn find-essential-mat!
([org_opencv_core_mat_0 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 org_opencv_core_mat_9 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 org_opencv_core_mat_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_point_3 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_point_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 double_2 org_opencv_core_point_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_calib3d_usacparams_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 ]
  (Calib3d/findEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 int_6 double_7 double_8 ) org_opencv_core_mat_0 )
)

(defn decompose-essential-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn decompose-essential-mat!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/decomposeEssentialMat org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn recover-pose
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 org_opencv_core_mat_12 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 org_opencv_core_mat_12 ))
)

(defn recover-pose!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_point_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 org_opencv_core_mat_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 org_opencv_core_mat_12 ]
  (Calib3d/recoverPose org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 int_9 double_10 double_11 org_opencv_core_mat_12 ) org_opencv_core_mat_0 )
)

(defn compute-correspond-epilines
([org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/computeCorrespondEpilines org_opencv_core_mat_0 int_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn triangulate-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/triangulatePoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn triangulate-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/triangulatePoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn correct-matches
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/correctMatches org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn correct-matches!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/correctMatches org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn filter-speckles
([org_opencv_core_mat_0 double_1 int_2 double_3 ]
  (Calib3d/filterSpeckles org_opencv_core_mat_0 double_1 int_2 double_3 ))
([org_opencv_core_mat_0 double_1 int_2 double_3 org_opencv_core_mat_4 ]
  (Calib3d/filterSpeckles org_opencv_core_mat_0 double_1 int_2 double_3 org_opencv_core_mat_4 ))
)

(defn get-valid-disparity-roi
([org_opencv_core_rect_0 org_opencv_core_rect_1 int_2 int_3 int_4 ]
  (Calib3d/getValidDisparityROI org_opencv_core_rect_0 org_opencv_core_rect_1 int_2 int_3 int_4 ))
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

(defn reproject-image-to-3-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 int_4 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 int_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 boolean_3 ))
)

(defn reproject-image-to-3-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 int_4 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 int_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ]
  (Calib3d/reprojectImageTo3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 boolean_3 ) org_opencv_core_mat_0 )
)

(defn sampson-distance
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/sampsonDistance org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
)

(defn sampson-distance!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/sampsonDistance org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-3-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 array_d_2 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 array_d_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 array_d_2 boolean_3 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 array_d_2 boolean_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ))
)

(defn estimate-affine-3-d!
([org_opencv_core_mat_0 array_d_2 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 array_d_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 array_d_2 boolean_3 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 array_d_2 boolean_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/estimateAffine3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ) org_opencv_core_mat_0 )
)

(defn estimate-translation-3-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ))
)

(defn estimate-translation-3-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ]
  (Calib3d/estimateTranslation3D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 double_4 double_5 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ))
)

(defn estimate-affine-2-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateAffine2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ) org_opencv_core_mat_0 )
)

(defn estimate-affine-partial-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ))
)

(defn estimate-affine-partial-2-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateAffinePartial2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ) org_opencv_core_mat_0 )
)

(defn estimate-translation-2-d
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 long_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 int_3 double_4 ))
)

(defn estimate-translation-2-d!
([org_opencv_core_mat_0 org_opencv_core_mat_2 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 long_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 long_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ]
  (Calib3d/estimateTranslation2D org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 int_3 double_4 ) org_opencv_core_mat_0 )
)

(defn decompose-homography-mat
([org_opencv_core_mat_0 org_opencv_core_mat_1 java_util_list_2 java_util_list_3 java_util_list_4 ]
  (Calib3d/decomposeHomographyMat org_opencv_core_mat_0 org_opencv_core_mat_1 java_util_list_2 java_util_list_3 java_util_list_4 ))
)

(defn decompose-homography-mat!
([org_opencv_core_mat_0 java_util_list_2 java_util_list_3 java_util_list_4 ]
  (Calib3d/decomposeHomographyMat org_opencv_core_mat_0 org_opencv_core_mat_0 java_util_list_2 java_util_list_3 java_util_list_4 ) org_opencv_core_mat_0 )
)

(defn filter-homography-decomp-by-visible-refpoints
([java_util_list_0 java_util_list_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/filterHomographyDecompByVisibleRefpoints java_util_list_0 java_util_list_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([java_util_list_0 java_util_list_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/filterHomographyDecompByVisibleRefpoints java_util_list_0 java_util_list_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn undistort
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistort org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/undistort org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
)

(defn undistort!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistort org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/undistort org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
)

(defn init-inverse-rectification-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initInverseRectificationMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn init-inverse-rectification-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/initInverseRectificationMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn get-default-new-camera-matrix
([org_opencv_core_mat_0 org_opencv_core_size_1 ]
  (Calib3d/getDefaultNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_size_1 ))
([org_opencv_core_mat_0 ]
  (Calib3d/getDefaultNewCameraMatrix org_opencv_core_mat_0 ))
([org_opencv_core_mat_0 org_opencv_core_size_1 boolean_2 ]
  (Calib3d/getDefaultNewCameraMatrix org_opencv_core_mat_0 org_opencv_core_size_1 boolean_2 ))
)

(defn undistort-points
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortPoints org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/undistortPoints org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/undistortPoints org_opencv_core_matofpoint2f_0 org_opencv_core_matofpoint2f_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
)

(defn undistort-points-iter
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/undistortPointsIter org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ))
)

(defn undistort-points-iter!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/undistortPointsIter org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ) org_opencv_core_mat_0 )
)

(defn undistort-image-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortImagePoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_termcriteria_4 ]
  (Calib3d/undistortImagePoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_termcriteria_4 ))
)

(defn undistort-image-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/undistortImagePoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_termcriteria_4 ]
  (Calib3d/undistortImagePoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_termcriteria_4 ) org_opencv_core_mat_0 )
)

(defn fisheye-project-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 ))
)

(defn fisheye-project-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 ]
  (Calib3d/fisheye_projectPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 double_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn fisheye-distort-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
)

(defn fisheye-distort-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_distortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
)

(defn fisheye-undistort-points
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ))
)

(defn fisheye-undistort-points!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ]
  (Calib3d/fisheye_undistortPoints org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_termcriteria_6 ) org_opencv_core_mat_0 )
)

(defn fisheye-init-undistort-rectify-map
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/fisheye_initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ))
)

(defn fisheye-init-undistort-rectify-map!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ]
  (Calib3d/fisheye_initUndistortRectifyMap org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 int_5 org_opencv_core_mat_6 org_opencv_core_mat_7 ) org_opencv_core_mat_0 )
)

(defn fisheye-undistort-image
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ))
)

(defn fisheye-undistort-image!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ]
  (Calib3d/fisheye_undistortImage org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_size_5 ) org_opencv_core_mat_0 )
)

(defn fisheye-estimate-new-camera-matrix-for-undistort-rectify
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ))
)

(defn fisheye-estimate-new-camera-matrix-for-undistort-rectify!
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ]
  (Calib3d/fisheye_estimateNewCameraMatrixForUndistortRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 double_5 org_opencv_core_size_6 double_7 ) org_opencv_core_mat_0 )
)

(defn fisheye-calibrate
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ]
  (Calib3d/fisheye_calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ]
  (Calib3d/fisheye_calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 ))
([java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/fisheye_calibrate java_util_list_0 java_util_list_1 org_opencv_core_size_2 org_opencv_core_mat_3 org_opencv_core_mat_4 java_util_list_5 java_util_list_6 int_7 org_opencv_core_termcriteria_8 ))
)

(defn fisheye-stereo-rectify
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ))
)

(defn fisheye-stereo-rectify!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ]
  (Calib3d/fisheye_stereoRectify org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_size_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_mat_7 org_opencv_core_mat_8 org_opencv_core_mat_9 org_opencv_core_mat_10 org_opencv_core_mat_11 int_12 org_opencv_core_size_13 double_14 double_15 ) org_opencv_core_mat_0 )
)

(defn fisheye-stereo-calibrate
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ]
  (Calib3d/fisheye_stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ]
  (Calib3d/fisheye_stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 int_10 org_opencv_core_termcriteria_11 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ]
  (Calib3d/fisheye_stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 java_util_list_10 java_util_list_11 int_12 org_opencv_core_termcriteria_13 ]
  (Calib3d/fisheye_stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 java_util_list_10 java_util_list_11 int_12 org_opencv_core_termcriteria_13 ))
([java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 java_util_list_10 java_util_list_11 int_12 ]
  (Calib3d/fisheye_stereoCalibrate java_util_list_0 java_util_list_1 java_util_list_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 org_opencv_core_mat_6 org_opencv_core_size_7 org_opencv_core_mat_8 org_opencv_core_mat_9 java_util_list_10 java_util_list_11 int_12 ))
)

(defn fisheye-solve-pn-p
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 org_opencv_core_termcriteria_8 ))
)

(defn fisheye-solve-pn-p!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 org_opencv_core_termcriteria_8 ]
  (Calib3d/fisheye_solvePnP org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 org_opencv_core_termcriteria_8 ) org_opencv_core_mat_0 )
)

(defn fisheye-solve-pn-p-ransac
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 org_opencv_core_termcriteria_12 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 org_opencv_core_termcriteria_12 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ))
([org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_1 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ))
)

(defn fisheye-solve-pn-p-ransac!
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 org_opencv_core_termcriteria_12 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 org_opencv_core_termcriteria_12 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 int_11 ) org_opencv_core_mat_0 )
([org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ]
  (Calib3d/fisheye_solvePnPRansac org_opencv_core_mat_0 org_opencv_core_mat_0 org_opencv_core_mat_2 org_opencv_core_mat_3 org_opencv_core_mat_4 org_opencv_core_mat_5 boolean_6 int_7 float_8 double_9 org_opencv_core_mat_10 ) org_opencv_core_mat_0 )
)

(def CV_ITERATIVE Calib3d/CV_ITERATIVE)
(def CV_EPNP Calib3d/CV_EPNP)
(def CV_P3P Calib3d/CV_P3P)
(def CV_DLS Calib3d/CV_DLS)
(def CvLevMarq_DONE Calib3d/CvLevMarq_DONE)
(def CvLevMarq_STARTED Calib3d/CvLevMarq_STARTED)
(def CvLevMarq_CALC_J Calib3d/CvLevMarq_CALC_J)
(def CvLevMarq_CHECK_ERR Calib3d/CvLevMarq_CHECK_ERR)
(def LMEDS Calib3d/LMEDS)
(def RANSAC Calib3d/RANSAC)
(def RHO Calib3d/RHO)
(def USAC_DEFAULT Calib3d/USAC_DEFAULT)
(def USAC_PARALLEL Calib3d/USAC_PARALLEL)
(def USAC_FM_8PTS Calib3d/USAC_FM_8PTS)
(def USAC_FAST Calib3d/USAC_FAST)
(def USAC_ACCURATE Calib3d/USAC_ACCURATE)
(def USAC_PROSAC Calib3d/USAC_PROSAC)
(def USAC_MAGSAC Calib3d/USAC_MAGSAC)
(def CALIB_CB_ADAPTIVE_THRESH Calib3d/CALIB_CB_ADAPTIVE_THRESH)
(def CALIB_CB_NORMALIZE_IMAGE Calib3d/CALIB_CB_NORMALIZE_IMAGE)
(def CALIB_CB_FILTER_QUADS Calib3d/CALIB_CB_FILTER_QUADS)
(def CALIB_CB_FAST_CHECK Calib3d/CALIB_CB_FAST_CHECK)
(def CALIB_CB_EXHAUSTIVE Calib3d/CALIB_CB_EXHAUSTIVE)
(def CALIB_CB_ACCURACY Calib3d/CALIB_CB_ACCURACY)
(def CALIB_CB_LARGER Calib3d/CALIB_CB_LARGER)
(def CALIB_CB_MARKER Calib3d/CALIB_CB_MARKER)
(def CALIB_CB_PLAIN Calib3d/CALIB_CB_PLAIN)
(def CALIB_CB_SYMMETRIC_GRID Calib3d/CALIB_CB_SYMMETRIC_GRID)
(def CALIB_CB_ASYMMETRIC_GRID Calib3d/CALIB_CB_ASYMMETRIC_GRID)
(def CALIB_CB_CLUSTERING Calib3d/CALIB_CB_CLUSTERING)
(def CALIB_NINTRINSIC Calib3d/CALIB_NINTRINSIC)
(def CALIB_USE_INTRINSIC_GUESS Calib3d/CALIB_USE_INTRINSIC_GUESS)
(def CALIB_FIX_ASPECT_RATIO Calib3d/CALIB_FIX_ASPECT_RATIO)
(def CALIB_FIX_PRINCIPAL_POINT Calib3d/CALIB_FIX_PRINCIPAL_POINT)
(def CALIB_ZERO_TANGENT_DIST Calib3d/CALIB_ZERO_TANGENT_DIST)
(def CALIB_FIX_FOCAL_LENGTH Calib3d/CALIB_FIX_FOCAL_LENGTH)
(def CALIB_FIX_K1 Calib3d/CALIB_FIX_K1)
(def CALIB_FIX_K2 Calib3d/CALIB_FIX_K2)
(def CALIB_FIX_K3 Calib3d/CALIB_FIX_K3)
(def CALIB_FIX_K4 Calib3d/CALIB_FIX_K4)
(def CALIB_FIX_K5 Calib3d/CALIB_FIX_K5)
(def CALIB_FIX_K6 Calib3d/CALIB_FIX_K6)
(def CALIB_RATIONAL_MODEL Calib3d/CALIB_RATIONAL_MODEL)
(def CALIB_THIN_PRISM_MODEL Calib3d/CALIB_THIN_PRISM_MODEL)
(def CALIB_FIX_S1_S2_S3_S4 Calib3d/CALIB_FIX_S1_S2_S3_S4)
(def CALIB_TILTED_MODEL Calib3d/CALIB_TILTED_MODEL)
(def CALIB_FIX_TAUX_TAUY Calib3d/CALIB_FIX_TAUX_TAUY)
(def CALIB_USE_QR Calib3d/CALIB_USE_QR)
(def CALIB_FIX_TANGENT_DIST Calib3d/CALIB_FIX_TANGENT_DIST)
(def CALIB_FIX_INTRINSIC Calib3d/CALIB_FIX_INTRINSIC)
(def CALIB_SAME_FOCAL_LENGTH Calib3d/CALIB_SAME_FOCAL_LENGTH)
(def CALIB_ZERO_DISPARITY Calib3d/CALIB_ZERO_DISPARITY)
(def CALIB_USE_LU Calib3d/CALIB_USE_LU)
(def CALIB_USE_EXTRINSIC_GUESS Calib3d/CALIB_USE_EXTRINSIC_GUESS)
(def FM_7POINT Calib3d/FM_7POINT)
(def FM_8POINT Calib3d/FM_8POINT)
(def FM_LMEDS Calib3d/FM_LMEDS)
(def FM_RANSAC Calib3d/FM_RANSAC)
(def fisheye_CALIB_USE_INTRINSIC_GUESS Calib3d/fisheye_CALIB_USE_INTRINSIC_GUESS)
(def fisheye_CALIB_RECOMPUTE_EXTRINSIC Calib3d/fisheye_CALIB_RECOMPUTE_EXTRINSIC)
(def fisheye_CALIB_CHECK_COND Calib3d/fisheye_CALIB_CHECK_COND)
(def fisheye_CALIB_FIX_SKEW Calib3d/fisheye_CALIB_FIX_SKEW)
(def fisheye_CALIB_FIX_K1 Calib3d/fisheye_CALIB_FIX_K1)
(def fisheye_CALIB_FIX_K2 Calib3d/fisheye_CALIB_FIX_K2)
(def fisheye_CALIB_FIX_K3 Calib3d/fisheye_CALIB_FIX_K3)
(def fisheye_CALIB_FIX_K4 Calib3d/fisheye_CALIB_FIX_K4)
(def fisheye_CALIB_FIX_INTRINSIC Calib3d/fisheye_CALIB_FIX_INTRINSIC)
(def fisheye_CALIB_FIX_PRINCIPAL_POINT Calib3d/fisheye_CALIB_FIX_PRINCIPAL_POINT)
(def fisheye_CALIB_ZERO_DISPARITY Calib3d/fisheye_CALIB_ZERO_DISPARITY)
(def fisheye_CALIB_FIX_FOCAL_LENGTH Calib3d/fisheye_CALIB_FIX_FOCAL_LENGTH)
(def CirclesGridFinderParameters_SYMMETRIC_GRID Calib3d/CirclesGridFinderParameters_SYMMETRIC_GRID)
(def CirclesGridFinderParameters_ASYMMETRIC_GRID Calib3d/CirclesGridFinderParameters_ASYMMETRIC_GRID)
(def CALIB_HAND_EYE_TSAI Calib3d/CALIB_HAND_EYE_TSAI)
(def CALIB_HAND_EYE_PARK Calib3d/CALIB_HAND_EYE_PARK)
(def CALIB_HAND_EYE_HORAUD Calib3d/CALIB_HAND_EYE_HORAUD)
(def CALIB_HAND_EYE_ANDREFF Calib3d/CALIB_HAND_EYE_ANDREFF)
(def CALIB_HAND_EYE_DANIILIDIS Calib3d/CALIB_HAND_EYE_DANIILIDIS)
(def LOCAL_OPTIM_NULL Calib3d/LOCAL_OPTIM_NULL)
(def LOCAL_OPTIM_INNER_LO Calib3d/LOCAL_OPTIM_INNER_LO)
(def LOCAL_OPTIM_INNER_AND_ITER_LO Calib3d/LOCAL_OPTIM_INNER_AND_ITER_LO)
(def LOCAL_OPTIM_GC Calib3d/LOCAL_OPTIM_GC)
(def LOCAL_OPTIM_SIGMA Calib3d/LOCAL_OPTIM_SIGMA)
(def NEIGH_FLANN_KNN Calib3d/NEIGH_FLANN_KNN)
(def NEIGH_GRID Calib3d/NEIGH_GRID)
(def NEIGH_FLANN_RADIUS Calib3d/NEIGH_FLANN_RADIUS)
(def NONE_POLISHER Calib3d/NONE_POLISHER)
(def LSQ_POLISHER Calib3d/LSQ_POLISHER)
(def MAGSAC Calib3d/MAGSAC)
(def COV_POLISHER Calib3d/COV_POLISHER)
(def CALIB_ROBOT_WORLD_HAND_EYE_SHAH Calib3d/CALIB_ROBOT_WORLD_HAND_EYE_SHAH)
(def CALIB_ROBOT_WORLD_HAND_EYE_LI Calib3d/CALIB_ROBOT_WORLD_HAND_EYE_LI)
(def SAMPLING_UNIFORM Calib3d/SAMPLING_UNIFORM)
(def SAMPLING_PROGRESSIVE_NAPSAC Calib3d/SAMPLING_PROGRESSIVE_NAPSAC)
(def SAMPLING_NAPSAC Calib3d/SAMPLING_NAPSAC)
(def SAMPLING_PROSAC Calib3d/SAMPLING_PROSAC)
(def SCORE_METHOD_RANSAC Calib3d/SCORE_METHOD_RANSAC)
(def SCORE_METHOD_MSAC Calib3d/SCORE_METHOD_MSAC)
(def SCORE_METHOD_MAGSAC Calib3d/SCORE_METHOD_MAGSAC)
(def SCORE_METHOD_LMEDS Calib3d/SCORE_METHOD_LMEDS)
(def SOLVEPNP_ITERATIVE Calib3d/SOLVEPNP_ITERATIVE)
(def SOLVEPNP_EPNP Calib3d/SOLVEPNP_EPNP)
(def SOLVEPNP_P3P Calib3d/SOLVEPNP_P3P)
(def SOLVEPNP_DLS Calib3d/SOLVEPNP_DLS)
(def SOLVEPNP_UPNP Calib3d/SOLVEPNP_UPNP)
(def SOLVEPNP_AP3P Calib3d/SOLVEPNP_AP3P)
(def SOLVEPNP_IPPE Calib3d/SOLVEPNP_IPPE)
(def SOLVEPNP_IPPE_SQUARE Calib3d/SOLVEPNP_IPPE_SQUARE)
(def SOLVEPNP_SQPNP Calib3d/SOLVEPNP_SQPNP)
(def SOLVEPNP_MAX_COUNT Calib3d/SOLVEPNP_MAX_COUNT)
(def PROJ_SPHERICAL_ORTHO Calib3d/PROJ_SPHERICAL_ORTHO)
(def PROJ_SPHERICAL_EQRECT Calib3d/PROJ_SPHERICAL_EQRECT)
