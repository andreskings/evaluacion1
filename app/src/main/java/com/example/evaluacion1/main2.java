package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class main2 extends AppCompatActivity {

    private EditText txtcostoverduras;
    private EditText txtcostohectarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtcostoverduras = findViewById(R.id.txtcostoverdura);
        txtcostohectarea = findViewById(R.id.txtcostohectarea);

        Button btncalcular = findViewById(R.id.bntcalcular);
        Button btnlimpiar = findViewById(R.id.btnlimpiar);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores ingresados
                String costoVerdurasStr = txtcostoverduras.getText().toString();
                String costoHectareaStr = txtcostohectarea.getText().toString();

                // Convertir los valores a números (asegurarse de manejar excepciones)
                try {
                    double costoVerduras = Double.parseDouble(costoVerdurasStr);
                    double costoHectarea = Double.parseDouble(costoHectareaStr);

                    // Realizar el cálculo (precio por 10,000 metros)
                    double resultado = costoVerduras * costoHectarea;

                    // Crear un intent para pasar el resultado a main3
                    Intent intent = new Intent(main2.this, main3.class);
                    intent.putExtra("resultado", resultado);

                    // Iniciar la actividad main3
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    // Manejar error si los valores ingresados no son números válidos
                }
            }
        });

        // Configurar el botón Limpiar
        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpiar los campos de texto
                txtcostoverduras.setText("");
                txtcostohectarea.setText("");
            }
        });
    }
}
