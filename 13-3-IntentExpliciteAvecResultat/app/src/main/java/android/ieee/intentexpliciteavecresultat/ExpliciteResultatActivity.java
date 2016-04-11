package android.ieee.intentexpliciteavecresultat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ExpliciteResultatActivity extends Activity {

    public static final int REQUEST_CODE = 1;

    EditText texte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicite_resultat);
         texte = (EditText) findViewById(R.id.editText);
    }

    public void start(View v){
        Intent i = new Intent(this,DestinationActivity.class);
        i.putExtra("val",Integer.valueOf(texte.getText().toString()));
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"Resultat = "+intent.getIntExtra("resultat",0),Toast.LENGTH_LONG).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this,"Pas de Resultat !",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicite_resultat, menu);
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
