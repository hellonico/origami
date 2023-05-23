package origami.colors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Palette {
    public static List<String> get(String name, boolean reversed) {
        try {
            InputStream is = Objects.requireNonNull(Palette.class.getClassLoader().getResourceAsStream("palette.txt"));
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader =  new BufferedReader(isr);
            Set<String> lines = reader.lines().collect(Collectors.toSet());
            for(String line : lines) {
                if(line.startsWith(name)) {
                    String colors = line.substring(line.indexOf("="))+1;
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
}
