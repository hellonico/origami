package origami;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.opencv.core.Mat;
import origami.Filter;

public class Filters implements Filter {
    List<Filter> filters;

    public Filters(Class... __filters) {
        List<Class> _filters = (List) Arrays.asList(__filters);
        this.filters = _filters.stream().map(i -> {
            try {
                return (Filter) Class.forName(i.getName()).newInstance();
            } catch (Exception e) {
                return null;
            }
        }).collect(Collectors.toList());
    }

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
