package isi.ing.tn.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Je suis dans onCreate", 1).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "Je suis dans onStart", 1).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Je suis dans onRestart", 1).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "Je suis dans onStop", 1).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "Je suis dans onPause", 1).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Je suis dans onResume", 1).show();
    }


}