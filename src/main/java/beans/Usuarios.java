
package beans;


public class Usuarios {
    private String username;
    private String password_user;
    private String nombres_user;
    private String apellidos_user;
    private String email_user;
    private double saldo_user;
    private boolean premium_user;

    public Usuarios(String username, String password_user, String nombres_user, String apellidos_user, String email_user, double saldo_user, boolean premium_user) {
        this.username = username;
        this.password_user = password_user;
        this.nombres_user = nombres_user;
        this.apellidos_user = apellidos_user;
        this.email_user = email_user;
        this.saldo_user = saldo_user;
        this.premium_user = premium_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getNombres_user() {
        return nombres_user;
    }

    public void setNombres_user(String nombres_user) {
        this.nombres_user = nombres_user;
    }

    public String getApellidos_user() {
        return apellidos_user;
    }

    public void setApellidos_user(String apellidos_user) {
        this.apellidos_user = apellidos_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public double getSaldo_user() {
        return saldo_user;
    }

    public void setSaldo_user(double saldo_user) {
        this.saldo_user = saldo_user;
    }

    public boolean isPremium_user() {
        return premium_user;
    }

    public void setPremium_user(boolean premium_user) {
        this.premium_user = premium_user;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "username=" + username + ", password_user=" + password_user + ","
                + " nombres_user=" + nombres_user + ", apellidos_user=" + apellidos_user + ","
                + " email_user=" + email_user + ", saldo_user=" + saldo_user + ","
                + " premium_user=" + premium_user + '}';
    }
    
    
}
