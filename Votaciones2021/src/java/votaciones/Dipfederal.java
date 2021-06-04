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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/Dipfederal"})
public class Dipfederal extends HttpServlet {

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
            out.println("<title>Servlet Dipfederal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dipfederal at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        RequestDispatcher rd = null;
        request.setAttribute("dipfederal", null);
        request.setAttribute("dipfederalE", null);

        //presidenteasfd
        conexion con = new conexion();
        Statement stmt = null;

        int fkusuario = 1, pan, prd, pri, verdeeco, pt, morena, pes, rsp, fuerzamex, movciudadano, coal1, coal2, nulo;

        pan = Integer.parseInt(request.getParameter("pan"));
        prd = Integer.parseInt(request.getParameter("prd"));
        pri = Integer.parseInt(request.getParameter("pri"));
        verdeeco = Integer.parseInt(request.getParameter("verdeeco"));
        pt = Integer.parseInt(request.getParameter("pt"));
        morena = Integer.parseInt(request.getParameter("morena"));
        pes = Integer.parseInt(request.getParameter("pes"));
        rsp = Integer.parseInt(request.getParameter("rsp"));
        fuerzamex = Integer.parseInt(request.getParameter("fuerzamex"));
        movciudadano = Integer.parseInt(request.getParameter("movciudadano"));
        coal1 = Integer.parseInt(request.getParameter("coal1"));
        coal2 = Integer.parseInt(request.getParameter("coal2"));
        nulo = Integer.parseInt(request.getParameter("nulo"));
        coal1 = coal1 + pan + prd + pri;
        coal2 = coal2 + morena + verdeeco + pt;

        try {
            //controlador conexion-------------------------------------

            //statement hace el proceso de sql
            //se le asigna la coneccion que tengo
            stmt = con.conexion(request, response).createStatement();
            //ejecutar un update, (execute.Query para borrar)
            stmt.executeUpdate("INSERT INTO dipfederal(fkUsuario,pan,prd,pri,verdeecologista,pt,"
                    + "morena,pes,rsp,fuerzamexico,movimientociudadano,panprdpri,morenaverdept,nulo) "
                    + "VALUES ('" + fkusuario + "','" + pan + "'"
                    + ",'" + prd + "','" + pri + "','" + verdeeco + "','" + pt + "'"
                    + ",'" + morena + "','" + pes + "'"
                    + ",'" + rsp + "','" + fuerzamex + "','" + movciudadano + "','" + coal1 + "','" + coal2 + "','" + nulo + "')");
            request.setAttribute("dipfederal", "Registro de votos Exitoso ");
            rd = request.getRequestDispatcher("diplocal.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("dipfederalE", "Error en el Registro");
            rd = request.getRequestDispatcher("dipfederal.jsp");
            rd.forward(request, response);
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
