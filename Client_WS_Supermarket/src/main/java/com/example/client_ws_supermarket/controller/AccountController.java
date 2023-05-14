/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ben
 */
@Controller
@RequestMapping("account")
public class AccountController {
    protected RestTemplate rest = new RestTemplate();
    
    @GetMapping("login")
    public String login(){
       
        return "account/login";
    }
    
    @PostMapping("dologin")
    public ResponseEntity<?> doLogin( @RequestBody Account account){
        String url = "";
        System.err.println(account.getUsername());
        return ResponseEntity.ok(account);
    }
}
