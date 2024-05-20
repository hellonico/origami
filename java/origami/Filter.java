package origami;

import clojure.lang.IFn;
import clojure.lang.ISeq;
import org.opencv.core.Mat;

public interface Filter extends IFn {
    Mat apply(Mat in);


    @Override
    default public Object invoke() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o) {
        return this.apply((Mat) o);
    }

    @Override
    default public Object invoke(Object o, Object o1) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18, Object o19) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object invoke(Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10, Object o11, Object o12, Object o13, Object o14, Object o15, Object o16, Object o17, Object o18, Object o19, Object... objects) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    default public Object applyTo(ISeq iSeq) {
        // TODO: should apply to all elements in the list
        throw new RuntimeException("Not Implemented");
    }


    @Override
    default void run() {
        System.out.println("Using run in filter");
    }

    @Override
    default Object call() throws Exception {
        System.out.println("Using call in filter");
        return null;
    }
}
