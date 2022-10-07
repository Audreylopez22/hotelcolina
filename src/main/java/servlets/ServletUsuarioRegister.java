package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

/**
 * Servlet implementation class ServletUsuarioRegister
 */
@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioController usuarios = new UsuarioController();

        String username = request.getParameter("username");
        String password_user = request.getParameter("password_user");
        String nombres_user = request.getParameter("nombres_user");
        String apellidos_user = request.getParameter("apellidos_user");
        String email_user = request.getParameter("email_user");
        double saldo_user = Double.parseDouble(request.getParameter("saldo_user"));
        boolean premium_user = Boolean.parseBoolean(request.getParameter("premium_user"));

        String result = usuarios.register(username,password_user, nombres_user , apellidos_user, email_user,saldo_user,premium_user);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
