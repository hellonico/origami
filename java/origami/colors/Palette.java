package origami.colors;

import org.opencv.core.Scalar;
import origami.utils.Resourcer;

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
            String content =  Resourcer.linesFromResourceAndCustomization("palette.txt");
            String[] lines = content.split("\n");

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

    List<String> paletteList = new ArrayList<String>();
    public Palette(String _name, boolean _reverse) {
        name = _name;
        reverse = _reverse;
        paletteList = Palette.get(name,reverse);
    }

    public Scalar ratioColor(double p) {
        int randomElement = (int) (paletteList.size() * p);
        return HTML.toScalar(paletteList.get(randomElement));
    }


}
