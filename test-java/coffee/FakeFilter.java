package coffee;

import org.opencv.core.Mat;
import origami.Filter;

public class FakeFilter implements Filter {

    public double rotationAngle = 2.0;

    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    @Override
    public Mat apply(Mat in) {
        return null;
    }
}
