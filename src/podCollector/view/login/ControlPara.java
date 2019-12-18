package podCollector.view.login;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import podCollector.Model.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


import java.io.IOException;

public class ControlPara {
    private Boolean[] chosenCat;
    private final Stage thisStage;
    private final Utilisateur ut;
    private ToggleGroup toggleGroup;
    @FXML
    private ToggleButton butCat1,butCat2,butCat3,butCat4,butCat5,butCat6,butCat7,butCat8,butCat9;
    @FXML
    private  Button ButValPara;

    HttpResponse<JsonNode> response = Unirest.get("https://listen-api.listennotes.com/api/v2/search?q=star%20wars&sort_by_date=0&type=episode&offset=0&len_min=10&len_max=30&genre_ids=68%2C82&published_before=1390190241000&published_after=0&only_in=title%2Cdescription&language=English&safe_mode=1")
            .header("X-ListenAPI-Key", "<SIGN UP FOR API KEY>")
            .asJson();

    @FXML
    private Label lPrenom;

    public ControlPara(Stage stage,Utilisateur ut) throws IOException {
        thisStage = stage;
        this.ut = ut;
        chosenCat = new Boolean[]{false,false,false,false,false,false,false,false,false};
        toggleGroup = new ToggleGroup();
    }

    @FXML
    private void initialize() {
        ButValPara.setOnAction(event -> {
            try {
                clickValiderPref();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        butCat1.setToggleGroup(toggleGroup);
        butCat2.setToggleGroup(toggleGroup);
        butCat3.setToggleGroup(toggleGroup);
        butCat4.setToggleGroup(toggleGroup);
        butCat5.setToggleGroup(toggleGroup);
        butCat6.setToggleGroup(toggleGroup);
        butCat7.setToggleGroup(toggleGroup);
        butCat8.setToggleGroup(toggleGroup);
        butCat9.setToggleGroup(toggleGroup);
        butCat1.setOnAction(this::clickButnPref);
        butCat2.setOnAction(this::clickButnPref);
        butCat3.setOnAction(this::clickButnPref);
        butCat4.setOnAction(this::clickButnPref);
        butCat5.setOnAction(this::clickButnPref);
        butCat6.setOnAction(this::clickButnPref);
        butCat7.setOnAction(this::clickButnPref);
        butCat8.setOnAction(this::clickButnPref);
        butCat9.setOnAction(this::clickButnPref);
        lPrenom.setText(ut.getPrenom());

    }

    private void clickValiderPref() throws IOException {
        System.out.println(this.ut.getNom());
        this.ut.createUserJson();
        thisStage.close();
    }

    private void clickButnPref(ActionEvent event){
        if(event.getSource() == butCat1) {
            if(butCat1.isSelected()){
                butCat1.setStyle(butCat1.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat1.setStyle(butCat1.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat2) {
            if(butCat2.isSelected()){
                butCat2.setStyle(butCat2.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat2.setStyle(butCat2.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat3) {
            if(butCat3.isSelected()){
                butCat3.setStyle(butCat3.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat3.setStyle(butCat3.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat4) {
            if(butCat4.isSelected()){
                butCat4.setStyle(butCat4.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat4.setStyle(butCat4.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat5) {
            if(butCat5.isSelected()){
                butCat5.setStyle(butCat5.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat5.setStyle(butCat5.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat6) {
            if(butCat6.isSelected()){
                butCat6.setStyle(butCat6.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat6.setStyle(butCat6.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat7) {
            if(butCat7.isSelected()){
                butCat7.setStyle(butCat7.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat7.setStyle(butCat7.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat8) {
            if(butCat8.isSelected()){
                butCat8.setStyle(butCat8.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat8.setStyle(butCat8.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
        else if(event.getSource() == butCat9) {
            if(butCat9.isSelected()){
                butCat9.setStyle(butCat9.getStyle() + "-fx-border-color: #FFFFFF");
            }
            else{
                butCat9.setStyle(butCat9.getStyle().replaceAll("-fx-border-color: #FFFFFF",""));
            }
        }
    }

    public void showStage() throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("preference.fxml"));

        // Set this class as the podCollector.controller
        loader.setController(this);
        root=loader.load();
        Scene scene=new Scene(root);
        thisStage.setScene(scene);
        thisStage.show();
    }
}
