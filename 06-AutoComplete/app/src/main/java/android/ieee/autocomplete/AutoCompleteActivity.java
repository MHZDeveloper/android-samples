package android.ieee.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


public class AutoCompleteActivity extends Activity{

    AutoCompleteTextView edit;
    String[] items = {"elem1", "elem2", "elem3", "elem4"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        edit = (AutoCompleteTextView) findViewById(R.id.edit);

        edit.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items));

    }



}
