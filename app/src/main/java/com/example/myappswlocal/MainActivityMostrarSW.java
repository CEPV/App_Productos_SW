package com.example.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myappswlocal.complementos.MetodosSW;
import com.example.myappswlocal.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ProductoVO> ListaProductoVO;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_sw);

        listView = findViewById(R.id.lvListaProductos);
        metodosSW.consultaSW(this,this,this);

    }

    private void resultadoConsultaCompleta(JSONObject response){
        //ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        ListaProductoVO = new ArrayList<>();

        try {
            for (int i=0;i<jsonArray.length();i++){
                ProductoVO productoVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productoVO.setIdProducto((jsonObject.optInt("id_producto")));
                productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
                productoVO.setDistribuidorProducto(jsonObject.optString("distribuidor_producto"));
                productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
                productoVO.setTamañoProducto(jsonObject.optString("tamaño_producto"));

                ListaProductoVO.add(productoVO);
            }

            listaDatos = new ArrayList<>();
            for (int i=0; i < ListaProductoVO.size();i++){
                listaDatos.add(ListaProductoVO.get(i).getIdProducto()+". "+ListaProductoVO.get(i).getNombreProducto());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,listaDatos);
            listView.setAdapter(arrayAdapter);
        }
        catch (Exception e){
            Toast.makeText(this,"Error referente a C", Toast.LENGTH_LONG).show();
            System.err.println("B----- "+e.getCause()+" --- "+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
    this.resultadoConsultaCompleta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente C "+error, Toast.LENGTH_SHORT).show();
        System.err.println("C***** "+error);
    }


}