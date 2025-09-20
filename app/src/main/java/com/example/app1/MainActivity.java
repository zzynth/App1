package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlaza el botón por ID
        Button btnEmpezar = findViewById(R.id.btnLogin2);

        //Agrega el listener para cambiar de actividad
        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainIniciarSesion.class);
                startActivity(intent);
                finish(); //para cerrar la pantalla actual
            }
        });
    }
}
