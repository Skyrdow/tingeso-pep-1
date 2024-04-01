package com.example.demo.services;

import com.example.demo.entities.CarEntity;
import com.example.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    public ArrayList<CarEntity> getCars() { return (ArrayList<CarEntity>) carRepository.findAll();}
    public CarEntity saveCar(CarEntity carEntity) { return carRepository.save(carEntity); }
}
