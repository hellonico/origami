package origami;

import org.scijava.nativelib.DefaultJniExtractor;

import java.io.*;

public class OrigamiJniExtractor extends DefaultJniExtractor {

    public OrigamiJniExtractor(Class<?> libraryJarClass) throws IOException {
        super(libraryJarClass);
    }

    private String sh(String cmd) {
        String o = null;
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String r;
            while ((r = b.readLine()) != null) o += r;
        } catch (Exception e) {
            o = "error";
        }
        return o;
    }

    @Override
    public File extractJni(String libPath, String libname) throws IOException {
//        if(Origami.DEBUG) {
            System.out.println("Loading:" + libname + " from:" + libPath);
//        }
        if (libPath.equalsIgnoreCase("natives/linux_arm64/")) {
            String uname = sh("uname -a");
            boolean check = uname.contains("nvidia");
            if(check) {
                return super.extractJni("natives/linux_arm64_nvidia", libname);
            } else {
                return super.extractJni(libPath, libname);
            }
        } else {
            return super.extractJni(libPath, libname);
        }
    }
}
