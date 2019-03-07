package isi.ing.tn.p02_microcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nbr1, nbr2 ;
    TextView res ;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nbr1 = (EditText) findViewById(R.id.nbr1);
        nbr2 = (EditText) findViewById(R.id.nbr2);

        res = (TextView) findViewById(R.id.res);

        btn = (Button) findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer t1, t2, r ;

                t1 = Integer.valueOf(nbr1.getText().toString() );
                t2 = Integer.valueOf(nbr2.getText().toString() );
                r = t1 +t2 ;


                res.setText( r.toString() );



            }
        });


    }

}
