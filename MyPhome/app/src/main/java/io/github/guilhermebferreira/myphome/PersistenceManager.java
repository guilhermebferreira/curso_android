package io.github.guilhermebferreira.myphome;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PersistenceManager {
    private static PersistenceManager manager = null;
    private PersistenceManager(){

    }

    public static PersistenceManager getPersistenceManager() {

        if(manager == null){
            manager = new PersistenceManager();
        }
        return manager;
    }

    public void save(Context context, boolean value){
        //dicionario de persistencia fácil
        //muito usado para salvar configurações do app
        SharedPreferences shared = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean("notification", value);
        editor.commit();
    }

    public boolean getStored(Context context){
        SharedPreferences shared = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);

        if(shared.contains("notification")){
            return shared.getBoolean("notification", false);
        }

        return false;
    }
}
