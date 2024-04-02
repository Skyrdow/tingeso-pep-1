package com.example.demo.services;

import com.example.demo.PriceConstants;
import com.example.demo.entities.CarEntity;
import com.example.demo.entities.ReparationEntity;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    CarService carService;
    @Autowired
    BrandBonusService brandBonusService;
    @Autowired
    ReparationService reparationService;
    @Autowired
    ReparationRepository reparationRepository;
    @Autowired
    CarRepository carRepository;

    PriceConstants pc = PriceConstants.getInstance();
    public List<Map> getReport1 () {
        try {
        List<Map> responseMaps = new ArrayList<>();
        List<CarEntity> everyCar = carService.getCars();
        everyCar.forEach((CarEntity car) -> {
            Map newMap = Map.of(
                "car", car.getPatent(),
                "reparationPrice", calculateReparationPrice(1L)
            );
            responseMaps.add(newMap);
        });
        return responseMaps;
        } catch (Exception e) { return new ArrayList<>(); }
    }


    public Float calculateReparationPrice(Long id) throws Exception {
        ReparationEntity reparation;
        CarEntity car;
        // Costo Total = [Suma(Reparaciones) + Recargos – Descuentos] + IVA
        reparation = reparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reparation with id " + id + " not found"));
        String patent = reparation.getPatent();
        car = carRepository.findByPatent(patent).orElseThrow(() -> new RuntimeException("Car with patent " + patent + " not found"));

        try {
            Long price = getReparationPrices(car);
            Long brandBonus = brandBonusService.getBrandBonus(car.getBrand());
            Float surcharges = getSurcharges(reparation, car) * price;
            Float discounts = getDiscounts(reparation, car) * price;
            return applyIva(price + surcharges - discounts - brandBonus);
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    public Long getReparationPrices(CarEntity car) {
        Long priceSum = 0L;
        List<ReparationEntity> reparations = reparationRepository.findByPatent(car.getPatent());
        for (ReparationEntity reparation : reparations) {
            priceSum += pc.repairPricesMap.get(reparation.getReparationType()).getPrice(car.getMotorType());
        }
        return priceSum;
    }

    public Float getSurcharges(ReparationEntity reparation, CarEntity car) throws Exception {
        try {
            Float mileageSurcharge = pc.mileageSurchargeMap.get(car.getCarType()).getMileageSurcharge(car.getMileage())/100f;
            Float ageSurcharge = pc.ageSurchargeMap.get(car.getCarType()).getAgeSurcharge(car.getFabDate())/100f;
            Float delaySurcharge = pc.delaySurcharge.getDelaySurcharge(reparation.getRepairExitDate(), reparation.getRetrievalDate())/100f;
            return mileageSurcharge + ageSurcharge + delaySurcharge;
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    private Float getDiscounts(ReparationEntity reparation, CarEntity car) throws Exception {
        try {
            Integer reparations = reparationService.reparationCount(car);
            Float repairDiscount = pc.discountByRepairMap.get(car.getMotorType()).getDiscountByRepair(reparations)/100f;
            Float dayDiscount = pc.discountByDay.getDiscountByDay(reparation.getRetrievalDate())/100f;
            return repairDiscount + dayDiscount;
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    private Float applyIva(Float price) {
        return (price + (price * pc.iva));
    }
}
