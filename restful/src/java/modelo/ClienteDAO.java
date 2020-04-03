package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends DAO {
    
    public ClienteDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public void insert(Cliente c) throws SQLException {
        String sql = "INSERT INTO cliente (user, password) VALUES ('"
                +c.getUser()+"', '"
                +c.getPassword()+"')";
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id="+id;
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void edit(Cliente c) throws SQLException {
        String sql = "UPDATE cliente SET user='"+c.getUser()+"', password='"+c.getPassword()
                +"' WHERE cliente.id="+c.getId();
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public ArrayList<Cliente> selectCliente() throws SQLException {
        String sql = "SELECT * FROM cliente";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Cliente> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Cliente(rs.getInt("id"), rs.getString("user"), rs.getString("password")));
        }
        return list;
    }
    
    public ArrayList<Cliente> selectCliente(int id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id="+id;
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Cliente> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Cliente(rs.getInt("id"), rs.getString("user"), rs.getString("password")));
        }
        return list;
    }
    
    public ArrayList<Cliente> selectCliente(String user, String password) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE user='"+user+"' AND password='"+password+"'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Cliente> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Cliente(rs.getInt("id"), rs.getString("user"), rs.getString("password")));
        }
        return list;
    }
}
