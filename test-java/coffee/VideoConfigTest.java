package coffee;

import org.junit.Assert;
import org.junit.Test;
import origami.Origami;
import origami.utils.Downloader;
import origami.video.HttpVideoHandler;

import java.io.File;
import java.io.IOException;

public class VideoConfigTest {

    @Test
    public void testConfig() throws IOException {
        Origami.init();
        Origami.CaptureDevice("{:device 0}");
    }
}