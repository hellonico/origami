package origami.video;

import origami.Origami;
import origami.utils.Downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class HttpVideoHandler implements VideoHandler {

    long bufferTime = 1000;

    public long getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(long bufferTime) {
        this.bufferTime = bufferTime;
    }

    @Override
    public String getFilename(String url) {
        try {
            URL website = new URL(url);
            String file = website.getFile();
            file = file.substring(file.lastIndexOf("/")+1);
            Downloader.asyncTransfer(url, file);
            // wait some buffer time
            Thread.sleep(bufferTime);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}