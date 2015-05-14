package com.curso.androidm.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by androidm on 13/05/2015.
 */
public class TareasAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<Tareas> collecion;

    public List<Tareas> getCollecion() {
        return collecion;
    }

    public void setCollecion(List<Tareas> collecion) {
        this.collecion = collecion;
    }
    // List ->  garantiza que los datos estan ordenadors y puedo meter dos iguales.
       //  Set ->  lo mismo que list pero no puedo meter duplicados.
       // Collection -> NO garantiza que estan ordenador.
       // y necesitamos una lista ordenada.
       // Array - > no se puede redimensionar los

    public TareasAdapter(Context context, int layout, List<Tareas> collecion) {
        this.context = context;
        this.layout = layout;
        this.collecion = collecion;
    }
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return collecion.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {

        return collecion.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // obtiene cualquier servicicio del sistema

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        final Tareas item = (Tareas) getItem(position);

        TextView txNombre      = (TextView)  convertView.findViewById(R.id.txNombre);
        TextView txDescripcion = (TextView)  convertView.findViewById(R.id.txDescripcion);





        txNombre.setText(item.getNombre());
        txDescripcion.setText(item.getDescripcion());


        Button button1 = (Button) convertView.findViewById(R.id.button1);
        button1.setText(item.getNombre());
        button1.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(TareasAdapter.this.context, "este " + item.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }
}
