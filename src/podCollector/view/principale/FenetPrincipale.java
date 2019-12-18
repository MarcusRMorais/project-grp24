package podCollector.view.principale;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import podCollector.Model.PodcastPlayer;
import podCollector.Model.Utilisateur;

import java.io.IOException;

public class FenetPrincipale {
    @FXML
    private Pane PaneLecture,PaneFav,PanePrincipal;


    private final Stage thisStage;
    private final Utilisateur ut;
    private ControlVueSide controlSide;
    private ControlVuePlayer controlVuePlayer;
    private ControlDecouvrir controlDecouvrir;
    private Media podActuel;
    private MediaPlayer mediaPlayer;

    public FenetPrincipale(Utilisateur ut) throws IOException {
        // Create the new stage
        thisStage = new Stage();

        this.ut = ut;
        mediaPlayer = new MediaPlayer(new Media("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BasePrincipale.fxml"));

        // Set this class as the podCollector.controller
        loader.setController(this);

        // Load the scene
        thisStage.setScene(new Scene(loader.load()));

        // Setup the window/stage
        thisStage.setTitle("Podcast Collector");

        controlSide = new ControlVueSide(PaneFav);
        controlVuePlayer = new ControlVuePlayer(mediaPlayer,PaneLecture);
        controlDecouvrir = new ControlDecouvrir(PanePrincipal);

    }

//    @FXML
//    private void initialize() {
//
//    }

    public void showStage() {
        thisStage.showAndWait();
    }

}
