package origami.colors;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Symbol;
import org.opencv.core.Scalar;

public class HTML {
    static {
        Symbol cvu = (Symbol) Clojure.var("clojure.core", "symbol").invoke("opencv4.colors.html");
        Clojure.var("clojure.core", "require").invoke(cvu);
    }
    static final IFn toScalarFn = Clojure.var("opencv4.colors.html", "->scalar");

    public static Scalar toScalar(String f) {
        if(f.startsWith("#"))
            return (Scalar) toScalarFn.invoke(f);
        else
            return RGB.toScalar(f);
    }

    static final IFn toHtmlFn = Clojure.var("opencv4.colors.html", "->html");

    public static String toHTML(Scalar f) {
        return (String) toHtmlFn.invoke(f);
    }
}
