package servlets;

import connection.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;
import java.sql.Statement;

/**
 * Servlet implementation class ServletUsuarioModificar
 */
@WebServlet("/ServletUsuarioModificar")
public class ServletUsuarioModificar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        /**
         * UsuarioController usuarios = new UsuarioController();
         *
         * String username = request.getParameter("username"); String
         * password_user = request.getParameter("password_user"); String
         * nombres_user = request.getParameter("nombres_user"); String
         * apellidos_user = request.getParameter("apellidos_user"); String
         * email_user = request.getParameter("email_user"); double saldo_user =
         * Double.parseDouble(request.getParameter("saldo_user")); boolean
         * premium_user = Boolean.parseBoolean(request.getParameter("premium_user"));
         */

        // String usuarioStr = usuarios.modificar(username,password_user, nombres_user , apellidos_user, email_user,saldo_user,premium_user);
        String username = request.getParameter("username");
        String password_user = request.getParameter("password_user");
        String nombres_user = request.getParameter("nombres_user");
        String apellidos_user = request.getParameter("apellidos_user");
        String email_user = request.getParameter("email_user");
        double saldo_user = Double.parseDouble(request.getParameter("saldo_user"));
        boolean premium_user = Boolean.parseBoolean(request.getParameter("premium_user"));

        DBConnection con = new DBConnection();
        String sql = "UPDATE usuarios SET password_user='" + password_user
                + "', nombres_user='" + nombres_user + "', "
                + "apellidos_user='" + apellidos_user + "', email_user='"
                + email_user + "', saldo_user=" + saldo_user + ", premium_user=";

        if (premium_user) {
            sql += "1";
        } else {
            sql += "0";
        }

        sql += " WHERE username='" + username + "';";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex);
            out.flush();
            out.close();

        }
    }
        /**
         * @see HttpServlet#doPost(HttpServletRequest request,
         * HttpServletResponse response)
         
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
                // TODO Auto-generated method stub
                 doGet(request, response);
    }
    
*/
}
