package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class main3 extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Set<String> historialCostosSet = new HashSet<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main3.this, main2.class);
                startActivity(intent);
            }
        });

        // Obtener el resultado del intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double resultado = extras.getDouble("resultado");

            // Mostrar el resultado en txtresultado
            TextView txtresultado = findViewById(R.id.txtresultado);
            txtresultado.setText(String.format("$"+"%.2f",   resultado));

            // Inicializar SharedPreferences
            sharedPreferences = getSharedPreferences("historial_costos", MODE_PRIVATE);
            historialCostosSet = sharedPreferences.getStringSet("costos", new HashSet<String>());

            // Agregar el resultado al historial de costos
            historialCostosSet.add(String.format("%.2f", resultado));

            // Guardar el historial en SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("costos", historialCostosSet);
            editor.apply();

            // Configurar el adaptador para el ListView
            ListView listViewCostos = findViewById(R.id.listacosto);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(historialCostosSet));
            listViewCostos.setAdapter(adapter);
        }
    }
}


