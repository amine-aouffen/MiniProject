package tdm.miniproject.managers;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

    public String postDataToServiceURI(String uri,String data){
            String result="" ;
            try {
                URL url = new URL(uri);
                HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                OutputStream outputStream = conn.getOutputStream();
                // Ecrire les données de la requete
                outputStream.write(data.getBytes("UTF-8"));
                if (conn.getResponseCode() == 200) {
                    // Lire la réponse
                    InputStream is = conn.getInputStream();
                    BufferedReader reader =
                            new BufferedReader
                                    (new InputStreamReader(is, "UTF-8"));
                    result = reader.readLine();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return result;
    }

    public String postJsonToServiceURI(String uri,String json){
        String result="" ;
        try {
            URL url = new URL(uri);
            HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter outputStream = new OutputStreamWriter(conn.getOutputStream());
            // Ecrire les données de la requete
            outputStream.write(json);
            if (conn.getResponseCode() == 200) {
                // Lire la réponse
                InputStream is = conn.getInputStream();
                BufferedReader reader =
                        new BufferedReader
                                (new InputStreamReader(is, "UTF-8"));
                result = reader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
