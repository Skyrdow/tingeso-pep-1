package com.example.demo.services;

import com.example.demo.entities.BrandBonusEntity;
import com.example.demo.repositories.BrandBonusRepository;
import org.junit.jupiter.api.Test;

public class BrandBonusServiceTest {

    BrandBonusEntity brandBonus = new BrandBonusEntity();
    BrandBonusService brandBonusService = new BrandBonusService();
    @Test
    public void whenGetBrandBonus_thenSuccessful() {
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);

    }
}
