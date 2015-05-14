package com.curso.androidm.mycalculadora2intento;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import MODELO.CalculadoraAvanzada;
import MODELO.CalculadoraBasica;
import NEGOCIO.GestionCalculadora;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////// creamos la calculardor y la gestion de la misma
        CalculadoraAvanzada CalculadoraAvanzada1 = new CalculadoraAvanzada();
        CalculadoraBasica CalculadoraBasica1  = new CalculadoraBasica();
        //////////////////////////////////////////////// asignamos la calculadora avanzada por ejemplo

        ((GestionCalculadora ) getApplication()).setCalculadora(CalculadoraAvanzada1);
        (((GestionCalculadora) getApplication()).getCalculadora()).holaCaragola();

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
