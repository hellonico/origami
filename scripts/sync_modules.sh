#!/bin/bash
# Get the version from project.clj
VERSION=$(grep 'defproject origami/origami' project.clj | sed 's/.*"\(.*\)".*/\1/')
echo "Syncing submodules to version: $VERSION"

# clojure-cli-samples
echo "Updating clojure-cli-samples..."
sed -i '' "s|origami/origami {:mvn/version \".*\"}|origami/origami {:mvn/version \"$VERSION\"}|" modules/clojure-cli-samples/deps.edn
(cd modules/clojure-cli-samples && git diff --quiet && echo "No changes in clojure-cli-samples" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

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
sed -i '' "s|implementation 'origami:origami:.*'|implementation 'origami:origami:$VERSION'|" modules/kotlin-samples/build.gradle
(cd modules/kotlin-samples && git diff --quiet && echo "No changes in kotlin-samples" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# origami-filters
echo "Updating origami-filters..."
sed -i '' "s|implementation group: 'origami', name: 'origami', version:'.*'|implementation group: 'origami', name: 'origami', version:'$VERSION'|" modules/origami-filters/build.gradle
(cd modules/origami-filters && git diff --quiet && echo "No changes in origami-filters" || (git commit -am "Bump origami to $VERSION" && echo "Committed."))

# Stage submodule changes in main repo
# We use git add to ensure the updated submodule commit pointer is staged for the main repo commit
git add modules/clojure-cli-samples modules/llamaclj-on-cam modules/jetbrains-compose-webcam modules/kotlin-samples modules/origami-filters

echo "Submodules synced and staged."
