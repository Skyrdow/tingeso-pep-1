package com.example.demo.entities;


import com.example.demo.enums.ReparationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String patent;
    private Date admissionDate;
    private ReparationType reparationType;
    private Long repairValue;
    private Date repairExitDate;
    private Date retrievalDate;
}
