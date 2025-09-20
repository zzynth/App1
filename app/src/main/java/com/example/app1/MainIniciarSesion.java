package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainIniciarSesion extends AppCompatActivity {

    private EditText editTxtEmail, editTxtPasswrd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_iniciar_sesion);

        editTxtEmail = findViewById(R.id.editTxtEmail);
        editTxtPasswrd = findViewById(R.id.editTxtPasswrd);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = editTxtEmail.getText().toString().trim();
            String password = editTxtPasswrd.getText().toString().trim();

            if (username.equals("admin") && password.equals("admin1234")) {
                // Ir a la pantalla de tareas
                Intent intent = new Intent(MainIniciarSesion.this, MainTareas.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainIniciarSesion.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
