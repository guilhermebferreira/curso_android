package io.github.guilhermebferreira.myphome;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentoCardapio extends Fragment {


    ArrayList<Prato> dataSet = null;
    RecyclerView recycle = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        //1 - cria e preenche o dataset
        createDataset();
        //2 - busca a referencia para o recycleview
        recycle = view.findViewById(R.id.fragmento_cardapio_lista_recycle);
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle.setItemAnimator(new DefaultItemAnimator());
        //3 - instancia um objeto adapter que recebe o dataset
        ListAdapter adapter = new ListAdapter(getContext(), dataSet);
        //vincula o adapter ao recycle view
        recycle.setAdapter(adapter);

        return view;

    }


    private void createDataset() {

        dataSet = new ArrayList<Prato>();

        dataSet.add(new Prato(2, "California", R.drawable.california));
        dataSet.add(new Prato(3, "Mussarela", R.drawable.mussarela));
        dataSet.add(new Prato(2.5, "Portuguesa", R.drawable.portuguesa));
        dataSet.add(new Prato(1, "Quatro Queijos", R.drawable.quatro_queijos));
        dataSet.add(new Prato(2.3, "Salada de Frutas", R.drawable.salada_de_frutas));
        dataSet.add(new Prato(3, "Sorvete", R.drawable.sorvete));
        dataSet.add(new Prato(2, "Sucos", R.drawable.sucos));
        //repetindo
        dataSet.add(new Prato(3, "Calabresa", R.drawable.california));
        dataSet.add(new Prato(2.5, "Frango com Catupiry", R.drawable.california));
        dataSet.add(new Prato(2.6, "Strogonoff", R.drawable.mussarela));
        dataSet.add(new Prato(2.5, "Bahiana", R.drawable.portuguesa));
        dataSet.add(new Prato(0.5, "Cinco Queijos", R.drawable.quatro_queijos));
        dataSet.add(new Prato(3, "Carne de Sol", R.drawable.california));
        dataSet.add(new Prato(3, "Milk Shake", R.drawable.sorvete));
        dataSet.add(new Prato(1.8, "Vitaminas", R.drawable.sucos));
    }

}
