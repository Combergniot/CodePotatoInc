package com.webmodels.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.webmodels.data.imageapi.ImageApi;
import com.webmodels.data.imageapi.Item;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class JsonResponse {

    public List<String> getResponse(String address) {
        List<String> models;
        String response = getResponseFromUrl(address);
        response = removeJasonPAnnotation(response);
        System.out.println(response);
        models = parseJson(response);

        return models;
    }

    private String getResponseFromUrl(String address) {
        String output = "output";
        StringBuilder builder = new StringBuilder();
        try {

            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {

                builder.append(output);

            }
            br.close();
            conn.disconnect();
            System.out.println("Po disconnect " + builder);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("getResposeFromUrl " + builder);
        return builder.toString();
    }

    private String removeJasonPAnnotation(String response) {
        // parsing response from image api
        System.out.println(response);
        StringBuilder builder = new StringBuilder(response);
        System.out.println(builder.length());
        builder.setLength(builder.length() - 5);
        builder.delete(0, 24);

        return builder.toString();
    }

    private List<String> parseJson(String jsonString) {
        Gson gson = new Gson();
        ImageApi imageApi = gson.fromJson(jsonString, ImageApi.class);

        List<Item> items = new ArrayList<>();
        List<String> productCodes = new ArrayList<>();
        items.addAll(imageApi.getSet().getItem());
        //  System.out.println("Items = " + items);
        //  System.out.println("Items size = " + items.size());
        for (Item item : items) {
            productCodes.add(item.getI().getN());
        }
        return productCodes;
    }

}
