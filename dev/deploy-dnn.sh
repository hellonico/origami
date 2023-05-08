#!/bin/zsh

# > tree yolov6t-1.0.zip/                                                                                                                                           (base) 09:12:31
# yolov6t-1.0.zip/
# ├── coco.names
# └── yolov6t_v1.onnx

DIR=$1
PARENT="$(dirname $DIR)"
FILE="$(basename $DIR)"
NETWORK=`echo $FILE | cut -d"-" -f1`
VERSION=`echo $FILE | cut -d"-" -f2 | rev | cut -d"." -f2- | rev`
TEMPFILE=deploy.zip

rm $DIR/**/.DS_Store

echo "Preparing: $NETWORK $VERSION from $FILE located in $PARENT"
#echo "Waiting 5 seconds ..."
#sleep 5

(cd $PARENT && zip -r - $FILE) >$TEMPFILE

echo "Uploading"
mvn deploy:deploy-file -DgroupId=networks.yolo \
  -DartifactId=$NETWORK \
  -Dversion=$VERSION \
  -Dpackaging=zip \
  -Dfile=$TEMPFILE \
  -DrepositoryId=vendredi \
  -Durl=https://repository.hellonico.info/repository/hellonico/

rm $TEMPFILE