package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Habitacion;
import connection.DBConnection;

public class HabitacionController implements IHabitacionController {
    
    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from habitacion";

        if (ordenar == true) {
            sql += " order by id_hab " + orden;
        }
        
        sql += ";";

        List<String> habitaciones = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //return sql;

            while (rs.next()) {
                int id_hab = rs.getInt("id_hab");
                String nombre_hab = rs.getString("nombre_hab");
                int capacidad_hab = rs.getInt("capacidad_hab");
                int camas_hab = rs.getInt("camas_hab");
                int terraza_hab = rs.getInt("terraza_hab");
                int banos_hab = rs.getInt("banos_hab");
                boolean novedades = rs.getBoolean("novedad");
                int precio = rs.getInt("precio");
                String estado = rs.getString("estado");
                
                Habitacion habitacion = new Habitacion(id_hab, nombre_hab, capacidad_hab, camas_hab, terraza_hab, banos_hab, novedades, precio, estado);
                habitaciones.add(gson.toJson(habitacion));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        

        return gson.toJson(habitaciones);

    }
//hasta aqui va la pagina
}