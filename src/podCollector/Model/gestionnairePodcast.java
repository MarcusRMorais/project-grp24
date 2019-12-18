package podCollector.Model;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.concurrent.Future;

import static com.sun.deploy.util.BufferUtil.MB;

public class gestionnairePodcast {
    private ArrayList<Podcast> Podcasts;

    public gestionnairePodcast() {

    }

    public void createPodcast() {
    }


    public void getPodcast() {
        HttpResponse<JsonNode> response = Unirest.get("https://listen-api.listennotes.com/api/v2/" +
                "search?q=star%20wars&" +
                "sort_by_date=0&" +
                "type=episode&" +
                "offset=0&len_min=10&" +
                "len_max=30&" +
                "genre_ids=68%2C82&" +
                "published_before=1390190241000&" +
                "published_after=0&" +
                "only_in=title%2Cdescription&" +

                "language=English&" +
                "safe_mode=1")
                .header("X-ListenAPI-Key", "b860fd3ab7f4037a9e4013a90322277")
                .asJson();

        File directory = new File("Podcasts");
        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            File file = new File("Podcasts" + "/" + "podcasts.json");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(response.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMusic(String url, String name) throws IOException {
        //  URLConnection conn= new URL(url).openConnection();
        //InputStream is=conn.getInputStream();

        File directory = new File("MP3");
        if (!directory.exists()) {
            directory.mkdir();
        }
        //OutputStream outstream= new FileOutputStream(new File("MP3/file.mp3"));
        URL myUrl = new URL(url);
        InputStream myUrlStream = myUrl.openStream();
        ReadableByteChannel myUrlChannel = Channels.newChannel(myUrlStream);
        FileChannel destinationChannel = new FileOutputStream("MP3/" + name + ".mp3").getChannel();
        destinationChannel.transferFrom(myUrlChannel, 0, 10 * MB);


    }
    public void deleteMusic(String name) throws IOException {
        File file = new File("MP3/" + name + ".mp3");
        if(file.exists()) {
            file.delete();
        }
    }

   public static void main(String[] args) throws IOException {
        gestionnairePodcast gestpod= new gestionnairePodcast();
        gestpod.getPodcast();
       // gestpod.getMusic("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3","maMusique");
        gestpod.deleteMusic("maMusique");
    }

}