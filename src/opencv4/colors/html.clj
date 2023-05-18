(ns opencv4.colors.html
  (:import [org.opencv.core Scalar])
  (:require [opencv4.core :only [new-scalar]]))

(defn- hex->num [#^String s]
  (Integer/parseInt s 16))

(defn ->scalar [#^String s]
  (let [[r g b] (map #(apply str %) (partition 2 (.substring s 1)))]
    (opencv4.core/new-scalar (hex->num b) (hex->num g) (hex->num r))))

(defn- num->hex [s]
  (.toUpperCase (format "%02d" (Integer/toHexString (int s)))))

(defn ->html [#^Scalar s]
  (println s)
  (let [aa (.-val s) [b g r _] aa]
    (str "#" (num->hex r) (num->hex g) (num->hex b))))