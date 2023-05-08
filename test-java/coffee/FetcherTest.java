package coffee;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.junit.Test;
import origami.Origami;


import static org.junit.Assert.assertNotNull;

/**
 * Same as DnnTest, we need this workaround to test the clojure code, because of cyclic dependencies.
 * Eventually, we can just use Fetcher when from outside this project.
 */
class Fetcher2 {
    static {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("opencv4.fetcher"));
    }

    static IFn fetch = Clojure.var("opencv4.fetcher", "fetch-from-spec");

    public static String fetchFromSpec(String spec) {
        return (String) fetch.invoke(spec);
    }
}

public class FetcherTest {
    @Test
    public void simpleLoad() {
        Origami.init();
        assertNotNull(Fetcher2.fetchFromSpec("networks.yolo:yolov6A:1.0"));
    }
}
