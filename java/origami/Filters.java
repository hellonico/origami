package origami;

import java.util.Arrays;
import java.util.List;

import org.opencv.core.Mat;

public class Filters implements Filter {
    public static class NoOP implements Filter {
        @Override
        public Mat apply(Mat in) {
            return in;
        }
    }

    List<Filter> filters;

    public Filters(Filter... __filters) {
        this.filters = (List) Arrays.asList(__filters);
    }

    public Filters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public Mat apply(Mat dst) {
        for (Filter f : filters) {
            dst = f.apply(dst);
        }
        return dst;
    }

}
