package podCollector.Model;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utilisateur implements Serializable {

    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private JSONArray preferences;
    private JSONArray playlists;
    private Path pathTelechargement;
    private String dateN;
    private JSONArray actualPodcast;
    private JSONObject user;
    private gestionnairePlaylist gestplaylist;



    public Utilisateur() throws IOException {
        this.actualPodcast = new JSONArray();

        this.user = new JSONObject();
        nom = "";
        prenom = "";
        login = "";
        this.gestplaylist=new gestionnairePlaylist(this);
        this.gestplaylist.newPlaylist("Historique");
        this.gestplaylist.newPlaylist("Favoris");



    }

    public void setNom(String n) {
        this.nom = n;
    }

    public void setPrenom(String p) {
        this.prenom = p;
    }

    public void setDateN(String d) {
        this.dateN = d;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public void setMdp(String m) {
        this.mdp = m;
    }
    public void setPreferences(String pref){
        this.preferences.add(pref);
    }
    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getLogin() {
        return this.login;
    }

    public ArrayList<String> getPreferences(){
        ArrayList<String> listdata= new ArrayList<String>();
        JSONArray jArray= this.preferences;
        if(jArray!=null){
             for(Object o: jArray){
                 listdata.add(o.toString());

             }
        }
        return listdata;
    }
    public void createUserJson() {
        String directoryName = "userDoc";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        this.pathTelechargement = Paths.get("userDoc\\" + login + "\\downloads");
        this.user.put("nom", nom);
        this.user.put("prenom", prenom);
        this.user.put("login", login);
        this.user.put("mdp", mdp);
        this.user.put("dateN", this.dateN);
        this.user.put("actualPodcast", this.actualPodcast);
        this.user.put("pathTelechargement", this.pathTelechargement.toString());
        this.user.put("preferences",this.preferences);
        this.user.put("playlists",this.playlists);


        //Path filename=Paths.get( "userDoc\\DATA"+login+".json");
        //String filename = new File("").getAbsolutePath();
        //filename.concat("DATA"+login+".json");
        String filename = (login + ".json");
        try {
            File file = new File(directoryName + "/" + filename);
            if(file.exists()){
                file.delete();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(user.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //////////////////////////////////parsing for authentification
    public void getInfo(String login) throws IOException, ParseException {
        String filename = ("userDoc/" + login + ".json");
        File jsonfile = new File(filename);
        boolean exists = jsonfile.exists();
        if (exists == true) {

            try (FileReader reader = new FileReader(filename)) {
                InputStreamReader intpread = new InputStreamReader(new FileInputStream(filename));
                //Read JSON file
                JSONObject jo = (JSONObject) (new JSONParser().parse(intpread));
                String log = (String) jo.get("login");
                this.login=log;
                String password = (String) jo.get("mdp");
                this.mdp=password;
                String name=(String) jo.get("nom");
                this.nom=name;
                String forname=(String) jo.get("prenom");
                this.prenom=forname;
                String datum=(String) jo.get("dateN");
                this.dateN=datum;
                JSONArray pref= (JSONArray) jo.get("preferences");
                this.preferences=pref;
                JSONArray actualPod= (JSONArray) jo.get("actualPodcast");
                this.actualPodcast=actualPod;
                Path path=Paths.get((String)jo.get("pathTelechargement"));
                this.pathTelechargement=path;
                JSONArray play=(JSONArray) jo.get("playlists");
                this.playlists=play;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public int authentification(String login, String mdp) throws FileNotFoundException, ParseException {
            String filename = ("userDoc/" + login + ".json");
             File jsonfile = new File(filename);
             boolean exists = jsonfile.exists();
             if (exists == true) {

                 try (FileReader reader = new FileReader(filename)) {
                    InputStreamReader intpread= new InputStreamReader(new FileInputStream(filename));
                //Read JSON file
                     JSONObject jo=(JSONObject) (new JSONParser().parse(intpread));
                     String log=(String)jo.get("login");
                     String password=(String) jo.get("mdp");
                     if(log.equals(login) && mdp.equals(password)){
                         return 1;

                     }
                     else{
                         ///////////si le mdp ne correspond pas au bon mdp
                         return 0;
                     }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
             else{
                 ////////si le compte n'a  jamais été créé

                 return 2;
             }
        return 0;
    }

    /////////////////parsing for creating an account
    public int verifyLogin(String login){
        String filename = ("userDoc/" + login + ".json");
        File jsonfile = new File(filename);
        boolean exists = jsonfile.exists();
        if (exists){
            ////////si un compte a déjà été créé avec ce login
            return 0;
        }
        return 1;

    }

    public void newPlaylist (String nom){
            this.gestplaylist.newPlaylist(nom);

    }

    public void newPlaylist (String nom, Podcast pod){
            this.gestplaylist.newPlaylist(nom, pod);
        }

    public String getActualPodcastID(){
        String str="";
        str=str+this.actualPodcast.get(0);

        return str;
    }
    public String getActualPodcastTime(){
        String str="";
        str=str+this.actualPodcast.get(1);
        return str;
    }
    public void setActualPodcast(String id,Double time){
        String i=""+id;
        Double j=0+time;
        this.actualPodcast.add(i);
        this.actualPodcast.add(j);

    }
    public void saveActualPodcast(String id, Double time) throws ParseException, IOException {
       // this.getInfo(this.login);
        this.setActualPodcast(id,time);
        this.createUserJson();



    }

 public static void main(String args[]) throws IOException, ParseException {
        String nom="ANOUAR";
        String prenom="Ilyy";
        String login="ILYANOUAR";
        String mdp="1989";
        controleurFenetre cont = new controleurFenetre();
        Utilisateur user=new Utilisateur();
        user.setPrenom(prenom);
        user.setNom(nom);
        user.setLogin(login);
        user.setMdp(mdp);
        user.createUserJson();
        int auth= user.authentification(login,mdp);
        int n=user.verifyLogin(login);
        System.out.println(n);
        System.out.println(auth);
       // user.setActualPodcast("actualPod",13.24);
       user.saveActualPodcast("actualPod",13.24);
    }

}