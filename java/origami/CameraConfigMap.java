package origami;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Keyword;
import clojure.lang.PersistentArrayMap;
import clojure.lang.Symbol;
import org.opencv.videoio.VideoCapture;

import java.io.*;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class CameraConfigMap {

    private PersistentArrayMap pam;

    Object original;

    public Set keySet() {
        return Collections.singleton(pam.keySet().stream().map(e -> {
            return e.toString();
        }).collect(Collectors.toSet()));
    }

    public CameraConfigMap(Object o) {
        this.original = o;
        String configAsString = (String) o;
        Reader sr = null;
        if (new File(configAsString).exists()) {
            try {
                sr = new FileReader(configAsString);
            } catch (FileNotFoundException e) {
                // throw new RuntimeException(e);
            }
        } else {
            sr = new StringReader(configAsString);
        }
        PersistentArrayMap pam = (PersistentArrayMap) Origami.readDeviceFn.invoke(sr);
        this.pam = pam;
    }

    public Object get(String key) {
        return pam.get(Keyword.intern(key));
    }

    public boolean contains(String key) {
        return pam.containsKey(Keyword.intern(key));
    }

    public String getString(String key) {
        return (String) pam.get(Keyword.intern(key));
    }

    public String getString(String key, String _default) {
        if (contains(key)) {
            return getString(key);
        } else {
            return _default;
        }
    }

    public long getLong(String key) {
        return (Long) pam.get(Keyword.intern(key));
    }

    public long getLong(String key, long _default) {
        if (contains(key)) {
            return getLong(key);
        } else {
            return _default;
        }
    }

    public VideoCapture openVideoCapture() {
        return Origami.CaptureDevice(this.original);
    }

}
