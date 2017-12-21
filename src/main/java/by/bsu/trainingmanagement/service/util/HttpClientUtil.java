package by.bsu.trainingmanagement.service.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by anyab on 21.12.2017.
 */
public class HttpClientUtil {
    private static final Logger LOGGER = Logger.getLogger(HttpClientUtil.class);

    public static JsonObject getJsonObjectFromResponse(CloseableHttpClient client, HttpGet httpGet){
        JsonObject json = null;
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            String responseBody = new BasicResponseHandler().handleResponse(response);
            String clearResponse = deleteUnnecessaryBrackets(responseBody);
            json = convertStringToJsonObject(clearResponse);
        } catch (IOException e) {
            LOGGER.error("Exception is occurred during getting json object from response." + e);
        }
        return json;
    }

    public static HttpGet createHttpGetForJson(String url){
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");
        return httpGet;
    }

    public static JsonObject convertStringToJsonObject(String jsonString) {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonArray = jsonReader.readObject();
        jsonReader.close();
        return jsonArray;
    }

    private static String deleteUnnecessaryBrackets(String text){
        return text.replaceAll("\\[", "").
                replaceAll("]", "");
    }


}
