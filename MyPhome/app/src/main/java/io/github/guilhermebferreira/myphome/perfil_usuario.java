package io.github.guilhermebferreira.myphome;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
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

public class perfil_usuario extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_perfil_usuario);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String username = data.getString("username");


        Log.i("INFO", username);


        TextView label_username;
        label_username = findViewById(R.id.perfil_usuario_nome);
        label_username.setText(username);


        Toast.makeText(this, "Seja bem vindo " + username, Toast.LENGTH_LONG).show();


        //pega as configurações salvas pelo usuario
        boolean userChoice = PersistenceManager.getPersistenceManager().getStored(this);
        Switch userChoiceSwitch = findViewById(R.id.fragmento_perfil_usuario_switch_notificacoes);
        userChoiceSwitch.setChecked(userChoice);


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


        for (int imagem : imagens) {


            Drawable pic = ContextCompat.getDrawable(this, imagem);


            LinearLayout line = (LinearLayout) inflador.inflate(R.layout.oferta_celula, linearLayout, false);

            ImageView imagem_oferta = line.findViewById(R.id.oferta_celula_imagem);
            imagem_oferta.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imagem_oferta.setAdjustViewBounds(false);
            imagem_oferta.setImageDrawable(pic);


            linearLayout.addView(line);


        }
    }

    public void handleLogoffButton(View button) {

        DesejaSair();

    }

    public void DesejaSair() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("AVISO!");
        alert.setIcon(R.mipmap.ic_launcher_round);
        alert.setMessage("Deseja mesmo sair?");
        alert.setPositiveButton("Sim", this);
        alert.setNegativeButton("Não", this);
        alert.show();
    }


    public void handleListaButton(View button) {
        Intent myIntent = new Intent(this, Lista.class);

        this.startActivity(myIntent);
    }


    @Override
    public void onClick(DialogInterface dialog, int codButton) {
        if (codButton == DialogInterface.BUTTON_POSITIVE) {

            Switch choice = findViewById(R.id.fragmento_perfil_usuario_switch_notificacoes);
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
    public void onBackPressed() {

        DesejaSair();
    }

    public void openMap(View view) {
        /*Uri uri = Uri.parse(”tel:32333455”);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);

        Uri uri = Uri.parse(”http://google.com”);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);*/

        String rota = "http://maps.google.com/maps?saddr=-10.184519,-48.335203&daddr=-10.177710,-48.332699";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(rota));


        this.startActivityForResult(intent, 1021);
    }

    public void openUrl(View view) {
        /*Uri uri = Uri.parse(”tel:32333455”);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);*/

        Uri uri = Uri.parse("http://google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);


        this.startActivityForResult(intent, 1022);
    }

    public void openCall(View view) {
        Uri uri = Uri.parse("tel:32333455");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


        this.startActivityForResult(intent, 1022);
    }


}
