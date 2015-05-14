package MODELO;

/**
 * Created by androidm on 11/05/2015.
 */
public interface ICalculadora {
    double memoria = 0;
    //void setMemoria(double a);
    double getMemoria();
    double suma(double a , double b);
    double resta(double a , double b);
    double multiplica(double a , double b);
    void holaCaragola();
}
