package isi.ing.tn.a04_arrayadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayAdapterActivity extends AppCompatActivity {

    ListView myList;
    String[] myData = {"Lundi", "Mardi", "Mercredi", "Jeudi",
            "Vendredi", "Samedi", "Dimanche","Lundi", "Mardi", "Mercredi", "Jeudi",
            "Vendredi", "Samedi", "Dimanche"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        myList = (ListView) findViewById(R.id.myList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_multichoice



                        , myData);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(mMessageClickedHandler);

    }


    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            Toast.makeText(ArrayAdapterActivity.this,
                    "Item " + (position + 1) + ": " + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();

        }
    };
}
