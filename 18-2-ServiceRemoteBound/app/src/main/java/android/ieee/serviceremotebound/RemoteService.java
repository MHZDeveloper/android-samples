package android.ieee.serviceremotebound;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;


public class RemoteService extends Service {
    private static final String TAG = "sample-service.remote";

    public RemoteService() {
    }

    final Messenger myMessenger = new Messenger(new IncomingHandler());

    class IncomingHandler extends Handler {
        public IncomingHandler(){}

        @Override
        public void handleMessage(Message msg){
            Bundle data = msg.getData();
            String dataString = data.getString("MyString");
            Toast.makeText(getApplicationContext(), dataString, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public IBinder onBind(Intent intent) {

        return myMessenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "Remote Service Unbound");
        return super.onUnbind(intent);
    }
}
