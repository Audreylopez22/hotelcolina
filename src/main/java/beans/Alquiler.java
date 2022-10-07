package beans;

import java.sql.Date;

public class Alquiler {
    private int id_hab;
    private String username;
    private Date fecha_alq;
    private int huespedes_alq;
    private int dias_alq;
    private int factura_alq;

    public Alquiler(int id_hab, String username, Date fecha_alq, int huespedes_alq, int dias_alq, int factura_alq) {
        this.id_hab = id_hab;
        this.username = username;
        this.fecha_alq = fecha_alq;
        this.huespedes_alq = huespedes_alq;
        this.dias_alq = dias_alq;
        this.factura_alq = factura_alq;
    }

    public int getId_hab() {
        return id_hab;
    }

    public void setId_hab(int id_hab) {
        this.id_hab = id_hab;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha_alq() {
        return fecha_alq;
    }

    public void setFecha_alq(Date fecha_alq) {
        this.fecha_alq = fecha_alq;
    }

    public int getHuespedes_alq() {
        return huespedes_alq;
    }

    public void setHuespedes_alq(int huespedes_alq) {
        this.huespedes_alq = huespedes_alq;
    }

    public int getDias_alq() {
        return dias_alq;
    }

    public void setDias_alq(int dias_alq) {
        this.dias_alq = dias_alq;
    }

    public int getFactura_alq() {
        return factura_alq;
    }

    public void setFactura_alq(int factura_alq) {
        this.factura_alq = factura_alq;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id_hab=" + id_hab + ", username=" + username + ","
                + " fecha_alq=" + fecha_alq + ", huespedes_alq=" + huespedes_alq + ", "
                + "dias_alq=" + dias_alq + ", factura_alq=" + factura_alq + '}';
    }
    
    
}
