package tdm.miniproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import tdm.miniproject.tasks.FollowOrderStatus;

public class OrderStateReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        new FollowOrderStatus(context).execute();
    }
}
