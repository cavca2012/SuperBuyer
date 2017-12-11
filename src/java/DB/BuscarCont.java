package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarCont {

    Connection cn;
    Statement s;
    ResultSet rs;
        
    public BuscarCont() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SuperBuyer", "root", "n0m3l0");
        s = cn.createStatement();
    }
    
    

    public String Contraseña(String mail) {
        try {
            rs = s.executeQuery("Select * from Usuario where correo = '"+ mail+"'");
            
            if(rs.next()){
                return rs.getString(3);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String Usuario(String mail) {
        try {
            rs = s.executeQuery("Select * from Usuario where correo = '"+ mail+"'");
            
            if(rs.next()){
                return rs.getString(3);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String Correo(String mail) {
        try {
            rs = s.executeQuery("Select * from Usuario where correo = '"+ mail+"'");
            
            if(rs.next()){
                return rs.getString(3);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
