package votaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kinjiro
 */
@WebServlet(urlPatterns = {"/Ingresar"})
public class Ingresar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        //processRequest(request, response);
        RequestDispatcher rd = null;
        conexion con = new conexion();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        HttpSession sesion = request.getSession();

        //Variables de programa
        Contra contrasena1 = new Contra();
        String usuario2 = null, contra = null, contrades = null, contrades2 = null;
        int estado = 0;
        usuario2 = request.getParameter("us");
        contra = request.getParameter("contra");
        sesion.setAttribute("fallo", null);
        sesion.setAttribute("proceso", null);
        sesion.setAttribute("usuario", null);
        sesion.setAttribute("estadoU", null);
        sesion.setAttribute("login", null);

        if (usuario2.equals("") || contra.equals("")) {
            sesion.setAttribute("fallo", "Ingresa datos validos !!! ");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {
            try {
                //conexion toma los parametros
                //obtenemos una conexion
                stmt = con.conexion(request, response).prepareStatement("SELECT Contraseña FROM usuarios where Usuario = '" + usuario2 + "'");
                stmt2 = con.conexion(request, response).prepareStatement("SELECT Estado FROM usuarios where Usuario = '" + usuario2 + "'");
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (con != null) {

                try {
                    ResultSet contraen = stmt.executeQuery();
                    while (contraen.next()) {
                        contrades2 = contraen.getString("Contraseña");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return;
                }
                try {
                    ResultSet estadou = stmt2.executeQuery();
                    while (estadou.next()) {
                        estado = estadou.getInt("Estado");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return;
                }
                contrades = contrasena1.getDesencriptar(contrades2);

                if (contra.equals(contrades) && estado == 0) {
                    sesion.setAttribute("usuario", usuario2);
                    sesion.setAttribute("estadoU", "Uno");
                    sesion.setAttribute("login", "True");
                    rd = request.getRequestDispatcher("menu.jsp");
                    rd.forward(request, response);
                }
                if (contra.equals(contrades) && estado == 1) {
                    sesion.setAttribute("usuario", usuario2);
                    sesion.setAttribute("estadoU", "Dos");
                    sesion.setAttribute("login", "True");
                    rd = request.getRequestDispatcher("menu.jsp");
                    rd.forward(request, response);
                }
                if (contra.equals(contrades) && estado == 2) {
                    sesion.setAttribute("fallo", "Usuario dado de baja");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                if (contra.equals(contrades) && estado == 3) {
                    sesion.setAttribute("proceso", "Usuario en proceso de alta");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {
                    sesion.setAttribute("fallo", "Usuario o contraseña incorrectos !!! ");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            }
            try {
            } finally {
                if (con != null) {
                    try {
                        con.cerrar();
                        stmt.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
