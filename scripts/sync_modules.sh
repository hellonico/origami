#!/bin/bash
# Get the version from project.clj
VERSION=$(grep 'defproject origami/origami' project.clj | sed 's/.*"\(.*\)".*/\1/')
FILTERS_VERSION=$(grep 'defproject origami/filters' modules/origami-filters/project.clj 2>/dev/null | sed 's/.*"\(.*\)".*/\1/' || echo "1.48")
echo "Syncing submodules to origami: $VERSION, filters: $FILTERS_VERSION"

# clojure-cli-samples
echo "Updating clojure-cli-samples..."
sed -i '' "s|origami/origami {:mvn/version \".*\"}|origami/origami {:mvn/version \"$VERSION\"}|" modules/clojure-cli-samples/deps.edn
(cd modules/clojure-cli-samples && bash bump.sh "$VERSION" "$FILTERS_VERSION" && git diff --quiet && echo "No changes in clojure-cli-samples" || (git commit -am "Bump origami to $VERSION, filters to $FILTERS_VERSION" && echo "Committed."))

# llamaclj-on-cam
echo "Updating llamaclj-on-cam..."
sed -i '' "s|origami/origami {:mvn/version \".*\"}|origami/origami {:mvn/version \"$VERSION\"}|" modules/llamaclj-on-cam/deps.edn
(cd modules/llamaclj-on-cam && git diff --quiet && echo "No changes in llamaclj-on-cam" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# jetbrains-compose-webcam
echo "Updating jetbrains-compose-webcam..."
sed -i '' "s|implementation(\"origami:origami:.*\")|implementation(\"origami:origami:$VERSION\")|" modules/jetbrains-compose-webcam/build.gradle.kts
(cd modules/jetbrains-compose-webcam && git diff --quiet && echo "No changes in jetbrains-compose-webcam" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# kotlin-samples
echo "Updating kotlin-samples..."
sed -i '' "s|implementation(\"origami:origami:.*\")|implementation(\"origami:origami:$VERSION\")|" modules/kotlin-samples/build.gradle.kts
(cd modules/kotlin-samples && git diff --quiet && echo "No changes in kotlin-samples" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# origami-filters
echo "Updating origami-filters..."
sed -i '' "s|implementation group: 'origami', name: 'origami', version:'.*'|implementation group: 'origami', name: 'origami', version:'$VERSION'|" modules/origami-filters/build.gradle
(cd modules/origami-filters && git diff --quiet && echo "No changes in origami-filters" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# jbangs
echo "Updating jbangs..."
for f in modules/jbangs/*.java; do
  sed -i '' "s|//DEPS origami:origami:.*|//DEPS origami:origami:$VERSION|" "$f"
done
(cd modules/jbangs && git diff --quiet && echo "No changes in jbangs" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# starter-scala
echo "Updating starter-scala..."
sed -i '' "s|\"origami\" % \"origami\" % \".*\"|\"origami\" % \"origami\" % \"$VERSION\"|" modules/starter-scala/src/main/g8/build.sbt
(cd modules/starter-scala && git diff --quiet && echo "No changes in starter-scala" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# opencv-live-video-stream-over-http
echo "Updating opencv-live-video-stream-over-http..."
sed -i '' "/<artifactId>origami<\/artifactId>/{n;s|<version>.*</version>|<version>$VERSION</version>|;}" modules/opencv-live-video-stream-over-http/pom.xml
(cd modules/opencv-live-video-stream-over-http && git diff --quiet && echo "No changes in opencv-live-video-stream-over-http" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# origami-dnn
echo "Updating origami-dnn..."
sed -i '' "s|origami/origami \"[^\"]*\"|origami/origami \"$VERSION\"|" modules/origami-dnn/project.clj
sed -i '' "s|origami/origami {:mvn/version \"[^\"]*\"}|origami/origami {:mvn/version \"$VERSION\"}|" modules/origami-dnn/deps.edn
(cd modules/origami-dnn && git diff --quiet && echo "No changes in origami-dnn" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# origami-wasabi
echo "Updating origami-wasabi..."
sed -i '' "s|implementation(\"origami:origami:[^\"]*\")|implementation(\"origami:origami:$VERSION\")|" modules/origami-wasabi/build.gradle.kts
(cd modules/origami-wasabi && git diff --quiet && echo "No changes in origami-wasabi" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# Stage submodule changes in main repo
# We use git add to ensure the updated submodule commit pointer is staged for the main repo commit
git add modules/clojure-cli-samples modules/llamaclj-on-cam modules/jetbrains-compose-webcam modules/kotlin-samples modules/origami-filters modules/jbangs modules/starter-scala modules/opencv-live-video-stream-over-http modules/origami-dnn modules/origami-wasabi

echo "Submodules synced and staged."
