package com.curso.androidm.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView viewById2 = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<Terremoto> terremotoArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        viewById2.setAdapter(terremotoArrayAdapter);

        DescargarXmTerremotos descargarXmTerremotos = new DescargarXmTerremotos(terremotoArrayAdapter);


        descargarXmTerremotos.execute("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.atom");

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
