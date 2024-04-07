package com.example.demo.services;

import com.example.demo.entities.BrandBonusEntity;
import com.example.demo.repositories.BrandBonusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BrandBonusServiceTest {
    BrandBonusEntity brandBonus = new BrandBonusEntity();
    @Mock
    BrandBonusRepository brandBonusRepository;
    @InjectMocks
    BrandBonusService brandBonusService;
    @Test
    public void whenGetBrandBonus_thenSuccessful() {
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);
        brandBonusService.saveBrandBonus(brandBonus);

        Optional<BrandBonusEntity> brandBonusEntity = Optional.ofNullable(brandBonus);
        when(brandBonusRepository.findByBrand("Kia")).thenReturn(brandBonusEntity);

        assertThat(brandBonusService.getBrandBonus("Kia")).isEqualTo(1000L);
    }
    @Test
    public void whenGetBrandBonus_thenOutOfBonus() {
        // Given a brand bonus
        brandBonus.setBrand("Kia");
        brandBonus.setCount(2);
        brandBonus.setValue(1000L);
        brandBonusService.saveBrandBonus(brandBonus);
        when(brandBonusRepository.findByBrand("Kia")).thenReturn(Optional.ofNullable(brandBonus));
        // when brand bonus count is reduced to zero
        brandBonusService.getBrandBonus("Kia");
        brandBonusService.getBrandBonus("Kia");
        // then the returned bonus should be zero
        assertThat(brandBonusService.getBrandBonus("Kia")).isEqualTo(0L);
    }

    @Test
    public void whenGetBrandBonusList_Success() {
        BrandBonusEntity br1 = new BrandBonusEntity("Kia", 2, 500L);
        BrandBonusEntity br2 = new BrandBonusEntity("Volvo", 5, 1500L);
        List<BrandBonusEntity> brandBonusEntities = new ArrayList<>();
        brandBonusEntities.add(br1);
        brandBonusEntities.add(br2);

        when(brandBonusRepository.findAll()).thenReturn(brandBonusEntities);
        assertThat(brandBonusService.getBrandBonusList()).contains(br1);
        assertThat(brandBonusService.getBrandBonusList()).contains(br2);
    }
}
