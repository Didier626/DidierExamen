package com.example.examen2.model;

public class EmpleadoMedioTiempo extends Empleado {
    private int horasSemanales;
    private double tarifaHora;

    public EmpleadoMedioTiempo(String nombre, String id, String departamento, double salarioBase,
                               int añosExperiencia, int horasSemanales, double tarifaHora) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
        this.horasSemanales = horasSemanales;
        this.tarifaHora = tarifaHora;

        int count = 0;
        for (Empleado e : EmpleadoData.listaEmpleados) {
            if (e instanceof EmpleadoMedioTiempo) {
                count++;
            }
        }
        this.number = 10;
    }

    @Override
    public double calcularSalario() {
        return horasSemanales * tarifaHora * 4;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() +
                "\nTipo: Medio Tiempo" +
                "\nHoras semanales: " + horasSemanales +
                "\nTarifa por hora: " + tarifaHora +
                "\nSalario Total: " + calcularSalario();
    }
}

