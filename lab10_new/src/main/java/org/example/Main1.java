package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        CastMember cast1 = new CastMember("Actor One", "Character One");
        CastMember cast2 = new CastMember("Actor Two", "Character Two");


        Movie movie1 = new Movie("Movie Title One", "Director Name One", 120, Arrays.asList(cast1, cast2));

        CastMember cast3 = new CastMember("Actor Three", "Character Three");
        CastMember cast4 = new CastMember("Actor Four", "Character Four");


        Movie movie2 = new Movie("Movie Title Two", "Director Name Two", 150, Arrays.asList(cast3, cast4));


        List<Movie> movies = Arrays.asList(movie1, movie2);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(movies);


        System.out.println(json);
    }
}
