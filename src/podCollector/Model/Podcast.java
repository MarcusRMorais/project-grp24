package podCollector.Model;

public class Podcast {
    private String id;
    private String nom;
    private String pathImage;
    private String URl;
    public Podcast(){

    }
    public Podcast(String n,String pathIm){
        nom = n;
        pathImage = pathIm;
    }

    public String getNom(){
        return nom;
    }

    public String getPathImage(){
        return pathImage;
    }
}
