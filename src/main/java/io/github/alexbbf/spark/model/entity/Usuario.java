package io.github.alexbbf.spark.model.entity;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")
    private String username;

    @Column( name = "senha")
    private String password;
}
