package com.curso.androidm.myapplication;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // obtenmos el objeto
        Fragment fragmentById = getFragmentManager().findFragmentById(R.id.fragmentlistado);
        ((ListadoTareasFragment) fragmentById).registresListViesTareasOnClickListenesr(this);
        // O
        ((ListadoTareasFragment) fragmentById).registresListViesTareasOnClickListenesr(new View.OnClickListener(){
                                                                                           /**
                                                                                            * Called when a view has been clicked.
                                                                                            *
                                                                                            * @param v The view that was clicked.
                                                                                            */
                                                                                           @Override
                                                                                           public void onClick(View v) {

                                                                                           }
                                                                                       }
        );


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
    @Override
    public void onClick(View v) {


    }
}
