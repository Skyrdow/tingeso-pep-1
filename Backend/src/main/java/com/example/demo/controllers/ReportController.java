package com.example.demo.controllers;

import com.example.demo.entities.CarEntity;
import com.example.demo.services.BrandBonusService;
import com.example.demo.services.CarService;
import com.example.demo.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping("/1")
    public ResponseEntity<?> getReport1() {
        List<Map> report1 = reportService.getReport1();
        return ResponseEntity.ok(report1);
    }
    @GetMapping("/2")
    public ResponseEntity<?> getReport2() {
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/3")
    public ResponseEntity<?> getReport3() {
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/4")
    public ResponseEntity<?> getReport4() {
        return ResponseEntity.ok("ok");
    }
}
