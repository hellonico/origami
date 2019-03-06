
(ns opencv4.gorilla
  (:require [opencv4.utils :as u])
  (:use [gorilla-repl.image]))

; gorilla repl
(defn mat-view[img]
  	(image-view (u/mat-to-buffered-image img)))
(def >> mat-view)