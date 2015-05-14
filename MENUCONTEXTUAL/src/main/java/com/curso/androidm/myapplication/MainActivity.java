package com.curso.androidm.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView tareaslistView = (ListView) findViewById(R.id.lvtareas);

        final List<Tareas> datos = new LinkedList<Tareas>();
        datos.add(new Tareas("Nadar","nadar Nadar Nadar"));
        datos.add(new Tareas("Bici","bici Bici Bici "));
        // hola
        // tercera versiuon

        datos.add(new Tareas("Correr", "correr Correr Correr"));

        final TareasAdapter adaptador = new TareasAdapter(this,R.layout.tarea_list_item,datos);

        tareaslistView.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
