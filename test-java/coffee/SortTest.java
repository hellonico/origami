package coffee;

import org.junit.Assert;
import org.junit.Test;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;

import static java.lang.System.out;
import static org.opencv.core.Core.*;
import static origami.Origami.init;

public class SortTest {

    @Test
    public void ReshapeAndSortTest() {
        init();
        MatOfFloat top5RefScores = new MatOfFloat(0.63032645f, 0.032181446f, 0.015721032f, 0.2561979f, 0.014785315f);
        out.println(top5RefScores.dump());
        Mat top5RefScores_ = top5RefScores.reshape(1, 1);
        out.println(top5RefScores_.dump());
        sort(top5RefScores_, top5RefScores_, SORT_DESCENDING);
        out.println(top5RefScores_.dump());

        MatOfFloat expected = new MatOfFloat();
        expected.fromArray(0.63032645f, 0.2561979f, 0.032181446f, 0.015721032f, 0.014785315f);

        top5RefScores_ = top5RefScores.reshape(1, 5);

        System.out.println(top5RefScores_.dump());
        System.out.println(expected.dump());

        Assert.assertEquals(expected.dump(), top5RefScores_.dump());
    }
}
