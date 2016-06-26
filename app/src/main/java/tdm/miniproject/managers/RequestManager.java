package tdm.miniproject.managers;

import java.net.URLEncoder;

import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;

/**
 * Created by amine on 26/06/2016.
 */
public class RequestManager {
    public static final String localUrl= "http://192.168.56.1:8080/";

    public static String getRequestProductListWP(String density, Category category, Consumer consumer){
        try{
            String request = localUrl+
                    "getProducts?"+
                    "density="+density+
                    "&category="+ URLEncoder.encode(category.toString(),"UTF-8")+
                    "&consumer="+URLEncoder.encode(consumer.toString(),"UTF-8");
            return request;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
