package android.ieee.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
        Log.d("reciver","Created  the reciever" ) ;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "Broadcast Intent Detected: " + intent.getAction();
        Log.d("reciver", message ) ;

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
