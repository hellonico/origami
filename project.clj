(defproject origami "0.1.8"
  :description "OpenCV Wrapper"
  :url "https://github.com/hellonico/origami"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
:repositories [
["vendredi" {:url "https://repository.hellonico.info/repository/hellonico/" :creds :gpg}]
]
:resource-paths ["rsc"]
:injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]

:release-tasks [["vcs" "assert-committed"]
                ["change" "version" "leiningen.release/bump-version" "release"]
                ["vcs" "commit"]
                ;["vcs" "tag" "--no-sign"]
                ["deploy" "vendredi"]
                ]

:profiles {:dev {
    :plugins [[quickie "0.4.1"]]
    :dependencies [
    ; used for proto repl
    [org.clojure/tools.nrepl "0.2.11"]
    [proto-repl "0.3.1"]
    ; used for api code only
    [camel-snake-kebab "0.4.0"]]}}
  :dependencies [
  	[org.clojure/clojure "1.8.0"]
    [opencv/opencv "3.3.1"]
    [opencv/opencv-native "3.3.1"]
    [gorilla-repl "0.4.0"]])