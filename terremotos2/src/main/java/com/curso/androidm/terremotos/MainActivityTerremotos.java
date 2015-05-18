package com.curso.androidm.terremotos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// pagina de los termotos.
// http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.atom

public class MainActivityTerremotos extends ActionBarActivity implements View.OnClickListener{

    private ImageButton bottonbuscar;
    private EditText editTextFecha;
    private   Spinner spinnerMagnitud;
    final List<TipoTerremoto> datos = new LinkedList<TipoTerremoto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_terremotos);
        bottonbuscar = (ImageButton) findViewById(R.id.ButtonBuscar);
        editTextFecha= (EditText) findViewById(R.id.editTextFecha);
        spinnerMagnitud = (Spinner) findViewById(R.id.spinnerMagnitud);

        bottonbuscar.setOnClickListener(this);


        datos.add(new TipoTerremoto(1, "Tipo 1"));
        datos.add(new TipoTerremoto(2, "Tipo 2"));
        datos.add(new TipoTerremoto(3, "Tipo 3"));
        datos.add(new TipoTerremoto(4, "Tipo 4"));
        datos.add(new TipoTerremoto(5, "Tipo 5"));
        datos.add(new TipoTerremoto(6, "Tipo 6"));
        datos.add(new TipoTerremoto(7, "Tipo 7"));

        ArrayAdapter<TipoTerremoto> adaptador = new ArrayAdapter<TipoTerremoto>(this, android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMagnitud.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_terremotos, menu);
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

            Intent intent = new Intent(this, MainActivityConfiguracion.class);
            startActivityForResult(intent, 0); //
            //startActivityForResult(intent,0); //
            return true;
        }

        if (id == R.id.action_help) {

            Intent intent = new Intent(this, MainActivityHelp.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {

        } else {
                switch (requestCode) {
                    case 0: //  venimos del la configuracion
                            String lc_url,lc_frecuencia = new String();
                            lc_url  = data.getExtras().getString("URL");
                            lc_frecuencia = data.getExtras().getString("FRECUENCIA");
                            //TODO  HAY QUE ACTUALICAR EL SETTING Y REPROGRAMAR LA ALARMA
                            break;
                            }
        }


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        int selectedItemPosition = spinnerMagnitud.getSelectedItemPosition();
        Editable text1 = editTextFecha.getText();
        Intent i = getIntent();
        //////////////////////////////////////////////////////////////////////////////////////
        // Le metemos el resultado que queremos mandar a la
        // actividad principal.
        //////////////////////////////////////////////////////////////////////////////////////
        // TODO HAY QUE VALIDAD LAS ENTRADAS DE LA URL Y LA FRECUENCIA.

        i.putExtra("MAGNITUD",datos.get(selectedItemPosition).getIntensidad());
        i.putExtra("FECHA", text1.toString());
//        Toast.makeText(this, "MAGNITUD"+ datos.get(selectedItemPosition).getIntensidad(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "FECHA"+ text1.toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivityListaResultado.class);
        startActivity(intent);

    }
}
