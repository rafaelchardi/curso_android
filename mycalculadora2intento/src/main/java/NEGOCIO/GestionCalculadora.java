package NEGOCIO;

import android.app.Application;

import MODELO.ICalculadora;

/**
 * Created by androidm on 11/05/2015.
 */

public class GestionCalculadora  extends Application {

    private ICalculadora Calculadora;

    public GestionCalculadora(ICalculadora calculadora) {
        Calculadora = calculadora;
    }

    public ICalculadora getCalculadora() {

        return Calculadora;
    }

    public void setCalculadora(ICalculadora calculadora) {
        Calculadora = calculadora;
    }


}
