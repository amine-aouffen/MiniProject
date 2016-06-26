package tdm.miniproject.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.DisplayMetrics;

/**
 * Created by Dell on 16/05/2016.
 */
public class ServiceUtil {


    // cette méthode transforme une chaine de caractere en Bitmap
    public static Bitmap getImageByte(String  image) {
        // décodage de image avec Base64
        byte[] imgbytes = Base64.decode(image, Base64.DEFAULT);
        // Conversion de byte vers bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgbytes, 0,
                imgbytes.length);
        return bitmap;
    }

    // Cette méthode vérifie si le dispositif est connecté (wifi ou mobile 3G/4G)
    // utilisée avant de lancer la tache asynchrone
    public static boolean checkNetwork(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= cm.getActiveNetworkInfo();
        /*utilisé pour tester les types des connexions
        if networkInfo.getType()==ConnectivityManager.TYPE_WIFI
       /if networkInfo.getType()==ConnectivityManager.TYPE_MOBILE
       */
        return ( networkInfo!=null&&networkInfo.isConnected() );
    }

    public static String getScreenDensity(AppCompatActivity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        String density ="";
        switch(metrics.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                density="ldpi";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                density= "mdpi";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                density="hdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                density= "xhdpi";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                density= "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                density= "xxxhdpi";
                break;
        }

        return density;

    }

    public static Bitmap getBitmapFromString(String s){
        byte[]  bytes = Base64.decode(s,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}
