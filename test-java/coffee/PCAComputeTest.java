package coffee;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import origami.Origami;

import java.util.Vector;

public class PCAComputeTest {

    @Test
    /*
     * https://www.bytefish.de/blog/pca_in_opencv.html
     */
    public void pcaComputeTest() {
        Origami.init();
        Vector<Mat> trainingImages = new Vector<Mat>();
        trainingImages.add(Imgcodecs.imread("doc/nico/face1.jpg"));
        trainingImages.add(Imgcodecs.imread("doc/nico/face2.jpg"));

        for (Mat image : trainingImages) {
            Mat gray = new Mat();
            Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
        }

        Mat x = trainingImages.get(0);
        int total = x.rows() * x.cols();
        // build matrix (column)
        // This matrix will have one col for each image and imagerows x imagecols rows
        Mat mat = new Mat(total, trainingImages.size(), CvType.CV_32FC1);
        for (int i = 0; i < trainingImages.size(); i++) {
            Mat X = mat.col(i);
            Mat c = trainingImages.get(i);
            c.reshape(1, total).convertTo(X, CvType.CV_32FC1);
        }
        Mat eigenVectors = new Mat();
        Mat mean = new Mat();
        Core.PCACompute(mat, mean, eigenVectors);
        System.out.println(eigenVectors);
    }
}
