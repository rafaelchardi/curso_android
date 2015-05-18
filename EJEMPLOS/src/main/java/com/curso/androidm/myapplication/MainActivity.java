package com.curso.androidm.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;





import javax.xml.parsers.SAXParser;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carga el conetext del layout/activity_main.xml
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // carga el abrol del menu.mail.xml
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
        if (id == R.id.action_1) {
            //TODO abrir una nueva actividad .
            Intent intent = new Intent(this, SeconActivity.class);
            // disparamos el evento o ejecutamos la intecion
            //                                                                          startActivity(intent); // abrir actividad sin esperar respuesta
            // arancarcar una actividad esperando un resultado.
            Informacion dado = new Informacion("rafael");
            intent.putExtra("dato1",dado); // valores que les pasamos a la actividadad.
            startActivityForResult(intent,0); //
            return true;
        }
        if (id == R.id.action_2) {
            //TODO abrir una nueva actividad .
            Intent intent = new Intent(this, SeconActivity.class);
            // disparamos el evento o ejecutamos la intecion
            //startActivity(intent); // abrir actividad sin esperar respuesta
            // arancarcar una actividad esperando un resultado.
            //Bundle es un mapa de valores
            Informacion dado = new Informacion("pilar");
            intent.putExtra("dato1",dado); // valores que les pasamos a la actividadad.
            startActivityForResult(intent,1); //
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*{if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT).show();
        }*/
        String f11 = new String();
        f11  = data.getExtras().getString("RESULTADO");
        switch (requestCode) {
            case 0:
                Toast.makeText(this, "este el 0", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, f11, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "este el 1", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, f11, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
