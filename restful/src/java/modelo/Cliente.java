/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gdragoni
 */
public class Cliente {
    private int id;
    private String user;
    private String password;
    
    public Cliente(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
