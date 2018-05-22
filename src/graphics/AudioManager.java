package graphics;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/*
 * Allows code anywhere to play/stop sounds or play/stop background music.
 */
public class AudioManager {
    private static HashMap<Integer, Clip> currentSounds = new HashMap<>();
    private static MediaPlayer mediaPlayer;

    private static int UUID = 0;

    /*
     * First is sounds. There are small .wav effects for the game. For larger audio files, see media, below.
     */

    // returns the ID of the sound being played
    public static int playSound(String filename) {
        try {
            File file = new File(filename);
            Clip clip = AudioSystem.getClip();
            // getAudioInputStream() also accepts a File or InputStream
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.loop(0);

            UUID++;
            currentSounds.put(UUID, clip);

            return UUID;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static void stopSound(int ID) {
        Clip clip = currentSounds.get(ID);

        if(clip != null) {
            clip.close();
        }

        currentSounds.remove(ID);
    }

    public static void stopAllSounds() {
        for(Integer id : currentSounds.keySet()) {
            stopSound(id);
        }
    }

    /*
     * Media works a little different than sound.
     *
     * This is pretty much for background music, and takes mp3 files.
     *
     * Only one background track can be playing at a time.
     */
    public static void playMedia(String filename) {
/*
        stopMedia();

        Media hit = new Media(new File(filename).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
*/
    }

    public static void stopMedia() {
/*
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
*/
    }
}
