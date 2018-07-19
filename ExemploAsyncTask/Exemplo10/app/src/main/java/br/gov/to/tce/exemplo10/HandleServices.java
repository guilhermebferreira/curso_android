package br.gov.to.tce.exemplo10;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HandleServices extends AsyncTask<String, Void, ArrayList<Food>> {
    RecycleActivity activity = null;
    ProgressDialog dialog = null;

    public HandleServices(RecycleActivity activity){
        this.activity = activity;
    }

    @Override
    public void onPreExecute(){
        //metodo chamado antes do inicio da thread
        dialog = new ProgressDialog(activity);
        dialog.setCancelable(false); //impossibilita o usuario de cancelar a tarefa
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("BAIXANDO DADOS...");
        dialog.setTitle("Aguarde!");
        dialog.show();
    }


    @Override
    protected ArrayList<Food> doInBackground(String... params) {
        //usando okhttp para pegar o json da nuvem

        //cria uma referência para o objeo cliente
        OkHttpClient client = new OkHttpClient();
        //monta  arequisição de conteúdo (http)
        Request request = new Request.Builder().url(params[0]).build();
        try {
            //cria uma resposta e executa a requisição
            Response response = client.newCall(request).execute();
            //armazena o conteúdo baixado pela requisição
            String json = response.body().string();

            //transformando o json no objeto company

            Gson gson = new Gson();
            Company company = gson.fromJson(json, Company.class);

            return (ArrayList)company.getItens();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute( ArrayList<Food> list){
        Log.i("INFO", "Finalizado");
        //já posso atualizar a interface
        activity.updateRecycleView(list);

        //encerrando o dialogo de interface que exibe a mensagem "CARREGANDO..."
        dialog.cancel();
    }



}
