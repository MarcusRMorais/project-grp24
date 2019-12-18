package podCollector.Model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Observable;

public class PodcastPlayer extends Observable {
    private MediaPlayer mediaPlayer;
    private Media podActuel;

    public PodcastPlayer(String url){
        podActuel = new Media(url);
        mediaPlayer = new MediaPlayer(podActuel);
    }

    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }

    public void stopPodcast(){
        mediaPlayer.stop();
        setChanged();
        notifyObservers();
    }

    public void pausePodcast(){
        mediaPlayer.pause();
        setChanged();
        notifyObservers();
    }

    public void playPodcast(){
        mediaPlayer.play();
        setChanged();
        notifyObservers();
    }

    public void changePodcast(String url){
        mediaPlayer.play();
    }
}

