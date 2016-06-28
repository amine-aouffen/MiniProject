package tdm.miniproject.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import tdm.miniproject.managers.TasksManager;

/**
 * Created by amine on 27/06/2016.
 */
public class BootReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //Lancement de l'alarm (durée de validation du chariot est 4 heures
        TasksManager.setClearCartAlarm(context,240);
        TasksManager.setOrdderStatusChangedAlarm(context,300);
    }
}
