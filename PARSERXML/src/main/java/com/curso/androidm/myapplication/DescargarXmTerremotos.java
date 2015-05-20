package com.curso.androidm.myapplication;

import android.os.AsyncTask;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by androidm on 20/05/2015.
 */
public class DescargarXmTerremotos extends AsyncTask<String,Void, List<Terremoto>> {
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
    //private ListView listaView;
    private ArrayAdapter arrayAdapter;


    public DescargarXmTerremotos(ArrayAdapter arrayAdapter1) {
        this.arrayAdapter = arrayAdapter1;
    }

    @Override
    protected List<Terremoto> doInBackground(String... params) {


        try {
            URL url = new URL(params[0]);
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            return parsearXML(is);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;


    }
/*
<entry>
<id>urn:earthquake-usgs-gov:nn:00495052</id>
<title>M 0.4 - 57km N of Pahrump, Nevada</title>
<updated>2015-05-20T08:29:47.898Z</updated>
<link rel="alternate" type="text/html" href="http://earthquake.usgs.gov/earthquakes/eventpage/nn00495052"/>
<summary type="html">
<![CDATA[
<dl><dt>Time</dt><dd>2015-05-20 08:28:11 UTC</dd><dd>2015-05-20 01:28:11 -07:00 at epicenter</dd><dt>Location</dt><dd>36.726&deg;N 115.917&deg;W</dd><dt>Depth</dt><dd>15.95 km (9.91 mi)</dd></dl>
]]>
</summary>
<georss:point>36.726 -115.9173</georss:point>
<georss:elev>-15950</georss:elev>
<category label="Age" term="Past Hour"/>
<category label="Magnitude" term="Magnitude 0"/>
</entry>
<entry>
 */
    private List<Terremoto> parsearXML(InputStream is) throws XmlPullParserException, IOException {

        LinkedList<Terremoto> resultado = new LinkedList<>();

        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(is, "UTF-8");

        int event = parser.getEventType();

        Terremoto terremoto = null;


        while (event != XmlPullParser.END_DOCUMENT) {

            String tag = parser.getName();

            if (event == XmlPullParser.START_TAG) {
                //////////////////////////////////////////////////
                if (tag.equals("entry")) { //entry
                    terremoto = new Terremoto();
                }

                if (terremoto !=null && tag.equals("id") ){
                    terremoto.setId(parser.nextText());
                }

                if (terremoto !=null && tag.equals("title") ){
                //    <title>M 0.4 - 57km N of Pahrump, Nevada</title>
                     String s = parser.nextText();
                      String[] split = s.split(" - ");
//                    float magnitud = Float.parseFloat(split[0].split(" ")[1]);
                     terremoto.setTitulo(split[1]);
//                    terremoto.setMagnitud(magnitud);

                }

                if (terremoto !=null && tag.equals("updated") ){
                //    <updated>2015-05-20T08:29:47.898Z</updated>

                    SimpleDateFormat sdf = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\"");

                    try {
                         Date date = sdf.parse(parser.nextText());
                         terremoto.setFecha(date);
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }

                }
                if (terremoto !=null && tag.equals("link") ){
                    //<link rel="alternate" type="text/html" href="http://earthquake.usgs.gov/earthquakes/eventpage/nn00495052"/>
                    String href = parser.getAttributeValue(null, "href");
                    terremoto.setLink(href);

                }
                if (terremoto !=null && tag.equals("point") ){
                    String[] coordenadas = parser.nextText().split(" ");
                    terremoto.setLatitud(Double.parseDouble(coordenadas[0]));
                    terremoto.setLongitud(Double.parseDouble(coordenadas[1]));
                }

                //////////////////////////////////////////////////
            } else if (event == XmlPullParser.END_TAG) {
                //////////////////////////////////////////
                if (tag.equals("entry")) {
                    resultado.add(terremoto);
                    terremoto = null;
                }
                //////////////////////////////



            } // else

            event = parser.next(); // tipo de elemento


        } // while

        return resultado;
    }

    @Override
    protected void onPostExecute(List<Terremoto> terremotos) {
        super.onPostExecute(terremotos);

//        ((ArrayAdapter<Terremoto>) listaView.getAdapter()).addAll(terremotos);

  //      ((ArrayAdapter<Terremoto>) listaView.getAdapter()).notifyDataSetChanged();


        arrayAdapter.addAll(terremotos);
        arrayAdapter.notifyDataSetChanged();

    }
}
