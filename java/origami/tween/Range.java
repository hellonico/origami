package origami.tween;

import java.lang.reflect.Field;

public class Range extends Tween {

    public double start = 20;
    public double end = 300;
    public double step = 2;
    public int sleep = 500;
    public boolean reverse = false;

    public boolean loop;

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public boolean bounce = false;

    public boolean isBounce() {
        return bounce;
    }

    public void setBounce(boolean bounce) {
        this.bounce = bounce;
    }

    public void run() {
        try {

            do {
                Field field = target.getClass().getDeclaredField(fieldName);
                if (reverse) {
                    for (double i = end; i > start; i = i - step) {
                        Thread.sleep(sleep);
                        setFieldValue(i);
                    }
                } else {
                    for (double i = start; i < end; i = i + step) {
                        Thread.sleep(sleep);
                        setFieldValue(i);
                    }
                }
                if (bounce) {
                    reverse = !reverse;
                }

            } while (loop);
        } catch (Exception e) {
            System.out.println("Finishing:" + this.getClass().getSimpleName() + ">" + e.getMessage());
//            e.printStackTrace();
            //
        }
    }

}
