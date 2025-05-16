package co.edu.uniquindio.empledos.empleadosapp.services;

import java.util.List;

public interface iProyectoCrud {
    boolean crearProyecto(String nombre, String codigo, List<Empleado> empleadosAsignados);
    boolean eliminarProyecto(String codigo);
    boolean actualizarProyecto(String nombre, String codigo, String codigoNuevo, List<Empleado> empleadosAsignados);
    boolean obtenerDatosProyecto(String codigo);
}
