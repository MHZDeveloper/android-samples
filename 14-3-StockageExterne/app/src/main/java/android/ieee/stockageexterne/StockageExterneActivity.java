package android.ieee.stockageexterne;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class StockageExterneActivity extends Activity {


    private static final String FILENAME = "fichier_externe.txt";
    EditText name, age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockage_externe);
        name = (EditText) findViewById(R.id.nameInput);
        age = (EditText) findViewById(R.id.ageInput);
    }

    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

    public void save(View v) throws IOException {
        if (isExternalStorageWritable()){
            File directory = Environment.getExternalStorageDirectory();
            File file = new File(directory+"/"+FILENAME);
            FileOutputStream fos = new FileOutputStream(file);
            String message = "Je m'appelle " + name.getText() + " et j'ai " + age.getText() + " ans.";
            fos.write(message.getBytes());
            fos.close();
        }

    }

    public boolean isExternalStorageReadable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        return false;
    }

    public void read(View v) throws IOException {
        if (isExternalStorageReadable()) {
            File directory = Environment.getExternalStorageDirectory();
            File file = new File(directory + "/" + FILENAME);
            FileInputStream fis = new FileInputStream(file);
            StringBuffer buffer = new StringBuffer();
            int content;
            while ((content = fis.read()) != -1) {
                buffer.append((char) content);
            }
            Toast.makeText(this, buffer, Toast.LENGTH_LONG).show();
            fis.close();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stockage_externe, menu);
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
