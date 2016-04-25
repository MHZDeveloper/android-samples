package android.ieee.servicestarted;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService{


    private static final String TAG = "sample-service.intent";

    @Override
    protected void onHandleIntent(Intent arg0){

        Log.i(TAG,"Intent Service Started!");
        // add the service business here
        // will get request params from intent

    }

    public MyIntentService(){

        super("MyIntentService");
    }
}
