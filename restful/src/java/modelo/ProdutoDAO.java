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
public class ProdutoDAO extends DAO {
    
    public ProdutoDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public void insert(Produto p) throws SQLException {
        String sql = "INSERT INTO produto (codigo, nome, preco) VALUES ("
                +p.getCodigo()+", "
                +"'"+p.getNome()+"', "
                +p.getPreco()+")";
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void delete(int codigo) throws SQLException {
        String sql = "DELETE FROM produto WHERE codigo="+codigo;
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public void edit(Produto p) throws SQLException {
        String sql = "UPDATE produto SET nome='"+p.getNome()
                +"', preco="+p.getPreco()
                +" WHERE produto.codigo="+p.getCodigo();
        System.out.println(sql);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    public ArrayList<Produto> selectProduto() throws SQLException {
        String sql = "SELECT * FROM produto";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Produto> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Produto(rs.getInt("codigo"), rs.getString("nome"), rs.getFloat("preco")));
        }
        return list;
    }
}
