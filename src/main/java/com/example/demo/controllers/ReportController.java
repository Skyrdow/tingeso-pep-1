package com.example.demo.controllers;

import com.example.demo.services.BrandBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    BrandBonusService brandBonusService;
    @GetMapping("/1")
    public ResponseEntity<?> getReport1() {
        brandBonusService.whenGetBrandBonus_thenSuccessful();
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/2")
    public ResponseEntity<?> getReport2() {
        brandBonusService.whenGetBrandBonus_thenSuccessful();
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/3")
    public ResponseEntity<?> getReport3() {
        brandBonusService.whenGetBrandBonus_thenSuccessful();
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/4")
    public ResponseEntity<?> getReport4() {
        brandBonusService.whenGetBrandBonus_thenSuccessful();
        return ResponseEntity.ok("ok");
    }
}
