package io.github.alexbbf.spark.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostoGraduacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String descricao;

    @Column(nullable = false, length = 20)
    private String descricaoAbreviada;

}
