package origami;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import org.opencv.core.Mat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filters implements Filter {
    public static class NoOP implements Filter{
        @Override
        public Mat apply(Mat in) {
            return in;
        }
    }
    List<Filter> filters;
//
//    public Filters(Class... __filters) {
//        List<Class> _filters = (List) Arrays.asList(__filters);
//        this.filters = _filters.stream().map(i -> {
//            try {
//                return (Filter) Class.forName(i.getName()).newInstance();
//            } catch (Exception e) {
//                return null;
//            }
//        }).collect(Collectors.toList());
//    }

    public Filters(Filter... __filters) {
        this.filters = (List) Arrays.asList(__filters);
    }

    @Override
    public Mat apply(Mat in) {
        Mat dst = in.clone();
        for (Filter f : filters) {
            dst = f.apply(dst);
        }
        return dst;
    }

}
