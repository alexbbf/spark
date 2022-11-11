package io.github.alexbbf.spark.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Rg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String numero;

    @Column(name = "orgao_expeditor",nullable = false, length = 50)
    private String orgaoExpeditor;

    @Column(name = "data_expedicao")
    private LocalDate dataExpedicao;
}
