package Homework13;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static final String USERS = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args) throws Exception {
        System.out.println("Task1.1");
        User user = new User();
        user.setId(1);
        user.setName("Oleksandr");
        user.setUserName("Oleksandr11");
        //should be 11 id
        user.setEmail("rogozkin371@gmail.com");
        User userCreate = Utils.createNewObject(user, URI.create(USERS));
        System.out.println(userCreate);

        System.out.println("\n\nTask1.2");
        User user1 =new User();
        user1.setName("Victor");
        user1.setUserName("Pavlick11");
        user1.setEmail("VictorPavlick11@gmail.com");
        User userRenew=Utils.renewObject(user1,URI.create(USERS),3);
        System.out.println(userRenew);

        System.out.println("\n\nTask1.3");
        Utils.deleteObject(URI.create(USERS),3);

        System.out.println("\n\nTask1.4");
        List<User> infAboutALlUser=Utils.getInformationAboutAllObject(URI.create(USERS));
        System.out.println(infAboutALlUser.toString());

        System.out.println("\n\nTask1.5");
        User userById=Utils.getInformationAboutObjectFromId(URI.create(USERS), 3);
        System.out.println(userById);

        System.out.println("\n\nTask1.6");
        User userByName=Utils.getInformationAboutObjectFromName(URI.create(USERS), "Antonette");
        System.out.println(userByName);

        System.out.println("\n\nTask2");
        int userId = 5;
        int lastPostId = Utils.ObjectLastPost(URI.create(USERS), userId);
        String commentsJson = Utils.findLastPostComments(URI.create(USERS), userId, lastPostId);
        Utils.commentToJson(commentsJson, userId, lastPostId);

        System.out.println("\n\nTask3");
        Utils.findAndWrite(URI.create(USERS), 1);


    }
}