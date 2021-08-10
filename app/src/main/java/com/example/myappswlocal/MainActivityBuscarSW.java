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

public class MainActivityBuscarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editText;
    TextView textViewNombre, textViewDistribuidor, textViewPrecio, textViewTamaño;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar_sw);
        editText = findViewById(R.id.edtBuscar);
        textViewNombre = findViewById(R.id.txtNombreProducto);
        textViewDistribuidor = findViewById(R.id.txtDistribuidorProducto);
        textViewPrecio = findViewById(R.id.txtPrecioProducto);
        textViewTamaño = findViewById(R.id.txtTamañoProducto);

    }

    public void Onclick(View view) {
        this.buscarID();
    }

    private void buscarID(){
        if(!editText.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this,Integer.parseInt(editText.getText().toString()),this,this);
        }
        else {
            Toast.makeText(this,"Debe de llenar campo",Toast.LENGTH_SHORT).show();
        }
    }

    private void resultado(JSONObject response){
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try {
            JSONObject jsonObject = null;
            jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
            productoVO.setDistribuidorProducto(jsonObject.optString("distribuidor_producto"));
            productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
            productoVO.setTamañoProducto(jsonObject.optString("tamaño_producto"));

            textViewNombre.setText(productoVO.getNombreProducto());
            textViewDistribuidor.setText(productoVO.getDistribuidorProducto());
            textViewPrecio.setText(String.valueOf(productoVO.getPrecioProducto()));
            textViewTamaño.setText(productoVO.getTamañoProducto());

        }catch (Exception e){
            Toast.makeText(this,"Error referente a B", Toast.LENGTH_LONG).show();
            System.err.println("B----- "+e.getCause()+" --- "+e.getMessage());
        }
    }


    @Override
    public void onResponse(JSONObject response)
    {
        this.resultado(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a B "+error, Toast.LENGTH_SHORT).show();
        System.err.println("B***** "+error);
    }


}