package podCollector.view.principale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import podCollector.Model.Podcast;
import podCollector.Model.PodcastCell;

import java.io.IOException;
import java.util.ArrayList;

public class ControlDecouvrir {

    @FXML
    ListView<Podcast> List1,List2,List3;

    private ArrayList<Podcast> listPodcast;

    Pane paneActuel;

    public ControlDecouvrir(Pane pane) throws IOException {
        paneActuel = pane;
        listPodcast = new ArrayList<>();
        listPodcast.add(new Podcast("Podcast1", "https://cdn-images-1.listennotes.com/podcasts/star-wars-7x7-star-wars-news-interviews-and-AIg3cZVKCsL.300x300.jpg"));
        listPodcast.add(new Podcast("Podcast2", "https://global-uploads.webflow.com/5c4117329fc3235735cd430f/5c82cd5d3d48f736ac4b787e_Mini-Logo-256px.jpg"));
        listPodcast.add(new Podcast("Podcast3", "https://pbs.twimg.com/profile_images/613349488053256193/T8iozMsb_400x400.png"));
        listPodcast.add(new Podcast("Podcast4", "https://poddmap.com/assets/force-center/256x256.jpg"));
        listPodcast.add(new Podcast("Podcast5", "https://i.pinimg.com/originals/de/f4/f1/def4f1d7a435248bf2a64ebc43de468d.png"));
        listPodcast.add(new Podcast("Podcast6", "https://pbs.twimg.com/profile_images/595582272637575168/4h55zbVI_400x400.jpg"));

        ObservableList<Podcast> oListPodcast = FXCollections.observableArrayList(listPodcast);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Découvrir.fxml"));
        // Set this class as the podCollector.controller
        loader.setController(this);
        paneActuel.getChildren().add(loader.load());

        List1.setItems(oListPodcast);
        List1.setCellFactory(param -> new PodcastCell());

        List2.setItems(oListPodcast);
        List2.setCellFactory(param -> new PodcastCell());

        List3.setItems(oListPodcast);
        List3.setCellFactory(param -> new PodcastCell());

    }
}
