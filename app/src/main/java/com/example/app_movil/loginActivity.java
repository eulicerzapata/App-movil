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


public class loginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button boton_login = findViewById(R.id.boton_inicio);

        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ingreseEmal = findViewById(R.id.ingreseEmailLogin);
                EditText ingreseContraseña = findViewById(R.id.ingreseContraseñaLogin);

                // variable booleana para guardar el resultado de la validación
                boolean isValid = true;

                // Comprueba si alguno de los campos está vacío usando el método isEmpty() y cambia el valor de isValid a false si es así

                if (TextUtils.isEmpty(ingreseEmal.getText())) {
                    isValid = false;
                    Toast.makeText(loginActivity.this, "El campo email está vacío", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(ingreseContraseña.getText())) {
                    isValid = false;
                    Toast.makeText(loginActivity.this, "El campo contraseña está vacío", Toast.LENGTH_SHORT).show();
                }

                // Si todos los campos tienen algún texto, isValid será true y se cambiará el color del botón y se mostrará la alerta de registro exitoso
                if (isValid) {

                    boton_login.setBackgroundColor(Color.WHITE);
                    // Crea y muestra un AlertDialog con el mensaje "Registro exitoso"
                    AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                    builder.setTitle("inicio de sesión ¡exitoso!");
                    builder.setMessage("has ingresado los campos correctamente");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
