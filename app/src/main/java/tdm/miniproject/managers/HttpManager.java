package tdm.miniproject.managers;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by amine on 26/06/2016.
 */
public class HttpManager {

    public  String getDataFromServiceURI(String uri){
        StringBuilder result = new StringBuilder();
        String data;
        BufferedReader reader=null;
        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode()==200) {
                InputStream is = conn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((data = reader.readLine()) != null) {
                    result.append(data);
                }
            }

            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(reader!=null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
}
