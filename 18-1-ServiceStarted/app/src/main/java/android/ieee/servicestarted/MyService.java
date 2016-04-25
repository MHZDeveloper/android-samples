package android.ieee.servicestarted;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "sample-service.bad";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG,"Service OnStartCommand - Will start heavy work on main thread");

        for (int i=0;i<3;i++){
            long endTime = System.currentTimeMillis() + 10 * 1000;
            while(System.currentTimeMillis()<endTime){
                synchronized (this){
                    try{
                        wait(endTime - System.currentTimeMillis());
                        Log.i(TAG,"Waiting...");
                    }catch(Exception e){

                    }
                }
                Log.i(TAG,"Service Running");
            }
        }
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Service onDestroy");
    }
}
