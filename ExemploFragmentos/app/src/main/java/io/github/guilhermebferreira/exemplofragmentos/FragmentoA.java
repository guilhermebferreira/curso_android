package io.github.guilhermebferreira.exemplofragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentoA extends android.support.v4.app.Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.layout_fragmento_a, container, false);
        Log.i("INFO", "Fragmento A criado");

        return view;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i("INFO", "Fragmento A acoplado");
    }
    @Override
    public void onDetach(){
        super.onDetach();
        Log.i("INFO", "Fragmento A desaclopado");
    }
}
