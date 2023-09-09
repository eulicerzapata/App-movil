package com.example.app_movil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class registrateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgistrate);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_identificacion);
// Crea un ArrayAdapter usando el array de strings y un layout predeterminado para el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipos_identificacion, android.R.layout.simple_spinner_item);
// Especifica el layout que se usa cuando se muestra la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Aplica el adaptador al Spinner
        spinner.setAdapter(adapter);


    }
}
