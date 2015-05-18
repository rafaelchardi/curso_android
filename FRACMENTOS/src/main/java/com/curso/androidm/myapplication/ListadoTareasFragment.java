package com.curso.androidm.myapplication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import static android.view.View.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoTareasFragment extends Fragment {

    ListView tareaslistView;


    public ListadoTareasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado_tareas, container, false);




    }

    @Override
    // cuanto termina la ACTIVIDAD de crear todos los onCreateView de todos los fracmetos se dispara esta

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*    tareaslistView = (ListView) (this.getActivity()).findViewById(R.id.lvtareas);

        final List<Tareas> datos = new LinkedList<Tareas>();
        datos.add(new Tareas("Nadar","nadar Nadar Nadar"));
        datos.add(new Tareas("Bici","bici Bici Bici "));
        datos.add(new Tareas("Correr", "correr Correr Correr"));

        final TareasAdapter adaptador = new TareasAdapter(this.getActivity() ,R.layout.tarea_list_item,datos);

        tareaslistView.setAdapter(adaptador);*/
    }


    public void  registresListViesTareasOnClickListenesr(View.OnClickListener listener1){
        View lvtareas = getActivity().findViewById(R.id.lvtareas);
        lvtareas.setOnClickListener(listener1);
    }
}
