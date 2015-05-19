package com.curso.androidm.myapplication;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */


public class MiDialagoFragment extends DialogFragment {


    private DialogInterface.OnClickListener pnegativo, ppositivo;

    private  AlertDialog.Builder factoria;

    public MiDialagoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Dialog onCreateDialog(Bundle savedInstanceState){


        factoria = new AlertDialog.Builder(getActivity());
        factoria.setMessage("Desea continuar");
        factoria.setPositiveButton("Si", ppositivo);
        factoria.setNegativeButton("No",pnegativo);
        return  factoria.create();

    }
    public void SetOnClicLisenerPositivo(DialogInterface.OnClickListener p1) {
        ppositivo = p1;
    }
    public void SetOnClicLisenerNegativo(DialogInterface.OnClickListener p1)
    {
        pnegativo = p1;
    }


}
