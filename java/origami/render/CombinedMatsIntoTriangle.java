package origami.render;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import origami.Origami;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.Core.*;
import static org.opencv.imgproc.Imgproc.*;

public class CombinedMatsIntoTriangle implements Render{

    public Mat apply(Mat... mats) {

        Mat image1 = mats[0];
        Mat image2 = mats[1];

        resize(image2, image2, image1.size());

        // Create an empty mat with 3 channels for the result
        Mat combinedMat = Mat.zeros(image1.size(), CvType.CV_8UC3);

        // Create a single-channel mat for the triangle
        Mat triangleMat = Mat.zeros(image1.size(), CvType.CV_8UC1);

        // Define the points for the triangle
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);                    // Top-left corner
        points[1] = new Point(0, triangleMat.rows());   // Bottom-left corner
        points[2] = new Point(triangleMat.cols() / 2, triangleMat.rows() / 2); // Center

        // Create a mask with the triangle filled in white
        MatOfPoint matOfPoint = new MatOfPoint(points);
        List<MatOfPoint> listOfPoints = new ArrayList<>();
        listOfPoints.add(matOfPoint);

        fillPoly(triangleMat, listOfPoints, new Scalar(255));

        // Create the inverted mask
        Mat invertedMaskMat = new Mat();
        bitwise_not(triangleMat, invertedMaskMat);

        // Copy image1 to the combinedMat using the triangle mask
        image1.copyTo(combinedMat, triangleMat);

        // Copy image2 to the combinedMat using the inverted mask
        image2.copyTo(combinedMat, invertedMaskMat);

        return combinedMat;
    }

    public static void main(String[] args) {
        Origami.init();

        // Load the two images
        Mat image1 = Imgcodecs.imread("data/aloeL.jpg");
        Mat image2 = Imgcodecs.imread("data/apple.jpg");

        // Display the combined mat
        HighGui.imshow("Combined Mat", new CombinedMatsIntoTriangle().apply(image1, image2));
        HighGui.waitKey();
    }
}
