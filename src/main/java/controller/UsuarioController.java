package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuarios;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String password_user) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuarios WHERE username = '" + username + "' and password_user= '" + password_user + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombres_user = rs.getString("nombres_user");
                String apellidos_user = rs.getString("apellidos_user");
                String email_user = rs.getString("email_user");
                double saldo_user = rs.getDouble("saldo_user");
                boolean premium_user = rs.getBoolean("premium_user");

                Usuarios usuarios = new Usuarios(username, password_user, nombres_user, apellidos_user, email_user, saldo_user, premium_user);
                return gson.toJson(usuarios);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String password_user, String nombres_user, String apellidos_user, String email_user, double saldo_user, boolean premium_user) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuarios values('" + username + "', '" + password_user + "', '" + nombres_user
                + "', '" + apellidos_user + "', '" + email_user + "', " + saldo_user + ", " + premium_user + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuarios usuarios = new Usuarios(username, password_user, nombres_user, apellidos_user, email_user, saldo_user, premium_user);

            st.close();

            return gson.toJson(usuarios);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuarios where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String password_user = rs.getString("password_user");
                String nombres_user = rs.getString("nombres_user");
                String apellidos_user = rs.getString("apellidos_user");
                String email_user = rs.getString("email_user");
                double saldo_user = rs.getDouble("saldo_user");
                boolean premium_user = rs.getBoolean("premium_user");

                Usuarios usuarios = new Usuarios(username, password_user, nombres_user, apellidos_user, email_user, saldo_user, premium_user);

                return gson.toJson(usuarios);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
        @Override
    public String modificar(String username, String nuevaPassword_user,
            String nuevoNombres_user, String nuevosApellidos_user,
            String nuevoEmail_user, double nuevoSaldo_user, boolean nuevoPremium_user) {

        DBConnection con = new DBConnection();

        String sql = "Update usuarios set Password_user = '" + nuevaPassword_user
                + "', nombres_user = '" + nuevoNombres_user + "', "
                + "apellidos_user = '" + nuevosApellidos_user + "', email_user'"
                + nuevoEmail_user + "', saldo_user = " + nuevoSaldo_user + ", premium_user = ";

        if (nuevoPremium_user == true) {
            sql += " 1 ";
        } else {
            sql += " 0 ";
        }

        sql += " where username = '" + username + "';";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

}
