package isi.ing.tn.a05_spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] myData = {"Lundi","Mardi","Mercredi","Jeudi",
            "Vendredi","Samedi","Dimanche"};

    Spinner mySpinner;
    TextView selectionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        selectionText = (TextView) findViewById(R.id.selectionText);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item
                        ,myData);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(mMessageSelectedHandler);
    }

    private AdapterView.OnItemSelectedListener mMessageSelectedHandler = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView parent, View v, int position, long id) {
            selectionText.setText("Item " + (position + 1) + ": " +
                    ((TextView) v).getText());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            selectionText.setText("Choisir un jour de semaine...");
        }
    };


}
