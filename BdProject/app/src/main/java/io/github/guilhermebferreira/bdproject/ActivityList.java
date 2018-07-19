package io.github.guilhermebferreira.bdproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void handleFloatButton(View view) {
        //chama a tela de cadastro
        Intent intent = new Intent(this, ActivityForm.class);
        startActivityForResult(intent, 0);
    }

    public void onActivityResult(int code, int result, Intent intent){
        //atualizar lista caso operação ocorra com sucesso
    }
}
