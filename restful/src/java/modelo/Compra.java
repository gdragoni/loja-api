/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author gdragoni
 */
public class Compra {
    private int id;
    private int id_user;
    private int codigo_prod;
    private int qtd;
    private Date data;
    
    public Compra(int id, int id_user, int codigo_prod, int qtd, Date data) {
        this.id = id;
        this.id_user = id_user;
        this.codigo_prod = codigo_prod;
        this.qtd = qtd;
        this.data = data;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @return the codigo_prod
     */
    public int getCodigo_prod() {
        return codigo_prod;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }
    
    public Date getData() {
        return data;
    }
}
