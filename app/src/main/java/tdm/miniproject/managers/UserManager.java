package tdm.miniproject.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by amine on 27/06/2016.
 */
public class UserManager {
    public static final String userSharedPrefName="userFile";
    public static final String isConnectedName="isConnected";
    public static final String userIdName="userId";

    public static void setConnected(Context context,String userId){
        SharedPreferences sp=context.getSharedPreferences(userSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null){
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(isConnectedName,true);
            editor.putString(userIdName,userId);
            editor.commit();
        }

    }

    public static void setDisconnected(Context context){
        SharedPreferences sp=context.getSharedPreferences(userSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null){
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(isConnectedName,false);
            editor.commit();
        }
    }

    public static boolean isConnected(Context context){
        SharedPreferences sp=context.getSharedPreferences(userSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null)return  sp.getBoolean(isConnectedName,false);
        else return false;
    }

    public static String getUserId(Context context){
        SharedPreferences sp=context.getSharedPreferences(userSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null) return sp.getString(userIdName,"");
        else return"";
    }
}
