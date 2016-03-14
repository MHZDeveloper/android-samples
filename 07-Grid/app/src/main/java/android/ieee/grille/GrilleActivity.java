package android.ieee.grille;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class GrilleActivity extends Activity {

    GridView grille;
    TextView selection;
    String[] items = {"Lundi","Mardi","Mercredi","Jeudi",
            "Vendredi","Samedi","Dimanche"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille);
        selection = (TextView) findViewById(R.id.selection);
        grille= (GridView) findViewById(R.id.grille) ;

        ArrayAdapter<String> aa = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_1, items) ;
        grille.setAdapter(aa) ;
        grille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(items[position]) ;
            }
        }) ;

    }


}
