#!/bin/zsh

# https://stackoverflow.com/questions/45539521/nexus-artifact-download-using-curl

#curl -sSL -X GET -G "http://mynexus3.local/service/rest/v1/search/assets" \
#  -d repository=maven-snapshots \
#  -d maven.groupId=my.group.id \
#  -d maven.artifactId=my-artifact \
#  -d maven.baseVersion=1.0-SNAPSHOT \
#  -d maven.extension=jar \
#  -d maven.classifier=jar-with-dependencies \
#  | grep -Po '"downloadUrl" : "\K.+(?=",)' \
#  | xargs curl -fsSL -o my-artifact.jar

FOO="${1:-networks.*}"

curl -sSL -X GET -G "https://repository.hellonico.info/service/rest/v1/search/assets" \
  -d repository=hellonico \
  -d maven.groupId=$FOO \
  -d maven.extension=zip |
  grep -a1 -b1 "artifactId"