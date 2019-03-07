package isi.ing.tn.a08_listepersonnalisee;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    TextView selection;
    //String[] items = {"12.5", "5.12", "9.43", "2.33", "15.12", "8.3"};
    List<String> items = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection = (TextView) findViewById(R.id.selection);

        items.add("12.5");
        items.add("10.5");
        items.add("2.5");
        items.add("9.5");
        items.add("12.25");


        setListAdapter(new IconicAdapter(this));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if(Float.valueOf(items.get(position)) >= 10) {
            selection.setText("Vous avez réussi!");
        }else{
            selection.setText("Désolé!");
        }
    }

    class IconicAdapter extends ArrayAdapter<String> {
        Activity context;
        IconicAdapter(Activity context) {
            super(context, R.layout.ma_ligne, items);
            this.context = context;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View ligne = inflater.inflate(R.layout.ma_ligne, null);
            TextView label = (TextView) ligne.findViewById(R.id.label);
            ImageView icone = (ImageView) ligne.findViewById(R.id.imageView);
            label.setText(items.get(position));
            if (Float.valueOf(items.get(position)) >= 10) {
                icone.setImageResource(R.drawable.pass);
            } else {
                icone.setImageResource(R.drawable.fail);
            }
            return ligne;
        }
    }
}
