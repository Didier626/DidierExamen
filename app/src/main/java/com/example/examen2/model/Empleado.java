package com.example.examen2.model;

public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected String departamento;
    protected double salarioBase;
    protected int añosExperiencia;
    protected int number;

    public Empleado(String nombre, String id, String departamento, double salarioBase, int añosExperiencia) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
        this.salarioBase = salarioBase;
        this.añosExperiencia = añosExperiencia;
    }

    public abstract double calcularSalario();

    public String obtenerInformacion() {
        return "Nombre: " + nombre +
                "\nID: " + id +
                "\nDepartamento: " + departamento +
                "\nSalario Base: " + salarioBase +
                "\nAños de experiencia: " + añosExperiencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }
    public int getNumber() {
        return number;
    }
}
