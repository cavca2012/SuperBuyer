/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.BuscarCont;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cavca
 */
public class MContrasenia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String correo = request.getParameter("mail");
            
            BuscarCont bc = new BuscarCont();
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MUsuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form>");
                out.println("Usuario:   <input type='text' value='"+bc.Usuario(correo)+"'>");
                out.println("   <input type='submit' value='Confirmar' formaction='MCorreo'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (SQLException ex) {
            Logger.getLogger(MContrasenia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MContrasenia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
