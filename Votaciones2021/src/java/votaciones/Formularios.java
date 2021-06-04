package votaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/Formularios"})
public class Formularios extends HttpServlet {

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
            out.println("<title>Servlet Formularios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formularios at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();

        conexion con = new conexion();
        Statement stmt = null;

        //diplocal
        int iddiplocal, iddipfederal, idpremunicipal, fkusuario, pan, prd, pri, verdeeco, pt, movciudadano, morena, pes, rsp, fuerzamex, hagamos, somos, futuro, indep1, indep2, coal1, coal2, nulo;
        ResultSet rs = null;
        
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("login") == null) {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        try {
            stmt = con.conexion(request, response).createStatement();
            rs = stmt.executeQuery("Select * From premunicipal");

            out.print("<center>");
            out.print("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
            out.print("<h1>" + "Formularios" + "<h1>");
            out.print("<h2>" + "Presidente Municipal" + "<h2>");
            out.print("<table class='table table-sm table-striped table-dark'");
            out.print("<tr>");
            out.print("<th>" + "Codigo" + "</th>");
            out.print("<th>" + "Usuario" + "</th>");
            out.print("<th>" + "PAN" + "</th>");
            out.print("<th>" + "PRD" + "</th>");
            out.print("<th>" + "PRI" + "</th>");
            out.print("<th>" + "VERDE ECOLOGISTA" + "</th>");
            out.print("<th>" + "PT" + "</th>");
            out.print("<th>" + "MOVIMIENTO CIUDADANO" + "</th>");
            out.print("<th>" + "MORENA" + "</th>");
            out.print("<th>" + "PES" + "</th>");
            out.print("<th>" + "RSP" + "</th>");
            out.print("<th>" + "FUERZA MEXICO" + "</th>");
            out.print("<th>" + "HAGAMOS" + "</th>");
            out.print("<th>" + "SOMOS" + "</th>");
            out.print("<th>" + "FUTURO" + "</th>");
            out.print("<th>" + "INDEPENDIENTE<br>J. LUIS FLORES" + "</th>");
            out.print("<th>" + "INDEPENDIENTE<br>M. ISABEL NOLASCO" + "</th>");
            out.print("<th>" + "NULO" + "</th>");

            out.print("</tr>");

            while (rs.next()) {
                idpremunicipal = rs.getInt(1);
                fkusuario = rs.getInt(2);
                pan = rs.getInt(3);
                prd = rs.getInt(4);
                pri = rs.getInt(5);
                verdeeco = rs.getInt(6);
                pt = rs.getInt(7);
                movciudadano = rs.getInt(8);
                morena = rs.getInt(9);
                pes = rs.getInt(10);
                rsp = rs.getInt(11);
                fuerzamex = rs.getInt(12);
                hagamos = rs.getInt(13);
                somos = rs.getInt(14);
                futuro = rs.getInt(15);
                indep1 = rs.getInt(16);
                indep2 = rs.getInt(17);
                nulo = rs.getInt(18);

                out.print("<tr>");

                out.print("<td>");
                out.print("" + idpremunicipal);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fkusuario);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pan);
                out.print("</td>");

                out.print("<td>");
                out.print("" + prd);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pri);
                out.print("</td>");

                out.print("<td>");
                out.print("" + verdeeco);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pt);
                out.print("</td>");

                out.print("<td>");
                out.print("" + movciudadano);
                out.print("</td>");

