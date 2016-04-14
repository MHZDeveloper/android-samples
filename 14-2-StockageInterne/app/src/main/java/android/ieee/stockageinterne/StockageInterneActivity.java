package android.ieee.stockageinterne;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;


public class StockageInterneActivity extends Activity {

    private static final String FILENAME = "fichier_interne.txt";
    EditText name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockage_interne);
        name = (EditText) findViewById(R.id.nameInput);
        age = (EditText) findViewById(R.id.ageInput);
    }

    public void save(View v) throws IOException{
        FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE | MODE_APPEND);
        String message = "Je m'appelle "+ name.getText()+" et j'ai "+age.getText()+ " ans.";
        fos.write(message.getBytes());
        fos.close();
    }

    public void read(View v) throws IOException{
        FileInputStream fis = openFileInput(FILENAME);

        // if file the available for reading
        if (fis != null) {
        /*
            StringBuffer buffer = new StringBuffer();
            int content;
            while((content=fis.read())!=-1){
                buffer.append((char)content);
            }
            Toast.makeText(this, buffer,Toast.LENGTH_LONG).show();
        */



            // prepare the file for reading
            InputStreamReader inputreader = new InputStreamReader(fis);
            BufferedReader buffreader = new BufferedReader(inputreader);

            String line;

            // read every line of the file into the line-variable, on line at the time
            do {
                line = buffreader.readLine();
                // do something with the line
                Toast.makeText(this, "line= " + line,Toast.LENGTH_LONG).show();

            } while (line != null);

        }


        fis.close();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stockage_interne, menu);
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
