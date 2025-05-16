package co.edu.uniquindio.empledos.empleadosapp.services;

import co.edu.uniquindio.empledos.empleadosapp.model.Departamento;

public interface iGerenteCrud {
    boolean crearGerente(String nombre, int edad, String idEmpleado, Departamento departamento);
    boolean actualizarGerente(String nombre, int edad, String idEmpleado, String idEmpleadoNuevo, Departamento departamento);
    boolean eliminarGerente(String idEmpleado);
    boolean obtenerDatosGerente(String idEmpleado);
}
