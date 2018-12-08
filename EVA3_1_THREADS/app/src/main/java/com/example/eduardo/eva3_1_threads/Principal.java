package com.example.eduardo.eva3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
    //RUNNABLE
    Runnable rMiHiloRun = new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 20; i++){
              Log.wtf("Runnable", i+"");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //RUNNABLES (INTERFAZ) Y LOS THREAD(CLASS)
        //AMBOS TINENE EL METODO RUN
        Thread tHilo = new Thread(rMiHiloRun);
        tHilo.start();
        //DESTRUIR HILO CUNAOD SE ACABE LA APLICACION

        Thread tMiHilo = new MiHilo();
        tMiHilo.start();
    }
    class MiHilo extends  Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 20; i++){
                Log.wtf("Runnable", i+"");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
