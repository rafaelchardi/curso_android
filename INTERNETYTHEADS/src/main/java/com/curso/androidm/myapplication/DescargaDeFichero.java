package com.curso.androidm.myapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by androidm on 19/05/2015.
 */
public class DescargaDeFichero extends AsyncTask<String, Integer ,Bitmap> {

    private ImageView imageview1;
    private ProgressDialog progressDialog1;

    public DescargaDeFichero(ImageView imageview1, ProgressDialog progressDialog1) {
        this.imageview1 = imageview1;
        this.progressDialog1 = progressDialog1;
    }

    public ImageView getImageview1() {
        return imageview1;
    }

    public void setImageview1(ImageView imageview1) {
        this.imageview1 = imageview1;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */

    // metodo que se ejecuta en el hilo secundario.
    // aqui utilizaremos el API de conexion url



    @Override
    protected Bitmap doInBackground(String... params) {

        Bitmap bitmapresul = null;
       //  String param = params[0];
       //  creaMOS LA NUEVA URL
       // el parametro 0 tienene que ser un http.

        try {
            URL url = new URL(params[0]);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int tamanoImagen = con.getContentLength(); // tamaño de la imagen en byte

            InputStream is = con.getInputStream();

            //esto es para sacar la barra de proceso.
            byte[] buffer = new byte[512];
            byte[] imagen = new byte[tamanoImagen];
            // recorremos en 512 en 512

            for (int bytestotalesleidos = 0; bytestotalesleidos < tamanoImagen;){

                int bytesledidos = is.read(buffer);
                // compia un array desde una posicion
                System.arraycopy(buffer,0,imagen,bytestotalesleidos,bytesledidos);

                publishProgress(bytestotalesleidos*100/tamanoImagen);

                bytestotalesleidos+=bytesledidos;
            }

            bitmapresul = BitmapFactory.decodeByteArray(imagen, 0, tamanoImagen);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bitmapresul;
    }

    // se ejecuta al terminar.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageview1.setImageBitmap(bitmap);
        progressDialog1.hide();
    }

    // se ejeucta mientas va ejecutandose.
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressDialog1.setProgress(values[0]);

    }

    @Override
    // se ejecuta anteriormente
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog1.setProgress(0);
        progressDialog1.setProgressStyle(progressDialog1.STYLE_HORIZONTAL);
        progressDialog1.show();
    }
}
