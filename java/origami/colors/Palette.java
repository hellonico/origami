package origami.colors;

import org.opencv.core.Scalar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Palette {
    private final String name;
    private final boolean reverse;

    public static List<String> get(String name, boolean reversed) {
        try {
            InputStream is = Objects.requireNonNull(Palette.class.getClassLoader().getResourceAsStream("palette.txt"));
            Set<String> lines = linesFromInputStream(is);

            File customPalette = new File(System.getProperty("user.home")+"/.origami/palette.txt");
            if(customPalette.exists()) {
                lines.addAll(linesFromInputStream(Files.newInputStream(customPalette.toPath())));
            }

            for(String line : lines) {
                if(line.startsWith(name)) {
                    String colors = line.substring(line.indexOf("=")+1);
                    List<String> givenList = Arrays.asList(colors.split(","));
                    if(reversed) {
                        Collections.reverse(givenList);
                    }
                    return givenList;
                }
            }
            throw new RuntimeException("Not found:"+name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<String> linesFromInputStream(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader =  new BufferedReader(isr);
        Set<String> lines = reader.lines().collect(Collectors.toSet());
        return lines;
    }

    List<String> paletteList = List.of();
    public Palette(String _name, boolean _reverse) {
        name = _name;
        reverse = _reverse;
        paletteList = Palette.get(name,reverse);
    }

    public Scalar ratioColor(double p) {
        int randomElement = (int) (paletteList.size() * p);
        return HTML.toScalar(paletteList.get(randomElement));
    }
//
//    public Scalar randomElement() {
//
//    }

}
