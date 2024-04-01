package com.example.demo.repositories;

import com.example.demo.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    public ClienteEntity findByRut(String rut);
    List<ClienteEntity> findByCategory(String category);
    @Query(value = "select * from clientes where cliente.rut = :rut", nativeQuery = true)
    ClienteEntity findByRutNativeQuery(@Param("rut") String rut);
}
