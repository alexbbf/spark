package io.github.alexbbf.spark.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Militar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(name = "nome_guerra",nullable = false, length = 100)
    private String nomeGuerra;

    @Column(nullable = false, length = 20)
    private String matricula;

    @Column(nullable = false, length = 11)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rg_id")
    private Rg rg;

    @ManyToOne
    @JoinColumn(name = "posto_graduacao_id")
    private PostoGraduacao postoGraduacao;

    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private Quadro quadro;

     @Column(name = "data_nascimento")
    private LocalDate dataNascimento;




}
