package coffee;

import org.junit.Test;
import origami.Filter;
import origami.Origami;
import origami.tween.Orchestrator;
import origami.tween.Range;
import origami.tween.Tween;

public class TweenTest {

    public Tween getTestTween() {
        Range tween = new Range();
        tween.start = 10.0;
        tween.end = 11.0;
        tween.step = 0.1;
        tween.sleep = 50;
        tween.reverse = true;
        tween.fieldName = "rotationAngle";

        // TODO: round trip does not work here
        // String s = Origami.TweenToString(tween);
        // System.out.println(s);
        // return Origami.StringToTween(s);
        return tween;
    }

    @Test
    public void tweening() throws InterruptedException {
        Orchestrator a = new Orchestrator();
        Filter f = Origami.StringToFilter("{:class coffee.FakeFilter}");
        Tween tween = getTestTween();
        tween.target(f);
        a.addTween(tween);
        a.start();
        a.waitForAll();
    }
}
