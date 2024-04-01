package com.example.demo.repositories;

import com.example.demo.entities.ReparationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReparationRepository extends JpaRepository<ReparationEntity, Long> {
    public List<ReparationEntity> findByPatent(String patent);
    public Integer countByPatent(String patent);
}
