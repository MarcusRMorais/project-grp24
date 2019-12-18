package podCollector.Model;
import java.util.ArrayList;

public class gestionnaireAbonnement {
    private ArrayList<abonnement> abonnements;
    public gestionnaireAbonnement(String userID, String podcastID){
        abonnement abon=new abonnement(userID,podcastID);
        this.abonnements.add(abon);
    }
}
