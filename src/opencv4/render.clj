(ns opencv4.render
  (:require
    [opencv4.core :as cv])
  (:import (origami.render CombinedMatsIntoTriangle LeftRight)))

;;;
;;; RENDER
;;;

; TODO: could be the start of a collage framework here
;(def left-right [ mats ]
;  (.apply (LeftRight.) mats))
;
;(def triangle
;  {:class CombinedMatsIntoTriangle})