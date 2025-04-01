package com.example.examen2.model;

public class Contratista extends Empleado {
    private int duracionContrato; // en meses
    private double tarifaProyecto;

    public Contratista(String nombre, String id, String departamento, double salarioBase,
                       int añosExperiencia, int duracionContrato, double tarifaProyecto) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
        this.duracionContrato = duracionContrato;
        this.tarifaProyecto = tarifaProyecto;

        int count = 0;
        for (Empleado e : EmpleadoData.listaEmpleados) {
            if (e instanceof Contratista) {
                count++;
            }
        }
        this.number = 10;
    }

    @Override
    public double calcularSalario() {
        return tarifaProyecto / duracionContrato;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() +
                "\nTipo: Contratista" +
                "\nDuración del contrato: " + duracionContrato + " meses" +
                "\nTarifa del proyecto: " + tarifaProyecto +
                "\nSalario Total: " + calcularSalario();
    }
}
