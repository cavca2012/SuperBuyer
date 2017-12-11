/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cavca
 */
public class RegistrarCont {

    Connection cn;
    Statement s;
    
    public RegistrarCont() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperBuyer", "root", "n0m3l0");
        s = cn.createStatement();
    }

    public void Regis(String correo, String user, String pass) throws SQLException {
        s.execute("Insert into Usuario (nombre,contraseña,correo) values ('"+user+"','"+pass+"','"+correo+"');");
    }
    
}
