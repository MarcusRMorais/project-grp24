package podCollector.view.login;

import javafx.scene.control.Label;
import org.json.simple.parser.ParseException;
import podCollector.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginScreen {
    private final Stage thisStage;
    private final Utilisateur ut;
    @FXML
    private TextField fieldUtilisateur;
    @FXML
    private Button butConnect;
    @FXML
    private Button butInsc;
    @FXML
    private Label lError;
    @FXML
    private PasswordField fieldPasse;

    public LoginScreen(Utilisateur ut) throws IOException{
        // Create the new stage
        thisStage = new Stage();

        this.ut = ut;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));

        // Set this class as the podCollector.controller
        loader.setController(this);

        // Load the scene
        thisStage.setScene(new Scene(loader.load()));

        // Setup the window/stage
        thisStage.setTitle("Podcast Collector");
    }

    @FXML
    private void initialize() {
        butConnect.setOnAction(event -> {
            try {
                pressButConnect();
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        });
        butInsc.setOnAction(event -> {
            try {
                pressButInsc();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void pressButConnect() throws IOException, ParseException {
        if (fieldUtilisateur.getText().trim().isEmpty() || fieldPasse.getText().trim().isEmpty())
            lError.setText("Veuillez saisir toutes les informations !");
        else if(ut.authentification(fieldUtilisateur.getText(),fieldPasse.getText()) == 0)
            lError.setText("Mot de passe Incorrect");
        else if(ut.authentification(fieldUtilisateur.getText(),fieldPasse.getText()) == 2)
            lError.setText("Compte pas créé");
        else {
            ut.getInfo(fieldUtilisateur.getText());
            thisStage.close();
        }
    }

    private void pressButInsc() throws IOException {
        Stage pStage = new Stage();
        ControlInscp inscpS = new ControlInscp(pStage,ut);
        inscpS.showStage();
    }

    public void showStage() {
        thisStage.showAndWait();
    }
}
