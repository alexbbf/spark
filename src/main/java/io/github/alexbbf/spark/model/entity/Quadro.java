package io.github.alexbbf.spark.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Quadro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String descricao;

    @Column(length = 10)
    private String sigla;
}
