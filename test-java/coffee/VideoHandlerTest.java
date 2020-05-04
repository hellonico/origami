package coffee;

import org.junit.Assert;
import org.junit.Test;
import origami.Camera;
import origami.Origami;
import origami.utils.Downloader;
import origami.video.HttpVideoHandler;

import java.io.File;
import java.io.IOException;

public class VideoHandlerTest {

    @Test
    public void testHandler() throws IOException {
        Origami.init();
        Origami.registerVideoHandler("http", new HttpVideoHandler());
//        VideoCapture vc = Origami.CaptureDevice();
//        new Camera().device("http://mirrors.standaloneinstaller.com/video-sample/star_trails.mov").run();

        String targetFile = "target/starts.mov";
        Downloader.transfer("http://mirrors.standaloneinstaller.com/video-sample/star_trails.mov", targetFile);
        Assert.assertTrue(new File(targetFile).exists());
    }
}