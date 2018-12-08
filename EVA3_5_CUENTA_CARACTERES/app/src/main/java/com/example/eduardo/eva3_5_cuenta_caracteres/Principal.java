package com.example.eduardo.eva3_5_cuenta_caracteres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView mostrar;
    EditText escribir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mostrar = findViewById(R.id.textViewMostrar);
        escribir = findViewById(R.id.editTextEscribir);
    }
}
