package com.curso.androidm.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    ListView tareaslistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tareaslistView = (ListView) findViewById(R.id.lvtareas);

        final List<Tareas> datos = new LinkedList<Tareas>();
        datos.add(new Tareas("Nadar","nadar Nadar Nadar"));
        datos.add(new Tareas("Bici","bici Bici Bici "));
        datos.add(new Tareas("Correr", "correr Correr Correr"));

        final TareasAdapter adaptador = new TareasAdapter(this,R.layout.tarea_list_item,datos);

        tareaslistView.setAdapter(adaptador);

        // REGISTRAMOS EL MENU CONTESTUAL.
        registerForContextMenu(tareaslistView);

    }

     /// CREAMOS EL MENU CONTEXTUAL
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        Log.i("MainActivity", "hola i");
        Log.e("MainActivity", "hola e ");
        Log.d("MainActivity", "hola d");

        if (v.getId()==R.id.lvtareas) {

            getMenuInflater().inflate(R.menu.menu_main, menu);
            int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
           // Tareas item = (Tareas) ((AdapterView) v).getAdapter().getItem(position);
            Tareas tarea = (Tareas) tareaslistView.getAdapter().getItem(position);

            menu.setHeaderTitle(tarea.getNombre());


        }
    }

    /// AQUI PONEMOS LAS ACCIONES REFERENTES A LAS ACCIONES DEL MENU CONTEXTUAL
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();
            int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            Tareas tarea = (Tareas) tareaslistView.getAdapter().getItem(position);


            Toast.makeText(this, "HAS PULSADO caca"+ tarea.getNombre(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

}
