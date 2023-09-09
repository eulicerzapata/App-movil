package com.example.app_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvBoton, tvBoton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBoton=(TextView) findViewById(R.id.tvBoton);
        tvBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  finish();
                Intent i =new Intent(MainActivity.this,loginActivity.class);
                startActivity(i);
            }
        });
        tvBoton2=(TextView) findViewById(R.id.tvBoton2);
        tvBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  finish();
                Intent i =new Intent(MainActivity.this,registrateActivity.class);
                startActivity(i);
            }
        });
    }
}