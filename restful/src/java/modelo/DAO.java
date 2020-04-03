package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import javax.ws.rs.Produces;

/**
 *
 * @author gdragoni
 */
public class DAO {
    protected Connection con;
    
    public DAO() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=GMT", "root", "");
    }
}
