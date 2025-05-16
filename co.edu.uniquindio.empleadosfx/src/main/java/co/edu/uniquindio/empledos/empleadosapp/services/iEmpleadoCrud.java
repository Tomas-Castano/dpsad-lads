package co.edu.uniquindio.empledos.empleadosapp.services;

import co.edu.uniquindio.empledos.empleadosapp.model.Departamento;

public interface iEmpleadoCrud {

    boolean crearEmpleado(String nombre, String idEmpleado, Departamento departamento, int edad);
    boolean eliminarEmpleado(String idEmpleado);
    boolean actualizarEmpleado(String nombre, String idEmpleado, String idEmpleadoNuevo, Departamento departamento, int edad);
    boolean obtenerDatosEmpleado(String idEmpleado);
}
