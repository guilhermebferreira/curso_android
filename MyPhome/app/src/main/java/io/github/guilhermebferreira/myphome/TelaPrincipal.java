package io.github.guilhermebferreira.myphome;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //configura o layout que será publicado na tela


    }


    public void handleButton(View button) {
        if (button.getId() == R.id.button) {

            EditText username = (EditText) findViewById(R.id.tela_principal_login);
            EditText password = (EditText) findViewById(R.id.tela_principal_password);

            if (!TextUtils.isEmpty(username.getText()) && password.getText().toString().equals("123")) {

                //cria uma intenção para a troca de tela
                Intent myIntent = new Intent(this, perfil_usuario.class);
                //cria um dicionario para armazenar os parametros extras
                Bundle data = new Bundle();

                data.putString("username", username.getText().toString());


                //passa parametros extras para a nova tela
                //                myIntent.putExtra("data", data); //Optional parameters
                myIntent.putExtras(data); //Optional parameters

                //Empilha a nova tela
                //                this.startActivity(myIntent);
                this.startActivityForResult(myIntent, 1020);
            } else {

                Toast.makeText(this, "Password errado", Toast.LENGTH_LONG).show();
            }

            if (TextUtils.isEmpty(username.getText())) {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onActivityResult(int cod, int res, Intent data){
        if(res == Activity.RESULT_OK){
            Log.i("INFO", "cod: "+cod);
            if(cod == 1020){
                Boolean userChoice = data.getExtras().getBoolean("notification");

                Log.i("INFO", "userChoice: "+userChoice);

                PersistenceManager.getPersistenceManager().save(this, userChoice);
            }
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int codButton) {
        if (codButton == DialogInterface.BUTTON_POSITIVE) {

            Toast.makeText(this, "Aplicação finalizada", Toast.LENGTH_LONG).show();
            //finalizar essa activity
            finish();
        }
    }
}
