package co.edu.uniquindio.empledos.empleadosapp.model;

public class Empleado {
    public String nombre;
    public String IdEmpleado;
    public Departamento departamento;
    public int edad;

    public Empleado(String nombre, String idEmpleado, Departamento departamento, int edad) {
        this.nombre = nombre;
        IdEmpleado = idEmpleado;
        this.departamento = departamento;
        this.edad=edad;
    }

    public Empleado() {

    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", IdEmpleado='" + IdEmpleado + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
    }
}