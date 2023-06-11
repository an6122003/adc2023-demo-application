package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class testAPI {
    private static final String API_KEY_1 = "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";
    private static final String API_KEY_2 = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-3.5-turbo";

    public static void main(String[] args) {
        try {
            // System.out.println("input");
            // Scanner scanner = new Scanner(System.in);
            // String userMessage = "Production Integration: The submission should provide a clear description of how the solution can be seamlessly integrated into a product or a specific design. It should also address scalability, ease of integration, and market readiness.  Innovation: The submission should showcase the amount of effort and thought put into finding innovative solutions or novel approaches to existing problems. Cost-consciousness: Evaluate how the team considers the cost of implementation of the product to the market. Intuitiveness: The submission should demonstrate an easy and intuitive solution for prospective users.";
            String userMessage = "Testing functionality of the chatbot";
            String systemMessage = "Give me the 3 main ideas of the following paragraph";

            String response;
            try {
                System.out.println("printing");
                response = chatGPT(systemMessage,userMessage);
                System.out.println(response);
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String chatGPT(String systemMessage,String userMessage) throws IOException, URISyntaxException {
        URI url = new URI(API_URL);

        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY_2);
        connection.setDoOutput(true);

        String requestBody = "{\"model\": \"" + MODEL + "\", \"messages\": [{\"role\": \"system\", \"content\": \"" + systemMessage + "\"}, {\"role\": \"user\", \"content\": \"" + userMessage + "\"}]}";

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();
        }

        StringBuilder response = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        connection.disconnect();
         String jsonResponse = response.toString();
//         int startIndex = jsonResponse.indexOf("\"content\":\"") + 11;
//         int endIndex = jsonResponse.indexOf("\"", startIndex);
//         String content = jsonResponse.substring(startIndex, endIndex);
        int startIndex = jsonResponse.indexOf("\"content\": \"") + 12;
        int endIndex = jsonResponse.indexOf("\"", startIndex);
        String content = jsonResponse.substring(startIndex, endIndex);

        System.out.println("Start Index:" + startIndex);
        System.out.println("End Index:" + endIndex);
        System.out.println(jsonResponse);

        
        // Replace \n with line breaks
        content = content.replace("\\n", System.lineSeparator());
        return content;
    }
}
