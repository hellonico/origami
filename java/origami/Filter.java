package origami;

import org.opencv.core.Mat;

import java.util.function.Function;

@FunctionalInterface
public interface Filter extends Function<Mat,Mat> {
    Mat apply(Mat in);
}
