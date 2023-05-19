(ns opencv4.video
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.set])
  (:import (java.io IOException PushbackReader)
           [org.opencv.videoio Videoio]
           (origami.video VideoCapture)))

(declare new-videocapture)
(declare debug-device)

(defn- key-to-prop-s [k]
    (let [ks (name k) prop (str "CAP_PROP_" (clojure.string/upper-case (clojure.string/replace ks  "-" "_")))]
    (str "org.opencv.videoio.Videoio/" prop)))

(defn- key-to-prop [k]
  (eval (read-string (key-to-prop-s k))))


(defn load-edn
  "Load edn from an io/reader source (filename or io/resource)."
  [source]
  (try
    (with-open [r (io/reader source)]
      (edn/read (PushbackReader. r)))
    (catch IOException e
      (printf "Couldn't open '%s': %s\n" source (.getMessage e)))
    (catch RuntimeException e
      (printf "Error parsing edn file '%s': %s\n" source (.getMessage e)))))

(defn capture-device [ video ]
  (let [capture (VideoCapture.)
        video-map (if (integer? video)
                    {}
                    (cond
                      (map? video) video
                      (map? (read-string video)) (read-string video)
                      (and (string? video) (clojure.string/ends-with? video ".edn")) (read-string (slurp video))
                      :else {}))
        device (if  (= video-map {}) video (-> video-map :device))
        debug? (dissoc video-map :debug)
        settings
         (keys
          (clojure.set/rename-keys (dissoc video-map :fn :debug :device) {:width :frame-width :height :frame-height } ) )  ]
        (doseq [s settings]
          (try (.set capture (key-to-prop s) (-> video-map s)) (catch Exception _)))
      (.open capture device)
      (if debug? (debug-device capture))
  capture))

