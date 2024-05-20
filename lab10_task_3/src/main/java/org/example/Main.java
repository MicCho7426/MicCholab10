package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        JokeApiClient jokeClient = new JokeApiClient();
        String jokeJson = jokeClient.jokeApiRequest();

        if (jokeJson != null) {
            Gson gson = new Gson();
            Joke joke = gson.fromJson(jokeJson, Joke.class);
            System.out.println(joke);
        } else {
            System.out.println("Failed to retrieve joke.");
        }
    }
}