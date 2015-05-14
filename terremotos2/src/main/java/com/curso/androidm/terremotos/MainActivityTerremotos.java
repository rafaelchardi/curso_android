package com.curso.androidm.terremotos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivityTerremotos extends ActionBarActivity implements View.OnClickListener{

    private ImageButton bottonbuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_terremotos);
        bottonbuscar = (ImageButton) findViewById(R.id.ButtonBuscar);
        bottonbuscar.setOnClickListener(this);
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

        Intent intent = new Intent(this, MainActivityListaResultado.class);
        startActivity(intent);

    }
}
