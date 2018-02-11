package com.example.u3_controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;
    Spinner spProvincias;
    CheckBox cbOpcion;
    RadioGroup rgSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        spProvincias = (Spinner)findViewById(R.id.spProvincias);
        cbOpcion = (CheckBox)findViewById(R.id.cbOpcion);
        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);

        String[] provincias = {"","Cádiz","Málaga","Almeria"};

        ArrayAdapter<String> adaptadorProvincias = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,provincias);

        spProvincias.setAdapter(adaptadorProvincias);

    }//FIN ONCREATE

    public void validar(View view){

        if(cbOpcion.isChecked()){

            String nombre = etNombre.getText().toString();
            String provincia = spProvincias.getSelectedItem().toString();
            int id = rgSexo.getCheckedRadioButtonId();

            if(nombre.equals("") || provincia.equals("") || id==-1){
                Toast.makeText(getApplicationContext(), "Debe de rellenar todos los campos",Toast.LENGTH_LONG).show();
            }else{

                RadioButton rbCopia = (RadioButton)findViewById(id);
                String textoRadioButton = rbCopia.getText().toString();
                Toast.makeText(getApplicationContext(), "Nombre "+nombre+"\nProvincia: "+provincia+"\nSexo: "+textoRadioButton,Toast.LENGTH_LONG).show();
            }


        }else{
            Toast.makeText(getApplicationContext(), "Debe de seleccionar el Checkbox",Toast.LENGTH_LONG).show();
        }
    }
}
