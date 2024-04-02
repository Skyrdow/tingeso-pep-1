package com.example.demo.services;

import com.example.demo.PriceConstants;
import com.example.demo.entities.CarEntity;
import com.example.demo.entities.ReparationEntity;
import com.example.demo.enums.ReparationType;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReparationService {
    @Autowired
    ReparationRepository reparationRepository;
    @Autowired
    BrandBonusService brandBonusService;
    @Autowired
    CarRepository carRepository;

    public ArrayList<ReparationEntity> getReparations() { return (ArrayList<ReparationEntity>) reparationRepository.findAll(); }
    public ArrayList<ReparationEntity> getReparationsByPatent(String patent) { return (ArrayList<ReparationEntity>) reparationRepository.findByPatent(patent); }
    public ReparationEntity saveReparation(ReparationEntity reparationEntity) { return reparationRepository.save(reparationEntity); }
    public Integer reparationCount(CarEntity carEntity) { return reparationRepository.countByPatent(carEntity.getPatent()); }
}
