package com.example.examen2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examen2.model.Empleado;
import com.example.examen2.model.EmpleadoData;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpleadosActivity extends AppCompatActivity {

    private ListView listaCompleta;
    private ArrayAdapter<String> adapter;
    private List<String> listaDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        listaCompleta = findViewById(R.id.listaCompleta);
        listaDatos = new ArrayList<>();

        if (EmpleadoData.listaEmpleados.isEmpty()) {
            listaDatos.add("No hay empleados registrados.");
        } else {
            for (Empleado e : EmpleadoData.listaEmpleados) {
                String tipo = e.getClass().getSimpleName();
                listaDatos.add(
                        "Nombre: " + e.getNombre() +
                                "\nTipo: " + tipo +
                                "\nSalario: " + e.calcularSalario()
                );
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDatos);
        listaCompleta.setAdapter(adapter);
    }
}