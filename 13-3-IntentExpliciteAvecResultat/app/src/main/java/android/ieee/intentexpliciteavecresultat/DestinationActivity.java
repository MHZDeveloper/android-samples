package android.ieee.intentexpliciteavecresultat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class DestinationActivity extends Activity {

    TextView tv;
    EditText mult;
    int valueReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        tv = (TextView)findViewById(R.id.show);
        mult = (EditText) findViewById(R.id.multEdit);

        valueReceived = getIntent().getIntExtra("val",0);
        tv.setText("Multiply "+valueReceived+" by: ");

    }


    public void retour (View v){
        Intent returnIntent = new Intent();
        if (mult.getText()!= null) {
            int result = valueReceived * Integer.valueOf(mult.getText().toString());
            returnIntent.putExtra("resultat", result);
            setResult(RESULT_OK, returnIntent);
        }else{
            setResult(RESULT_CANCELED, returnIntent);
        }
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_destination, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
