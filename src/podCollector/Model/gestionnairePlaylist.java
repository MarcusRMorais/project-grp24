package podCollector.Model;
import java.util.ArrayList;

public class gestionnairePlaylist {
    private Utilisateur myUser;
    private ArrayList<playlist> playliste;

    public gestionnairePlaylist(Utilisateur user){
        this.myUser=user;
        this.playliste = new ArrayList<playlist>();

    }

    public void newPlaylist(String nom){
        playlist play = new playlist(nom);
        this.playliste.add(play);

    }

    public void newPlaylist(String nom, Podcast pod){
        playlist play = new playlist(nom,pod);
        this.playliste.add(play);
    }

}
