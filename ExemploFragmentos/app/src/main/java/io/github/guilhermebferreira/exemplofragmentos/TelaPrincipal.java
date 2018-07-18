package io.github.guilhermebferreira.exemplofragmentos;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaPrincipal extends AppCompatActivity {

    private FragmentManager manager = null;
    private FragmentTransaction transaction = null;
    private FragmentoA fragmentoA = null;
    private FragmentoB fragmentoB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        fragmentoA = new FragmentoA();

        transaction.replace(R.id.frameLayout,fragmentoA);
        transaction.commit();

    }

    public void handleTransiction(View button) {

        fragmentoB = new FragmentoB();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragmentoB);
        //cria um empilhamento de telas, com os fragmentos
        //para o app ter para onde retornar, caso o usuário pressione o botão de voltar
        transaction.addToBackStack("TelaAB");
        transaction.commit();
    }
}
