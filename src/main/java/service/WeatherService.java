package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WeatherService {


    public void getResults(){
        try {
            URL url = new URL("http://api.wunderground.com/api/10f14aa242fe6d99/history_20171030/q/NY/New_York.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            /*
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String line="";
            line = br.readLine();
            while (line!=null){
                if(line.contains("maxhumidity"))
                    System.out.println(line);
                line=br.readLine();
            }
            */

            HashMap<String,Object> result = new ObjectMapper()
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
