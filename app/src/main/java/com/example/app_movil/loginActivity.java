package com.example.app_movil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

                    View view = (View) v;
                    AdministradorSQLite database = new AdministradorSQLite(view.getContext());
                    SQLiteDatabase db = database.getReadableDatabase();

                    String email = ingreseEmal.getText().toString();
                    String contraseña = ingreseContraseña.getText().toString();

                    if(email.isEmpty()){
                        ingreseEmal.setError("email vacio");
                        ingreseEmal.requestFocus();
                    }else if(contraseña.isEmpty()){
                        ingreseContraseña.setError("clave vacia");
                        ingreseContraseña.requestFocus();
                    }else{
                        // Aquí consultamos la base de datos usando el método query()
                        String[] columns = {"Id", "Nombre", "Email", "Contraseña"};
                        String selection = "Email = ? AND Contraseña = ?";
                        String[] selectionArgs = {email, contraseña}; // Los valores para reemplazar los ? en la condición
                        Cursor cursor = db.query(AdministradorSQLite.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
                        // Si el cursor tiene algún resultado, significa que el usuario está registrado y sus datos son correctos
                        if (cursor.moveToFirst()) {
                            // Obtenemos el ID y el nombre del usuario del cursor
                             @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("Id"));
                             @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("Nombre"));

                            AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                            builder.setTitle("Inicio de sesión exitoso");
                            builder.setMessage("Hola " + nombre + ", has iniciado sesión correctamente " );
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(loginActivity.this, MenuActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                            builder.setTitle("Inicio de sesión fallido");
                            builder.setMessage(" No has ingresado los datos correctamente o no  estas registrado en el sistema " );
                            builder.setPositiveButton("Aceptar", null);
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                }
            }
        });
    }
}


