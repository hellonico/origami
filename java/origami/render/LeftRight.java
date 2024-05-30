package origami.render;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgproc.Imgproc.*;

public class LeftRight implements Render{

    // Define the percentage width for the first image
    public double percentage = 0.4; // 40% for the first image

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Mat apply(Mat[] mats) {
        Mat image1 = mats[0];
        Mat image2 = mats[1];

        // Resize images to the same height (if necessary)
        int height = Math.max(image1.rows(), image2.rows());
        resize(image1, image1, new Size(image1.cols(), height));
        resize(image2, image2, new Size(image2.cols(), height));

        // Calculate the widths based on the percentage
        int totalWidth = image1.cols() + image2.cols();
        int width1 = (int) (totalWidth * percentage);
        int width2 = totalWidth - width1;

        // Resize images to fit the calculated widths
        resize(image1, image1, new Size(width1, height));
        resize(image2, image2, new Size(width2, height));

        // Create an empty mat to hold the combined image
        Mat combinedMat = new Mat(height, totalWidth, CvType.CV_8UC3);

        // Copy the left part (image1) into the combined mat
        Mat leftPart = combinedMat.colRange(0, width1);
        image1.copyTo(leftPart);

        // Copy the right part (image2) into the combined mat
        Mat rightPart = combinedMat.colRange(width1, totalWidth);
        image2.copyTo(rightPart);

        return combinedMat;
    }
}
