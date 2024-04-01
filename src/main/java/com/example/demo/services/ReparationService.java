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
import java.util.Optional;

@Service
public class ReparationService {
    Float iva = 0.19f;

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
    public Float calculateReparationPrice(Long id) throws Exception {
        ReparationEntity reparation;
        CarEntity car;
        // Costo Total = [Suma(Reparaciones) + Recargos – Descuentos] + IVA
        reparation = reparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reparation with id " + id + " not found"));
        String patent = reparation.getPatent();
        car = carRepository.findByPatent(patent).orElseThrow(() -> new RuntimeException("Car with patent " + patent + " not found"));


        ReparationType reparationType = reparation.getReparationType();

        PriceConstants pc = PriceConstants.getInstance();
        Long price = pc.repairPricesMap.get(reparationType).getPrice(car.getMotorType());
        Long brandBonus = brandBonusService.getBrandBonus(car.getBrand());

        return applyIva(price - brandBonus);
    }

    private Float getSurcharges(ReparationEntity reparation, CarEntity car) throws Exception {
        PriceConstants pc = PriceConstants.getInstance();
        try {
            Float mileageSurcharge = pc.mileageSurchargeMap.get(car.getCarType()).getMileageSurcharge(car.getMileage())/100f;
            Float ageSurcharge = pc.ageSurchargeMap.get(car.getCarType()).getAgeSurcharge(car.getFabDate())/100f;
            Float delaySurcharge = pc.delaySurcharge.getDelaySurcharge(reparation.getRepairExitDate(), reparation.getRetrievalDate())/100f;
            return mileageSurcharge + ageSurcharge + delaySurcharge;
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    private Float getDiscounts(ReparationEntity reparation, CarEntity car) throws Exception {
        PriceConstants pc = PriceConstants.getInstance();
        try {
            Integer reparations = reparationCount(car);
            Float repairDiscount = pc.discountByRepairMap.get(car.getMotorType()).getDiscountByRepair(reparations)/100f;
            return repairDiscount;
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    private Float applyIva(Long price) {
        return (price + (price * iva));
    }
}
