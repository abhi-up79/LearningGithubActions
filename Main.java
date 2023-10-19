package com.example;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.github.com/repos/abhi-up79/LearningGithubActions/dispatches"))
				.header("Accept", "application/vnd.github.everest-preview+json")
				.header("Authorization", "Bearer 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")
                		.POST(HttpRequest.BodyPublishers.ofString("{\"event_type\": \"do-something\", \"client_payload\": {\"text\": \"Call from Java code\"}}"))
				.build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
    }
}
