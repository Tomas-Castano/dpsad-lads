package co.edu.uniquindio.empledos.empleadosapp.model;

public class Presupuesto {
    private String idPresupuesto;
    private int valor;
    private String estado;
    private String descripcion;

    public Presupuesto(String idPresupuesto, int valor,String estado, String descripcion) {
        this.idPresupuesto = idPresupuesto;
        this.valor = valor;

    }
    public String getidPresupuesto() {
        return idPresupuesto;
    }
    public int getValor() {
        return valor;
    }
    public String getEstado(){
        return estado;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public static PresupuestoBuilder builder () {
        return new PresupuestoBuilder();
    }
}
