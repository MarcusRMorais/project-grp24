package podCollector;

import javafx.application.Application;
import javafx.stage.Stage;
import podCollector.Model.Utilisateur;
import podCollector.view.login.LoginScreen;
import podCollector.view.principale.FenetPrincipale;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Utilisateur ut = new Utilisateur();
        LoginScreen loginS = new LoginScreen(ut);
        loginS.showStage();
        if(ut.getLogin() != ""){
            FenetPrincipale fenetP = new FenetPrincipale(ut);
            fenetP.showStage();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
