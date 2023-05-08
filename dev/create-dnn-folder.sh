#!/bin/bash
VERSION="3.1"
EXTRA="_face"
#EXTRA=""
BASE="https://github.com/meituan/YOLOv6/releases/download/0.$VERSION"

for value in n l s m
do
   NAME=yolov6$value$EXTRA
   URL=$BASE/$NAME.onnx
   TARGET=$NAME-$VERSION
   TARGET_FOLDER=/tmp/$TARGET.zip
   mkdir $TARGET_FOLDER
   echo $URL >> $TARGET_FOLDER/get.url
   cp dev/coco.names $TARGET_FOLDER/
   ./dev/deploy-dnn.sh $TARGET_FOLDER
done