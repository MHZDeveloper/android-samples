package android.ieee.arrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ArrayAdapterActivity extends Activity {

    ListView myList;
    String[] myData = {"Lundi","Mardi","Mercredi","Jeudi",
                       "Vendredi","Samedi","Dimanche"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        myList = (ListView) findViewById(R.id.myList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,myData);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(mMessageClickedHandler);
    }

    private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Toast.makeText(ArrayAdapterActivity.this,"Item "+(position+1)+": "+
                    ((TextView)v).getText(),Toast.LENGTH_LONG).show();
        }
    };
}


