package isi.ing.tn.a04b_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    String[] cheeses = {
            "Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> cheeseAdapter =
                new ArrayAdapter<String>(this,
                        R.layout.activity_main,
                        R.id.cheese_name,
                        cheeses
                );

        ListView cheeseList = new ListView(this);

        setContentView(cheeseList);

        cheeseList.setAdapter(cheeseAdapter);


        // ---- NOW GRID ---
        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);

        cheeseGrid.setNumColumns(2);

        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(10);

        cheeseGrid.setAdapter(cheeseAdapter);

        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position§
                String message = "You clicked on " + cheeses[position];

                // Use the message to create a Snackbar
                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG)
                        .show(); // Show the Snackbar
            }
        });





    }
}
