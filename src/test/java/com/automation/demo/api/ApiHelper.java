package com.automation.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ApiHelper {

    private URL url;
    private ObjectMapper objectMapper;
    private HttpURLConnection httpURLConnection;
    private OutputStreamWriter outputStreamWriter;

    public Map<String, String> submitPostRequestAndReturnResponseString(String endpoint, Object requestBody) {

        Map<String, String> responseData = new HashMap<>();
        String responseString = "";

        try {
            url = new URL(endpoint);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            objectMapper = new ObjectMapper();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");

            outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            log.info("Request Body: {}", objectMapper.writeValueAsString(requestBody));
            outputStreamWriter.write(objectMapper.writeValueAsString(requestBody));
            outputStreamWriter.flush();

            log.info("Response Code: {}", httpURLConnection.getResponseCode());
            log.info("Response Message: {}", httpURLConnection.getResponseMessage());

            responseData.put("ResponseCode", String.valueOf(httpURLConnection.getResponseCode()));
            responseData.put("ResponseMessage", readStream(httpURLConnection.getInputStream()));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    private String readStream(InputStream stream) {
        StringBuilder response = new StringBuilder();
        BufferedReader in;

        try {
            in = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}
