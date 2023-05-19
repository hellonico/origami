package origami;

import clojure.lang.Keyword;
import clojure.lang.PersistentArrayMap;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import origami.utils.Downloader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Function;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.*;

public class Camera {
    VideoCapture cap;
    public ImShow ims; //  = new ImShow("Origami");
    Function<Mat, Mat> filter = mat -> mat;

    boolean stop = false;
    private boolean pause;
    private boolean headless = false;
    private boolean recording;
    private Mat last;
    private CameraConfigMap configMap;

    public Camera headless() {
        this.headless = !this.headless;
        return this;
    }

    public CameraFn getFn() {
        return fn;
    }

    public Camera setFn(CameraFn fn) {
        this.fn = fn;
        return this;
    }

    CameraFn fn = new DefaultCameraFn();

    public VideoCapture VC() {
        return this.cap;
    }


    public boolean isHeadless() {
        return headless;
    }

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
                    if (skipFrames > 0) skipFrames--;
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
                    // Camera.this.ims.Window.ex
                    break;
                case 'f':
                    Camera.this.fullscreen();
                    break;
                case 'p':
                    Camera.this.skipFilter = !Camera.this.skipFilter;
                    break;
                case 'r':
                    Camera.this.pause = false;
                    Camera.this.stop = false;
                    Camera.this.device(Camera.this.device);
                    break;
                case 's':
                    imwrite("origami_screenshot_" + new Date().toString().toLowerCase() + ".jpg", Camera.this.buffer);
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

    public boolean isSkipFilter() {
        return skipFilter;
    }

    public Camera skipFilter(boolean skipFilter) {
        this.skipFilter = skipFilter;
        return this;
    }

    public Mat getBuffer() {
        return buffer.clone();
    }

    private Mat buffer = new Mat();


    public Camera() {
//        GraphicsDevice d = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                .getDefaultScreenDevice();
//        Dimension di = d.getFullScreenWindow().getSize();
        setupFrame();
    }

    private void setupFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (this.ims == null) {
            this.ims = new ImShow("Origami", screenSize.width / 2, screenSize.height / 2);
            this.ims.setResizable(true);
            this.ims.Window.addKeyListener(kl);
        }
    }

    public Camera cap(VideoCapture _cap) {
        this.cap = _cap;
        return this;
    }

    public Camera hideOnClose() {
        this.ims.setCloseOption(DISPOSE_ON_CLOSE);
        return this;
    }

    public Camera exitOnClose() {
        this.ims.setCloseOption(EXIT_ON_CLOSE);
        return this;
    }

    public Camera fullscreen() {
        this.fullscreen = !this.fullscreen;

        if (fullscreen)
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
        configMap = null;
        this.device = o;
        // that's opening the stream so not here
        // cap = Origami.CaptureDevice(o);
        configMap = new CameraConfigMap(o);
        this.slowDown(configMap.getLong("slow", 0));

        return this;
    }

    public Camera stop() {
        this.stop = true;
        return this;
    }

    long slow = 0;

    public long getSlow() {
        return slow;
    }

    public Camera slowDown(long slow) {
        this.slow = slow;
        return this;
    }

    public void run() {
        stop = false;

        if (!headless)
            setupFrame();

        if (this.cap == null) {
            if (this.configMap == null) {
                device("{:device 0}");
            }
            this.cap = configMap.openVideoCapture();
        } else {
            if (this.cap.isOpened()) {
                this.cap.release();
                this.cap = configMap.openVideoCapture();
            }
        }

        myLoop:
        while (!stop) {
            if (slow != 0) {
                try {
                    Thread.sleep(slow);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            if (skipFrames < 0) {
//                skip++;
//                if (skip < -1 * skipFrames) {
//                    continue myLoop;
//                }
//            }

            if (pause || !this.cap.grab()) {
                try {
                    // pausing
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                continue;
            }

//            if (skipFrames > 0) {
//                skip++;
//                if (skipFrames > skip)
//                    continue myLoop;
//            }

            try {
                step();
            } catch (Exception e) {
                System.out.printf("Reading error ... %s\n", e.getMessage());
            }

        }
        onVideoStop();


    }

    public void step() {
        if(this.cap !=null && this.cap.isOpened())
            this.cap.read(buffer);

        boolean check = buffer.size().height == 0 && buffer.size().width == 0;
        if(!check) {
            Mat filtered = skipFilter ? buffer : this.filter.apply(buffer);
            last = fn.read(this, filtered);
        }
    }

    public void onVideoStop() {
        this.cap.release();
        this.cap = null;

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

        // TODO: check
        //    ims.Window.dispatchEvent(new WindowEvent(ims.Window, WindowEvent.WINDOW_CLOSING));
    }

    public Mat last() {
        return last;
    }

    public void record() {
        recording = !recording;
        if (!recording) {
            return;
        }

        new Thread(() -> {

            VideoWriter vw = new VideoWriter();

            String code = configMap.getString("recordingFormat", "mjpg");
            long recordingSlow = configMap.getLong("recordingSlow", 1);
            String filename = configMap.getString("recordingFile", "stream_" + LocalDateTime.now() + ".mp4");

            // https://softron.zendesk.com/hc/en-us/articles/207695697-List-of-FourCC-codes-for-video-codecs
            // slow but compatible ?
            // fast but only for osx
            // TODO: should in settings
            // String code = "avc1";
            int fourcc = VideoWriter.fourcc(code.charAt(0), code.charAt(1), code.charAt(2), code.charAt(3));

            vw.open(filename, fourcc, 240, last.size());

            while (recording) {
                if (!stop) {
                    vw.write(last);
                    try {
                        Thread.sleep(recordingSlow);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            vw.release();
            System.out.println("recording saved:" + filename);
        }).start();

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
        //.keyHandler(ked)
        //.fullscreen()


        //Camera c = new Camera().headless().device(0).filter(p);
        Camera c = new Camera().device("{:device 0 :slow 0}").filter(p);
        Thread t = new Thread(c::run);

        System.out.println("starting");
        t.start();

        Thread.sleep(3000);
        // enter
        c.fullscreen();
        Thread.sleep(3000);
        c.fullscreen();

        Thread.sleep(10000);
        System.out.println("stopping");
        c.stop();
        Mat b = c.getBuffer();
        imwrite("headless_after_5_seconds.png", b);

    }

}
