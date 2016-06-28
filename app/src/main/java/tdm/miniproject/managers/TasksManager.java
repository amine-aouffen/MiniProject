package tdm.miniproject.managers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import tdm.miniproject.receivers.ClearCartReceiver;
import tdm.miniproject.receivers.OrderStateReceiver;

/**
 * Created by amine on 28/06/2016.
 */
public class TasksManager {

    public static void cancelClearCartAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,ClearCartReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(context, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public static void setClearCartAlarm(Context context,int secondes){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,ClearCartReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+secondes*1000,pendingIntent);
        Toast.makeText(context, "Alarm set", Toast.LENGTH_SHORT).show();
    }

    public static void setOrdderStatusChangedAlarm(Context context,int secondes){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,OrderStateReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+secondes*1000,secondes*1000,pendingIntent);
    }

    public static void cancelOrdderStatusChangedAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,OrderStateReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        alarmManager.cancel(pendingIntent);
    }

}
