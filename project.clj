(defproject origami "0.1.1"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
:profiles {:dev {
    :resource-paths ["resources-dev"]
    :dependencies [
    ; used for api code only
    [camel-snake-kebab "0.4.0"]]}}            
  :dependencies [
  	[org.clojure/clojure "1.8.0"]
    [opencv/opencv "3.3.1"]
    [opencv/opencv-native "3.3.1"]
])