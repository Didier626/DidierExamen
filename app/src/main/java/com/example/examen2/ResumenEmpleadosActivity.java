package com.example.examen2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examen2.model.*;

public class ResumenEmpleadosActivity extends AppCompatActivity {

    private TextView tvTiempoCompleto, tvMedioTiempo, tvContratistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_empleados);

        tvTiempoCompleto = findViewById(R.id.tvTiempoCompleto);
        tvMedioTiempo = findViewById(R.id.tvMedioTiempo);
        tvContratistas = findViewById(R.id.tvContratistas);

        int totalTiempoCompleto = 0;
        int totalMedioTiempo = 0;
        int totalContratistas = 0;

        for (Empleado e : EmpleadoData.listaEmpleados) {
            if (e instanceof EmpleadoTiempoCompleto) {

                totalTiempoCompleto=totalTiempoCompleto+e.getNumber();
            } else if (e instanceof EmpleadoMedioTiempo) {
                totalMedioTiempo=totalMedioTiempo+e.getNumber();
            } else if (e instanceof Contratista) {
                totalContratistas=totalContratistas+e.getNumber();
            }
        }

        tvTiempoCompleto.setText("Tiempo Completo: " + totalTiempoCompleto + " empleados");
        tvMedioTiempo.setText("Medio Tiempo: " + totalMedioTiempo + " empleados");
        tvContratistas.setText("Contratistas: " + totalContratistas + " empleados");
    }
}