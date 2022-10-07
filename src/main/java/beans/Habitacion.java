
package beans;


public class Habitacion {
    private int id_hab;
    private String nombre_hab;
    private int capacidad_hab;
    private int camas_hab;
    private int terraza_hab;
    private int banos_hab;
    private boolean novedad;
    private int precio;
    private String estado;

    public Habitacion(int id_hab, String nombre_hab, int capacidad_hab, int camas_hab, int terraza_hab, int banos_hab, boolean novedad, int precio, String estado) {
        this.id_hab = id_hab;
        this.nombre_hab = nombre_hab;
        this.capacidad_hab = capacidad_hab;
        this.camas_hab = camas_hab;
        this.terraza_hab = terraza_hab;
        this.banos_hab = banos_hab;
        this.novedad = novedad;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId_hab() {
        return id_hab;
    }

    public void setId_hab(int id_hab) {
        this.id_hab = id_hab;
    }

    public String getNombre_hab() {
        return nombre_hab;
    }

    public void setNombre_hab(String nombre_hab) {
        this.nombre_hab = nombre_hab;
    }

    public int getCapacidad_hab() {
        return capacidad_hab;
    }

    public void setCapacidad_hab(int capacidad_hab) {
        this.capacidad_hab = capacidad_hab;
    }

    public int getCamas_hab() {
        return camas_hab;
    }

    public void setCamas_hab(int camas_hab) {
        this.camas_hab = camas_hab;
    }

    public int getTerraza_hab() {
        return terraza_hab;
    }

    public void setTerraza_hab(int terraza_hab) {
        this.terraza_hab = terraza_hab;
    }

    public int getBanos_hab() {
        return banos_hab;
    }

    public void setBanos_hab(int banos_hab) {
        this.banos_hab = banos_hab;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_hab=" + id_hab + ", nombre_hab=" + nombre_hab + ", capacidad_hab=" + capacidad_hab + ", camas_hab=" + camas_hab + ", terraza_hab=" + terraza_hab + ", banos_hab=" + banos_hab + ", novedad=" + novedad + ", precio=" + precio + ", estado=" + estado + '}';
    }

    public void add(String toJson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
}