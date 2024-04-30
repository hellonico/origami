Origami Project Goals

- Lowest barrier of entry to Image Processing, Computer Vision and Neural Networks on the JVM
  - by using OpenCV (and when possible Clojure)
- Works out of the box on your device (OSX, Windows, Linux, Raspberry, Jetson ..) and in your language (Clojure, Java, Kotlin, Scala, Binary via Google's Bazel)

![Clojars Project](https://clojars.org/origami/latest-version.svg)

![image](https://circleci.com/gh/hellonico/origami.svg?style=svg)
![github](https://github.com/hellonico/origami/actions/workflows/clojure.yml/badge.svg)

# AT A GLANCE

- Full support for [OpenCV 4.9.0](https://github.com/opencv/opencv/wiki/ChangeLog#version490) 
  - [CircleCI Passing](https://app.circleci.com/pipelines/github/hellonico/origami)
  - [Cuda Enabled NVidia Support](https://developer.nvidia.com/embedded/jetson-nano-developer-kit) included
  - [Architecture support matrix](http://origamidocs.hellonico.info/#/units/compatibility?id=origami-470-compatibility-matrix)
- On-going support for [Yolo v6](https://github.com/meituan/YOLOv6) <img style="height:20px;width:20px" src="doc/yolo.png" alt=""/>
- <img style="height:16px;width:16px" src="doc/doc.png" alt=""/>  <a href="https://hellonico.github.io/origami-docs/#/">Origami Docs</a>
- [codox](https://github.com/weavejester/codox) generated API is [here](http://origamidocs.hellonico.info/codox/index.html)
- Ready to use jupyter, [clojure notebooks](https://github.com/hellonico/origami-fun/tree/master/jupyter), [java notebooks](https://github.com/hellonico/opencv4_java_tutorial/tree/master/jupyter)
- Deep Neural Networks with [origami-dnn](https://github.com/hellonico/origami-dnn)
- Run on [AWS Lambdas](https://github.com/hellonico/origami-aws-lambdas)
- Real-time Streaming Server [App](https://github.com/hellonico/opencv-live-video-stream-over-http) 
- With [origami-sources](https://github.com/hellonico/origami-sources/)
  - use various sources (folders, zip files, dropbox, webcam, flickr etc..) to lazily load OpenCV Mat objects
  - use various handlers (You Tube, HTTPS etc...) to load VideoCapture objects

# ORIGAMI APPS

- [Booth](https://github.com/hellonico/opencv-javafx-camera)
- [Yololi](https://github.com/hellonico/yololi)
- [Streamer](https://github.com/hellonico/opencv-live-video-stream-over-http)
- [Viewer](https://github.com/hellonico/origami-viewer)

# Developed with

<a href="https://www.jetbrains.com/idea/">
<img title="idea" width="64" height="64" src="doc/idea.png"/>
</a>

<a href="https://cursive-ide.com/">
<img title="cursive" width="64" height="64" src="doc/cursive.png"/>
</a>

<a href="https://ko-fi.com/hellonico">
<img title="cursive" width="140" height="64" src="doc/ko-fi.webp"/>
</a>
