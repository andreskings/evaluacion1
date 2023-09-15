package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000; // Duración del splash en milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura una temporización para cambiar a la actividad principal después del tiempo especificado
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, main2.class);
                startActivity(mainIntent);
                finish(); // Cierra la actividad del splash
            }
        }, SPLASH_DURATION);
    }
}
