package origami.tween;

import javafx.geometry.Rectangle2D;
import javafx.scene.media.EqualizerBand;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

import javax.sound.midi.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayMidiFX extends Tween {
    Media hit;

    public String sound;

    public PlayMidiFX() {
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

    public static void main(String... args) {

                try {
                    // Get the default MIDI device
                    MidiDevice.Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
                    MidiDevice midiDevice = MidiSystem.getMidiDevice(midiDeviceInfo[0]);

                    // Open the MIDI device
                    midiDevice.open();

                    // Get the MIDI receiver from the device
                    Receiver midiReceiver = midiDevice.getReceiver();

                    // Create a MIDI message
                    ShortMessage message = new ShortMessage();
                    int noteNumber = 60; // C4
                    int velocity = 100; // Note velocity
                    int channelNumber = 0; // MIDI channel number (0-15)
                    message.setMessage(ShortMessage.NOTE_ON, channelNumber, noteNumber, velocity);

                    // Send the MIDI message
                    midiReceiver.send(message, -1);
                    Thread.sleep(500);
                    System.out.println("1");


                    // https://www.midi.org/specifications-old/item/table-3-control-change-messages-data-bytes-2
                    /*
                        Modulation (Controller number 1): Modulation control is often used to add expression and vibrato effects. The modulation controller varies the intensity or depth of a modulation effect. For example, on a synthesizer, it can control the depth of a vibrato effect.
                        Expression (Controller number 11): The expression controller is used to adjust the overall expression or volume level of a MIDI channel. It allows you to smoothly control the volume without abruptly changing it.
                        Sustain Pedal (Controller number 64): The sustain pedal controller mimics the behavior of a sustain pedal on a piano. When the pedal is pressed, it sustains or extends the duration of the played notes.
                        Pitch Bend (Controller number 0): The pitch bend controller is used to alter the pitch of a note. It provides a continuous pitch variation up or down from the center position, allowing for expressive pitch-bending effects.
                        Pan (Controller number 10): The pan controller controls the stereo panning of a sound. It adjusts the position of the sound in the stereo field, ranging from left to right.
                        Program Change (Controller number 12): The program change message is used to select different instrument sounds or presets. It allows you to change the timbre or patch of a MIDI channel to produce different sounds.
                     */
                    // gain
                    List<Integer> change = Arrays.asList(58, 7, 1,11,64,0,10,12);
                    Random rand = new Random();
                    for(int i : change) {
                        message.setMessage(ShortMessage.NOTE_ON, channelNumber, 60+rand.nextInt(30), velocity);
                        midiReceiver.send(message, -1);

                        ShortMessage message_ = new ShortMessage();
                        message_.setMessage(ShortMessage.CONTROL_CHANGE, channelNumber,1, rand.nextInt(100));
                        midiReceiver.send(message_, -1);
                        System.out.printf("> %d\n",i);
                        Thread.sleep(700);
                    }

                    // Wait for some time
                    Thread.sleep(2000);

                    // Create a note-off message
                    message.setMessage(ShortMessage.NOTE_OFF, channelNumber, noteNumber, velocity);

                    // Send the note-off message
                    midiReceiver.send(message, -1);
                    System.out.println("3");

                    // Close the MIDI device
                    midiDevice.close();
                } catch (MidiUnavailableException | InvalidMidiDataException | InterruptedException e) {
                    e.printStackTrace();
                }

    }
}