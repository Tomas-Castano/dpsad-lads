package co.edu.uniquindio.empledos.empleadosapp.model;

import co.edu.uniquindio.empledos.empleadosapp.services.ContribuyenteGerencial;

public class Gerente extends Empleado implements ContribuyenteGerencial {

    public Gerente(String nombre, String idEmpleado, Departamento departamento, int edad) {
        super(nombre, idEmpleado, departamento,edad);

    }
    public String gestionarProyectos() {
        return (" El gerente está Gestionando proyectos");
    }
    public void gestionarEquipos() {

    }
}
