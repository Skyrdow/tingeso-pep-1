package com.example.demo.services;

import com.example.demo.entities.ClienteEntity;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteEntity> getClientes() { return (ArrayList<ClienteEntity>) clienteRepository.findAll();}

    public ClienteEntity saveCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
    public ClienteEntity updateCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
}
