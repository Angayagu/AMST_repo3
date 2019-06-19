package com.example.adita.amstta3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_mapa extends Fragment {

    public Fragment_mapa() {
        // Required empty public constructor
    }
    //este es un comentario de prueba en el fragment de mapa
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_fragment_mapa, container, false);
    }
}
