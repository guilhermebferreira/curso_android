package io.github.guilhermebferreira.myphome;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.profile:
                Log.i("INFO", "click on PROFILE");
                break;
            case R.id.cardapio:
                Log.i("INFO", "click on CARDAPIO");
                break;
            case R.id.about:
                Log.i("INFO", "click on ABOUT");
                break;
        }

        return true;

    }
}
