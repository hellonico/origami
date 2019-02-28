(let [properties (select-keys (into {} (System/getProperties))
                              ["os.name"])
      platform (apply format "%s" (vals properties))
      
      ; https://stackoverflow.com/questions/4688336/what-is-an-elegant-way-to-set-up-a-leiningen-project-that-requires-different-dep
      mxnet (case platform
      "Mac OS X" '[org.apache.mxnet.contrib.clojure/clojure-mxnet-osx-cpu "1.4.0"]
      '[org.apache.mxnet.contrib.clojure/clojure-mxnet-linux-cpu "1.4.0"]
      )
      _ (println (str platform mxnet))
      ]

(defproject origami "4.0.0-4-SNAPSHOT"
  :description "OpenCV4 Wrapper"
  :url "https://github.com/hellonico/origami"
  :license {:name "Eclipse Public License" :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [
  ["vendredi" {:url "https://repository.hellonico.info/repository/hellonico/" :creds :gpg}]
  ["mxnet" {:url "https://repository.apache.org/content/repositories/staging/"}]
  ]
  :aliases {"api" ["with-profile" "dev" "run" "-m" "opencv4.api" ]}
  :release-tasks 
    [["vcs" "assert-committed"]
     ["change" "version" "leiningen.release/bump-version" "release"]
     ["vcs" "commit"]
     ["vcs" "tag" "--no-sign"]
     ["deploy" "vendredi"]
     ["change" "version" "leiningen.release/bump-version"]
     ["vcs" "commit"]
     ["vcs" "push"]]
  :profiles {:dev {
    :plugins [[jonase/eastwood "0.3.5"][quickie "0.4.1"]]
    :source-paths ["dev"]
    :dependencies [
    ; testing
    ~mxnet
    ; used for api code only
    [camel-snake-kebab "0.4.0"]]}}
  :dependencies [
  	[org.clojure/clojure "1.10.0"]
    [org.scijava/native-lib-loader "2.3.1"]                 
    [opencv/opencv "4.0.0-0"]
    [opencv/opencv-native "4.0.0-1"]
    [hellonico/gorilla-repl "0.4.1"]]))