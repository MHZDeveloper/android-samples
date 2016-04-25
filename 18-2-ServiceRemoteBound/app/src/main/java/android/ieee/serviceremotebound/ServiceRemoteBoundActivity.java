package android.ieee.serviceremotebound;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;



public class ServiceRemoteBoundActivity extends Activity {

    Messenger myService = null;
    boolean isBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_remote_bound);

        Intent intent = new Intent(getApplicationContext(),RemoteService.class);
        bindService(intent,myConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection myConnection =
            new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    myService = new Messenger(service);
                    isBound = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    myService = null;
                    isBound = false;
                }
            };

    public void sendMessage(View view) {
        if (!isBound) return;

        Message msg = Message.obtain();

        Bundle bundle = new Bundle();
        bundle.putString("MyString","Message Received !");

        msg.setData(bundle);

        try{
            myService.send(msg);
        }catch (RemoteException e){
            e.printStackTrace();
        }

    }
}

