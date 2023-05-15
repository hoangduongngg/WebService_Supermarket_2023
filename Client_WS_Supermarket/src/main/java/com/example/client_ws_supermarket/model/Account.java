/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.client_ws_supermarket.model;

/**
 *
 * @author ben
 */
public class Account {

    private static final long serialVersionUID = 1L;

    public Integer id;
    public String username;
    public String password;
    public String role;
    public Integer idUser;

    public Account(Integer id, String username, String password, String role, Integer idUser) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idUser = idUser;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

}
