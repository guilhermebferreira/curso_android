package io.github.guilhermebferreira.bdproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import javax.xml.transform.sax.SAXTransformerFactory;

public class ActivityList extends AppCompatActivity {

    RecyclerView recycler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recycler = findViewById(R.id.listRecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());

        BdHandler bd = new BdHandler(this, "reg",1);
        updateRecycleView(bd.getRegs());
    }

    public void handleFloatButton(View view) {
        //chama a tela de cadastro
        Intent intent = new Intent(this, ActivityForm.class);
        startActivityForResult(intent, 0);
    }

    public void onActivityResult(int code, int result, Intent intent){

        if(result == Activity.RESULT_OK){
            BdHandler bd = new BdHandler(this, "reg", 1);
            updateRecycleView(bd.getRegs());

        }
    }

    private void updateRecycleView(ArrayList<Reg> list) {
        //atualizar lista caso operação ocorra com sucesso
        //seta o adapter da recycleview
        this.recycler.setAdapter(new Adapter(this, list));


    }
}
