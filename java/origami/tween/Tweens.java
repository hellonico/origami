package origami.tween;

import java.util.Arrays;
import java.util.List;

public class Tweens extends Tween {

    List<Tween> tweens;

    @Override
    public Tween target(Object f) {
        super.target(f);
        for(Tween t : tweens) {
            t.target(f);
        }
        return this;
    }

    public Tweens(Tween... __filters) {
        this.tweens = (List) Arrays.asList(__filters);
    }

    public Tweens(List<Tween> filters) {
        this.tweens = filters;
    }

    public List<Tween> getTweens() {
        return tweens;
    }

    public void setTweens(List<Tween> filters) {
        this.tweens = filters;
    }


    @Override
    public void run() {

    }
}
