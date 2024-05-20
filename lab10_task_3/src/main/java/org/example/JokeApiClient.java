package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class JokeApiClient {
    private static final String JOKE_API_URL = "https://official-joke-api.appspot.com/random_joke"; // Example API URL

    public String jokeApiRequest() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(JOKE_API_URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error during API request: " + e.getMessage());
            return null;
        }
    }
}