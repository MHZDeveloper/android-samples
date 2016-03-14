package isi.android.custumlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        listView1 = (ListView)findViewById(R.id.listView1);
        
        Weather weather_data[] = new Weather[]
        {
            new Weather(R.drawable.clear, "Clear"),
            new Weather(R.drawable.cloudy, "Cloudy"),
            new Weather(R.drawable.cloundysnow, "Cloudy Snow"),
            new Weather(R.drawable.frost, "Frost"),
            new Weather(R.drawable.freezing, "Freezing"),
            new Weather(R.drawable.hot02, "Hot"),
            new Weather(R.drawable.unknown, "it Works !"),
        };
       
          
        View header = (View)getLayoutInflater().inflate(R.layout.header_layout, null);
       // View footer = (View)getLayoutInflater().inflate(R.layout.header_layout, null);



        listView1.addHeaderView(header);

        //listView1.addFooterView(footer);




       
        WeatherAdapter adapter = new WeatherAdapter(this,
													R.layout.row, 
													weather_data);
        listView1.setAdapter(adapter);
    }





    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity, menu);
		return true;
	}
	
	
}