package tdm.miniproject.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by amine on 27/06/2016.
 */
public class BootReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //Lancement de l'alarm (durée de validation du chariot est 4 heures
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent2 = new Intent(context,ClearCartReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent2,0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,System.currentTimeMillis()+240*1000,pendingIntent);
    }
}
