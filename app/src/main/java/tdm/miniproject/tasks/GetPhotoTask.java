package tdm.miniproject.tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;

import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.job.Product;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;

/**
 * Created by amine on 28/06/2016.
 */
public class GetPhotoTask extends AsyncTask<String,Void,String>{
    private ImageView image;

    public GetPhotoTask(ImageView image) {
        this.image = image;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        return new HttpManager().getDataFromServiceURI(RequestManager.getPhotoRequest(params[0],params[1]));
    }

    @Override
    protected void onPostExecute(String s) {
        Product product = new Gson().fromJson(s,Product.class);
        if(product!=null){
            image.setImageBitmap(ServiceUtil.getBitmapFromString(product.getPhoto()));
        }
    }
}
