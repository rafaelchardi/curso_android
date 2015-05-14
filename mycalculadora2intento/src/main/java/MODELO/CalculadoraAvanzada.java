package MODELO;

/**
 * Created by androidm on 11/05/2015.
 */
public class CalculadoraAvanzada implements ICalculadora{
    //public void setMemoria(double a)
    //{
    //memoria = a;
    //}
    public void holaCaragola (){

    }


    public double getMemoria()
    {
        return memoria;
    }

    @Override
    public double suma(double a, double b) {
        return a+b;
    }

    @Override
    public double resta(double a, double b) {
        return a-b;
    }

    @Override
    public double multiplica(double a, double b) {
        return a*b;
    }
}