package origami;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.function.Function;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.*;

public class Camera {
    VideoCapture cap;
    ImShow ims = new ImShow("Origami");
    Function<Mat, Mat> filter = mat -> mat;

    boolean stop = false;
    private boolean pause;

    KeyEventDispatcher ked = e -> {
        char key = e.getKeyChar();
        switch (key) {
            case ' ':
                this.pause = !this.pause;
                break;
            case 'q':
                this.stop = true;
                break;
            case 'f':
                this.fullscreen();
                break;
            case 'p':
                this.skipFilter = !this.skipFilter;
                break;
            case 'r':
                this.device(this.device);
                this.pause = false;
                break;
            case 's':
                imwrite("origami_screenshot_"+new Date().toString().toLowerCase()+".jpg", this.buffer);
            default:
                ;
        }

        return true;
    };

    private boolean fullscreen = false;
    private Runnable exitTask;
    private Object device;
    private boolean skipFilter = false;


    public Camera() {
        this.keyHandler(ked);
    }

    public Camera cap(VideoCapture _cap) {
        this.cap = _cap;
        return this;
    }

    public Camera fullscreen() {
        this.fullscreen = !this.fullscreen;
        // ims.Window.dispose();

        if(fullscreen)
            ims.enterFullScreen();
        else
            ims.exitFullScreen();

        return this;
    }

    public Camera size(int width, int height) {
        ims = new ImShow("Origami", width, height);
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
        this.device = o;
        cap = Origami.CaptureDevice(o);
        return this;
    }


    Mat buffer = new Mat();
    public void run() {
        stop = false;
        if (this.cap == null) {
            this.cap = new VideoCapture();
            this.cap.open(0);
        }


        while (!stop) {
            if(pause) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                continue;
            }
            try {
                this.cap.grab();
                this.cap.retrieve(buffer);
                if (skipFilter)
                    this.ims.showImage(buffer);
                else
                    this.ims.showImage(this.filter.apply(buffer));

            } catch (Exception e) {
                System.out.printf("Reading error ... %s\n", e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }

        this.cap.release();

        if (this.fullscreen)
            this.ims.exitFullScreen();

        if (this.exitTask != null) {
            Thread t = new Thread(exitTask);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        ims.Window.dispatchEvent(new WindowEvent(ims.Window, WindowEvent.WINDOW_CLOSING));
    }

    public Camera keyHandler(KeyEventDispatcher ked) {
//        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(ked);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(ked);
        return this;
    }

    public Camera exitTask(Runnable r) {
        this.exitTask = r;
        return this;
    }

    public static void main(String[] args) throws Exception {
        Origami.init();
        Filter p = mat -> {
            cvtColor(mat, mat, COLOR_BGR2GRAY);
            cvtColor(mat, mat, COLOR_GRAY2BGR);
            return mat;
        };

        Camera c = new Camera();
        c.size(400,300);
        c.device(0)
                //.keyHandler(ked)
                //.fullscreen()
                .filter(p).run();
    }

}
