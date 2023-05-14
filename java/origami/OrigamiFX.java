package origami;

import javafx.scene.image.Image;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import origami.Filter;
import origami.Filters;
import origami.Origami;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_REDUCED_COLOR_2;

public class OrigamiFX {

    public static Image file2FXImage(File imageFile) {
        String fileLocation = imageFile.toURI().toString();
        return new Image(fileLocation);
    }

    public static Image toFXImage(Mat mat) {
        MatOfByte buffer = new MatOfByte();
        Imgcodecs.imencode(".png", mat, buffer);
        return new Image(new ByteArrayInputStream(buffer.toArray()));
    }

    public static Image magic(String path, Filter f) {
        Mat m = Imgcodecs.imread(path, IMREAD_REDUCED_COLOR_2);
        Mat out = f.apply(m);
        return toFXImage(out);
    }

    public static Image magic(String path) {
        return magic(path, new Filters.NoOP());
    }

    public static void export(String path, String filter, String format, String _outputDir) {
        Filter f = Origami.StringToFilter(filter);
        File input = new File(path);
        Mat m = Imgcodecs.imread(input.getAbsolutePath());
        Mat out = f.apply(m);
        String outputDir = _outputDir == null ? input.getParent() : _outputDir;
        String outputFile = outputDir+ "/"+input.getName()+"." + format;
        Imgcodecs.imwrite(outputFile , out);
    }

    public static void exportAll(String path, String filter, String format, String _outputDir) {
        File input = new File(path).getParentFile();
        File outputDir = new File(_outputDir);
        outputDir.mkdirs();
        FilenameFilter f = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("png") || name.contains("jpg");
            }
        };
        for (File file : input.listFiles(f)) {
            export(file.getAbsolutePath(), filter, format, outputDir.getAbsolutePath());
        }
    }

    public static void exportAll(String path, String filter, String format) {
        File input = new File(path).getParentFile();
        String outputDir = input.getAbsolutePath()+"/origami";
        exportAll(path,filter,format,outputDir);
    }
}