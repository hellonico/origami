package origami;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.util.function.Function;

import static org.opencv.imgproc.Imgproc.*;

public class Camera {
    VideoCapture cap;
    ImShow ims = new ImShow("Origami");
    Function<Mat, Mat> filter = mat -> mat;

    public Camera() {
        
    }

    public Camera fullscreen() {
        ims = new ImShow("Origami", true);
        return this;
    }

    public Camera size(int width, int height) {
        ims = new ImShow("Origami", width,height);
        return this;
    }

    public Camera filter(Function<Mat, Mat> filter) {
        this.filter = filter;
        return this;
    }

    public Camera filter(Filter filter) {
        this.filter = mat -> filter.apply(mat);
        return this;
    }

    public Camera device(Object o) {
        if (o instanceof String) {
            cap = new VideoCapture((String) o);
        } else if (o instanceof Integer) {
            cap = new VideoCapture((Integer) o);
        } else {
            throw new RuntimeException("Invalid value for device");
        }
        return this;
    }

    public void run() {
        if(cap==null) {
            cap = new VideoCapture(0);
        }
        Mat matFrame = new Mat();
        while (cap.grab()) {
            cap.retrieve(matFrame);
            ims.showImage(filter.apply(matFrame));
        }
    }

    public static void main(String[] args) throws Exception {
        Origami.init();
        Filter p = mat -> {
            Imgproc.cvtColor(mat, mat, COLOR_BGR2GRAY);
            cvtColor(mat, mat, COLOR_GRAY2BGR);
            return mat;
        };
        new Camera().device(0).fullscreen().filter(p).run();
    }

}
