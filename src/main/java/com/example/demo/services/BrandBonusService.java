package com.example.demo.services;

import com.example.demo.entities.BrandBonusEntity;
import com.example.demo.repositories.BrandBonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandBonusService {
    @Autowired
    BrandBonusRepository brandBonusRepository;

    public BrandBonusEntity saveBrandBonus(BrandBonusEntity brandBonus) { return brandBonusRepository.save(brandBonus); }
    public Long getBrandBonus(String brand) {
        Optional<BrandBonusEntity> brandBonus = brandBonusRepository.findByBrand(brand);
        if (brandBonus.isEmpty()) return 0L;
        Integer bonusCount = brandBonus.get().getCount();
        if (bonusCount == 0) return 0L;
        Long bonus = brandBonus.get().getValue();
        brandBonus.get().setCount(bonusCount - 1);
        brandBonusRepository.save(brandBonus.get());
        return bonus;
    }

    public void whenGetBrandBonus_thenSuccessful() {
        BrandBonusEntity brandBonus = new BrandBonusEntity();
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);
        saveBrandBonus(brandBonus);

        System.out.println(getBrandBonus("Kia"));
        System.out.println(brandBonusRepository.findByBrand("Kia").get().getCount());
        System.out.println(brandBonusRepository.findByBrand("Kia").get().getValue());
    }
}
