package com.example.eduardo.eva3_2_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        hello = findViewById(R.id.txtViewHello);
        Runnable rHilo = new Runnable() {
            @Override
            public void run() {
                hello.setText("HOLLA");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        MiHilo miHPerpetuo = new MiHilo();
        miHPerpetuo.start();
    }
}
