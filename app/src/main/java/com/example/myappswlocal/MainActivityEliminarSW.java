package com.example.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myappswlocal.complementos.MetodosSW;
import com.example.myappswlocal.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.EventListener;

public class MainActivityEliminarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText editText;
    TextView textViewNombre, textViewDistribuidor, textViewPrecio, textViewTamaño;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar_sw);

        editText = findViewById(R.id.edtBuscarEliminar);
        textViewNombre = findViewById(R.id.txtNombreProductoEliminar);
        textViewDistribuidor = findViewById(R.id.txtDistribuidorProductoEliminar);
        textViewPrecio = findViewById(R.id.txtPrecioProductoEliminar);
        textViewTamaño = findViewById(R.id.txtTamañoProductoEliminar);


    }

    public void Onclick(View view) {
        switch (view.getId()){
            case  R.id.imgBuscarEliminar:
                buscarID();
                break;
            case  R.id.btnEliminarBusqueda:
                eliminar();
                break;
        }
    }

    private void eliminar(){
        if(!editText.getText().toString().isEmpty()){
            metodosSW.eliminarSW(this, Integer.parseInt(editText.getText().toString()),this,this);
            editText.setText("");
            textViewNombre.setText("...");
            textViewDistribuidor.setText("...");
            textViewPrecio.setText("...");
            textViewTamaño.setText("...");
            Toast.makeText(this,"Dato Eliminado Correctamente",Toast.LENGTH_SHORT).show();


        }else {
            Toast.makeText(this,"Debe de llenar campo",Toast.LENGTH_SHORT).show();
        }
    }

    private void buscarID(){
        if(!editText.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this, Integer.parseInt(editText.getText().toString()),this,this);
        }
        else {
            Toast.makeText(this,"Debe de llenar campo",Toast.LENGTH_SHORT).show();
        }
    }
    private  void resultadoBusqueda(JSONObject response){
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
            productoVO.setDistribuidorProducto(jsonObject.optString("distribuidor_producto"));
            productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
            productoVO.setTamañoProducto(jsonObject.optString("tamaño_producto"));

            textViewNombre.setText(productoVO.getNombreProducto());
            textViewDistribuidor.setText(productoVO.getDistribuidorProducto());
            textViewPrecio.setText(String.valueOf(productoVO.getPrecioProducto()));
            textViewTamaño.setText(productoVO.getTamañoProducto());



        }catch (Exception e){
            Toast.makeText(this,"Error referente a E", Toast.LENGTH_LONG).show();
            System.err.println("E----- "+e.getCause()+" --- "+e.getMessage());

        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoBusqueda(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a E "+error, Toast.LENGTH_SHORT).show();
        System.err.println("E***** "+error);
    }


}