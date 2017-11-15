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


![](output/cat_in_bowl.jpeg)

![](output/canny-cat.jpg)
