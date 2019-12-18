package podCollector.Model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PodcastCell extends ListCell<Podcast> {
    private ImageView imageView = new ImageView();
    Label title;
    VBox vBox;
    public PodcastCell(){
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        title = new Label("");
        title.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().addAll(imageView,title);
        vBox.setFillWidth(false);
        setGraphic(vBox);
    }

    @Override
    protected void updateItem(Podcast item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            imageView.setImage(null);
            setGraphic(null);
            title.setText(null);
        } else {
            imageView.setImage(new Image(item.getPathImage()));
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(130);
            title.setText(item.getNom());
            //setText("");
            setGraphic(vBox);

        }
    }

}
