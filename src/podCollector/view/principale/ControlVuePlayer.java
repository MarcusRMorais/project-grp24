package podCollector.view.principale;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import podCollector.Model.PodcastPlayer;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ControlVuePlayer implements Observer {

    @FXML
    private Button butNext,butPrev,butPlay;

    Pane paneActuel;
    
    MediaPlayer podcastPlayer;

    public ControlVuePlayer(MediaPlayer podPlayer,Pane pane) throws IOException {
        paneActuel = pane;
        podcastPlayer = podPlayer;

        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Lecture.fxml"));

        // Set this class as the podCollector.controller
        loader.setController(this);
        paneActuel.getChildren().add(loader.load());
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    @FXML
    private void initialize() {
        butNext.setOnAction(event -> nextPod());
        butPlay.setOnAction(event -> playPod());
        butPrev.setOnAction(event -> prevPod());
    }

    private void nextPod(){
        podcastPlayer.stop();
        podcastPlayer = new MediaPlayer(new Media("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3"));
        podcastPlayer.play();
    }

    private void playPod(){
        if(podcastPlayer.getStatus().equals(MediaPlayer.Status.PLAYING))
            podcastPlayer.pause();
        else
            podcastPlayer.play();
    }

    private void prevPod(){
        if(podcastPlayer.getCurrentTime().toSeconds() > 5){
            podcastPlayer.stop();
            podcastPlayer.play();
        }
        else{
            podcastPlayer.stop();
            podcastPlayer = new MediaPlayer(new Media("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"));
            podcastPlayer.play();
        }
    }
}
