package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class GPTCall {
    private static final String API_KEY_1 = "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";
    private static final String API_KEY_2 = "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";
    private static final String API_KEY_3 = "sk-lrzsDRU9Y0j1etLr7hbLT3BlbkFJeDQbQvac9uqWhWe9OwT";

    public static void main(String[] args) {
        try {
            System.out.println(GPTCall.chatGPT("How to make UI for javaFX"));
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String chatGPT(String message) throws URISyntaxException {
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";
        
        message = "What is the main ideas for below paragraph, give me 3:\n " + message;

        try {
            // Create the HTTP POST request
            URI obj = new URI(url);

            HttpURLConnection con = (HttpURLConnection) obj.toURL().openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + API_KEY_2);
            con.setDoOutput(true);

            // Build the request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + message + "\"}]}";
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(body.getBytes());
            outputStream.flush();
            outputStream.close();

            // Get the response
            String inputLine;
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            in.close();
            con.disconnect();

            return (response.toString().split("\"content\":\"")[1].split("\"")[0]).substring(4);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

