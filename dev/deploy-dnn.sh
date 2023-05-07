#!/bin/zsh

DIR=$HOME/.origami/yolov6n-1.0.0.zip
PARENT="$(dirname $DIR)"
FILE="$(basename $DIR)"
(cd $PARENT && zip -r - $FILE) > deploy.zip

mvn deploy:deploy-file -DgroupId=networks.yolo \
  -DartifactId=yolov6n \
  -Dversion=1.0 \
  -Dpackaging=zip \
  -Dfile=deploy.zip \
  -DrepositoryId=vendredi \
  -Durl=https://repository.hellonico.info/repository/hellonico/

rm deploy.zip