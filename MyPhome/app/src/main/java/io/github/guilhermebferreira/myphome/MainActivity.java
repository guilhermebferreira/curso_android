package io.github.guilhermebferreira.myphome;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager manager = null;
    private FragmentTransaction transaction = null;
    private FragmentoPerfil fragmentoPerfil = null;
    private FragmentoCardapio fragmentoCardapio = null;
   // private FragmentoB fragmentoB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(this);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        fragmentoPerfil = new FragmentoPerfil();

        transaction.replace(R.id.TelaPrincipalFrame,fragmentoPerfil);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.profile:
                Log.i("INFO", "click on PROFILE");

                fragmentoPerfil = new FragmentoPerfil();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.TelaPrincipalFrame,fragmentoPerfil);
                //cria um empilhamento de telas, com os fragmentos
                //para o app ter para onde retornar, caso o usuário pressione o botão de voltar
                transaction.addToBackStack("TelaPrincipal");
                transaction.commit();
                break;
            case R.id.cardapio:
                Log.i("INFO", "click on CARDAPIO");


                fragmentoCardapio = new FragmentoCardapio();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.TelaPrincipalFrame,fragmentoCardapio);
                //cria um empilhamento de telas, com os fragmentos
                //para o app ter para onde retornar, caso o usuário pressione o botão de voltar
                transaction.addToBackStack("TelaPrincipal");
                transaction.commit();

                break;
            case R.id.about:
                Log.i("INFO", "click on ABOUT");
                break;
        }

        return true;

    }
}
