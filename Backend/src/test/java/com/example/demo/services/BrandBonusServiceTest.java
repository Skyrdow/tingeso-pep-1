package com.example.demo.services;

import com.example.demo.entities.BrandBonusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BrandBonusServiceTest {
    BrandBonusEntity brandBonus = new BrandBonusEntity();
    BrandBonusService brandBonusService;
    @Test
    public void whenGetBrandBonus_thenSuccessful() {
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);
        brandBonusService.saveBrandBonus(brandBonus);

        assertThat(brandBonusService.getBrandBonus("Kia")).isEqualTo(1000L);
    }
    @Test
    public void whenGetBrandBonus_thenOutOfBonus() {
        // Given a brand bonus
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);
        brandBonusService.saveBrandBonus(brandBonus);
        // when brand bonus count is reduced to zero
        brandBonusService.getBrandBonus("Kia");
        brandBonusService.getBrandBonus("Kia");
        // then the returned bonus should be zero
        assertThat(brandBonusService.getBrandBonus("Kia")).isEqualTo(0L);
    }
}
