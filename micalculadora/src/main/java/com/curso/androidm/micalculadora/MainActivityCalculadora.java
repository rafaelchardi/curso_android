package com.curso.androidm.micalculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityCalculadora extends Activity implements View.OnClickListener {

    private Integer ai_memoria = 0;                           /// almacenmos el valor de la memoria
    private String ac_operacion_anterior = "I";               // ultima operacion a realizar

    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bmas,bmenos,bc,buttonigual;
    private EditText Edit_resultado,Edit_trabajo;
    private TextView Texto_operacion;

    // getter y Setter
    /////////////////////////////////////////////////////////////////////////////////////////
    public String getAc_operacion_anterior() {

        return ac_operacion_anterior;
    }

    public void setAc_operacion_anterior(String ac_operacion_anterior) {
        this.ac_operacion_anterior = ac_operacion_anterior;
    }


    public Integer getAi_memoria() {
        return ai_memoria;
    }

    public void setAi_memoria(Integer ai_memoria) {
        this.ai_memoria = ai_memoria;
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_calculadora);
        inicializador();
    }
    private void inicializador()
    {
        // capturamos botones y campos de edicion
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bmas = (Button) findViewById(R.id.bmas);
        bmenos = (Button) findViewById(R.id.bmenos);
        bc = (Button) findViewById(R.id.bc);
        buttonigual = (Button) findViewById(R.id.buttonigual);
        Edit_resultado = (EditText) findViewById(R.id.editText2);
        Edit_trabajo  = (EditText) findViewById(R.id.editText1);
        Texto_operacion = (TextView) findViewById(R.id.Opercio);


        // asignamos los listener
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bmas.setOnClickListener(this);
        bmenos.setOnClickListener(this);
        bc.setOnClickListener(this);
        buttonigual.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_calculadora, menu);
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
    //
     private void  fi_opera() {
        CharSequence lc_texto_aux;
        String lc_texto;
        Integer li_resul = 0,li_valor_campo_trabajo=0;

        // optenemos el texto del campo de trabajo y calculamos su valor en li_valor_campo_trabajo
        lc_texto_aux = Edit_trabajo.getText();
        lc_texto = lc_texto_aux.toString();
         try
         {
             li_valor_campo_trabajo = Integer.parseInt(lc_texto);
         }

         catch(Exception excepcion)
         {
             li_valor_campo_trabajo =0;
         }

        // segun la operacion a realizar
        if (ac_operacion_anterior.equals("+")) {
                        setAi_memoria(getAi_memoria()+li_valor_campo_trabajo);
                        Edit_trabajo.setText("");
        }
        if (ac_operacion_anterior.equals("-")) {
                        setAi_memoria(getAi_memoria()-li_valor_campo_trabajo);
                        Edit_trabajo.setText("");
                                            }
         if (ac_operacion_anterior.equals("I")) {
                        setAi_memoria(li_valor_campo_trabajo );
                        Edit_trabajo.setText("");
         }

         Edit_resultado.setText(getAi_memoria().toString());

    }

    @Override
    public void onClick(View v) {
        boolean lb_actua;
        CharSequence lc_texto_aux;
        String lc_texto,lc_texto_trabajo;

        lc_texto_aux=((Button) v).getText(); // obtengo el texto del boton pulsado.
        lc_texto=lc_texto_aux.toString();

        lc_texto_aux = Edit_trabajo.getText();
        lc_texto_trabajo=lc_texto_aux.toString();


        if (lc_texto.equals("c") ||  lc_texto.equals("+") || lc_texto.equals("-") || lc_texto.equals("="))
        {

            if ((lc_texto.equals("=")) && (getAc_operacion_anterior() != "I")){
                                          fi_opera();
//                                         Edit_resultado.setText(getAi_memoria().toString());
                                          setAc_operacion_anterior("I");
                                          };

            if (lc_texto.equals("c")) {
                                       Edit_trabajo.setText("");
                                      };

            if (lc_texto.equals("+")) {
                                     fi_opera();
                                     setAc_operacion_anterior(lc_texto);
                                      };

            if (lc_texto.equals("-")) {
                                      fi_opera();
                                      setAc_operacion_anterior(lc_texto);
                                      };


            Texto_operacion.setText(getAc_operacion_anterior());
            if (getAc_operacion_anterior().equals("I")) {
                                 Texto_operacion.setText("");
                            }
        } else{

            lb_actua = true;
            if ( (lc_texto.equals("0")) &&  ((lc_texto_trabajo.equals("0") || lc_texto_trabajo.equals("") || lc_texto_trabajo.equals(null))))
            {
                lb_actua = false;
            }
            if (lb_actua){
                           Edit_trabajo.setText(lc_texto_trabajo+lc_texto);
                }

             }
        }




    }


