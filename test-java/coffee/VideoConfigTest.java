package coffee;

import clojure.lang.Keyword;
import clojure.lang.PersistentArrayMap;
import org.junit.Assert;
import org.junit.Test;
import origami.CameraConfigMap;
import origami.Origami;
import origami.utils.Downloader;
import origami.video.HttpVideoHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import static origami.Origami.*;

public class VideoConfigTest {

    @Test
    public void testConfig() throws IOException {
        init();
        CaptureDevice("{:device 0}");
    }


    @Test
    public void testConfig2() throws IOException {
        init();
        CameraConfigMap conf = ReadConfigMap("{:device 0 :slow 100}");
        for(Object c : conf.keySet()) {
            System.out.println(c+":"+conf.getString((String) c));
        }
        // System.out.println(conf.get(Keyword.intern("slow")));
    }
}