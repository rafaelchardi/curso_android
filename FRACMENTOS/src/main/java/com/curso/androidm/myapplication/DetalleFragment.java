package com.curso.androidm.myapplication;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetalleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    public DetalleFragment() {
        // Required empty public constructor
    }

    public void actualizaDetalle(Tareas tarea){
        TextView textViewNombre = (TextView) getActivity().findViewById(R.id.textViewNombre);
        textViewNombre.setText(tarea.getNombre());

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }


 }
