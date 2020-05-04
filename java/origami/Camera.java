package origami;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import origami.utils.Downloader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.function.Function;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.*;

public class Camera {
    VideoCapture cap;
    ImShow ims; //  = new ImShow("Origami");
    Function<Mat, Mat> filter = mat -> mat;

    boolean stop = false;
    private boolean pause;
    int skipFrames = 0;

    public int getSkipFrames() {
        return skipFrames;
    }

    public void setSkipFrames(int skipFrames) {
        this.skipFrames = skipFrames;
    }

    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            char key = e.getKeyChar();
            switch (key) {
                case '+':
                    skipFrames++;
//                System.out.printf(":skip:%d\n", skipFrames);
                    break;
                case '-':
                    if(skipFrames>0) skipFrames--;
//                System.out.printf(":skip:%d\n", skipFrames);
                    break;
                case 'd':
                    Downloader.debug();
                    break;
                case ' ':
                    Camera.this.pause = !Camera.this.pause;
                    break;
                case 'q':
                    Camera.this.stop = true;
                    break;
                case 'f':
                    Camera.this.fullscreen();
                    break;
                case 'p':
                    Camera.this.skipFilter = !Camera.this.skipFilter;
                    break;
                case 'r':
                    Camera.this.device(Camera.this.device);
                    Camera.this.pause = false;
                    break;
                case 's':
                    imwrite("origami_screenshot_"+new Date().toString().toLowerCase()+".jpg", Camera.this.buffer);
                default:
                    ;
            }
            e.consume();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };


    private boolean fullscreen = false;
    private Runnable exitTask;
    private Object device;
    private boolean skipFilter = false;


    public Camera() {
//        GraphicsDevice d = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                .getDefaultScreenDevice();
//        Dimension di = d.getFullScreenWindow().getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.ims = new ImShow("Origami", screenSize.width/2, screenSize.height/2);
        this.ims.Window.addKeyListener(kl);
    }

    public Camera cap(VideoCapture _cap) {
        this.cap = _cap;
        return this;
    }

    public Camera fullscreen() {
        this.fullscreen = !this.fullscreen;

        if(fullscreen)
            ims.enterFullScreen();
        else
            ims.exitFullScreen();

        return this;
    }

    public Camera size(int width, int height) {
        ims.Width = width;
        ims.Height = height; //= new ImShow("Origami", width, height);
//        this.ims.Window.addKeyListener(kl);
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
        int skip = 0;

        if (this.cap == null) {
            this.cap = new VideoCapture();
            this.cap.open(0);
        }

        while (!stop) {
            if(skipFrames<0) {
                skip++;
                if(skipFrames>-skip) {
                    continue;
                } else
                    skip=0;
            }

            if(pause || !this.cap.grab()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                continue;
            }

            if(skipFrames>0) {
                skip++;
                if(skipFrames>skip)
                    continue;
                else
                    skip=0;
            }


            try {
                this.cap.read(buffer);
                if(buffer.size().height==0 && buffer.size().width==0)
                    throw new Exception("Empty image ...");
                if (skipFilter)
                    this.ims.showImage(buffer);
                else
                    this.ims.showImage(this.filter.apply(buffer));

            } catch (Exception e) {
                System.out.printf("Reading error ... %s\n", e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    // ex.printStackTrace();
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

//        Camera c = ;
//        new Camera().size(400,300).device(0).filter(p).run();
        new Camera().device(0).filter(p).run();
                //.keyHandler(ked)
                //.fullscreen()
    }

}
