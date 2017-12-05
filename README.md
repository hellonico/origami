Origami is an opencv generated wrapper for Clojure which allows some of the opencv code to be written in a concise way.

![](doc/origami.jpg)

> After staring at origami directions long enough, you sort of become one with them and start understanding them from the inside.
> Zooey Deschanel


```
(require
  '[opencv3.utils :as u]
  '[opencv3.core :refer :all])

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

### Getting Started 

#### Required Software to install

- install jdk 1.8
- install [leiningen](https://leiningen.org/#install) (it is a simple script ...)
- that's it ! (as in, no need to install anyother OpenCV thing ...)

#### to use

Create a brand new origami based project using a Leiningen project template

```
# install the sample
lein new clj-opencv fun-with-opencv

# run the template simple example
cd fun-with-opencv
lein run

```

or you can also clone the origami examples:

```
git clone https://github.com/hellonico/opencv-fun.git
```


#### 