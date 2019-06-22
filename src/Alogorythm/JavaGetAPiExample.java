package Alogorythm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class JavaGetAPiExample {

    public static void main(String[] arg){

        JavaGetAPiExample obj = new JavaGetAPiExample();
        try {
            JavaGetAPiExample.getCountries("in",1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getCountries(String s, int p) throws Exception {

        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+s);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        StringBuffer response = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
        JSONArray controllers = (JSONArray) jsonObject.get("data");
        int count = 0;
        for(int i = 0; i < controllers.size();i++){
            JSONObject controller = (JSONObject) controllers.get(i);
            Long po = (Long) controller.get("population");
            if(po > p){
                count += 1;
            }
        }

        System.out.println(count);
        return count;
    }
}

