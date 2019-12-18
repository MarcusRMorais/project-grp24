package podCollector.view.login;

import javafx.scene.control.*;
import podCollector.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ControlInscp {
    private final Stage thisStage;

    private final Utilisateur ut;

    @FXML
    private Button butValInsc;

    @FXML
    private TextField fNom,fPrenom,fLogin;
    @FXML
    private PasswordField fMp;
    @FXML
    private DatePicker fDate;

    @FXML
    private Label LabelError;

    public ControlInscp(Stage stage, Utilisateur ut) throws IOException {
        thisStage = stage;
        this.ut = ut;
    }

    @FXML
    private void initialize() {
        butValInsc.setOnAction(event1 -> {
            try {
                clickValiderInsc();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void showStage() throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("formulaireInscription.fxml"));

        // Set this class as the podCollector.controller
        loader.setController(this);
        root=loader.load();
        Scene scene=new Scene(root);
        thisStage.setScene(scene);
        thisStage.show();
    }


    private void clickValiderInsc() throws IOException {
        if (fNom.getText().trim().isEmpty() || fMp.getText().trim().isEmpty() || fPrenom.getText().trim().isEmpty() || fLogin.getText().trim().isEmpty())
            LabelError.setText("Veuillez saisir toutes les informations !");
        else if (ut.verifyLogin(fLogin.getText()) == 0){
            LabelError.setText("Login déjà utilisé !");
        }
        else{
            LocalDate localDate = fDate.getValue();
            DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
            if(localDate.isAfter(LocalDate.parse("01-01-2005",f))){
                LabelError.setText("Date Invalide");
            }
            else{
                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date date = Date.from(instant);
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(date);
                this.ut.setNom(fNom.getText());
                this.ut.setPrenom(fPrenom.getText());
                this.ut.setMdp(fMp.getText());
                this.ut.setLogin(fLogin.getText());
                this.ut.setDateN(strDate);
                ControlPara cont = new ControlPara(thisStage,ut);
                cont.showStage();
            }
        }

    }


}
