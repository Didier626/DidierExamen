package com.example.examen2.model;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoData {

    public static List<Empleado> listaEmpleados = new ArrayList<>();

    public static void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public static List<Empleado> buscarPorDepartamento(String departamento) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : listaEmpleados) {
            if (e.getDepartamento().equalsIgnoreCase(departamento)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public static List<Empleado> buscarPorExperiencia(int experienciaMinima) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : listaEmpleados) {
            if (e.getAñosExperiencia() >= experienciaMinima) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public static void limpiar() {
        listaEmpleados.clear();
    }
}
