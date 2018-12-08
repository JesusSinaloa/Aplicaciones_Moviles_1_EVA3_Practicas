package com.example.eduardo.eva3_9_banner_asyn_task;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgBanner;
    int contador = 1;

    Handler hManejador = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgBanner = findViewById(R.id.imageViewBanner);

        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();
        maTareaAsin.execute("HOLA", "MUNDO");//EQUIVALENTE AL START
    }

    class MiClaseAsincrona extends AsyncTask<String, Integer, Void> {


        @Override
        protected Void doInBackground(String... strings) {


            while (true){
                try {
                    Thread.sleep(1000);
                    Message msg = hManejador.obtainMessage();
                    hManejador.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //HACE_TODO_EL_JALE


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            //UNICO METODO QUE NO SE OCMUNICA CON LA UI

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
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
            //COMUNICA
        }
    }
}
