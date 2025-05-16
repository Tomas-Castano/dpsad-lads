package co.edu.uniquindio.empledos.empleadosapp.model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private String codigo;
    private List<Empleado> listaEmpleados = new ArrayList<>();



    public Departamento(String nombre, String codigo, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public String toString() {
        return "Departamento [nombre=" + nombre + ", codigo=" + codigo + ", listaEmpleados=" + listaEmpleados + "]";
    }
    public static DepartamentoBuilder builder(){
        return new DepartamentoBuilder();
    }
}