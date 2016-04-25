package android.ieee.broadcastintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class BroadcastIntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_intent);
    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("android.ieee.sendbroadcast");
        intent.setFlags(
                Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        );
        sendBroadcast(intent);
    }
}
