package origami;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;

import java.util.List;
import java.util.stream.Collectors;

public interface Detect {
    List<Rect> detectROI(Mat mat);

    default List<Mat> detectMats(Mat input) {
        List<Rect> faces = detectROI(input);
        return faces.stream().map(rect -> input.submat(new Rect(new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height))).clone()).collect(Collectors.toList());
    }

    default boolean detected(Mat input) {
        return detectROI(input).size() != 0;
    }
}
