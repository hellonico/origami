package coffee;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.junit.Test;
import origami.Origami;

import java.util.List;

import static org.junit.Assert.assertNotNull;

class Dnn2 {
    static {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("opencv4.dnn.core"));
    }
    static IFn plus = Clojure.var("opencv4.dnn.core", "read-net-from-repo");
    public static java.util.List readNetFromSpec(String spec) {
        return (List) plus.invoke(spec);
    }
}
public class DnnTest {
    @Test
    public void simpleLoad() {
        Origami.init();
        assertNotNull(Dnn2.readNetFromSpec("networks.yolo:yolov2-tiny:1.0.0"));
    }

}
