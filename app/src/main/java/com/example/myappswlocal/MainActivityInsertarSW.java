package com.example.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myappswlocal.complementos.MetodosSW;

import org.json.JSONObject;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText editTextNombre, editTextDistribuidor, editTextPrecio, editTextTamaño;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);
        editTextNombre = findViewById(R.id.edtNombreProducto);
        editTextDistribuidor = findViewById(R.id.edtDistribuidorProducto);
        editTextPrecio = findViewById(R.id.edtPrecioProducto);
        editTextTamaño = findViewById(R.id.edtTamañoProducto);
    }

    public void Onclick(View view) {
        insertar();
    }

    private void insertar(){
        if(!editTextNombre.getText().toString().isEmpty()&&!editTextDistribuidor.getText().toString().isEmpty()&&!editTextPrecio.getText().toString().isEmpty()&&!editTextTamaño.getText().toString().isEmpty()){
          //Utilizamos el metodo respectivo de la clae MetodoSW
          metodosSW.insertarSW(this, editTextNombre.getText().toString(),editTextDistribuidor.getText().toString(),Integer.parseInt(editTextPrecio.getText().toString()),editTextTamaño.getText().toString(),
                  this,this);

          editTextNombre.setText("");
          editTextDistribuidor.setText("");
          editTextPrecio.setText("");
          editTextTamaño.setText("");


        }
        else {
            Toast.makeText(this,"Debe de llenar campo",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onResponse(JSONObject response) {
    Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a "+error, Toast.LENGTH_SHORT).show();
        System.err.println("I***** "+error);
    }


}