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
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

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
        String nome = "image"+System.currentTimeMillis();
        File path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            file = File.createTempFile(nome, "jpg", path);
        } catch (IOException e) { }

        imagePath = FileProvider.getUriForFile(this, "io.github.guilhermebferreira.bdproject.FileProvider", path);


        intent.putExtra(MediaStore.EXTRA_OUTPUT, imagePath);

        startActivityForResult(intent,1);
    }

    public void onActivityForResult(int cod, int result, Intent intent){

        if(result == Activity.RESULT_OK){

            ImageView image = findViewById(R.id.formImageView);

            //Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            Bundle bundle = intent.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");

            image.setImageBitmap(bitmap);
        }
    }
}
