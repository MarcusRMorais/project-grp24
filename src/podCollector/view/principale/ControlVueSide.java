package podCollector.view.principale;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import podCollector.Model.PodcastPlayer;

import java.io.IOException;

public class ControlVueSide {
    Pane paneActuel;

    public ControlVueSide(Pane pane) throws IOException {
        paneActuel = pane;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("favorite.fxml"));
        // Set this class as the podCollector.controller
        loader.setController(this);
        paneActuel.getChildren().add(loader.load());
    }
}
