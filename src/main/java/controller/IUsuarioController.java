
package controller;
import java.util.Map;


public interface IUsuarioController {
    public String login(String username, String password_user);
    
    public String register(String username, String password_user, String nombres_user , String apellidos_user, String email_user, double saldo_user, boolean premium_user);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaPassword_user,
            String nuevoNombres_user, String nuevosApellidos_user, String nuevoEmail_user,
            double nuevoSaldo_user, boolean nuevoPremium_user);
    
    //public String verCopias(String username);

    //public String devolverHabitacion(String username, Map<Integer, Integer> estado);

    //public String eliminar(String username);
    
}
    
    