package io.github.guilhermebferreira.aplicacaoexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //configura o layout que será publicado na tela
        setContentView(R.layout.layout_dinamic_scroll);
        //obtenha um areferencia para o linear layout filho do scroll view
        LinearLayout linearLayout = findViewById(R.id.dinamic_scroll_linear_layout);
        //obtem uma referencia para um objeto inflador, necessario para que a gente consiga instanciar os objetos celulas
        LayoutInflater inflador = LayoutInflater.from(this);



        for (int iIndex=0; iIndex<20; iIndex++){
            //infla uma celula usando o objeto inflate
            //adiciona como filha de linearlayout
            LinearLayout line = (LinearLayout)inflador.inflate(R.layout.celula, linearLayout, false);
            TextView texto = line.findViewById(R.id.celula_label);
            texto.setText("Celula: "+ iIndex);

            linearLayout.addView(line);
        }
    }
}
