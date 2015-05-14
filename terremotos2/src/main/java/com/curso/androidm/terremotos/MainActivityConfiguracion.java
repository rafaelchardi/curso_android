package com.curso.androidm.terremotos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivityConfiguracion extends ActionBarActivity implements View.OnClickListener{
    private Button bAceptar,bCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        bAceptar = (Button) findViewById(R.id.buttonAceptar);
        bCancelar = (Button) findViewById(R.id.buttonCancelar);
        bAceptar.setOnClickListener(this);
        bCancelar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_configuracion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salir) {

            setResult(RESULT_CANCELED);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        CharSequence lc_texto_aux;

        if (((Button) v).getId()==bAceptar.getId()) {
            Intent i = getIntent();
            //////////////////////////////////////////////////////////////////////////////////////
            // Le metemos el resultado que queremos mandar a la
            // actividad principal.
            //////////////////////////////////////////////////////////////////////////////////////
            EditText lc_url = (EditText) findViewById(R.id.editUrl);
            EditText lc_frecuencia = (EditText) findViewById(R.id.editFrecuencia);
            // TODO HAY QUE VALIDAD LAS ENTRADAS DE LA URL Y LA FRECUENCIA.
            i.putExtra("URL", lc_url.toString());
            i.putExtra("FRECUENCIA", lc_frecuencia.toString());
            setResult(RESULT_OK, i);
            //return true;
        }
        if (((Button) v).getId()==bAceptar.getId()) {

            setResult(RESULT_CANCELED);
            //return true;
        }
        finish();

    }
}
