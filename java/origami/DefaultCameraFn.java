package origami;

import org.opencv.core.Mat;

public class DefaultCameraFn implements CameraFn {
    @Override
    public Mat read(Camera cam, Mat buffer) {
        if (!cam.isHeadless()) {
            cam.ims.showImage(buffer);
        }
        return buffer;
    }
}
