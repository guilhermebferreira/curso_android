package io.github.guilhermebferreira.myphome;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class perfil_usuario extends AppCompatActivity implements DialogInterface.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_perfil_usuario);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String username = data.getString("username");



        Log.i("INFO", username);


        TextView label_username;
        label_username   = findViewById(R.id.perfil_usuario_nome);
        label_username.setText(username);


        Toast.makeText(this, "Seja bem vindo "+username, Toast.LENGTH_LONG).show();

        //obtenha um areferencia para o linear layout filho do scroll view
        LinearLayout linearLayout = findViewById(R.id.perfil_usuario_scroll_ofertas);
        //obtem uma referencia para um objeto inflador, necessario para que a gente consiga instanciar os objetos celulas
        LayoutInflater inflador = LayoutInflater.from(this);

        int[] imagens = {
                R.drawable.california,
                R.drawable.mussarela,
                R.drawable.portuguesa,
                R.drawable.quatro_queijos,
                R.drawable.salada_de_frutas,
                R.drawable.sorvete,
                R.drawable.sucos,
        };


        for (int imagem : imagens ) {


            Drawable pic = ContextCompat.getDrawable(this,  imagem);


            LinearLayout line = (LinearLayout)inflador.inflate(R.layout.oferta_celula, linearLayout, false);

            ImageView imagem_oferta =  line.findViewById(R.id.oferta_celula_imagem);
            imagem_oferta.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imagem_oferta.setAdjustViewBounds(false);
            imagem_oferta.setImageDrawable(pic);


            linearLayout.addView(line);


        }
    }

    public void handleLogoffButton(View button){

        DesejaSair();

    }

    public void DesejaSair(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("AVISO!");
        alert.setIcon(R.mipmap.ic_launcher_round);
        alert.setMessage("Deseja mesmo sair?");
        alert.setPositiveButton("Sim", this);
        alert.setNegativeButton("Não", this);
        alert.show();
    }


    public void handleListaButton(View button){
        Intent myIntent = new Intent( this, Lista.class);

        this.startActivity(myIntent);
    }



    @Override
    public void onClick(DialogInterface dialog, int codButton) {
        if(codButton == DialogInterface.BUTTON_POSITIVE){

            Switch choice = findViewById(R.id.perfil_usuario_switch_notificacoes);
            Bundle data = new Bundle();
            data.putBoolean("notification", choice.isChecked());

            Intent intent = new Intent();
            intent.putExtras(data);


            this.setResult(Activity.RESULT_OK, intent);

            Toast.makeText(this, "Aplicação finalizada", Toast.LENGTH_LONG).show();
            //finalizar essa activity
            finish();
        }
    }

    @Override
    //sobreescrevendo o botão de voltar
    public void onBackPressed(){

        DesejaSair();
    }


}
