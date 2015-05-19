package com.curso.androidm.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private MiDialagoFragment miDialagoFragment;


      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miDialagoFragment = new MiDialagoFragment();

        miDialagoFragment.SetOnClicLisenerPositivo(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Has pulsado SI", Toast.LENGTH_LONG);
            }
        });

        miDialagoFragment.SetOnClicLisenerNegativo(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Has pulsado NO", Toast.LENGTH_LONG);

            }

        });


         //FragmentTransaction  fragmentTransaction = getFragmentManager().beginTransaction();
         //fragmentTransaction.add(miDialagoFragment,"midialdogframenget");
         //fragmentTransaction.commit();
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
            miDialagoFragment.show(getFragmentManager(),"MIDIALOGOFRAME");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
