package com.example.demo.repositories;

import com.example.demo.entities.BrandBonusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandBonusRepository extends JpaRepository<BrandBonusEntity, String> {
    Optional<BrandBonusEntity> findByBrand(String brand);

}
