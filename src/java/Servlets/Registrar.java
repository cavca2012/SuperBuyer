/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.RegistrarCont;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cavca
 */
public class Registrar extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String correo = request.getParameter("correo");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");
            
            RegistrarCont rc = new RegistrarCont();
            
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registrar</title>");
                out.println("</head>");
                out.println("<body>");
                if(pass.equals(pass2)){
                    rc.Regis(correo,user,pass);
                    out.println("<form action='./Ingresar'>");
                    out.println("    Correo electronico: <input type='text' name='correo'>");
                    out.println("    Contraseña: <input type='text' name='contra'>");
                    out.println("    <br/><br/>");
                    out.println("    <input type='submit' value='Ingresar'>");
                    out.println("    <br/><br/>");
                    out.println("</form>");
                }
                else{
                    out.println("<form action='./'>");
                    out.println("    <b style='color: red'>Error al registrar usuario<br/>Las contraseñas no coinciden</b>");
                    out.println("    <br/><input type='submit' value='Regresar'>");
                    out.println("    <br/><br/>");
                    out.println("</form>");
                }
                out.println("</body>");
                out.println("</html>");
            }
            
        }       catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
