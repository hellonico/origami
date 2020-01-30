package coffee;

import org.junit.Test;
import origami.Dnn2;
import origami.Origami;

import static org.junit.Assert.assertNotNull;

public class DnnTest {

    @Test
    public void simpleLoad() {
        Origami.init();
        assertNotNull(Dnn2.readNetFromSpec("networks.yolo:yolov2-tiny:1.0.0"));
    }

}
