package tdm.miniproject.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import tdm.miniproject.job.Product;

/**
 * Created by Dell on 16/05/2016.
 */
public class GetProducts extends AsyncTask<String, Void, String> {
    ProgressDialog pd;
    private Context context;

    public GetProducts(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        // Création et affichage du ProgressDialog
        pd = new ProgressDialog(context);
        pd.setTitle("Veuiilez Attendre..");
        pd.setMessage("Chargement...");
        pd.show();
    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder result = new StringBuilder();
        String data;
        try {
            URL url = new URL("http://192.168.43.93:8080/getproducts?density="+params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Attendre 5 secondes max pour établir la connexion
            conn.setConnectTimeout(5000);
            // Attendre 1 minute max pour lire les données
            conn.setReadTimeout(60000);
            if (conn.getResponseCode()==200) {
                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((data = reader.readLine()) != null) {
                    result.append(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    protected void onPostExecute(String s) {
//        pd.dismiss();
//        if (!s.equals("")) {
//            List<Product> listProduct = new ArrayList<>();
//
//            try {
//                JSONArray jsonArray = new JSONArray(s);
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    Product product = new Product();
//                    product.setName(jsonObject.getString("name"));
//                    product.setDescription(jsonObject.getString("description"));
//                    product.setPrice(jsonObject.getDouble("price"));
//                    product.setCaracteristics(jsonObject.getString("caracteristics"));
//                    Author[] authorsList = new Gson().fromJson(jsonObject.get("listAuthors").toString(),Author[].class);
//                    product.setListAuthors(authorsList);
//                    product.setSummary(jsonObject.get("summary").toString());
//                    product.setCover(jsonObject.getString("cover"));
//                    product.setIconCover(jsonObject.getString("iconCover"));
//                    listProduct.add(product);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//            ListView listView = (ListView) ((Activity)context).findViewById(R.id.listView);
//            CustomAdapter cutomAdapter = new CustomAdapter(context,listProduct);
//            listView.setAdapter(cutomAdapter);
//        }
//        else {
//            Toast.makeText(context, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
//        }
    }
}
