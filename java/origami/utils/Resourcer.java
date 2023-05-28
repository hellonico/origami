package origami.utils;

import origami.colors.Palette;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Resourcer {

    public final static String ORIGAMI_HOME = System.getProperty("user.home")+"/.origami/";

    public static String linesFromResourceAndCustomization(String resource) {
        InputStream is = Objects.requireNonNull(Palette.class.getClassLoader().getResourceAsStream(resource));
        String lines = linesFromInputStream(is);

        File customPalette = new File(ORIGAMI_HOME+resource);
        try {
            if(customPalette.exists()) {
                lines.concat(Resourcer.linesFromInputStream(Files.newInputStream(customPalette.toPath())));
            }
        } catch (Exception ignored) {

        }
        return lines;
    }


    public static String linesFromResource(String resource) {
        InputStream is = Objects.requireNonNull(Palette.class.getClassLoader().getResourceAsStream(resource));
        return linesFromInputStream(is);
    }

    public static String linesFromInputStream(InputStream inputStream) {
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
