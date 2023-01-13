package io.github.alexbbf.spark.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false, length = 200)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;





}
