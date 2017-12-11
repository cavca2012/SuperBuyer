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

/**
 *
 * @author cavca
 */
public class EditarPerfil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("mail");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PresupuestarProductos</title>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<form>");
                out.println("   <input type='hidden' value='"+correo+"' name='mail'>");
                out.println("   <input type='submit' value='Modificar Usuario' formaction='MUsuario'>");
                out.println("   <input type='submit' value='Modificar Contraseña' formaction='MContrasenia'>");
                out.println("   <input type='submit' value='Modificar Correo' formaction='MCorreo'>");
                out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
