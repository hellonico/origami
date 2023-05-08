#!/bin/bash
VERSION="3.0"
BASE="https://github.com/meituan/YOLOv6/releases/download/0.$VERSION"

for value in n l s m
do
   URL=$BASE/yolov6$value.onnx
   TARGET=yolov6$value-$VERSION
   TARGET_FOLDER=/tmp/$TARGET.zip
   mkdir $TARGET_FOLDER
   echo $URL >> $TARGET_FOLDER/get.url
   cp dev/coco.names $TARGET_FOLDER/
   ./dev/deploy-dnn.sh $TARGET_FOLDER
done