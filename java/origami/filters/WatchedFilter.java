package origami.filters;

import org.opencv.core.Mat;
import origami.Filter;
import origami.Origami;
import origami.utils.FileWatcher;

import java.io.File;

public class WatchedFilter implements Filter {
    Filter internal;
    String filePath;
    FileWatcher watcher;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        internal = Origami.StringToFilter(filePath);
        if(watcher!=null) {
            watcher.stopThread();
            watcher = null;
        }
        watcher = new FileWatcher(new File(filePath)) {
            @Override
            public void doOnChange() {
                try {
                    internal = Origami.StringToFilter(filePath);
                } catch (Exception e) {
                    System.out.printf("could not load filter file: %s\n", filePath);
                }
            }
        };
        watcher.start();
    }

    @Override
    public Mat apply(Mat in) {
        return internal.apply(in);
    }
}
