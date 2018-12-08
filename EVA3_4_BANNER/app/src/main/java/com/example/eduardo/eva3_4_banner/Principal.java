package com.example.eduardo.eva3_4_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgBanner;
    int contador = 1;

    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (contador){
                case 1:
                    imgBanner.setImageResource(R.drawable.cloudy);
                    contador++;
                    break;
                case 2:
                    imgBanner.setImageResource(R.drawable.rainy);
                    contador++;
                    break;
                case 3:
                    imgBanner.setImageResource(R.drawable.light_rain);
                    contador++;
                    break;
                default:
                    imgBanner.setImageResource(R.drawable.sunny);
                    contador = 1;
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgBanner = findViewById(R.id.imageViewBanner);
        Banner bMiBanner = new Banner();
        bMiBanner.start();
    }
    class Banner extends Thread{

        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    Thread.sleep(500);
                    Message msg = hManejador.obtainMessage();
                    hManejador.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }



        }
    }

}
