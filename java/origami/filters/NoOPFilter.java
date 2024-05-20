package origami.filters;

import clojure.lang.ISeq;
import org.opencv.core.Mat;
import origami.Filter;

public class NoOPFilter implements Filter {
    public Mat apply(Mat in) {
        return in;
    }

}
