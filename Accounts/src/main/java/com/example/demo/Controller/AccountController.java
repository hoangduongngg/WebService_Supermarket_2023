/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Model.AccountDTO;
import com.example.demo.Repository.AccountRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author ben
 */
@RestController
public class AccountController {

    private final String SALT = "ENCRYPT";

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Account> register(@RequestBody AccountDTO accountDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(accountDTO.password);

        Optional<Account> account = accountRepository.findByUsername(accountDTO.username);
        if (account.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Account newAccount = new Account(accountDTO.username, hashedPassword, accountDTO.idCustomer);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }

    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Account> account = accountRepository.findByUsername(accountDTO.username);
        if (account.isPresent()) {
            if (passwordEncoder.matches(accountDTO.password, account.get().getPassword())) {
                return ResponseEntity.ok(account.get());
            } else {
                Account newAccount = new Account(accountDTO.username, accountDTO.password);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(accountDTO);
            }
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/update-account")
    @ResponseBody
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO accountDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Account> account = accountRepository.findById(accountDTO.id);
        if (account.isPresent()) {
            Account newAccount = new Account(accountDTO.id, accountDTO.username, passwordEncoder.encode(accountDTO.password), accountDTO.idCustomer);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountDTO);
        }

    }
}
