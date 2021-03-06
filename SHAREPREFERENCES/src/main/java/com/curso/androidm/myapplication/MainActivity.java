package com.curso.androidm.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent intent = new Intent(this, ComfiguracionActivity.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.action_leersettings) {

            String mensage = null;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            String frecuencia  = defaultSharedPreferences.getString("frecuencias", "0");
            String url         = defaultSharedPreferences.getString("url", "0");

            mensage = frecuencia + " " + url;
            Toast.makeText(this, mensage, Toast.LENGTH_LONG);


            return true;
        }
        if (id == R.id.action_escrivirsettings) {

            String mensage = null;


            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();

            editor.putString("frecuencias", "0");
            editor.putString("url","dadadad");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
