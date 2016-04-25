package android.ieee.servicestarted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ServiceStartedActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_started);

    }

    public void bStartService(View view){
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }

    public void bStartBackgroundService(View view){
        Intent intent = new Intent(this, MyBackgroundService.class);
        startService(intent);
    }



    public void bStartIntentService(View view){
        Intent intent = new Intent(this,MyIntentService.class);
        startService(intent);
    }


}
