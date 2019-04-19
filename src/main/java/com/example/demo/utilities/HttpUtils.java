package com.example.demo.utilities;

import com.example.demo.models.Summoner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtils {

    public static Map<String, Object> HttpGet(String target) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL(target);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode obj = mapper.readTree(responseContent.toString());

            return mapper.convertValue(obj, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JsonNode MapToJson(Map<String, Object> map){
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(map, JsonNode.class);
    }

    public static String ConvertToJson(Object any) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(any);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
