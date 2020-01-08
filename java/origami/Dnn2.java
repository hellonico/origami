package origami;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import java.util.List;

public class Dnn2 {
    static {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("opencv4.dnn.core"));
    }
    static IFn plus = Clojure.var("opencv4.dnn.core", "read-net-from-repo");

    public static void main(String... args) {
        readNetFromSpec("networks.yolo:yolov2-tiny:1.0.0");
    }

    public static java.util.List readNetFromSpec(String spec) {
        return (List) plus.invoke(spec);
    }
}


