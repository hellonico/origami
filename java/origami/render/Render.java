package origami.render;

import org.opencv.core.Mat;

public interface Render {
    public Mat apply(Mat[] mats);
}
