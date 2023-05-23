package coffee;

import org.junit.Assert;
import org.junit.Test;
import origami.colors.HTML;
import origami.colors.Palette;

import java.math.BigInteger;

public class ColorTest {

    @Test
    public void midnightTest() {
        String htmlColor = "#F61515";
        Assert.assertEquals(HTML.toHTML(HTML.toScalar(htmlColor)),htmlColor);
    }

    @Test
    public void noSharpColorTest() {
        Assert.assertNotNull(HTML.toScalar("f61515"));
    }

    @Test
    public void paletteTest() {
        String paletteName = "sunrise2";
        Assert.assertEquals(6,Palette.get("sunrise2", true).size());
    }
}
