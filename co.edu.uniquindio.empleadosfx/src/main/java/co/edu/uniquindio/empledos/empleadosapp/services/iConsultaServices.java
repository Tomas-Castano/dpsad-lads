package co.edu.uniquindio.empledos.empleadosapp.services;

public interface iConsultaServices {
    String consultarEmpleados(String idEmpleado);
    String obtenerEmpleadosProyecto(String codigo);
    String obtenerNumeroEmpleadoMayorEdad(int edad);
    String obtenerNumeroEmpleadoMenorEdad(int edad);
    String mostrarFuncionesEmpleados( String idEmpleado);
}