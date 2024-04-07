package com.example.demo.controllers;

import com.example.demo.entities.BrandBonusEntity;
import com.example.demo.services.BrandBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/brandBonus")
@CrossOrigin("*")
public class BrandBonusController {
    @Autowired
    BrandBonusService brandBonusService;
    @PostMapping("/")
    public ResponseEntity<?> postBrandBonus(@RequestBody BrandBonusEntity brandBonus) {
        brandBonusService.saveBrandBonus(brandBonus);
        return ResponseEntity.ok(brandBonus);
    }
    @GetMapping("/")
    public ResponseEntity<?> listBrandBonus() {
        List<BrandBonusEntity> bonus = brandBonusService.getBrandBonusList();
        return ResponseEntity.ok(Map.of("brandBonuses", bonus));
    }
    @GetMapping("/{brand}")
    public ResponseEntity<?> getBrandBonus(@PathVariable String brand) {
        Long bonus = brandBonusService.getBrandBonus(brand);
        return ResponseEntity.ok(Map.of("brand", brand, "brandBonus", bonus));
    }
}
