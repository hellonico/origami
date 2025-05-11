(let [properties (select-keys (into {} (System/getProperties)) ["os.name"])
      platform (apply format "%s" (vals properties))

      ; https://stackoverflow.com/questions/4688336/what-is-an-elegant-way-to-set-up-a-leiningen-project-that-requires-different-dep
      mxnet (case platform
              "Mac OS X" '[org.apache.mxnet.contrib.clojure/clojure-mxnet-osx-cpu "1.4.0"]
              '[org.apache.mxnet.contrib.clojure/clojure-mxnet-linux-cpu "1.4.0"])
      ; _ (println (str platform mxnet))
      ]

  (defproject origami/origami "4.11.0-3"
    :description "OpenCV4 Wrapper"
    :aot [opencv4.dnn.core opencv4.fetcher]
    :url "https://github.com/hellonico/origami"
    :license {:name "Eclipse Public License" :url "http://www.eclipse.org/legal/epl-v10.html"}
    :repositories [["vendredi" {:url "https://repository.hellonico.info/repository/hellonico/" :creds :gpg}]
                   ["mxnet" {:url "https://repository.apache.org/content/repositories/staging/"}]]
    :aliases {"api" ["with-profile" "dev" "run" "-m" "opencv4.api"]}
    :release-tasks
    [["vcs" "assert-committed"]
     ["change" "version" "leiningen.release/bump-version" "release"]
     ["vcs" "commit"]
     ["vcs" "tag" "--no-sign"]
     ; ["deploy" "vendredi"]
     ["deploy" "clojars"]
     ["change" "version" "leiningen.release/bump-version"]
     ["vcs" "commit"]
     ["vcs" "push"]]
    :java-source-paths ["java" "test-java"]
    :junit ["test-java"]
    :resource-paths ["resources"]
    :junit-formatter :plain
    :junit-results-dir "target/junit"
    :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options" "-nowarn"]
    :codox {:source-paths ["src"]}
    :test-selectors {:default (complement :x11)
                     :x11     :x11
                     :all     (constantly true)}

    :profiles {:dev {:plugins        [[lein-codox "0.10.7"] [lein-junit "1.1.9"] [jonase/eastwood "0.3.5"] [quickie "0.4.1"]]
                     :source-paths   ["dev"]
                     :resource-paths ["resources-dev"]
                     :dependencies   [; testing
                                      ; ~mxnet

                                      ; used for api code only
                                      [camel-snake-kebab "0.4.3"]]}}
    :dependencies [; [org.clojure/clojure "1.10.0"]
                   [org.scijava/native-lib-loader "2.5.0" :exclusions [org.slf4j/slf4j-api]]
                   [org.clojure/clojure "1.11.3" :scope "provided"]
                   [opencv/opencv "4.11.0-0"]
                   [opencv/opencv-native "4.11.0-0"]
                   ; java.data breaking with newer versions
                   [org.clojure/java.data "1.0.64" :exclusions [org.clojure/clojure]]
                   [com.nextjournal/beholder "1.0.2"]
                   [org.openjfx/javafx-controls "17" :scope "provided"]
                   [org.openjfx/javafx-base "17" :scope "provided"]
                   [org.openjfx/javafx-media "17" :scope "provided"]
                   ; do not move to :dev profile or javac cannot find it
                   [junit/junit "4.13.2" :scope "provided"]
                   [org.slf4j/slf4j-nop "2.0.13"]]))