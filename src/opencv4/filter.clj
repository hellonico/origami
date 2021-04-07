(ns opencv4.filter
  (:require
    [clojure.java.data :as j]))

(defn s->filter
  [values]
  (cond
    (instance? java.io.File values)
    (s->filter (slurp values))
    (string? values)
    (try
      (if (.exists (clojure.java.io/as-file values))
      (s->filter (clojure.java.io/as-file values))
      (let [ r (read-string values) ] (s->filter r)))
      (catch Exception e (let [ r (read-string values) ] (s->filter r))))
    (map? values)
    (j/to-java (eval (:class values)) values)
    (coll? values)
     (into-array origami.Filter (map s->filter values))
     :else (do (println values) nil)))

(defn filter->s
  ([values]
   (cond
     (instance? origami.Filters  values)
     (do (println "filters ... ")
       (apply str "[" (doall (map bean (.getFilters values))) "]"))
     (string? values)
       (filter->s (read-string values))
     (coll? values)
       (apply str (map bean values))
       :else
     (str (bean values))))
  ([values filename]
   (spit filename filter->s values)))

(defn- to-filter-fn[_fn]
  (fn [mat] (.apply _fn mat)))

(defn s->fn-filter [values]
  (let [_fn (s->filter values)]
    (cond
      ; (coll? _fn) ; ??
      ; there should be a better way to do this
      (= "class [Lorigami.Filter;" (str (class _fn)))
      (apply comp (map to-filter-fn _fn)) ; apply many
      :else
      (to-filter-fn _fn))))
