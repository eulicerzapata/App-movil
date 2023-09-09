package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.app_movil.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No hace falta asignar un layout a esta actividad, ya que se muestra el fondo definido en el estilo

        // Crea un objeto Handler para ejecutar un código después de un retraso
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crea un objeto Intent para iniciar la actividad principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // Finaliza esta actividad para que no se pueda volver a ella
                finish();
            }
        }, 3000); // Puedes cambiar el tiempo de retraso en milisegundos
    }
}
