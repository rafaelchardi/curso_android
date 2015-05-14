package com.curso.androidm.myapplication;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView tareaslistView = (ListView) findViewById(R.id.tareaslistView);

        final List<Tareas> datos = new LinkedList<Tareas>();
        datos.add(new Tareas("Nadar","nadar Nadar Nadar"));
        datos.add(new Tareas("Bici","bici Bici Bici "));
        datos.add(new Tareas("Correr", "correr Correr Correr"));

        final TareasAdapter adaptador = new TareasAdapter(this,R.layout.tarea_list_item,datos);

        tareaslistView.setAdapter(adaptador);

        Button buttonBorrar1 = (Button) findViewById(R.id.buttonBorrar);
        buttonBorrar1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                datos.remove(0);
                adaptador.notifyDataSetChanged();
            }
        });

        /*
            String[] datos = new String[]{"Correr", "Nadar", "Bici"};
            ListAdapter adaptador = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, datos);
        */



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

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

}
