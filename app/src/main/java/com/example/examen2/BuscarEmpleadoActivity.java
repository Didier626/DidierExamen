package com.example.examen2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examen2.model.Empleado;
import com.example.examen2.model.EmpleadoData;

import java.util.ArrayList;
import java.util.List;

public class BuscarEmpleadoActivity extends AppCompatActivity {

    private EditText edtDepartamento, edtExperiencia;
    private Button btnBuscar;
    private ListView listaResultados;
    private ArrayAdapter<String> adapter;
    private List<String> resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_empleado);

        edtDepartamento = findViewById(R.id.edtBuscarDepartamento);
        edtExperiencia = findViewById(R.id.edtBuscarExperiencia);
        btnBuscar = findViewById(R.id.btnBuscarEmpleado);
        listaResultados = findViewById(R.id.listaResultados);

        resultados = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultados);
        listaResultados.setAdapter(adapter);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEmpleados();
            }
        });
    }

    private void buscarEmpleados() {
        String departamento = edtDepartamento.getText().toString().trim();
        String expStr = edtExperiencia.getText().toString().trim();
        List<Empleado> empleadosFiltrados = new ArrayList<>(EmpleadoData.listaEmpleados);
        if (!departamento.isEmpty()) {
            empleadosFiltrados = EmpleadoData.buscarPorDepartamento(departamento);
        }
        if (!expStr.isEmpty()) {
            try {
                int expMinima = Integer.parseInt(expStr);
                List<Empleado> filtradoFinal = new ArrayList<>();
                for (Empleado e : empleadosFiltrados) {
                    if (e.getAñosExperiencia() >= expMinima) {
                        filtradoFinal.add(e);
                    }
                }
                empleadosFiltrados = filtradoFinal;
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingrese un número válido de experiencia", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        resultados.clear();
        if (empleadosFiltrados.isEmpty()) {
            resultados.add("No se encontraron empleados.");
        } else {
            for (Empleado e : empleadosFiltrados) {
                resultados.add(e.obtenerInformacion());
            }
        }
        adapter.notifyDataSetChanged();
    }
}