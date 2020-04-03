/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gdragoni
 */
public class CompraDAO extends DAO {
    
    public CompraDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public void insert(Compra c) throws SQLException {
        String sql = "INSERT INTO compra (id_user, codigo_prod, qtd) VALUES ("
                +c.getId_user()+", "
                +c.getCodigo_prod()+", "
                +c.getQtd()+")";
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM compra WHERE id="+id;
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void edit(Compra c) throws SQLException {
        String sql = "UPDATE compra SET id_user="+c.getId_user()
                +", codigo_prod="+c.getCodigo_prod()
                +", qtd="+c.getQtd()
                +" WHERE compra.id="+c.getId();
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public ArrayList<Compra> selectCompra() throws SQLException {
        String sql = "SELECT * FROM compra";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Compra> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Compra(rs.getInt("id"), rs.getInt("id_user"), rs.getInt("codigo_prod"), rs.getInt("qtd"), rs.getDate("data")));
        }
        return list;
    }
    
    public ArrayList<Compra> selectCompra(String date) throws SQLException {
        String sql = "SELECT * FROM compra WHERE data='"+date+"'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Compra> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Compra(rs.getInt("id"), rs.getInt("id_user"), rs.getInt("codigo_prod"), rs.getInt("qtd"), rs.getDate("data")));
        }
        return list;
    }
    
    public ArrayList<Compra> selectCompra(String beforeDate, String afterDate) throws SQLException {
        String sql = "SELECT * FROM compra WHERE data BETWEEN '"+beforeDate+"' AND '"+afterDate+"'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Compra> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Compra(rs.getInt("id"), rs.getInt("id_user"), rs.getInt("codigo_prod"), rs.getInt("qtd"), rs.getDate("data")));
        }
        return list;
    }
}
