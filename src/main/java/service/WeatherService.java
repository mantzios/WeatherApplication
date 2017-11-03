package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import enumeration.Metrics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

public class WeatherService {


    private static final String URL = "http://api.wunderground.com/api/10f14aa242fe6d99/history_20171030/q/NY/New_York.json";

    public List<String> getMetricsFromJson(){
        List<String> results = new ArrayList<>();
        LinkedHashMap linkedHashMap = getResults();
        for(Metrics metrics : Metrics.values()){
            results.add((String)linkedHashMap.get(metrics.toString()));
        }
        return results;
    }

    private LinkedHashMap getResults() {
        HttpURLConnection conn =getConnection();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = null;
        try {
            map = objectMapper.readValue(conn.getInputStream(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap) map.get("history");
        List list = (ArrayList) linkedHashMap.get("dailysummary");
        LinkedHashMap<String, String> daily = (LinkedHashMap) list.get(0);
        return daily;
    }

    private HttpURLConnection getConnection() {
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode()!=200){
                System.out.println("Problem with the api");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
