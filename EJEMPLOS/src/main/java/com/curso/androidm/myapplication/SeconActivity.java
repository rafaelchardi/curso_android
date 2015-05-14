package com.curso.androidm.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;


public class SeconActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        Informacion dato1 = (Informacion) getIntent().getExtras().getSerializable("dato1");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secon, menu);
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
            Intent i = getIntent();
            //////////////////////////////////////////////////////////////////////////////////////
            // Le metemos el resultado que queremos mandar a la
            // actividad principal.
            //////////////////////////////////////////////////////////////////////////////////////
            i.putExtra("RESULTADO", "resultado de la segunda actividad");
            setResult(RESULT_OK, i);
            finish();
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
