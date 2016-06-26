package tdm.miniproject.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.StringBuilderPrinter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by amine on 15/06/2016.
 */
public class GetProductsListByCat extends AsyncTask<String,Void,String> {
    private Context context;
    private ProgressDialog progressDialog;

    public GetProductsListByCat(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Chargement");
        progressDialog.setMessage("Veuillez patienter, la récupération de la liste des produit est en cours ...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder result= new StringBuilder();
        String dataLine;
        try{
            URL url = new URL("");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(20000);
            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                while((dataLine=reader.readLine())!=null){
                    result.append(dataLine);
                }
            }
        }catch (Exception e){

        }

        return null;
    }

    @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
}
