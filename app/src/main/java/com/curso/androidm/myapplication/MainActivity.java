package com.curso.androidm.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import android.view.View;
import android.widget.Button;
import listener.MionClicklistener;


public class MainActivity extends Activity implements View.OnClickListener{
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializador();
    }
    private void inicializador()
    {
        b1 = (Button) findViewById(R.id.button1111);
        b2 = (Button) findViewById(R.id.button2);

        //CASO 1
        //MionClicklistener Listener1 = new MionClicklistener(b1);
        //Listener1.setMiButton(b2);
        //b1.setOnClickListener(Listener1);
        //----------------------------------
        //CASO 2
        //b1.setOnClickListener(new MionClicklistener(b2));
        //-----------------------------------
        //CASO 3
        //final  String valor = "caragola";

        //b1.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v){
        //        Log.i("adfa","ad="+valor);
        //
        //    }
        //});

        b1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String lc_cadena;
        lc_cadena="b2";
        if (v.getId()==b1.getId()){
              lc_cadena="b1";
                    }

        ((Button) v).setText(lc_cadena);

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



    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

}
