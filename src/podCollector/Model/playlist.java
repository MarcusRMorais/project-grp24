package podCollector.Model;
import java.util.ArrayList;

public class playlist {
    private String nom;
    private ArrayList<Podcast> Podcasts;
    public playlist(String nom){
        this.nom=nom;
    }
    public playlist(String nom, Podcast pod){
        this.nom=nom;
        this.Podcasts.add(pod);
    }
    public void addPodcast(Podcast pod){
        this.Podcasts.add(pod);
    }
}
