package com.example.demo.services;

import com.example.demo.entities.CarEntity;
import com.example.demo.entities.ReparationEntity;
import com.example.demo.enums.CarType;
import com.example.demo.enums.MotorType;
import com.example.demo.enums.ReparationType;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.Date;

class ReparationServiceTest {

    CarEntity car = new CarEntity();
    ReparationEntity reparation = new ReparationEntity();
    ReparationService reparationService = new ReparationService();
    CarService carService = new CarService();

    @Test
    public void whenCalculatePrice_Successful() {
        // Given
        car.setPatent("ABCD12");
        car.setCarType(CarType.Sedan);
        car.setModel("Model S");
        car.setBrand("Kia");
        car.setMileage(100L);
        car.setFabDate(new Date());
        car.setMotorType(MotorType.Diesel);
        car.setSeatCount(5);

        reparation.setReparationType(ReparationType.Combustible);
        reparation.setPatent("ABCD12");
        reparation.setAdmissionDate(new Date());
        reparation.setRetrievalDate(new Date());
        reparation.setRepairExitDate(new Date());
        // When
        Float calculatedPrice = null;
        try {
            calculatedPrice = carService.getTotalPrice(car.getPatent());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // Then
        assertThat(calculatedPrice).isEqualTo(100L);
    }
}
