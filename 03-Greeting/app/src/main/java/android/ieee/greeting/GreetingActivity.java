package android.ieee.greeting;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class GreetingActivity extends Activity {

    EditText name;
    RadioButton maleRadio;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        name = (EditText) findViewById(R.id.name);
        maleRadio= (RadioButton) findViewById(R.id.maleRadio);
        resultText= (TextView) findViewById(R.id.resultText);
    }


    public void greeting(View v){
        if (maleRadio.isChecked()){
            resultText.setText("Hi Mr. "+name.getText());
            resultText.setTextColor(Color.RED);
        }else{
            resultText.setText("Hi Mrs. "+name.getText());
            resultText.setTextColor(Color.GREEN);
        }
    }
}
