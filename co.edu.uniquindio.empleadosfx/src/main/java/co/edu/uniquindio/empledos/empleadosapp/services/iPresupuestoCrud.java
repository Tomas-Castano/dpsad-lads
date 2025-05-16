package co.edu.uniquindio.empledos.empleadosapp.services;

public interface iPresupuestoCrud {
    boolean crearPresupuesto(String idPresupuesto, int valor, String estado, String descripcion);
    boolean actualizarPresupuesto(String idPresupuesto, int valor, String estado, String descripcion);
    boolean eliminarPresupuesto(String idPresupuesto);
}
