package origami.filters;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import org.opencv.core.Mat;
import origami.Filter;

import static clojure.java.api.Clojure.var;

public class ClojureFilter implements Filter {
    static IFn EDN_READ_STRING;

    static {
        Symbol edn = (Symbol) var("clojure.core", "symbol").invoke("clojure.edn");
        Clojure.var("clojure.core", "require").invoke(edn);
        EDN_READ_STRING = var("clojure.edn", "read-string");
    }

    IFn eval = Clojure.var("clojure.core", "eval");
    IFn myfn;
    String myfnString;

    public ClojureFilter() {
        this.setFn("(fn[mat] mat)");
    }

    public void setFn(String text) {
        this.myfnString = text;
        this.myfn = (IFn) eval.invoke(EDN_READ_STRING.invoke(text));
    }

    public String getFn() {
        return this.myfnString;
    }


    @Override
    public Mat apply(Mat mat) {
        return (Mat) myfn.invoke(mat);
    }

}
