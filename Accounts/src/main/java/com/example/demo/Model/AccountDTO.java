/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

/**
 *
 * @author ben
 */
public class AccountDTO {
    public Integer id;
    public String username;
    public String password;
    public Integer idCustomer;

    public AccountDTO(Integer id, String username, String password, Integer idCustomer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idCustomer = idCustomer;
    }
    
}
