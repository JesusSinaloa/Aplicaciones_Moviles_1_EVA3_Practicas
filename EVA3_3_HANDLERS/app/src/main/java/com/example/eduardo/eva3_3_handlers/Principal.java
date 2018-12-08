package com.example.eduardo.eva3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //AQUI SI PODEMOS INTERACTUAR CON LA INTERFAZ GRAFICA
            if(msg.what == 1){
                int i = (int) msg.obj;
                datos.append(i + " - ");
            }
        }
    };
        TextView datos;
    Thread tHilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        datos = findViewById(R.id.txtDatos);
        MiHilo miHilo = new MiHilo();
         tHilo = new Thread(miHilo);
        tHilo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
    }

    class MiHilo implements Runnable{

        @Override
        public void run() {
            int i = 0;
            while (true){
                i++;
                try {
                    //AQUI MODIFICAMOS LA ETIQUETE
                    Message msg = hManejador.obtainMessage(1, i);
                    hManejador.sendMessage(msg);

                    Log.wtf("Hilo", i+"");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;//TERMINAR EL HILO
                }

            }
        }
    }
}
