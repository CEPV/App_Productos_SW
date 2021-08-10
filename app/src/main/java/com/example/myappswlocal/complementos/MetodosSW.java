package com.example.myappswlocal.complementos;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {

    //Declarar una constante de la IP del servidor local en mi red LAN
    public static final String IP_SERVER = "http://192.168.0.22/";

    //Implementar variables para la conexion y obtencion de informacion
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {

    }

    //Metodo de Insertar
    public void insertarSW(Context context, String nombre, String distribuidor, int precio,
                           String tamaño, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/insertar_sw.php?nombre_producto="+nombre+
                    "&distribuidor_producto="+distribuidor+"&precio_producto="+precio+
                    "&tamaño_producto="+tamaño;

            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoI"+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("I----"+e.getCause()+"-----"+e.getMessage());
        }
    }

    //Metodo Buscar por ID
    public void  buscarIDSW(Context context, int id, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/buscar_id.php?id_producto="+id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoB"+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("B----"+e.getCause()+"-----"+e.getMessage());
        }


    }

    //Metodo Consultar
    public void consultaSW(Context context, Response.Listener listener, Response.ErrorListener errorListener){

        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);

        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoC"+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C----"+e.getCause()+"-----"+e.getMessage());
        }

    }

    //Metodo Eliminar
    public void eliminarSW(Context context, int id, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/eliminar_sw.php?id_producto="+id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);

        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoE"+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C----"+e.getCause()+"-----"+e.getMessage());
        }
    }

    public void actualizarsw(Context context, int id, String nombre, String distribuidor, int precio, String tamaño, Response.Listener listener, Response.ErrorListener errorListener){
        this.context=context;
        try {
            String url;
            url = IP_SERVER+"producto_sw/actualizar_sw.php?id_producto="+id+"&nombre_producto="+nombre+"&distribuidor_producto="+distribuidor+"&precio_producto="+precio+"&tamaño_producto="+tamaño;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);

        }catch (Exception e){
            Toast.makeText(context, "ConflictoA"+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("A----"+e.getCause()+"-----"+e.getMessage());

        }

    }

}
