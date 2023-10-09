package com.example.app_movil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import androidx.cursoradapter.widget.CursorAdapter;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button tarea1Button = findViewById(R.id.button5);
        tarea1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Crear una aplicación de Android");
                builder.setMessage("Crea una aplicación de Android que muestre información sobre tus pasatiempos favoritos. Utiliza Java y Android Studio para desarrollar la aplicación");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al hacer clic en Aceptar
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button tarea2Button = findViewById(R.id.button4);
        tarea2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Escribir un ensayo");
                builder.setMessage("Escribe un ensayo sobre un tema que te interese, como la tecnología o la política. El ensayo debe tener al menos 500 palabras y estar bien estructurado.");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al hacer clic en Aceptar
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button tarea3Button = findViewById(R.id.button6);
        tarea3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Aprender a tocar un instrumento musical:");
                builder.setMessage("Aprende a tocar un instrumento musical como la guitarra o el piano. Dedica al menos 30 minutos al día a practicar.");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al hacer clic en Aceptar
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button tarea4Button = findViewById(R.id.button3);
        tarea4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Crear una página web");
                builder.setMessage("Crea una página web que muestre información sobre tu ciudad o país favorito. Utiliza HTML, CSS y JavaScript para desarrollar la página web.");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al hacer clic en Aceptar
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}





