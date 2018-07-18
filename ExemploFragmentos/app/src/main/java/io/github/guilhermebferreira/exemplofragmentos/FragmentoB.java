package io.github.guilhermebferreira.exemplofragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentoB extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.layout_fragmento_b, container, false);
        Log.i("INFO", "Fragmento B criado");

        return view;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i("INFO", "Fragmento B acoplado");
    }
    @Override
    public void onDetach(){
        super.onDetach();
        Log.i("INFO", "Fragmento B desaclopado");
    }
}
