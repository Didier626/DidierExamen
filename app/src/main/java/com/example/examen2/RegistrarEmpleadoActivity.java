package com.example.examen2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examen2.model.*;

public class RegistrarEmpleadoActivity extends AppCompatActivity {

    private EditText edtNombre, edtID, edtDepartamento, edtSalarioBase, edtExperiencia;
    private EditText edtBonificacion, edtHoras, edtTarifaHora, edtDuracion, edtTarifaProyecto;
    private Spinner spinnerTipo;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empleado);

        // Inicializar campos
        edtNombre = findViewById(R.id.edtNombre);
        edtID = findViewById(R.id.edtID);
        edtDepartamento = findViewById(R.id.edtDepartamento);
        edtSalarioBase = findViewById(R.id.edtSalarioBase);
        edtExperiencia = findViewById(R.id.edtExperiencia);

        edtBonificacion = findViewById(R.id.edtBonificacion);
        edtHoras = findViewById(R.id.edtHoras);
        edtTarifaHora = findViewById(R.id.edtTarifaHora);
        edtDuracion = findViewById(R.id.edtDuracion);
        edtTarifaProyecto = findViewById(R.id.edtTarifaProyecto);

        spinnerTipo = findViewById(R.id.spinnerTipo);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Cargar tipos de empleado
        String[] tipos = {"Seleccionar tipo", "Tiempo Completo", "Medio Tiempo", "Contratista"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapter);

        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ocultarTodosLosCamposExtras();

                switch (position) {
                    case 1: // Tiempo completo
                        edtBonificacion.setVisibility(View.VISIBLE);
                        break;
                    case 2: // Medio tiempo
                        edtHoras.setVisibility(View.VISIBLE);
                        edtTarifaHora.setVisibility(View.VISIBLE);
                        break;
                    case 3: // Contratista
                        edtDuracion.setVisibility(View.VISIBLE);
                        edtTarifaProyecto.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnGuardar.setOnClickListener(v -> guardarEmpleado());
    }

    private void ocultarTodosLosCamposExtras() {
        edtBonificacion.setVisibility(View.GONE);
        edtHoras.setVisibility(View.GONE);
        edtTarifaHora.setVisibility(View.GONE);
        edtDuracion.setVisibility(View.GONE);
        edtTarifaProyecto.setVisibility(View.GONE);
    }

    private void guardarEmpleado() {
        String nombre = edtNombre.getText().toString().trim();
        String id = edtID.getText().toString().trim();
        String departamento = edtDepartamento.getText().toString().trim();
        String salarioStr = edtSalarioBase.getText().toString().trim();
        String experienciaStr = edtExperiencia.getText().toString().trim();
        int tipo = spinnerTipo.getSelectedItemPosition();

        if (nombre.isEmpty() || id.isEmpty() || departamento.isEmpty() ||
                salarioStr.isEmpty() || experienciaStr.isEmpty() || tipo == 0) {
            Toast.makeText(this, "Por favor completa todos los campos obligatorios.", Toast.LENGTH_SHORT).show();
            return;
        }

        double salarioBase = Double.parseDouble(salarioStr);
        int experiencia = Integer.parseInt(experienciaStr);

        Empleado nuevoEmpleado = null;

        try {
            switch (tipo) {
                case 1: // Tiempo completo
                    double bonificacion = Double.parseDouble(edtBonificacion.getText().toString().trim());
                    nuevoEmpleado = new EmpleadoTiempoCompleto(nombre, id, departamento, salarioBase, experiencia, bonificacion);
                    break;

                case 2: // Medio tiempo
                    int horas = Integer.parseInt(edtHoras.getText().toString().trim());
                    double tarifaHora = Double.parseDouble(edtTarifaHora.getText().toString().trim());
                    nuevoEmpleado = new EmpleadoMedioTiempo(nombre, id, departamento, salarioBase, experiencia, horas, tarifaHora);
                    break;

                case 3: // Contratista
                    int duracion = Integer.parseInt(edtDuracion.getText().toString().trim());
                    double tarifaProyecto = Double.parseDouble(edtTarifaProyecto.getText().toString().trim());
                    nuevoEmpleado = new Contratista(nombre, id, departamento, salarioBase, experiencia, duracion, tarifaProyecto);
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, "Datos inválidos o campos vacíos del tipo específico.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (nuevoEmpleado != null) {
            EmpleadoData.agregarEmpleado(nuevoEmpleado);
            Toast.makeText(this, "Empleado registrado exitosamente", Toast.LENGTH_SHORT).show();
            finish(); // Vuelve a la pantalla anterior
        }
    }
}