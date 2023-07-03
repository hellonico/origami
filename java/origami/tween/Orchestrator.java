package origami.tween;

import origami.Filter;

import java.util.ArrayList;

public class Orchestrator extends Thread {

    ArrayList<Runnable> threads = new ArrayList<Runnable>();
    ThreadGroup tg =  new ThreadGroup("tween");
    ArrayList<Thread> running = new ArrayList<Thread>();
    public void addTween(Runnable t) {
        if(t instanceof Tweens) {
            Tweens ts = (Tweens) t;
            threads.addAll(ts.tweens);
        } else {
            threads.add(t);
        }
    }

//    public void setTarget(Filter f) {
//        for(Tween tw : ts.tweens) {
//            addTween(tw);
//        }
//        t.field("last");
//    }

    public void start() {

        for(Runnable t : threads) {
            Thread _t = new Thread(tg,t, t.getClass().getSimpleName());
            running.add(_t);
            _t.start();
        }

    }

    public void clear() {
        threads.clear();
        running.clear();
    }

    public void waitForAll() throws InterruptedException {

        for(Thread t : running) {
            t.join();
        }
    }

    public void stopAll() {
        for(Thread t : running) {
            t.interrupt();
        }

    }

}
