package origami.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Downloader {

    public static void transfer(String url, String filename) throws IOException {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(filename);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

    static Map<String, Thread> threads =
            (Map<String, Thread>) Collections.synchronizedMap(new HashMap<String, Thread>());
    static Map<String, String> history =
            (Map<String, String>) Collections.synchronizedMap(new HashMap<String, String>());
    public static void asyncTransfer(String url, String file) {
        if (!new File(file).exists() && !threads.containsKey(file)) {
            try {
                new FileOutputStream(file).close();
                new File(file).setLastModified(System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if(threads.containsKey(file)) {
                System.out.printf("File [%s] is downloading...\n", file);
            } else {
                System.out.printf("File [%s] exists : [%s]\n", file, getFileSizeMegaBytes(new File(file)));
            }
        }

        final Thread t = new Thread(()->{
            try {
                transfer(url, file);
            } catch (IOException e) {
                System.out.printf("Error while downloading: %s [%s]\n", url, e.getMessage());
            }
            threads.remove(file);
            history.put(file, url);
        });
        threads.put(file, t);
        t.start();
    }

    public static void debug() {
        System.out.printf("-- Downloader debug --\n");
        System.out.printf("> Downloading \n");
        threads.keySet().iterator().forEachRemaining(e -> {
            File f = new File(e);
            System.out.printf("%s : [%s]\n", e, getFileSizeMegaBytes(f));
        });
        System.out.printf("> History \n");
        history.keySet().iterator().forEachRemaining(e -> {
            File f = new File(e);
            System.out.printf("%s \t [%s] \t < %s\n", e, getFileSizeMegaBytes(f), history.get(e));
        });
    }

    private static String getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

}
