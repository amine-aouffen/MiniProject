package tdm.miniproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by amine on 27/06/2016.
 */
public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "3h écoulées, le chariot sera vidé dans 1h !", Toast.LENGTH_SHORT).show();
    }
}
