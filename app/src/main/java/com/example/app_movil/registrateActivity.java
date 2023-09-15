package com.example.app_movil;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgistrate);

        Button boton_registrate = findViewById(R.id.boton_registrate);

        boton_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ingreseNombre = findViewById(R.id.ingreseNombre);
                EditText ingreseEmal = findViewById(R.id.ingreseEmal);
                EditText ingreseTelefono = findViewById(R.id.ingreseTelefono);
                EditText ingreseIdentificacion = findViewById(R.id.ingreseIdentificacion);
                EditText ingreseContraseña = findViewById(R.id.ingreseContraseña);

                // variable booleana para guardar el resultado de la validación
                boolean isValid = true;

                // Comprueba si alguno de los campos está vacío usando el método isEmpty() y cambia el valor de isValid a false si es así
                if (TextUtils.isEmpty(ingreseNombre.getText())) {
                    isValid = false;
                    // Muestra un mensaje de error indicando que el campo nombre está vacío
                    Toast.makeText(registrateActivity.this, "El campo nombre está vacío", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(ingreseEmal.getText())) {
                    isValid = false;
                    Toast.makeText(registrateActivity.this, "El campo email está vacío", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(ingreseTelefono.getText())) {
                    isValid = false;
                    Toast.makeText(registrateActivity.this, "El campo teléfono está vacío", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(ingreseIdentificacion.getText())) {
                    isValid = false;
                    Toast.makeText(registrateActivity.this, "El campo identificación está vacío", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(ingreseContraseña.getText())) {
                    isValid = false;
                    Toast.makeText(registrateActivity.this, "El campo contraseña está vacío", Toast.LENGTH_SHORT).show();
                }

                // Si todos los campos tienen algún texto, isValid será true y se cambiará el color del botón y se mostrará la alerta de registro exitoso
                if (isValid) {

                    boton_registrate.setBackgroundColor(Color.WHITE);
                    // Crea y muestra un AlertDialog con el mensaje "Registro exitoso"
                    AlertDialog.Builder builder = new AlertDialog.Builder(registrateActivity.this);
                    builder.setTitle("Registro exitoso");
                    builder.setMessage("Has creado tu cuenta correctamente");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });


    }
}

