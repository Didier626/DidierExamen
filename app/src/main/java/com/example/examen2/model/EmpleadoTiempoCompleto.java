package com.example.examen2.model;

public class EmpleadoTiempoCompleto extends Empleado {
    private double bonificacionAnual;

    public EmpleadoTiempoCompleto(String nombre, String id, String departamento, double salarioBase,
                                  int añosExperiencia, double bonificacionAnual) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
        this.bonificacionAnual = bonificacionAnual;

        int count = 0;
        for (Empleado e : EmpleadoData.listaEmpleados) {
            if (e instanceof EmpleadoTiempoCompleto) {
                count++;
            }
        }
        this.number = 10;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonificacionAnual;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() +
                "\nTipo: Tiempo Completo" +
                "\nBonificación Anual: " + bonificacionAnual +
                "\nSalario Total: " + calcularSalario();
    }
}
