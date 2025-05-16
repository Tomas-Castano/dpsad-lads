package co.edu.uniquindio.empledos.empleadosapp.model;

import java.util.LinkedList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String codigo;
    private List<Empleado> empleadosAsignados = new LinkedList<>();

    public Proyecto(String codigo, String nombre, List<Empleado> empleadosAsignados) {
        this.codigo = codigo;
        this.nombre = nombre;

    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public List<Empleado> getEmpleadosAsignados() {
        return empleadosAsignados;
    }
    public static ProyectoBuilder builder () {
        return new ProyectoBuilder();
    }
}
