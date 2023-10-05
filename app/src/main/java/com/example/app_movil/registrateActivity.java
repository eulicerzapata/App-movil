package com.example.app_movil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
                    // Aquí creamos la instancia de la clase AdministradorSQLite usando el método getContext() del objeto View v
                    AdministradorSQLite database = new AdministradorSQLite(v.getContext());
                    SQLiteDatabase db = database.getWritableDatabase();

                    String nombre = ingreseNombre.getText().toString();
                    String email = ingreseEmal.getText().toString();
                    String telefono = ingreseTelefono.getText().toString();
                    String identificacion = ingreseIdentificacion.getText().toString();
                    String contraseña = ingreseContraseña.getText().toString();


                    if(email.isEmpty()){
                        ingreseEmal.setError("email vacio");
                        ingreseEmal.requestFocus();
                    }else if(contraseña.isEmpty()){
                        ingreseContraseña.setError("clave vacia");
                        ingreseContraseña.requestFocus();
                    }else{
                        ContentValues datos = new ContentValues();
                        datos.put("Nombre", nombre);
                        datos.put("email",email);
                        datos.put("Telefono", telefono);
                        datos.put("Identificacion", identificacion);
                        datos.put("contraseña",contraseña);
                        // guardamos los datos en una variable
                        long rowId = db.insert(AdministradorSQLite.TABLE_NAME,null,datos);
                        if (rowId != -1) {
                            // Aquí mostramos el alerta de registro exitoso
                            AlertDialog.Builder builder = new AlertDialog.Builder(registrateActivity.this);
                            builder.setTitle("Registro exitoso");
                            builder.setMessage("Se ha registrado correctamente con los siguientes datos:\n" +

                                    "Nombre: " + datos.getAsString("Nombre") + "\n" +
                                    "Email: " + datos.getAsString("email"));
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(registrateActivity.this, loginActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        } else {
                            // Si rowId es igual a -1, significa que hubo un error
                            // Aquí mostramos un mensaje de error indicando que no se pudo insertar los datos
                            Toast.makeText(registrateActivity.this, "No se pudo insertar los datos en la base de datos", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });
    }
}