(defn debug-device [capture]
(let[ cam-keys 
    (->> (ns-map 'opencv4.video)
    (keys)
    (map str)
    (filter #(clojure.string/includes? % "CAP_PROP_") )
    (map #(second (clojure.string/split % #"CAP_PROP_")))
    (map #(clojure.string/lower-case %))
    (map #(clojure.string/replace %  "_" "-"))
    (map keyword))] 
    (doseq [k cam-keys]
    (let [v (.get capture (key-to-prop k))]
      (if (and (not (= 0.0 v)) (not (= -1.0 v)))
      (println k  ":" v))))))
(defn new-videowriter 
([java_lang_string_0 int_1 double_2 org_opencv_core_size_3 ] 
  (new org.opencv.videoio.VideoWriter java_lang_string_0 int_1 double_2 org_opencv_core_size_3 ))
([java_lang_string_0 int_1 int_2 double_3 org_opencv_core_size_4 boolean_5 ] 
  (new org.opencv.videoio.VideoWriter java_lang_string_0 int_1 int_2 double_3 org_opencv_core_size_4 boolean_5 ))
([java_lang_string_0 int_1 int_2 double_3 org_opencv_core_size_4 ] 
  (new org.opencv.videoio.VideoWriter java_lang_string_0 int_1 int_2 double_3 org_opencv_core_size_4 ))
([] 
  (new org.opencv.videoio.VideoWriter )))
(defn new-videocapture 
([java_lang_string_0 ] 
  (new org.opencv.videoio.VideoCapture java_lang_string_0 ))
([java_lang_string_0 int_1 org_opencv_core_matofint_2 ] 
  (new org.opencv.videoio.VideoCapture java_lang_string_0 int_1 org_opencv_core_matofint_2 ))
([int_0 int_1 ] 
  (new org.opencv.videoio.VideoCapture int_0 int_1 ))
([] 
  (new org.opencv.videoio.VideoCapture )))
(def CAP_PROP_DC1394_OFF Videoio/CAP_PROP_DC1394_OFF)
(def CAP_PROP_DC1394_MODE_MANUAL Videoio/CAP_PROP_DC1394_MODE_MANUAL)
(def CAP_PROP_DC1394_MODE_AUTO Videoio/CAP_PROP_DC1394_MODE_AUTO)
(def CAP_PROP_DC1394_MODE_ONE_PUSH_AUTO Videoio/CAP_PROP_DC1394_MODE_ONE_PUSH_AUTO)
(def CAP_PROP_DC1394_MAX Videoio/CAP_PROP_DC1394_MAX)
(def CAP_OPENNI_DEPTH_GENERATOR Videoio/CAP_OPENNI_DEPTH_GENERATOR)
(def CAP_OPENNI_IMAGE_GENERATOR Videoio/CAP_OPENNI_IMAGE_GENERATOR)
(def CAP_OPENNI_IR_GENERATOR Videoio/CAP_OPENNI_IR_GENERATOR)
(def CAP_OPENNI_GENERATORS_MASK Videoio/CAP_OPENNI_GENERATORS_MASK)
(def CAP_PROP_OPENNI_OUTPUT_MODE Videoio/CAP_PROP_OPENNI_OUTPUT_MODE)
(def CAP_PROP_OPENNI_FRAME_MAX_DEPTH Videoio/CAP_PROP_OPENNI_FRAME_MAX_DEPTH)
(def CAP_PROP_OPENNI_BASELINE Videoio/CAP_PROP_OPENNI_BASELINE)
(def CAP_PROP_OPENNI_FOCAL_LENGTH Videoio/CAP_PROP_OPENNI_FOCAL_LENGTH)
(def CAP_PROP_OPENNI_REGISTRATION Videoio/CAP_PROP_OPENNI_REGISTRATION)
(def CAP_PROP_OPENNI_REGISTRATION_ON Videoio/CAP_PROP_OPENNI_REGISTRATION_ON)
(def CAP_PROP_OPENNI_APPROX_FRAME_SYNC Videoio/CAP_PROP_OPENNI_APPROX_FRAME_SYNC)
(def CAP_PROP_OPENNI_MAX_BUFFER_SIZE Videoio/CAP_PROP_OPENNI_MAX_BUFFER_SIZE)
(def CAP_PROP_OPENNI_CIRCLE_BUFFER Videoio/CAP_PROP_OPENNI_CIRCLE_BUFFER)
(def CAP_PROP_OPENNI_MAX_TIME_DURATION Videoio/CAP_PROP_OPENNI_MAX_TIME_DURATION)
(def CAP_PROP_OPENNI_GENERATOR_PRESENT Videoio/CAP_PROP_OPENNI_GENERATOR_PRESENT)
(def CAP_PROP_OPENNI2_SYNC Videoio/CAP_PROP_OPENNI2_SYNC)
(def CAP_PROP_OPENNI2_MIRROR Videoio/CAP_PROP_OPENNI2_MIRROR)
(def CAP_OPENNI_IMAGE_GENERATOR_PRESENT Videoio/CAP_OPENNI_IMAGE_GENERATOR_PRESENT)
(def CAP_OPENNI_IMAGE_GENERATOR_OUTPUT_MODE Videoio/CAP_OPENNI_IMAGE_GENERATOR_OUTPUT_MODE)
(def CAP_OPENNI_DEPTH_GENERATOR_PRESENT Videoio/CAP_OPENNI_DEPTH_GENERATOR_PRESENT)
(def CAP_OPENNI_DEPTH_GENERATOR_BASELINE Videoio/CAP_OPENNI_DEPTH_GENERATOR_BASELINE)
(def CAP_OPENNI_DEPTH_GENERATOR_FOCAL_LENGTH Videoio/CAP_OPENNI_DEPTH_GENERATOR_FOCAL_LENGTH)
(def CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION Videoio/CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION)
(def CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION_ON Videoio/CAP_OPENNI_DEPTH_GENERATOR_REGISTRATION_ON)
(def CAP_OPENNI_IR_GENERATOR_PRESENT Videoio/CAP_OPENNI_IR_GENERATOR_PRESENT)
(def CAP_OPENNI_DEPTH_MAP Videoio/CAP_OPENNI_DEPTH_MAP)
(def CAP_OPENNI_POINT_CLOUD_MAP Videoio/CAP_OPENNI_POINT_CLOUD_MAP)
(def CAP_OPENNI_DISPARITY_MAP Videoio/CAP_OPENNI_DISPARITY_MAP)
(def CAP_OPENNI_DISPARITY_MAP_32F Videoio/CAP_OPENNI_DISPARITY_MAP_32F)
(def CAP_OPENNI_VALID_DEPTH_MASK Videoio/CAP_OPENNI_VALID_DEPTH_MASK)
(def CAP_OPENNI_BGR_IMAGE Videoio/CAP_OPENNI_BGR_IMAGE)
(def CAP_OPENNI_GRAY_IMAGE Videoio/CAP_OPENNI_GRAY_IMAGE)
(def CAP_OPENNI_IR_IMAGE Videoio/CAP_OPENNI_IR_IMAGE)
(def CAP_OPENNI_VGA_30HZ Videoio/CAP_OPENNI_VGA_30HZ)
(def CAP_OPENNI_SXGA_15HZ Videoio/CAP_OPENNI_SXGA_15HZ)
(def CAP_OPENNI_SXGA_30HZ Videoio/CAP_OPENNI_SXGA_30HZ)
(def CAP_OPENNI_QVGA_30HZ Videoio/CAP_OPENNI_QVGA_30HZ)
(def CAP_OPENNI_QVGA_60HZ Videoio/CAP_OPENNI_QVGA_60HZ)
(def CAP_PROP_GSTREAMER_QUEUE_LENGTH Videoio/CAP_PROP_GSTREAMER_QUEUE_LENGTH)
(def CAP_PROP_PVAPI_MULTICASTIP Videoio/CAP_PROP_PVAPI_MULTICASTIP)
(def CAP_PROP_PVAPI_FRAMESTARTTRIGGERMODE Videoio/CAP_PROP_PVAPI_FRAMESTARTTRIGGERMODE)
(def CAP_PROP_PVAPI_DECIMATIONHORIZONTAL Videoio/CAP_PROP_PVAPI_DECIMATIONHORIZONTAL)
(def CAP_PROP_PVAPI_DECIMATIONVERTICAL Videoio/CAP_PROP_PVAPI_DECIMATIONVERTICAL)
(def CAP_PROP_PVAPI_BINNINGX Videoio/CAP_PROP_PVAPI_BINNINGX)
(def CAP_PROP_PVAPI_BINNINGY Videoio/CAP_PROP_PVAPI_BINNINGY)
(def CAP_PROP_PVAPI_PIXELFORMAT Videoio/CAP_PROP_PVAPI_PIXELFORMAT)
(def CAP_PVAPI_FSTRIGMODE_FREERUN Videoio/CAP_PVAPI_FSTRIGMODE_FREERUN)
(def CAP_PVAPI_FSTRIGMODE_SYNCIN1 Videoio/CAP_PVAPI_FSTRIGMODE_SYNCIN1)
(def CAP_PVAPI_FSTRIGMODE_SYNCIN2 Videoio/CAP_PVAPI_FSTRIGMODE_SYNCIN2)
(def CAP_PVAPI_FSTRIGMODE_FIXEDRATE Videoio/CAP_PVAPI_FSTRIGMODE_FIXEDRATE)
(def CAP_PVAPI_FSTRIGMODE_SOFTWARE Videoio/CAP_PVAPI_FSTRIGMODE_SOFTWARE)
(def CAP_PVAPI_DECIMATION_OFF Videoio/CAP_PVAPI_DECIMATION_OFF)
(def CAP_PVAPI_DECIMATION_2OUTOF4 Videoio/CAP_PVAPI_DECIMATION_2OUTOF4)
(def CAP_PVAPI_DECIMATION_2OUTOF8 Videoio/CAP_PVAPI_DECIMATION_2OUTOF8)
(def CAP_PVAPI_DECIMATION_2OUTOF16 Videoio/CAP_PVAPI_DECIMATION_2OUTOF16)
(def CAP_PVAPI_PIXELFORMAT_MONO8 Videoio/CAP_PVAPI_PIXELFORMAT_MONO8)
(def CAP_PVAPI_PIXELFORMAT_MONO16 Videoio/CAP_PVAPI_PIXELFORMAT_MONO16)
(def CAP_PVAPI_PIXELFORMAT_BAYER8 Videoio/CAP_PVAPI_PIXELFORMAT_BAYER8)
(def CAP_PVAPI_PIXELFORMAT_BAYER16 Videoio/CAP_PVAPI_PIXELFORMAT_BAYER16)
(def CAP_PVAPI_PIXELFORMAT_RGB24 Videoio/CAP_PVAPI_PIXELFORMAT_RGB24)
(def CAP_PVAPI_PIXELFORMAT_BGR24 Videoio/CAP_PVAPI_PIXELFORMAT_BGR24)
(def CAP_PVAPI_PIXELFORMAT_RGBA32 Videoio/CAP_PVAPI_PIXELFORMAT_RGBA32)
(def CAP_PVAPI_PIXELFORMAT_BGRA32 Videoio/CAP_PVAPI_PIXELFORMAT_BGRA32)
(def CAP_PROP_XI_DOWNSAMPLING Videoio/CAP_PROP_XI_DOWNSAMPLING)
(def CAP_PROP_XI_DATA_FORMAT Videoio/CAP_PROP_XI_DATA_FORMAT)
(def CAP_PROP_XI_OFFSET_X Videoio/CAP_PROP_XI_OFFSET_X)
(def CAP_PROP_XI_OFFSET_Y Videoio/CAP_PROP_XI_OFFSET_Y)
(def CAP_PROP_XI_TRG_SOURCE Videoio/CAP_PROP_XI_TRG_SOURCE)
(def CAP_PROP_XI_TRG_SOFTWARE Videoio/CAP_PROP_XI_TRG_SOFTWARE)
(def CAP_PROP_XI_GPI_SELECTOR Videoio/CAP_PROP_XI_GPI_SELECTOR)
(def CAP_PROP_XI_GPI_MODE Videoio/CAP_PROP_XI_GPI_MODE)
(def CAP_PROP_XI_GPI_LEVEL Videoio/CAP_PROP_XI_GPI_LEVEL)
(def CAP_PROP_XI_GPO_SELECTOR Videoio/CAP_PROP_XI_GPO_SELECTOR)
(def CAP_PROP_XI_GPO_MODE Videoio/CAP_PROP_XI_GPO_MODE)
(def CAP_PROP_XI_LED_SELECTOR Videoio/CAP_PROP_XI_LED_SELECTOR)
(def CAP_PROP_XI_LED_MODE Videoio/CAP_PROP_XI_LED_MODE)
(def CAP_PROP_XI_MANUAL_WB Videoio/CAP_PROP_XI_MANUAL_WB)
(def CAP_PROP_XI_AUTO_WB Videoio/CAP_PROP_XI_AUTO_WB)
(def CAP_PROP_XI_AEAG Videoio/CAP_PROP_XI_AEAG)
(def CAP_PROP_XI_EXP_PRIORITY Videoio/CAP_PROP_XI_EXP_PRIORITY)
(def CAP_PROP_XI_AE_MAX_LIMIT Videoio/CAP_PROP_XI_AE_MAX_LIMIT)
(def CAP_PROP_XI_AG_MAX_LIMIT Videoio/CAP_PROP_XI_AG_MAX_LIMIT)
(def CAP_PROP_XI_AEAG_LEVEL Videoio/CAP_PROP_XI_AEAG_LEVEL)
(def CAP_PROP_XI_TIMEOUT Videoio/CAP_PROP_XI_TIMEOUT)
(def CAP_PROP_XI_EXPOSURE Videoio/CAP_PROP_XI_EXPOSURE)
(def CAP_PROP_XI_EXPOSURE_BURST_COUNT Videoio/CAP_PROP_XI_EXPOSURE_BURST_COUNT)
(def CAP_PROP_XI_GAIN_SELECTOR Videoio/CAP_PROP_XI_GAIN_SELECTOR)
(def CAP_PROP_XI_GAIN Videoio/CAP_PROP_XI_GAIN)
(def CAP_PROP_XI_DOWNSAMPLING_TYPE Videoio/CAP_PROP_XI_DOWNSAMPLING_TYPE)
(def CAP_PROP_XI_BINNING_SELECTOR Videoio/CAP_PROP_XI_BINNING_SELECTOR)
(def CAP_PROP_XI_BINNING_VERTICAL Videoio/CAP_PROP_XI_BINNING_VERTICAL)
(def CAP_PROP_XI_BINNING_HORIZONTAL Videoio/CAP_PROP_XI_BINNING_HORIZONTAL)
(def CAP_PROP_XI_BINNING_PATTERN Videoio/CAP_PROP_XI_BINNING_PATTERN)
(def CAP_PROP_XI_DECIMATION_SELECTOR Videoio/CAP_PROP_XI_DECIMATION_SELECTOR)
(def CAP_PROP_XI_DECIMATION_VERTICAL Videoio/CAP_PROP_XI_DECIMATION_VERTICAL)
(def CAP_PROP_XI_DECIMATION_HORIZONTAL Videoio/CAP_PROP_XI_DECIMATION_HORIZONTAL)
(def CAP_PROP_XI_DECIMATION_PATTERN Videoio/CAP_PROP_XI_DECIMATION_PATTERN)
(def CAP_PROP_XI_TEST_PATTERN_GENERATOR_SELECTOR Videoio/CAP_PROP_XI_TEST_PATTERN_GENERATOR_SELECTOR)
(def CAP_PROP_XI_TEST_PATTERN Videoio/CAP_PROP_XI_TEST_PATTERN)
(def CAP_PROP_XI_IMAGE_DATA_FORMAT Videoio/CAP_PROP_XI_IMAGE_DATA_FORMAT)
(def CAP_PROP_XI_SHUTTER_TYPE Videoio/CAP_PROP_XI_SHUTTER_TYPE)
(def CAP_PROP_XI_SENSOR_TAPS Videoio/CAP_PROP_XI_SENSOR_TAPS)
(def CAP_PROP_XI_AEAG_ROI_OFFSET_X Videoio/CAP_PROP_XI_AEAG_ROI_OFFSET_X)
(def CAP_PROP_XI_AEAG_ROI_OFFSET_Y Videoio/CAP_PROP_XI_AEAG_ROI_OFFSET_Y)
(def CAP_PROP_XI_AEAG_ROI_WIDTH Videoio/CAP_PROP_XI_AEAG_ROI_WIDTH)
(def CAP_PROP_XI_AEAG_ROI_HEIGHT Videoio/CAP_PROP_XI_AEAG_ROI_HEIGHT)
(def CAP_PROP_XI_BPC Videoio/CAP_PROP_XI_BPC)
(def CAP_PROP_XI_WB_KR Videoio/CAP_PROP_XI_WB_KR)
(def CAP_PROP_XI_WB_KG Videoio/CAP_PROP_XI_WB_KG)
(def CAP_PROP_XI_WB_KB Videoio/CAP_PROP_XI_WB_KB)
(def CAP_PROP_XI_WIDTH Videoio/CAP_PROP_XI_WIDTH)
(def CAP_PROP_XI_HEIGHT Videoio/CAP_PROP_XI_HEIGHT)
(def CAP_PROP_XI_REGION_SELECTOR Videoio/CAP_PROP_XI_REGION_SELECTOR)
(def CAP_PROP_XI_REGION_MODE Videoio/CAP_PROP_XI_REGION_MODE)
(def CAP_PROP_XI_LIMIT_BANDWIDTH Videoio/CAP_PROP_XI_LIMIT_BANDWIDTH)
(def CAP_PROP_XI_SENSOR_DATA_BIT_DEPTH Videoio/CAP_PROP_XI_SENSOR_DATA_BIT_DEPTH)
(def CAP_PROP_XI_OUTPUT_DATA_BIT_DEPTH Videoio/CAP_PROP_XI_OUTPUT_DATA_BIT_DEPTH)
(def CAP_PROP_XI_IMAGE_DATA_BIT_DEPTH Videoio/CAP_PROP_XI_IMAGE_DATA_BIT_DEPTH)
(def CAP_PROP_XI_OUTPUT_DATA_PACKING Videoio/CAP_PROP_XI_OUTPUT_DATA_PACKING)
(def CAP_PROP_XI_OUTPUT_DATA_PACKING_TYPE Videoio/CAP_PROP_XI_OUTPUT_DATA_PACKING_TYPE)
(def CAP_PROP_XI_IS_COOLED Videoio/CAP_PROP_XI_IS_COOLED)
(def CAP_PROP_XI_COOLING Videoio/CAP_PROP_XI_COOLING)
(def CAP_PROP_XI_TARGET_TEMP Videoio/CAP_PROP_XI_TARGET_TEMP)
(def CAP_PROP_XI_CHIP_TEMP Videoio/CAP_PROP_XI_CHIP_TEMP)
(def CAP_PROP_XI_HOUS_TEMP Videoio/CAP_PROP_XI_HOUS_TEMP)
(def CAP_PROP_XI_HOUS_BACK_SIDE_TEMP Videoio/CAP_PROP_XI_HOUS_BACK_SIDE_TEMP)
(def CAP_PROP_XI_SENSOR_BOARD_TEMP Videoio/CAP_PROP_XI_SENSOR_BOARD_TEMP)
(def CAP_PROP_XI_CMS Videoio/CAP_PROP_XI_CMS)
(def CAP_PROP_XI_APPLY_CMS Videoio/CAP_PROP_XI_APPLY_CMS)
(def CAP_PROP_XI_IMAGE_IS_COLOR Videoio/CAP_PROP_XI_IMAGE_IS_COLOR)
(def CAP_PROP_XI_COLOR_FILTER_ARRAY Videoio/CAP_PROP_XI_COLOR_FILTER_ARRAY)
(def CAP_PROP_XI_GAMMAY Videoio/CAP_PROP_XI_GAMMAY)
(def CAP_PROP_XI_GAMMAC Videoio/CAP_PROP_XI_GAMMAC)
(def CAP_PROP_XI_SHARPNESS Videoio/CAP_PROP_XI_SHARPNESS)
(def CAP_PROP_XI_CC_MATRIX_00 Videoio/CAP_PROP_XI_CC_MATRIX_00)
(def CAP_PROP_XI_CC_MATRIX_01 Videoio/CAP_PROP_XI_CC_MATRIX_01)
(def CAP_PROP_XI_CC_MATRIX_02 Videoio/CAP_PROP_XI_CC_MATRIX_02)
(def CAP_PROP_XI_CC_MATRIX_03 Videoio/CAP_PROP_XI_CC_MATRIX_03)
(def CAP_PROP_XI_CC_MATRIX_10 Videoio/CAP_PROP_XI_CC_MATRIX_10)
(def CAP_PROP_XI_CC_MATRIX_11 Videoio/CAP_PROP_XI_CC_MATRIX_11)
(def CAP_PROP_XI_CC_MATRIX_12 Videoio/CAP_PROP_XI_CC_MATRIX_12)
(def CAP_PROP_XI_CC_MATRIX_13 Videoio/CAP_PROP_XI_CC_MATRIX_13)
(def CAP_PROP_XI_CC_MATRIX_20 Videoio/CAP_PROP_XI_CC_MATRIX_20)
(def CAP_PROP_XI_CC_MATRIX_21 Videoio/CAP_PROP_XI_CC_MATRIX_21)
(def CAP_PROP_XI_CC_MATRIX_22 Videoio/CAP_PROP_XI_CC_MATRIX_22)
(def CAP_PROP_XI_CC_MATRIX_23 Videoio/CAP_PROP_XI_CC_MATRIX_23)
(def CAP_PROP_XI_CC_MATRIX_30 Videoio/CAP_PROP_XI_CC_MATRIX_30)
(def CAP_PROP_XI_CC_MATRIX_31 Videoio/CAP_PROP_XI_CC_MATRIX_31)
(def CAP_PROP_XI_CC_MATRIX_32 Videoio/CAP_PROP_XI_CC_MATRIX_32)
(def CAP_PROP_XI_CC_MATRIX_33 Videoio/CAP_PROP_XI_CC_MATRIX_33)
(def CAP_PROP_XI_DEFAULT_CC_MATRIX Videoio/CAP_PROP_XI_DEFAULT_CC_MATRIX)
(def CAP_PROP_XI_TRG_SELECTOR Videoio/CAP_PROP_XI_TRG_SELECTOR)
(def CAP_PROP_XI_ACQ_FRAME_BURST_COUNT Videoio/CAP_PROP_XI_ACQ_FRAME_BURST_COUNT)
(def CAP_PROP_XI_DEBOUNCE_EN Videoio/CAP_PROP_XI_DEBOUNCE_EN)
(def CAP_PROP_XI_DEBOUNCE_T0 Videoio/CAP_PROP_XI_DEBOUNCE_T0)
(def CAP_PROP_XI_DEBOUNCE_T1 Videoio/CAP_PROP_XI_DEBOUNCE_T1)
(def CAP_PROP_XI_DEBOUNCE_POL Videoio/CAP_PROP_XI_DEBOUNCE_POL)
(def CAP_PROP_XI_LENS_MODE Videoio/CAP_PROP_XI_LENS_MODE)
(def CAP_PROP_XI_LENS_APERTURE_VALUE Videoio/CAP_PROP_XI_LENS_APERTURE_VALUE)
(def CAP_PROP_XI_LENS_FOCUS_MOVEMENT_VALUE Videoio/CAP_PROP_XI_LENS_FOCUS_MOVEMENT_VALUE)
(def CAP_PROP_XI_LENS_FOCUS_MOVE Videoio/CAP_PROP_XI_LENS_FOCUS_MOVE)
(def CAP_PROP_XI_LENS_FOCUS_DISTANCE Videoio/CAP_PROP_XI_LENS_FOCUS_DISTANCE)
(def CAP_PROP_XI_LENS_FOCAL_LENGTH Videoio/CAP_PROP_XI_LENS_FOCAL_LENGTH)
(def CAP_PROP_XI_LENS_FEATURE_SELECTOR Videoio/CAP_PROP_XI_LENS_FEATURE_SELECTOR)
(def CAP_PROP_XI_LENS_FEATURE Videoio/CAP_PROP_XI_LENS_FEATURE)
(def CAP_PROP_XI_DEVICE_MODEL_ID Videoio/CAP_PROP_XI_DEVICE_MODEL_ID)
(def CAP_PROP_XI_DEVICE_SN Videoio/CAP_PROP_XI_DEVICE_SN)
(def CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA Videoio/CAP_PROP_XI_IMAGE_DATA_FORMAT_RGB32_ALPHA)
(def CAP_PROP_XI_IMAGE_PAYLOAD_SIZE Videoio/CAP_PROP_XI_IMAGE_PAYLOAD_SIZE)
(def CAP_PROP_XI_TRANSPORT_PIXEL_FORMAT Videoio/CAP_PROP_XI_TRANSPORT_PIXEL_FORMAT)
(def CAP_PROP_XI_SENSOR_CLOCK_FREQ_HZ Videoio/CAP_PROP_XI_SENSOR_CLOCK_FREQ_HZ)
(def CAP_PROP_XI_SENSOR_CLOCK_FREQ_INDEX Videoio/CAP_PROP_XI_SENSOR_CLOCK_FREQ_INDEX)
(def CAP_PROP_XI_SENSOR_OUTPUT_CHANNEL_COUNT Videoio/CAP_PROP_XI_SENSOR_OUTPUT_CHANNEL_COUNT)
(def CAP_PROP_XI_FRAMERATE Videoio/CAP_PROP_XI_FRAMERATE)
(def CAP_PROP_XI_COUNTER_SELECTOR Videoio/CAP_PROP_XI_COUNTER_SELECTOR)
(def CAP_PROP_XI_COUNTER_VALUE Videoio/CAP_PROP_XI_COUNTER_VALUE)
(def CAP_PROP_XI_ACQ_TIMING_MODE Videoio/CAP_PROP_XI_ACQ_TIMING_MODE)
(def CAP_PROP_XI_AVAILABLE_BANDWIDTH Videoio/CAP_PROP_XI_AVAILABLE_BANDWIDTH)
(def CAP_PROP_XI_BUFFER_POLICY Videoio/CAP_PROP_XI_BUFFER_POLICY)
(def CAP_PROP_XI_LUT_EN Videoio/CAP_PROP_XI_LUT_EN)
(def CAP_PROP_XI_LUT_INDEX Videoio/CAP_PROP_XI_LUT_INDEX)
(def CAP_PROP_XI_LUT_VALUE Videoio/CAP_PROP_XI_LUT_VALUE)
(def CAP_PROP_XI_TRG_DELAY Videoio/CAP_PROP_XI_TRG_DELAY)
(def CAP_PROP_XI_TS_RST_MODE Videoio/CAP_PROP_XI_TS_RST_MODE)
(def CAP_PROP_XI_TS_RST_SOURCE Videoio/CAP_PROP_XI_TS_RST_SOURCE)
(def CAP_PROP_XI_IS_DEVICE_EXIST Videoio/CAP_PROP_XI_IS_DEVICE_EXIST)
(def CAP_PROP_XI_ACQ_BUFFER_SIZE Videoio/CAP_PROP_XI_ACQ_BUFFER_SIZE)
(def CAP_PROP_XI_ACQ_BUFFER_SIZE_UNIT Videoio/CAP_PROP_XI_ACQ_BUFFER_SIZE_UNIT)
(def CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_SIZE Videoio/CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_SIZE)
(def CAP_PROP_XI_BUFFERS_QUEUE_SIZE Videoio/CAP_PROP_XI_BUFFERS_QUEUE_SIZE)
(def CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_COMMIT Videoio/CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_COMMIT)
(def CAP_PROP_XI_RECENT_FRAME Videoio/CAP_PROP_XI_RECENT_FRAME)
(def CAP_PROP_XI_DEVICE_RESET Videoio/CAP_PROP_XI_DEVICE_RESET)
(def CAP_PROP_XI_COLUMN_FPN_CORRECTION Videoio/CAP_PROP_XI_COLUMN_FPN_CORRECTION)
(def CAP_PROP_XI_ROW_FPN_CORRECTION Videoio/CAP_PROP_XI_ROW_FPN_CORRECTION)
(def CAP_PROP_XI_SENSOR_MODE Videoio/CAP_PROP_XI_SENSOR_MODE)
(def CAP_PROP_XI_HDR Videoio/CAP_PROP_XI_HDR)
(def CAP_PROP_XI_HDR_KNEEPOINT_COUNT Videoio/CAP_PROP_XI_HDR_KNEEPOINT_COUNT)
(def CAP_PROP_XI_HDR_T1 Videoio/CAP_PROP_XI_HDR_T1)
(def CAP_PROP_XI_HDR_T2 Videoio/CAP_PROP_XI_HDR_T2)
(def CAP_PROP_XI_KNEEPOINT1 Videoio/CAP_PROP_XI_KNEEPOINT1)
(def CAP_PROP_XI_KNEEPOINT2 Videoio/CAP_PROP_XI_KNEEPOINT2)
(def CAP_PROP_XI_IMAGE_BLACK_LEVEL Videoio/CAP_PROP_XI_IMAGE_BLACK_LEVEL)
(def CAP_PROP_XI_HW_REVISION Videoio/CAP_PROP_XI_HW_REVISION)
(def CAP_PROP_XI_DEBUG_LEVEL Videoio/CAP_PROP_XI_DEBUG_LEVEL)
(def CAP_PROP_XI_AUTO_BANDWIDTH_CALCULATION Videoio/CAP_PROP_XI_AUTO_BANDWIDTH_CALCULATION)
(def CAP_PROP_XI_FFS_FILE_ID Videoio/CAP_PROP_XI_FFS_FILE_ID)
(def CAP_PROP_XI_FFS_FILE_SIZE Videoio/CAP_PROP_XI_FFS_FILE_SIZE)
(def CAP_PROP_XI_FREE_FFS_SIZE Videoio/CAP_PROP_XI_FREE_FFS_SIZE)
(def CAP_PROP_XI_USED_FFS_SIZE Videoio/CAP_PROP_XI_USED_FFS_SIZE)
(def CAP_PROP_XI_FFS_ACCESS_KEY Videoio/CAP_PROP_XI_FFS_ACCESS_KEY)
(def CAP_PROP_XI_SENSOR_FEATURE_SELECTOR Videoio/CAP_PROP_XI_SENSOR_FEATURE_SELECTOR)
(def CAP_PROP_XI_SENSOR_FEATURE_VALUE Videoio/CAP_PROP_XI_SENSOR_FEATURE_VALUE)
(def CAP_PROP_ARAVIS_AUTOTRIGGER Videoio/CAP_PROP_ARAVIS_AUTOTRIGGER)
(def CAP_PROP_IOS_DEVICE_FOCUS Videoio/CAP_PROP_IOS_DEVICE_FOCUS)
(def CAP_PROP_IOS_DEVICE_EXPOSURE Videoio/CAP_PROP_IOS_DEVICE_EXPOSURE)
(def CAP_PROP_IOS_DEVICE_FLASH Videoio/CAP_PROP_IOS_DEVICE_FLASH)
(def CAP_PROP_IOS_DEVICE_WHITEBALANCE Videoio/CAP_PROP_IOS_DEVICE_WHITEBALANCE)
(def CAP_PROP_IOS_DEVICE_TORCH Videoio/CAP_PROP_IOS_DEVICE_TORCH)
(def CAP_PROP_GIGA_FRAME_OFFSET_X Videoio/CAP_PROP_GIGA_FRAME_OFFSET_X)
(def CAP_PROP_GIGA_FRAME_OFFSET_Y Videoio/CAP_PROP_GIGA_FRAME_OFFSET_Y)
(def CAP_PROP_GIGA_FRAME_WIDTH_MAX Videoio/CAP_PROP_GIGA_FRAME_WIDTH_MAX)
(def CAP_PROP_GIGA_FRAME_HEIGH_MAX Videoio/CAP_PROP_GIGA_FRAME_HEIGH_MAX)
(def CAP_PROP_GIGA_FRAME_SENS_WIDTH Videoio/CAP_PROP_GIGA_FRAME_SENS_WIDTH)
(def CAP_PROP_GIGA_FRAME_SENS_HEIGH Videoio/CAP_PROP_GIGA_FRAME_SENS_HEIGH)
(def CAP_PROP_INTELPERC_PROFILE_COUNT Videoio/CAP_PROP_INTELPERC_PROFILE_COUNT)
(def CAP_PROP_INTELPERC_PROFILE_IDX Videoio/CAP_PROP_INTELPERC_PROFILE_IDX)
(def CAP_PROP_INTELPERC_DEPTH_LOW_CONFIDENCE_VALUE Videoio/CAP_PROP_INTELPERC_DEPTH_LOW_CONFIDENCE_VALUE)
(def CAP_PROP_INTELPERC_DEPTH_SATURATION_VALUE Videoio/CAP_PROP_INTELPERC_DEPTH_SATURATION_VALUE)
(def CAP_PROP_INTELPERC_DEPTH_CONFIDENCE_THRESHOLD Videoio/CAP_PROP_INTELPERC_DEPTH_CONFIDENCE_THRESHOLD)
(def CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_HORZ Videoio/CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_HORZ)
(def CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_VERT Videoio/CAP_PROP_INTELPERC_DEPTH_FOCAL_LENGTH_VERT)
(def CAP_INTELPERC_DEPTH_GENERATOR Videoio/CAP_INTELPERC_DEPTH_GENERATOR)
(def CAP_INTELPERC_IMAGE_GENERATOR Videoio/CAP_INTELPERC_IMAGE_GENERATOR)
(def CAP_INTELPERC_IR_GENERATOR Videoio/CAP_INTELPERC_IR_GENERATOR)
(def CAP_INTELPERC_GENERATORS_MASK Videoio/CAP_INTELPERC_GENERATORS_MASK)
(def CAP_INTELPERC_DEPTH_MAP Videoio/CAP_INTELPERC_DEPTH_MAP)
(def CAP_INTELPERC_UVDEPTH_MAP Videoio/CAP_INTELPERC_UVDEPTH_MAP)
(def CAP_INTELPERC_IR_MAP Videoio/CAP_INTELPERC_IR_MAP)
(def CAP_INTELPERC_IMAGE Videoio/CAP_INTELPERC_IMAGE)
(def CAP_PROP_GPHOTO2_PREVIEW Videoio/CAP_PROP_GPHOTO2_PREVIEW)
(def CAP_PROP_GPHOTO2_WIDGET_ENUMERATE Videoio/CAP_PROP_GPHOTO2_WIDGET_ENUMERATE)
(def CAP_PROP_GPHOTO2_RELOAD_CONFIG Videoio/CAP_PROP_GPHOTO2_RELOAD_CONFIG)
(def CAP_PROP_GPHOTO2_RELOAD_ON_CHANGE Videoio/CAP_PROP_GPHOTO2_RELOAD_ON_CHANGE)
(def CAP_PROP_GPHOTO2_COLLECT_MSGS Videoio/CAP_PROP_GPHOTO2_COLLECT_MSGS)
(def CAP_PROP_GPHOTO2_FLUSH_MSGS Videoio/CAP_PROP_GPHOTO2_FLUSH_MSGS)
(def CAP_PROP_SPEED Videoio/CAP_PROP_SPEED)
(def CAP_PROP_APERTURE Videoio/CAP_PROP_APERTURE)
(def CAP_PROP_EXPOSUREPROGRAM Videoio/CAP_PROP_EXPOSUREPROGRAM)
(def CAP_PROP_VIEWFINDER Videoio/CAP_PROP_VIEWFINDER)
(def CAP_PROP_IMAGES_BASE Videoio/CAP_PROP_IMAGES_BASE)
(def CAP_PROP_IMAGES_LAST Videoio/CAP_PROP_IMAGES_LAST)
(def VIDEO_ACCELERATION_NONE Videoio/VIDEO_ACCELERATION_NONE)
(def VIDEO_ACCELERATION_ANY Videoio/VIDEO_ACCELERATION_ANY)
(def VIDEO_ACCELERATION_D3D11 Videoio/VIDEO_ACCELERATION_D3D11)
(def VIDEO_ACCELERATION_VAAPI Videoio/VIDEO_ACCELERATION_VAAPI)
(def VIDEO_ACCELERATION_MFX Videoio/VIDEO_ACCELERATION_MFX)
(def CAP_ANY Videoio/CAP_ANY)
(def CAP_VFW Videoio/CAP_VFW)
(def CAP_V4L Videoio/CAP_V4L)
(def CAP_V4L2 Videoio/CAP_V4L2)
(def CAP_FIREWIRE Videoio/CAP_FIREWIRE)
(def CAP_FIREWARE Videoio/CAP_FIREWARE)
(def CAP_IEEE1394 Videoio/CAP_IEEE1394)
(def CAP_DC1394 Videoio/CAP_DC1394)
(def CAP_CMU1394 Videoio/CAP_CMU1394)
(def CAP_QT Videoio/CAP_QT)
(def CAP_UNICAP Videoio/CAP_UNICAP)
(def CAP_DSHOW Videoio/CAP_DSHOW)
(def CAP_PVAPI Videoio/CAP_PVAPI)
(def CAP_OPENNI Videoio/CAP_OPENNI)
(def CAP_OPENNI_ASUS Videoio/CAP_OPENNI_ASUS)
(def CAP_ANDROID Videoio/CAP_ANDROID)
(def CAP_XIAPI Videoio/CAP_XIAPI)
(def CAP_AVFOUNDATION Videoio/CAP_AVFOUNDATION)
(def CAP_GIGANETIX Videoio/CAP_GIGANETIX)
(def CAP_MSMF Videoio/CAP_MSMF)
(def CAP_WINRT Videoio/CAP_WINRT)
(def CAP_INTELPERC Videoio/CAP_INTELPERC)
(def CAP_REALSENSE Videoio/CAP_REALSENSE)
(def CAP_OPENNI2 Videoio/CAP_OPENNI2)
(def CAP_OPENNI2_ASUS Videoio/CAP_OPENNI2_ASUS)
(def CAP_OPENNI2_ASTRA Videoio/CAP_OPENNI2_ASTRA)
(def CAP_GPHOTO2 Videoio/CAP_GPHOTO2)
(def CAP_GSTREAMER Videoio/CAP_GSTREAMER)
(def CAP_FFMPEG Videoio/CAP_FFMPEG)
(def CAP_IMAGES Videoio/CAP_IMAGES)
(def CAP_ARAVIS Videoio/CAP_ARAVIS)
(def CAP_OPENCV_MJPEG Videoio/CAP_OPENCV_MJPEG)
(def CAP_INTEL_MFX Videoio/CAP_INTEL_MFX)
(def CAP_XINE Videoio/CAP_XINE)
(def CAP_UEYE Videoio/CAP_UEYE)
(def CAP_OBSENSOR Videoio/CAP_OBSENSOR)
(def CAP_OBSENSOR_DEPTH_MAP Videoio/CAP_OBSENSOR_DEPTH_MAP)
(def CAP_OBSENSOR_BGR_IMAGE Videoio/CAP_OBSENSOR_BGR_IMAGE)
(def CAP_OBSENSOR_IR_IMAGE Videoio/CAP_OBSENSOR_IR_IMAGE)
(def CAP_OBSENSOR_DEPTH_GENERATOR Videoio/CAP_OBSENSOR_DEPTH_GENERATOR)
(def CAP_OBSENSOR_IMAGE_GENERATOR Videoio/CAP_OBSENSOR_IMAGE_GENERATOR)
(def CAP_OBSENSOR_IR_GENERATOR Videoio/CAP_OBSENSOR_IR_GENERATOR)
(def CAP_OBSENSOR_GENERATORS_MASK Videoio/CAP_OBSENSOR_GENERATORS_MASK)
(def CAP_PROP_OBSENSOR_INTRINSIC_FX Videoio/CAP_PROP_OBSENSOR_INTRINSIC_FX)
(def CAP_PROP_OBSENSOR_INTRINSIC_FY Videoio/CAP_PROP_OBSENSOR_INTRINSIC_FY)
(def CAP_PROP_OBSENSOR_INTRINSIC_CX Videoio/CAP_PROP_OBSENSOR_INTRINSIC_CX)
(def CAP_PROP_OBSENSOR_INTRINSIC_CY Videoio/CAP_PROP_OBSENSOR_INTRINSIC_CY)
(def CAP_PROP_POS_MSEC Videoio/CAP_PROP_POS_MSEC)
(def CAP_PROP_POS_FRAMES Videoio/CAP_PROP_POS_FRAMES)
(def CAP_PROP_POS_AVI_RATIO Videoio/CAP_PROP_POS_AVI_RATIO)
(def CAP_PROP_FRAME_WIDTH Videoio/CAP_PROP_FRAME_WIDTH)
(def CAP_PROP_FRAME_HEIGHT Videoio/CAP_PROP_FRAME_HEIGHT)
(def CAP_PROP_FPS Videoio/CAP_PROP_FPS)
(def CAP_PROP_FOURCC Videoio/CAP_PROP_FOURCC)
(def CAP_PROP_FRAME_COUNT Videoio/CAP_PROP_FRAME_COUNT)
(def CAP_PROP_FORMAT Videoio/CAP_PROP_FORMAT)
(def CAP_PROP_MODE Videoio/CAP_PROP_MODE)
(def CAP_PROP_BRIGHTNESS Videoio/CAP_PROP_BRIGHTNESS)
(def CAP_PROP_CONTRAST Videoio/CAP_PROP_CONTRAST)
(def CAP_PROP_SATURATION Videoio/CAP_PROP_SATURATION)
(def CAP_PROP_HUE Videoio/CAP_PROP_HUE)
(def CAP_PROP_GAIN Videoio/CAP_PROP_GAIN)
(def CAP_PROP_EXPOSURE Videoio/CAP_PROP_EXPOSURE)
(def CAP_PROP_CONVERT_RGB Videoio/CAP_PROP_CONVERT_RGB)
(def CAP_PROP_WHITE_BALANCE_BLUE_U Videoio/CAP_PROP_WHITE_BALANCE_BLUE_U)
(def CAP_PROP_RECTIFICATION Videoio/CAP_PROP_RECTIFICATION)
(def CAP_PROP_MONOCHROME Videoio/CAP_PROP_MONOCHROME)
(def CAP_PROP_SHARPNESS Videoio/CAP_PROP_SHARPNESS)
(def CAP_PROP_AUTO_EXPOSURE Videoio/CAP_PROP_AUTO_EXPOSURE)
(def CAP_PROP_GAMMA Videoio/CAP_PROP_GAMMA)
(def CAP_PROP_TEMPERATURE Videoio/CAP_PROP_TEMPERATURE)
(def CAP_PROP_TRIGGER Videoio/CAP_PROP_TRIGGER)
(def CAP_PROP_TRIGGER_DELAY Videoio/CAP_PROP_TRIGGER_DELAY)
(def CAP_PROP_WHITE_BALANCE_RED_V Videoio/CAP_PROP_WHITE_BALANCE_RED_V)
(def CAP_PROP_ZOOM Videoio/CAP_PROP_ZOOM)
(def CAP_PROP_FOCUS Videoio/CAP_PROP_FOCUS)
(def CAP_PROP_GUID Videoio/CAP_PROP_GUID)
(def CAP_PROP_ISO_SPEED Videoio/CAP_PROP_ISO_SPEED)
(def CAP_PROP_BACKLIGHT Videoio/CAP_PROP_BACKLIGHT)
(def CAP_PROP_PAN Videoio/CAP_PROP_PAN)
(def CAP_PROP_TILT Videoio/CAP_PROP_TILT)
(def CAP_PROP_ROLL Videoio/CAP_PROP_ROLL)
(def CAP_PROP_IRIS Videoio/CAP_PROP_IRIS)
(def CAP_PROP_SETTINGS Videoio/CAP_PROP_SETTINGS)
(def CAP_PROP_BUFFERSIZE Videoio/CAP_PROP_BUFFERSIZE)
(def CAP_PROP_AUTOFOCUS Videoio/CAP_PROP_AUTOFOCUS)
(def CAP_PROP_SAR_NUM Videoio/CAP_PROP_SAR_NUM)
(def CAP_PROP_SAR_DEN Videoio/CAP_PROP_SAR_DEN)
(def CAP_PROP_BACKEND Videoio/CAP_PROP_BACKEND)
(def CAP_PROP_CHANNEL Videoio/CAP_PROP_CHANNEL)
(def CAP_PROP_AUTO_WB Videoio/CAP_PROP_AUTO_WB)
(def CAP_PROP_WB_TEMPERATURE Videoio/CAP_PROP_WB_TEMPERATURE)
(def CAP_PROP_CODEC_PIXEL_FORMAT Videoio/CAP_PROP_CODEC_PIXEL_FORMAT)
(def CAP_PROP_BITRATE Videoio/CAP_PROP_BITRATE)
(def CAP_PROP_ORIENTATION_META Videoio/CAP_PROP_ORIENTATION_META)
(def CAP_PROP_ORIENTATION_AUTO Videoio/CAP_PROP_ORIENTATION_AUTO)
(def CAP_PROP_HW_ACCELERATION Videoio/CAP_PROP_HW_ACCELERATION)
(def CAP_PROP_HW_DEVICE Videoio/CAP_PROP_HW_DEVICE)
(def CAP_PROP_HW_ACCELERATION_USE_OPENCL Videoio/CAP_PROP_HW_ACCELERATION_USE_OPENCL)
(def CAP_PROP_OPEN_TIMEOUT_MSEC Videoio/CAP_PROP_OPEN_TIMEOUT_MSEC)
(def CAP_PROP_READ_TIMEOUT_MSEC Videoio/CAP_PROP_READ_TIMEOUT_MSEC)
(def CAP_PROP_STREAM_OPEN_TIME_USEC Videoio/CAP_PROP_STREAM_OPEN_TIME_USEC)
(def CAP_PROP_VIDEO_TOTAL_CHANNELS Videoio/CAP_PROP_VIDEO_TOTAL_CHANNELS)
(def CAP_PROP_VIDEO_STREAM Videoio/CAP_PROP_VIDEO_STREAM)
(def CAP_PROP_AUDIO_STREAM Videoio/CAP_PROP_AUDIO_STREAM)
(def CAP_PROP_AUDIO_POS Videoio/CAP_PROP_AUDIO_POS)
(def CAP_PROP_AUDIO_SHIFT_NSEC Videoio/CAP_PROP_AUDIO_SHIFT_NSEC)
(def CAP_PROP_AUDIO_DATA_DEPTH Videoio/CAP_PROP_AUDIO_DATA_DEPTH)
(def CAP_PROP_AUDIO_SAMPLES_PER_SECOND Videoio/CAP_PROP_AUDIO_SAMPLES_PER_SECOND)
(def CAP_PROP_AUDIO_BASE_INDEX Videoio/CAP_PROP_AUDIO_BASE_INDEX)
(def CAP_PROP_AUDIO_TOTAL_CHANNELS Videoio/CAP_PROP_AUDIO_TOTAL_CHANNELS)
(def CAP_PROP_AUDIO_TOTAL_STREAMS Videoio/CAP_PROP_AUDIO_TOTAL_STREAMS)
(def CAP_PROP_AUDIO_SYNCHRONIZE Videoio/CAP_PROP_AUDIO_SYNCHRONIZE)
(def CAP_PROP_LRF_HAS_KEY_FRAME Videoio/CAP_PROP_LRF_HAS_KEY_FRAME)
(def CAP_PROP_CODEC_EXTRADATA_INDEX Videoio/CAP_PROP_CODEC_EXTRADATA_INDEX)
(def CAP_PROP_FRAME_TYPE Videoio/CAP_PROP_FRAME_TYPE)
(def CAP_PROP_N_THREADS Videoio/CAP_PROP_N_THREADS)
(def VIDEOWRITER_PROP_QUALITY Videoio/VIDEOWRITER_PROP_QUALITY)
(def VIDEOWRITER_PROP_FRAMEBYTES Videoio/VIDEOWRITER_PROP_FRAMEBYTES)
(def VIDEOWRITER_PROP_NSTRIPES Videoio/VIDEOWRITER_PROP_NSTRIPES)
(def VIDEOWRITER_PROP_IS_COLOR Videoio/VIDEOWRITER_PROP_IS_COLOR)
(def VIDEOWRITER_PROP_DEPTH Videoio/VIDEOWRITER_PROP_DEPTH)
(def VIDEOWRITER_PROP_HW_ACCELERATION Videoio/VIDEOWRITER_PROP_HW_ACCELERATION)
(def VIDEOWRITER_PROP_HW_DEVICE Videoio/VIDEOWRITER_PROP_HW_DEVICE)
(def VIDEOWRITER_PROP_HW_ACCELERATION_USE_OPENCL Videoio/VIDEOWRITER_PROP_HW_ACCELERATION_USE_OPENCL)
