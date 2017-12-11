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
import DB.BuscarCont;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cavca
 */
public class Ingresar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        BuscarCont bc;
        String contraseña="";
        try {
            bc = new BuscarCont();
            contraseña = bc.Contraseña(correo);
        } catch (SQLException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ingresar</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println(correo+"<br>"+contraseña +" y "+contra);
            
            if(contraseña.equals(contra)){
                out.println("<form>");
                out.println("   <input type='hidden' value='"+correo+"' name='mail'>");
                out.println("   <input type='submit' value='Editar Perfil' formaction='EditarPerfil'>");
                out.println("   <input type='submit' value='Presupuestar Productos' formaction='PresupuestarProductos'>");
                out.println("</form>");
            }
            else{
                out.println("<form action='./Ingresar'>");
                out.println("    Correo electronico: <input type='text' name='correo'>");
                out.println("    Contraseña: <input type='text' name='contra'>");
                out.println("    <br/><br/>");
                out.println("    <b style=\"color: red\">Usuario o contraseña incorrectos</b>");
                out.println("    <input type='submit' value='Ingresar'>");
                out.println("    <br/><br/>");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
