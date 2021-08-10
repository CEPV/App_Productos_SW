package com.example.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myappswlocal.complementos.MetodosSW;
import com.example.myappswlocal.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText editTextBuscar, editTextNombre, editTextDistribuidor, editTextPrecio, editTextTamaño;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar_sw);

        editTextBuscar = findViewById(R.id.edtBuscarActualizar);
        editTextNombre = findViewById(R.id.edtNombreActualizar);
        editTextDistribuidor = findViewById(R.id.edtDistribuidorActualizar);
        editTextPrecio = findViewById(R.id.edtPrecioActualizar);
        editTextTamaño = findViewById(R.id.edtTamañoActualizar);

    }

    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.imgBuscarActualizar:
                this.buscarID();
                break;

            case R.id.btnActualizar:
                this.actualizar();
                break;


        }

    }
    private void actualizar(){
        if(!editTextBuscar.getText().toString().isEmpty()&&!editTextNombre.getText().toString().isEmpty()&&!editTextDistribuidor.getText().toString().isEmpty()&&!editTextPrecio.getText().toString().isEmpty()&&!editTextTamaño.getText().toString().isEmpty()){
            metodosSW.actualizarsw(this,Integer.parseInt(editTextBuscar.getText().toString()),editTextNombre.getText().toString(),editTextDistribuidor.getText().toString(),Integer.parseInt(editTextPrecio.getText().toString()),editTextTamaño.getText().toString(),this,this);

            editTextBuscar.setText("");
            editTextNombre.setText("...");
            editTextDistribuidor.setText("...");
            editTextPrecio.setText("...");
            editTextTamaño.setText("...");
            Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    private void buscarID(){
        if(!editTextBuscar.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this, Integer.parseInt(editTextBuscar.getText().toString()),this,this);
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
            String dato = productoVO.getNombreProducto();
            if(!dato.equals("...")) {
                editTextNombre.setText(productoVO.getNombreProducto());
                editTextDistribuidor.setText(productoVO.getDistribuidorProducto());
                editTextPrecio.setText(String.valueOf(productoVO.getPrecioProducto()));
                editTextTamaño.setText(productoVO.getTamañoProducto());
            }else{
                editTextNombre.setText("...");
                editTextDistribuidor.setText("...");
                editTextPrecio.setText("...");
                editTextTamaño.setText("...");
                Toast.makeText(this, "Datos no Encontrados", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"Error referente a A", Toast.LENGTH_LONG).show();
            System.err.println("A----- "+e.getCause()+" --- "+e.getMessage());
        }
    }
    @Override
    public void onResponse(JSONObject response) {
        this.resultado(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {

    }


}