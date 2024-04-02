package com.example.demo.controllers;

import com.example.demo.entities.ReparationEntity;
import com.example.demo.services.ReparationService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/reparation")
@CrossOrigin("*")
public class ReparationController {
    @Autowired
    ReparationService reparationService;

    @GetMapping("/")
    public ResponseEntity<List<ReparationEntity>> getReparations() {
        List<ReparationEntity> newReparations = reparationService.getReparations();
        return ResponseEntity.ok(newReparations);
    }

    @PostMapping("/")
    public ResponseEntity<ReparationEntity> saveReparation(@RequestBody ReparationEntity reparationEntity) {
        ReparationEntity newReparation = reparationService.saveReparation(reparationEntity);
        return ResponseEntity.ok(newReparation);
    }
}
