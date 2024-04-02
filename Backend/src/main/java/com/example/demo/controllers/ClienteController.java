package com.example.demo.controllers;

import com.example.demo.entities.ClienteEntity;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<List<ClienteEntity>> listClientes() {
        List<ClienteEntity> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }
}
