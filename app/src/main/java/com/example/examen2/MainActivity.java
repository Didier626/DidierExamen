package com.example.examen2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar, btnBuscar, btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnLista = findViewById(R.id.btnLista);

        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistrarEmpleadoActivity.class);
            startActivity(intent);
        });

        btnBuscar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BuscarEmpleadoActivity.class);
            startActivity(intent);
        });

        btnLista.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaEmpleadosActivity.class);
            startActivity(intent);
        });

        Button btnResumen = findViewById(R.id.btnResumen);
        btnResumen.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResumenEmpleadosActivity.class);
            startActivity(intent);
        });
    }
}
