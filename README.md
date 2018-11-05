![](doc/new.png) 

**Support for OpenCV4-beta is in.**

Origami is an opencv generated wrapper for Clojure which allows some of the opencv code to be written in a concise way, by putting emphasis on processing pipelines.

![](doc/origami.jpg)

> After staring at origami directions long enough, you sort of become one with them and start understanding them from the inside.
> Zooey Deschanel

```
(require
  '[opencv4.utils :as u]
  '[opencv4.core :refer :all])

(->
 (imread "doc/cat_in_bowl.jpeg")
 (cvt-color! COLOR_RGB2GRAY)
 (canny! 300.0 100.0 3 true)
 (bitwise-not!)
 (u/resize-by 0.5)
 (imwrite "doc/canny-cat.jpg"))
```

<img src="doc/cat_in_bowl.jpeg" width="50%" height="50%"/>

<img src="doc/canny-cat.jpg" width="50%" height="50%"/>

# NEWS! Book is out!!

[Java Image Processing Recipes: With OpenCV and JVM](http://a.co/3iImWz7) published by Apress will show you all the tricks to play and produce art and understand the underlying concepts of origami.

<img src="
https://images-na.ssl-images-amazon.com/images/I/51ZC5LMjvRL.jpg" width="50%" height="50%"/>


# Getting Started 

## Required Software to install

- install jdk 1.8
- install [leiningen](https://leiningen.org/#install) (it is a simple script ...)
- that's it ! (as in, no need to install anyother OpenCV thing ...)

## to use

Create a brand new origami based project using a Leiningen project template

```
# install the sample
lein new clj-opencv hello-origami

# change directory

cd hello-origami

# run the template simple example
lein run
# or ..
clj -m opencv4.ok
```
You can also clone the origami samples project:

```
git clone https://github.com/hellonico/origami_samples.git
```

# Running the samples


Some examples are included in the project template.

Origami Setup Check (including OpenCV native dependencies check)
```
lein run -m opencv4.ok
```

Some Simple OpenCV transformation using origami
```
lein run -m opencv4.simple
```

A more advanced set of imaging transformation.
```
lein run -m opencv4.tutorial
```

Webcam Sample
```
lein run -m opencv4.videosample
```

Gorilla Based Notebook

```
lein notebook
```

And two notebooks are included in the project template:

- [http://0.0.0.0:10000/worksheet.html?filename=notes/practice.clj](http://0.0.0.0:10000/worksheet.html?filename=notes/practice.clj)
- [http://0.0.0.0:10000/worksheet.html?filename=notes/empty.clj](http://0.0.0.0:10000/worksheet.html?filename=notes/empty.clj)

# more samples

For many, many more examples, you can also clone and check the [https://github.com/hellonico/opencv-fun](opencv-fun) repository:

```
git clone https://github.com/hellonico/opencv-fun.git
```

# compatibility notes

| Distribution | Version    | Status | Comments                                                    |
| ------------ | ---------- | :----: | ----------------------------------------------------------- |
| OSX          | Mojave     |   o    |                                                             |
| Windows      | 10         |   o    |                                                             |
| Ubuntu 18    | glibc 2.27 |   o    | Compiled with 2.27                                          |
| Manjaro      | glibc 2.28 |   o    | Compiled with 2.27                                          |
| Debian       | glibc 2.27 |   o    | Compiled with 2.27                                          |
| Old Debian   | glibc 2.19 |   △    | Compiled with 2.19<br />Needs a different opencv native jar |

Bonus link to see what is compatible. https://abi-laboratory.pro/?view=timeline&l=glibc

To try the slightly old setup for linux, you can use this repository:

https://github.com/hellonico/origami_samples_libc2_19

# electron based IDE

An experimental self-contained native application for windows and osx can be downloaded from the following project:

https://github.com/hellonico/origami-electron/releases

<img src="doc/electron-osx.png" width="50%" height="50%"/>

<img src="doc/electron-windows.png" width="50%" height="50%"/>

@Copyright Nicolas Modrzyk - 2017-2018
Eclipse Public License 