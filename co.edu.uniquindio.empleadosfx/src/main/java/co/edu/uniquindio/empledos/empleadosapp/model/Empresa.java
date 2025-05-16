package co.edu.uniquindio.empledos.empleadosapp.model;

import co.edu.uniquindio.empledos.empleadosapp.services.iConsultaServices;
import co.edu.uniquindio.empledos.empleadosapp.services.iEmpleadoCrud;
import co.edu.uniquindio.empledos.empleadosapp.services.iGerenteCrud;
import co.edu.uniquindio.empledos.empleadosapp.services.iProyectoCrud;

import java.util.ArrayList;
import java.util.List;

public class Empresa implements iEmpleadoCrud, iConsultaServices, iProyectoCrud, iGerenteCrud {
    private String nombre;
    List<Departamento> listaDepartamentos= new ArrayList<>();
    List<Proyecto> listaProyectos=new ArrayList<>();
    List<Empleado> listaEmpleados= new ArrayList<>();
    List<Presupuesto> listaPresupuestos = new ArrayList<>();

    public Empresa() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }
    public List<Presupuesto> getListaPresupuestos(){
        return listaPresupuestos;
    }
    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
    public String consultarEmpleados(String idEmpleado) {
        String resultado="";
        for(Empleado empleado1: getListaEmpleados()) {
            if(empleado1.getIdEmpleado().equals(idEmpleado)) {
                resultado= empleado1.toString();
                break;
            }
        }
        return resultado;
    }
    public String obtenerEmpleadosProyecto(String codigo) {
        String resultado="";
        Proyecto proyectoExistente=obtenerProyecto(codigo);
        if(proyectoExistente!=null) {
            resultado= proyectoExistente.getEmpleadosAsignados().toString();
        }
        return resultado;
    }
    public boolean crearEmpleado(String nombre,
                                 String idEmpleado,
                                 Departamento departamento,
                                 int edad) {
        Empleado empleadoExistente = obtenerEmpleado(idEmpleado);
        if (empleadoExistente == null) {
            Empleado empleado =  Empleado.builder()
                    .nombre(nombre)
                    .idEmpleado(idEmpleado)
                    .edad(edad)
                    .departamento(departamento)
                    .build();
            getListaEmpleados().add(empleado);
            return true;
        } else {
            return false;
        }
    }
    public boolean eliminarEmpleado(String idEmpleado) {
        Empleado empleadoExistente = obtenerEmpleado(idEmpleado);
        if (empleadoExistente != null) {
            getListaEmpleados().remove(empleadoExistente);
            return true;
        } else {
            return false;
        }
    }
    public boolean actualizarEmpleado(String nombre,
                                      String idEmpleado,
                                      String idEmpleadoNuevo,
                                      Departamento departamento, int edad) {
        Empleado empleadoExistente = obtenerEmpleado(idEmpleado);
        if (empleadoExistente != null) {
            getListaEmpleados().remove(empleadoExistente);
            Empleado empleado=Empleado.builder()
                    .nombre(nombre)
                    .idEmpleado(idEmpleadoNuevo)
                    .edad(edad)
                    .departamento(departamento)
                    .build();
            getListaEmpleados().add(empleado);
            return true;
        } else {
            return false;
        }
    }
    public boolean crearProyecto(String nombre, String codigo, List<Empleado> empleadosAsignados) {
        Proyecto proyectoExistente = obtenerProyecto(codigo);
        if(proyectoExistente==null){
            Proyecto proyecto = Proyecto.builder()
                    .nombre(nombre)
                    .codigo(codigo)
                    .empleadosAsignados(empleadosAsignados)
                    .build();
            getListaProyectos().add(proyecto);
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarProyecto(String codigo) {
        Proyecto proyectoExistente = obtenerProyecto(codigo);
        if (proyectoExistente != null) {
            listaProyectos.remove(proyectoExistente);
            return true;
        } else {
            return false;
        }
    }
    public boolean actualizarProyecto(String nombre, String codigo, String codigoNuevo, List<Empleado> empleadosAsignados) {
        Proyecto proyectoExistente = obtenerProyecto(codigo);
        if (proyectoExistente != null) {
            getListaProyectos().remove(proyectoExistente);
            Proyecto proyecto= Proyecto.builder()
                    .nombre(nombre)
                    .codigo(codigoNuevo)
                    .empleadosAsignados(empleadosAsignados)
                    .build();
            getListaProyectos().add(proyecto);
            return true;
        } else {
            return false;
        }
    }
    public boolean obtenerDatosProyecto(String codigo) {
        Proyecto proyectoExistente = obtenerProyecto(codigo);
        if (proyectoExistente != null) {
            obtenerProyecto(proyectoExistente.toString());
            return true;
        } else {
            return false;
        }
    }
    public boolean obtenerDatosEmpleado(String idEmpleado) {
        Empleado empleadoExistente = obtenerEmpleado(idEmpleado);
        if (empleadoExistente != null) {
            obtenerEmpleado(empleadoExistente.toString());
            return true;
        }else {
            return false;
        }
    }
    private Empleado obtenerEmpleado(String idEmpleado) {
        Empleado empleadoExistente = null;
        for(Empleado empleado: getListaEmpleados()) {
            if(empleado.getIdEmpleado().equals(idEmpleado)) {
                empleadoExistente = empleado;
                break;
            }
        }
        return empleadoExistente;
    }
    private Proyecto obtenerProyecto(String codigo){
        Proyecto proyectoExistente=null;
        for(Proyecto proyecto: getListaProyectos()){
            if(proyecto.getCodigo().equals(codigo)) {
                proyectoExistente = proyecto;
                break;
            }
        }
        return proyectoExistente;
    }
    private Empleado obtenerGerente (String idEmpleado) {
        Empleado gerenteExistente = null;
        for(Empleado empleado: getListaEmpleados()) {
            if(empleado.getIdEmpleado().equals(idEmpleado)) {
                gerenteExistente = empleado;
                break;
            }

        }
        return gerenteExistente;
    }

    public boolean crearPresupuesto(String idPresupuesto, int valor, String estado, String descripcion){
        Presupuesto  presupuestoExistente = obtenerPresupuesto(idPresupuesto);
        if(presupuestoExistente==null){
            Presupuesto presupuesto = Presupuesto.builder()
                    .idPresupuesto(idPresupuesto)
                    .valor(valor)
                    .estado(estado)
                    .descripcion(descripcion)
                    .build();
            getListaPresupuestos().add(presupuesto);
            return true;
        }else{
            return false;
        }
    }
    public boolean actualizarPresupuesto(String idPresupuesto, int valor, String estado, String descripcion){
        Presupuesto presupuestoExistente = obtenerPresupuesto(idPresupuesto);
        if (presupuestoExistente != null) {
            getListaPresupuestos().remove(presupuestoExistente);
            Presupuesto presupuesto = Presupuesto.builder()
                    .idPresupuesto(idPresupuesto)
                    .estado(estado)
                    .descripcion(descripcion)
                    .build();
            getListaPresupuestos().add(presupuesto);
            return true;
        } else {
            return false;
        }
    }
    public boolean eliminarPresupuesto(String idPresupuesto){
        Presupuesto presupuestoExistente= obtenerPresupuesto(idPresupuesto);
        if (presupuestoExistente != null) {
            listaPresupuestos.remove(presupuestoExistente);
            return true;
        } else {
            return false;
        }

    }
    public Presupuesto obtenerPresupuesto(String idPresupuesto){
        Presupuesto presupuestotoExistente=null;
        for(Presupuesto presupuesto: getListaPresupuestos()){
            if(presupuesto.getidPresupuesto().equals(idPresupuesto)) {
                presupuestotoExistente = presupuesto;
                break;
            }
        }
        return presupuestotoExistente;
    }

    public String obtenerNumeroEmpleadoMayorEdad(int edad) {
        int contador=0;
        for(Empleado empleado: getListaEmpleados()){
            if(empleado.getEdad()>=edad){
                contador++;
            }
        }
        return contador+"";

    }
    public String obtenerNumeroEmpleadoMenorEdad(int edad) {
        int contador = 0;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getEdad() <= edad) {
                contador++;
            }
        }
        return contador + "";
    }
    public String mostrarFuncionesEmpleados(String idEmpleado) {
        Empleado gerenteExistente = obtenerEmpleado(idEmpleado);
        if(gerenteExistente instanceof Gerente) {
            Gerente gerente = (Gerente) gerenteExistente;
            return gerente.gestionarProyectos();
        } else if ( gerenteExistente instanceof Tecnico) {
            Tecnico tecnico=(Tecnico) gerenteExistente;
            return tecnico.realizarTareasTecnicas();
        }
        return "";

    }
    public boolean crearGerente(String nombre, int edad, String idEmpleado, Departamento departamento) {
        Empleado empleadoExistente = obtenerEmpleado(idEmpleado);
        if (empleadoExistente == null) {
            Empleado gerenteExistente = Gerente.builder()
                    .nombre(nombre)
                    .edad(edad)
                    .idEmpleado(idEmpleado)
                    .departamento(departamento)
                    .build();
            getListaEmpleados().add(gerenteExistente);
            return true;
        } else {
            return false;
        }
    }
    public boolean actualizarGerente(String nombre, int edad, String idEmpleado, String idEmpleadoNuevo, Departamento departamento) {
        Empleado gerenteExistente=obtenerGerente(idEmpleado);
        if (gerenteExistente!=null) {
            getListaEmpleados().remove(gerenteExistente);
            Empleado gerente = Gerente.builder()
                    .nombre(nombre)
                    .edad(edad)
                    .idEmpleado(idEmpleado)
                    .departamento(departamento)
                    .build();
            getListaEmpleados().add(gerente);
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarGerente(String idEmpleado) {
        Empleado gerenteExistente = obtenerGerente(idEmpleado);
        if (gerenteExistente != null) {
            getListaEmpleados().remove(gerenteExistente);
            return true;
        } else {
            return false;
        }
    }
    public boolean obtenerDatosGerente(String idEmpleado) {
        Empleado gerenteExistente=obtenerGerente(idEmpleado);
        if(gerenteExistente!=null){
            obtenerGerente(gerenteExistente.toString());
            return true;
        }else{
            return false;
        }
    }
}
