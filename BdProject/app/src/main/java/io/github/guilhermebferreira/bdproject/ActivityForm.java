package io.github.guilhermebferreira.bdproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityForm extends AppCompatActivity {

    Uri imagePath = null;
    File file = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void handleCamera(View button) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {

            String nome = "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            Log.i("INFO", nome);
            File path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            //file = new File(path,"profile_" + UUID.randomUUID().toString() + ".jpg");
            file =  File.createTempFile(nome, ".jpg", path);

            imagePath = FileProvider.getUriForFile(this, "io.github.guilhermebferreira.bdproject.fileprovider", file);


            intent.putExtra(MediaStore.EXTRA_OUTPUT, imagePath);

            startActivityForResult(intent, 1);
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            Log.i("INFO", e.getMessage().toString());
        }
    }

    @Override
    public void onActivityResult(int cod, int result, Intent intent){

        if(result == Activity.RESULT_OK){

            ImageView image = findViewById(R.id.formImageView);

            Log.i("INFO", file.getAbsolutePath());

            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            //Bundle bundle = intent.getExtras();
            //Bitmap bitmap = (Bitmap)bundle.get("data");

            //ImageView image = findViewById(R.id.formImageView);
            //Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            image.setImageBitmap(bitmap);

        }
    }

    public void handleSave(View Button){

        BdHandler bd = new BdHandler(this, "reg",1);
        EditText fieldName = findViewById(R.id.formEditName);
        RatingBar rating = findViewById(R.id.ratingBar);
        Reg reg = new Reg(fieldName.getText().toString(),file.getAbsolutePath(), rating.getRating());

        //insere o registro no banco
        bd.insert(reg);
        //diz no retorno que a operação ocorreu tudo bem
        this.setResult(Activity.RESULT_OK);

        finish();
    }

}
