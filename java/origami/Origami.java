package origami;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.scijava.nativelib.NativeLoader;
import origami.video.VideoHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;

import static org.opencv.core.Core.getNumberOfCPUs;
import static org.opencv.imgcodecs.Imgcodecs.imencode;

public class Origami {

    /**
     * TODO: Should be calling the clojure function
     */
    public static BufferedImage matToBufferedImage(Mat frame) {
        int type = 0;
        if (frame.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if (frame.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        frame.get(0, 0, data);
        return image;
    }

    private static HashMap<String, VideoHandler> handlers = new HashMap<>();

    public static void registerVideoHandler(String prefix, VideoHandler handler) {
        handlers.put(prefix, handler);
    }

    public static VideoHandler getVideoHandler(String prefix) {
        System.out.println(prefix);
        System.out.println(handlers.toString());
        return handlers.get(prefix);
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat bufferedImagetoMat(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
    }

    private static final int BUFFER_SIZE = 8192;

    private static long copy(InputStream source, OutputStream sink) throws IOException {
        long nread = 0L;
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = source.read(buf)) > 0) {
            sink.write(buf, 0, n);
            nread += n;
        }
        return nread;
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat urlToMat(String url) throws IOException {
        return urlToMat(url, Imgcodecs.IMREAD_UNCHANGED);
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat urlToMat(String url, int flag) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (InputStream in = new URL(url).openStream()) {
            copy(in, byteArrayOutputStream);
        }
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), flag);
    }

    private static boolean isOpenCVLoaded() {
        try {
            return getNumberOfCPUs() != 0;
        } catch (UnsatisfiedLinkError e) {
            return false;
        }
    }

    public static void init() {
        try {
            System.out.printf("Loading: %s\n", Core.NATIVE_LIBRARY_NAME);
            if (isOpenCVLoaded()) {
                System.out.printf("Already loaded: %s\n", Core.NATIVE_LIBRARY_NAME);
            } else {
                NativeLoader.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                System.out.printf("Loaded: %s\n", Core.NATIVE_LIBRARY_NAME);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat grabOne(int camId) {
        VideoCapture vc = new VideoCapture();
        vc.open(camId);
        Mat img1 = new Mat();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        vc.read(img1);
        vc.release();
        return img1;
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat grabOne() {
        return grabOne(0);
    }

    /**
     * TODO: Should be calling the clojure function
     */
    public static Mat resize(Mat marcel, int resizeFactor) {
        Mat smallMarcel = new Mat();
        Imgproc.resize(marcel, smallMarcel, new Size(marcel.width() / resizeFactor, marcel.height() / resizeFactor));
        return smallMarcel;
    }

    // /**
    // * TODO: Should be calling the clojure function
    // */
    // static void cameraSettings(VideoCapture cap) {
    // String settings = String.format(
    // "Name:\t\t%s\nWidth:\t\t%s\nHeight:\t\t%s\nFPS:\t\t%s\nAperture:\t%s\nAutofocus:\t%s\nGain:\t\t%s\nGamma:\t\t%s\nBrightness:\t%s\nBackend:\t%s\nBacklight:\t%s\nContrast:\t%s\nSaturation:\t%s\nSharpness:\t%s\nZoom:\t\t%s\nBuffersize:\t%s\n",
    // "", cap.get(Videoio.CAP_PROP_FRAME_WIDTH),
    // cap.get(Videoio.CAP_PROP_FRAME_HEIGHT),
    // cap.get(Videoio.CAP_PROP_FPS), cap.get(Videoio.CAP_PROP_APERTURE),
    // cap.get(Videoio.CAP_PROP_AUTOFOCUS),
    // cap.get(Videoio.CAP_PROP_GAIN), cap.get(Videoio.CAP_PROP_GAMMA),
    // cap.get(Videoio.CAP_PROP_BRIGHTNESS),
    // cap.get(Videoio.CAP_PROP_BACKEND), cap.get(Videoio.CAP_PROP_BACKLIGHT),
    // cap.get(Videoio.CAP_PROP_CONTRAST), cap.get(Videoio.CAP_PROP_SATURATION),
    // cap.get(Videoio.CAP_PROP_SHARPNESS), cap.get(Videoio.CAP_PROP_ZOOM),
    // cap.get(Videoio.CAP_PROP_BUFFERSIZE));
    // System.out.println(settings);
    // }

    public static byte[] matToBytes(Mat frame) {
        MatOfByte matOfByte = new MatOfByte();
        imencode(".jpg", frame, matOfByte);
        return matOfByte.toArray();
    }

    static {
        Symbol cvu = (Symbol) Clojure.var("clojure.core", "symbol").invoke("opencv4.filter");
        Clojure.var("clojure.core", "require").invoke(cvu);
    }
    static final IFn sToF = Clojure.var("opencv4.filter", "s->filter");

    /**
     *
     * @see <a href="http://origamidocs.hellonico.info/#/units/filters">http://origamidocs.hellonico.info/#/units/filters</a>
     */
    public static Filter StringToFilter(Object s) {
        Object o = sToF.invoke(s);
        if (o instanceof Filter)
            return (Filter) o;
        else
            return new Filters((Filter[]) o);
    }

    static final IFn fToS = Clojure.var("opencv4.filter", "filter->s");

    public static String FilterToString(Object f) {
        return (String) fToS.invoke(f);
    }

    static {
        Symbol cvu = (Symbol) Clojure.var("clojure.core", "symbol").invoke("opencv4.video");
        Clojure.var("clojure.core", "require").invoke(cvu);
    }
    static final IFn captureDeviceFn = Clojure.var("opencv4.video", "capture-device");

    public static VideoCapture CaptureDevice(Object f) {
        return (VideoCapture) captureDeviceFn.invoke(f);
    }

}