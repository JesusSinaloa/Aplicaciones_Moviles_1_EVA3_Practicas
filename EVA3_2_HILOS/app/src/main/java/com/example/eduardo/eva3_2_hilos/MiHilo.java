package com.example.eduardo.eva3_2_hilos;

import android.util.Log;

public class MiHilo extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
            Log.wtf("HOLA", "loco");
        }
    }
}
