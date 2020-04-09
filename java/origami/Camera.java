package origami;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.awt.*;
import java.util.function.Function;

import static org.opencv.imgproc.Imgproc.*;

public class Camera {
    VideoCapture cap;
    ImShow ims = new ImShow("Origami");
    Function<Mat, Mat> filter = mat -> mat;

    static boolean stop = false;
    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            stop = true;
            return true;
        });
    }

    private boolean fullscreen = false;


    public Camera() {
        
    }

    private void exitFullScreen() {
        this.ims.Window.setVisible(false);
//        this.ims.Window.dispose();
        GraphicsDevice var3 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        var3.setFullScreenWindow(null);
    }


    public Camera cap(VideoCapture _cap) {
        this.cap = _cap;
        return this;
    }

    public Camera fullscreen() {
        ims = new ImShow("Origami", true);
        this.fullscreen = true;
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
            cap = new VideoCapture();
            cap.open((String) o);
        } else if (o instanceof Integer) {
            cap = new VideoCapture();
            cap.open((Integer) o);
        } else {
            throw new RuntimeException("Invalid value for device");
        }
        return this;
    }

    public void run() {
        stop = false;
        if (this.cap == null) {
            this.cap = new VideoCapture();
            this.cap.open(0);
        }

        Mat var1 = new Mat();

        while (!stop && this.cap.grab()) {
            this.cap.retrieve(var1);
            this.ims.showImage((Mat) this.filter.apply(var1));
        }

        this.cap.release();

        if(this.fullscreen)
            exitFullScreen();
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
