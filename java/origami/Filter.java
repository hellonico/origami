package origami;

import org.opencv.core.Mat;

public interface Filter {
    Mat apply(Mat in);
}
