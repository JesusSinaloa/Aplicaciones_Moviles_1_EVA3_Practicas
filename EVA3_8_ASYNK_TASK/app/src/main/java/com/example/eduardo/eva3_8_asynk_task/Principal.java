package com.example.eduardo.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView conteo;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        conteo = findViewById(R.id.textViewConteo);

        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();
        maTareaAsin.execute("HOLA", "MUNDO");//EQUIVALENTE AL START
    }

    class MiClaseAsincrona extends AsyncTask<String, Integer, Void>{

        String sCade;
        @Override
        protected Void doInBackground(String... strings) {
            sCade = strings[0] + "" + strings[1];

            while (true){
                try {
                    Thread.sleep(1000);
                    publishProgress(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

          //HACE_TODO_EL_JALE


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            conteo.setText(sCade+ "Empezando la tarea: ");

        //UNICO METODO QUE NO SE OCMUNICA CON LA UI

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            conteo.append(i + "-");
            //COMUNICA
        }
    }
}
