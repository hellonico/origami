package coffee;

import clojure.lang.PersistentList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import origami.Filter;
import origami.Filters;
import origami.Origami;
import origami.filter.ClojureFilter;
import origami.filter.NoOPFilter;

import java.io.File;

import static origami.Origami.FilterToString;
import static origami.Origami.StringToFilter;

@RunWith(JUnit4.class)
public class FilterTest {
    @Test
    public void loadOne() {
        Filter f = Origami.StringToFilter(NOOP_FILTER);
        Assert.assertTrue(f.getClass().equals(NoOPFilter.class));
    }

    @Test
    public void loadMany() {
        Filter f = Origami.StringToFilter("[" + NOOP_FILTER + " " + NOOP_FILTER + "]");
        Assert.assertTrue(f.getClass().equals(Filters.class));
    }

    String NOOP_FILTER = "{:class origami.filter.NoOPFilter}";

    @Test
    public void label() {
        Filter f = Origami.StringToFilter(NOOP_FILTER);
        String label = FilterToString(f);
        Assert.assertEquals(label, NOOP_FILTER);
    }

    @Test
    public void toFromFile() {
        File f = new File(ClassLoader.getSystemResource("noop.edn").getFile());
        Filter noopf = StringToFilter(f);
        Assert.assertEquals(noopf.getClass(), NoOPFilter.class);
    }

    @Test
    public void clojureFilter() {
            Origami.init();
            String function = "(fn[mat] (org.opencv.imgproc.Imgproc/applyColorMap mat mat 4) mat)";
            ClojureFilter cf = new ClojureFilter();
            cf.setFn(function);
            Mat me = Imgcodecs.imread("doc/lena.png");
            Mat me2 = cf.apply(me);
            Imgcodecs.imwrite("target/me2.png", me2);
    }

}
