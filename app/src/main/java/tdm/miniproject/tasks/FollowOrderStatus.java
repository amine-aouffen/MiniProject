package tdm.miniproject.tasks;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.List;

import tdm.miniproject.job.Order;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.NotifManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.support.GetOrdersResponse;

/**
 * Created by amine on 28/06/2016.
 */
public class FollowOrderStatus extends AsyncTask<Void,Void,String>{
    private Context context;

    public FollowOrderStatus(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        return new HttpManager().getDataFromServiceURI(RequestManager.getRequestGetOrders());
    }

    @Override
    protected void onPostExecute(String s) {
        GetOrdersResponse getOrdersResponse = new Gson().fromJson(s,GetOrdersResponse.class);
        if(getOrdersResponse.getCode()==1){
            List<Order> orders = getOrdersResponse.getOrders();
            for(int i=0;i<orders.size();i++){
                if (!orders.get(i).getState().equals("validee")){
                    if(NotifManager.getNotificationsStatus(context)==true)
                    NotifManager.sendNotification(context,"L'état de la commande n°"+orders.get(i).getId()+"est modifié");
                }
            }
        }
    }
}
