package origami;

import org.opencv.core.Mat;

public interface CameraFn {

    Mat read(Camera cam, Mat buffer);
}
