package origami.render;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class FourToOne implements Render{
    @Override
    public Mat apply(Mat[] mats) {
        Mat mat1 = mats[0];
        Mat mat2 = mats[1];
        Mat mat3 = mats[2];
        Mat mat4 = mats[3];

        // Resize each Mat to half its size
        Size size = new Size((double) mat1.cols() / 2, (double) mat1.rows() / 2);
        Mat resizedMat1 = new Mat();
        Mat resizedMat2 = new Mat();
        Mat resizedMat3 = new Mat();
        Mat resizedMat4 = new Mat();
        Imgproc.resize(mat1, resizedMat1, size);
        Imgproc.resize(mat2, resizedMat2, size);
        Imgproc.resize(mat3, resizedMat3, size);
        Imgproc.resize(mat4, resizedMat4, size);

        // Create a new Mat that is the same size as the original Mats
        Mat combinedMat = new Mat(mat1.rows(), mat1.cols(), mat1.type());

        // Copy each resized Mat to the appropriate quadrant
        resizedMat1.copyTo(combinedMat.submat(new Rect(0, 0, (int) size.width, (int) size.height)));
        resizedMat2.copyTo(combinedMat.submat(new Rect((int) size.width, 0, (int) size.width, (int) size.height)));
        resizedMat3.copyTo(combinedMat.submat(new Rect(0, (int) size.height, (int) size.width, (int) size.height)));
        resizedMat4.copyTo(combinedMat.submat(new Rect((int) size.width, (int) size.height, (int) size.width, (int) size.height)));

        return combinedMat;

    }
}
