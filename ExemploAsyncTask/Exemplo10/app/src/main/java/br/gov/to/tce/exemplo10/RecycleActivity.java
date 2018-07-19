/****************************************************************
 * Nome: Exemplo10
 * Descrição: demonstra o uso de alertas e componentes visuais
 * Autor: Silvano Malfatti
 * Data: 16/07/2018
 *****************************************************************/

//Pacote da aplicação
package br.gov.to.tce.exemplo10;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity
{
    RecyclerView recycler;
    ArrayList<Food> foodList;
    Adapter adapter;


    private static final int MY_PERMISSIONS_REQUEST_INTERNET = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycle);


        //Obtem a referencia para o recycler e configura as propriedades
        //para gerenciamento de layout e objeto de animacao
        recycler = (RecyclerView)findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());


        //new HandleServices(this).execute("https://api.myjson.com/bins/7j5ii");
        new HandleServices(this).execute("http://silvanomalfattiml.000webhostapp.com/cardapio.json");


        //Configura o adapter do recycler
        recycler.setAdapter(adapter);
    }

    //Cria um objeto listener para a lista
    private OnClickList createListener()
    {
        return new OnClickList()
        {
            @Override
            public void onClickCell(View view, int index)
            {
                Log.i("INFO", "CELULA " + index + " clicada");
            }
        };
    }

    public void handleFloatButton(View view)
    {
        Log.i("INFO", "FLOAT BUTTON PRESSIONADO");
    }

    //Carrega uma imagem com base em seu Id
    Bitmap carregaImagem(int id)
    {
       return BitmapFactory.decodeResource(getResources(), id);
    }
}