                out.print("<td>");
                out.print("" + morena);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pes);
                out.print("</td>");

                out.print("<td>");
                out.print("" + rsp);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fuerzamex);
                out.print("</td>");

                out.print("<td>");
                out.print("" + hagamos);
                out.print("</td>");

                out.print("<td>");
                out.print("" + somos);
                out.print("</td>");

                out.print("<td>");
                out.print("" + futuro);
                out.print("</td>");

                out.print("<td>");
                out.print("" + indep1);
                out.print("</td>");

                out.print("<td>");
                out.print("" + indep2);
                out.print("</td>");

                out.print("<td>");
                out.print("" + nulo);
                out.print("</td>");

                out.print("</tr>");
            }
            out.print("</table>");

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stmt = con.conexion(request, response).createStatement();
            rs = stmt.executeQuery("Select * From diplocal");

            out.print("<h2>" + "Diputado local" + "<h2>");
            out.print("<table class='table table-sm table-striped table-dark'>");
            out.print("<tr>");
            out.print("<th>" + "Codigo" + "</th>");
            out.print("<th>" + "Usuario" + "</th>");
            out.print("<th>" + "PAN" + "</th>");
            out.print("<th>" + "PRD" + "</th>");
            out.print("<th>" + "PRI" + "</th>");
            out.print("<th>" + "VERDE ECOLOGISTA" + "</th>");
            out.print("<th>" + "PT" + "</th>");
            out.print("<th>" + "MOVIMIENTO CIUDADANO" + "</th>");
            out.print("<th>" + "MORENA" + "</th>");
            out.print("<th>" + "PES" + "</th>");
            out.print("<th>" + "RSP" + "</th>");
            out.print("<th>" + "FUERZA MEXICO" + "</th>");
            out.print("<th>" + "HAGAMOS" + "</th>");
            out.print("<th>" + "SOMOS" + "</th>");
            out.print("<th>" + "FUTURO" + "</th>");
            out.print("<th>" + "INDEPENDIENTE<br>L.ANGEL MORALES" + "</th>");
            out.print("<th>" + "NULO" + "</th>");

            out.print("</tr>");

            while (rs.next()) {
                iddiplocal = rs.getInt(1);
                fkusuario = rs.getInt(2);
                pan = rs.getInt(3);
                prd = rs.getInt(4);
                pri = rs.getInt(5);
                verdeeco = rs.getInt(6);
                pt = rs.getInt(7);
                movciudadano = rs.getInt(8);
                morena = rs.getInt(9);
                pes = rs.getInt(10);
                rsp = rs.getInt(11);
                fuerzamex = rs.getInt(12);
                hagamos = rs.getInt(13);
                somos = rs.getInt(14);
                futuro = rs.getInt(15);
                indep1 = rs.getInt(16);
                nulo = rs.getInt(17);

                out.print("<tr>");

                out.print("<td>");
                out.print("" + iddiplocal);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fkusuario);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pan);
                out.print("</td>");

                out.print("<td>");
                out.print("" + prd);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pri);
                out.print("</td>");

                out.print("<td>");
                out.print("" + verdeeco);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pt);
                out.print("</td>");

                out.print("<td>");
                out.print("" + movciudadano);
                out.print("</td>");

                out.print("<td>");
                out.print("" + morena);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pes);
                out.print("</td>");

                out.print("<td>");
                out.print("" + rsp);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fuerzamex);
                out.print("</td>");

                out.print("<td>");
                out.print("" + hagamos);
                out.print("</td>");

                out.print("<td>");
                out.print("" + somos);
                out.print("</td>");

                out.print("<td>");
                out.print("" + futuro);
                out.print("</td>");

                out.print("<td>");
                out.print("" + indep1);
                out.print("</td>");

                out.print("<td>");
                out.print("" + nulo);
                out.print("</td>");

                out.print("</tr>");
            }
            out.print("</table>");

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stmt = con.conexion(request, response).createStatement();
            rs = stmt.executeQuery("Select * From dipfederal");

            out.print("<h2>" + "Diputado federal" + "<h2>");
            out.print("<table class='table table-sm table-striped table-dark'");
            out.print("<tr>");
            out.print("<th>" + "Codigo" + "</th>");
            out.print("<th>" + "Usuario" + "</th>");
            out.print("<th>" + "PAN" + "</th>");
            out.print("<th>" + "PRD" + "</th>");
            out.print("<th>" + "PRI" + "</th>");
            out.print("<th>" + "VERDE ECOLOGISTA" + "</th>");
            out.print("<th>" + "PT" + "</th>");
            out.print("<th>" + "MORENA" + "</th>");
            out.print("<th>" + "PES" + "</th>");
            out.print("<th>" + "RSP" + "</th>");
            out.print("<th>" + "FUERZA MEXICO" + "</th>");
            out.print("<th>" + "MOVIMIENTO CIUDADANO" + "</th>");
            out.print("<th>" + "COALICIÓN<br>PAN | PRI | PRD" + "</th>");
            out.print("<th>" + "COALICIÓN<br>MORENA | VERDE | PT" + "</th>");
            out.print("<th>" + "NULO" + "</th>");

            out.print("</tr>");

            while (rs.next()) {
                iddipfederal = rs.getInt(1);
                fkusuario = rs.getInt(2);
                pan = rs.getInt(3);
                prd = rs.getInt(4);
                pri = rs.getInt(5);
                verdeeco = rs.getInt(6);
                pt = rs.getInt(7);
                morena = rs.getInt(8);
                pes = rs.getInt(9);
                rsp = rs.getInt(10);
                fuerzamex = rs.getInt(11);
                movciudadano = rs.getInt(12);
                coal1 = rs.getInt(13);
                coal2 = rs.getInt(14);
                nulo = rs.getInt(15);

                out.print("<tr>");

                out.print("<td>");
                out.print("" + iddipfederal);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fkusuario);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pan);
                out.print("</td>");

                out.print("<td>");
                out.print("" + prd);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pri);
                out.print("</td>");

                out.print("<td>");
                out.print("" + verdeeco);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pt);
                out.print("</td>");

                out.print("<td>");
                out.print("" + morena);
                out.print("</td>");

                out.print("<td>");
                out.print("" + pes);
                out.print("</td>");

                out.print("<td>");
                out.print("" + rsp);
                out.print("</td>");

                out.print("<td>");
                out.print("" + fuerzamex);
                out.print("</td>");

                out.print("<td>");
                out.print("" + movciudadano);
                out.print("</td>");

                out.print("<td>");
                out.print("" + coal1);
                out.print("</td>");

                out.print("<td>");
                out.print("" + coal2);
                out.print("</td>");

                out.print("<td>");
                out.print("" + nulo);
                out.print("</td>");

                out.print("</tr>");
            }
            
            out.print("</table>");
            out.print("<br><a class='btn btn-primary' href = 'Formularios' role = 'button' > Recargar Pagina </a>");
            out.print("  <a class='btn btn-primary' href = 'menu.jsp' role = 'button' > Regresar </a>");
            out.print("</center>");

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
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
        // processRequest(request, response);

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
