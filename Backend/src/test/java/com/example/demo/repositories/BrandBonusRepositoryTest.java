package com.example.demo.repositories;

import com.example.demo.entities.BrandBonusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class BrandBonusRepositoryTest {
    @Autowired
    TestEntityManager EntityManager;
    @Autowired
    BrandBonusRepository brandBonusRepository;
}
