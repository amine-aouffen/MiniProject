package tdm.miniproject.managers;


import android.content.Context;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import tdm.miniproject.R;

public class NotificationManager {

    public static final String notifSharedPrefName ="notifsFile";
    public static final String isActivated="isActivated";

    public static void setNotificationsOn(Context context){
        SharedPreferences sp=context.getSharedPreferences(notifSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null){
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(isActivated,true);
            editor.commit();
        }
    }

    public static void setNotificationsOff(Context context){
        SharedPreferences sp=context.getSharedPreferences(notifSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null){
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(isActivated,false);
            editor.commit();
        }
    }

    public static boolean getNotificationsStatus(Context context){
        SharedPreferences sp=context.getSharedPreferences(notifSharedPrefName, Context.MODE_PRIVATE);
        if(sp!=null)return  sp.getBoolean(isActivated,false);
        else return false;
    }
    public static void sendNotification(Context context, String message) {

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification")
                .setContentText(message)
                .setAutoCancel(false)
                .setSound(defaultSoundUri);
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify();
        //notificationManager.notify(0,notificationBuilder.build());
    }
}
