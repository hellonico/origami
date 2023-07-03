package origami.tween;

import javafx.geometry.Rectangle2D;
import javafx.scene.media.AudioEqualizer;
import javafx.scene.media.EqualizerBand;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.util.Duration;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

import java.awt.*;
import java.net.URL;
import java.util.List;

public class PlayFX extends Tween {
    Media hit;

    public String sound;

    public PlayFX() {
        //String bip = "src/main/resources/cartoon-jump.mp3";
        //Media hit = new Media(new File(bip).toURI().toString());

    }

    public void setSound(String sound) {

            try {
                hit = new Media(new URL(sound).toURI().toString());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

    }

    public String getSound() {
        return sound;
    }

    public void run() {
        try {
            if(hit==null) {
                setSound(sound);
            }

            Rectangle2D screenBounds = Screen.getPrimary().getBounds();

            double maxX = screenBounds.getWidth();
            double maxY = screenBounds.getHeight();

            while (true) {
                // https://archive.org/details/24-piano-keys/key24.mp3
                // String bip = "24-piano-keys/key"+String.format("%02d" , 1)+".mp3";
                // mediaPlayer.seek(Duration.ZERO);
                List<RotatedRect> rects = getRects();
                for(RotatedRect rect : rects) {
                    Size size = rect.size;
                    double x = rect.center.x;
                    double y = rect.center.y;

                    double rate = y / maxY * 8;
                    // double balance = x / maxX * 2 - 1;
                    // double gain =
                    double band = x / maxX * 10 - 1;
                    MediaPlayer mediaPlayer = new MediaPlayer(hit);

                    EqualizerBand reverbBand = mediaPlayer.getAudioEqualizer().getBands().get((int) band);

                    // int band = 0;
                    double gain = 12;
                    // -24 and 12
                    reverbBand.setGain(gain);

                    mediaPlayer.setRate(rate);
                    // mediaPlayer.setBalance(balance);

                    mediaPlayer.play();
                    mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer.dispose();
                        }
                    });
                }

                 Thread.sleep(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}