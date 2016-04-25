package android.ieee.servicestarted;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyBackgroundService extends Service {
    private static final String TAG = "sample-service.newThread";

    public MyBackgroundService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Back Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"Back Service OnStartCommand");
        final int currentId = startId;

        Runnable r = new Runnable() {
            @Override
            public void run() {
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

                    }
                    Log.i(TAG,"Back Service Running "+currentId);
                }

                stopSelf();
            }
        };
        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"Back Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Back Service onDestroy");
    }
}
