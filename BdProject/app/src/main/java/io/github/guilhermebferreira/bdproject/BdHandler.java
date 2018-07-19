package io.github.guilhermebferreira.bdproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class BdHandler extends SQLiteOpenHelper {

    private String[] scripts = new String[2];
    private Context context = null;


    public BdHandler(Context context, String name, int version) {
        //a versão do banco e nome são o que controlam a base
        super(context, name, null, version);

        this.context = context;

        scripts[0] = "create table reg " +
                "(" +
                "_id integer primary key autoincrement," +
                "name text not null," +
                "imagepath text not null," +
                "rating float " +
                ");";
        scripts[1] = "drop table if exists reg;";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts[0]); //criando o banco
    }

    @Override
    //metodo chamado caso você altere a versão do banco no contrutor
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(scripts[1]);
    }

    public void insert(Reg reg){
        ContentValues values = new ContentValues();

        values.put("name", reg.getName());
        values.put("imagepath", reg.getImagepath());
        values.put("rating", reg.getRating());

        SQLiteDatabase db = getWritableDatabase();
        db.insert( "reg", null, values);
        Toast.makeText(context, "Inserção realizada", Toast.LENGTH_SHORT).show();
    }
}
