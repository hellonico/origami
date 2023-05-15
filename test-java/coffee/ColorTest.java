package coffee;

import org.junit.Assert;
import org.junit.Test;
import origami.colors.HTML;

import java.math.BigInteger;

public class ColorTest {

    @Test
    public void midnightTest() {
        String htmlColor = "#F61515";
        Assert.assertEquals(HTML.toHTML(HTML.toScalar(htmlColor)),htmlColor);
    }
}
