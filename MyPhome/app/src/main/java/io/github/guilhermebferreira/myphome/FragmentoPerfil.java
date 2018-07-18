package io.github.guilhermebferreira.myphome;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class FragmentoPerfil extends Fragment   {

    View viewPerfil = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);


        //pega as configurações salvas pelo usuario
        boolean userChoice = PersistenceManager.getPersistenceManager().getStored(getContext());



        Switch userChoiceSwitch;
        userChoiceSwitch =  view.findViewById(R.id.fragmento_perfil_usuario_switch_notificacoes);
        userChoiceSwitch.setChecked(userChoice);


        //obtenha um areferencia para o linear layout filho do scroll view
        LinearLayout linearLayout = view.findViewById(R.id.perfil_usuario_scroll_ofertas);
        //obtem uma referencia para um objeto inflador, necessario para que a gente consiga instanciar os objetos celulas
        LayoutInflater inflador = LayoutInflater.from(getContext());

        int[] imagens = {
                R.drawable.california,
                R.drawable.mussarela,
                R.drawable.portuguesa,
                R.drawable.quatro_queijos,
                R.drawable.salada_de_frutas,
                R.drawable.sorvete,
                R.drawable.sucos,
        };


        for (int imagem : imagens) {


            Drawable pic = ContextCompat.getDrawable(getContext(), imagem);


            LinearLayout line = (LinearLayout) inflador.inflate(R.layout.oferta_celula, linearLayout, false);

            ImageView imagem_oferta = line.findViewById(R.id.oferta_celula_imagem);
            imagem_oferta.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imagem_oferta.setAdjustViewBounds(false);
            imagem_oferta.setImageDrawable(pic);


            linearLayout.addView(line);


        }

        viewPerfil = view;
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
