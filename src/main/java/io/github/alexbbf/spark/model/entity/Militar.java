package io.github.alexbbf.spark.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Militar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(name = "nome_guerra",nullable = false, length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nomeGuerra;

    @Column(nullable = false, length = 20)
    @NotEmpty(message = "{campo.matricula.obrigatorio}")
    private String matricula;

    @Column(nullable = false, length = 11)
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{campo.dataNascimento.obrigatorio}")
    private LocalDate dataNascimento;

    @Column(name = "data_ingresso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{campo.dataNascimento.obrigatorio}")
    private LocalDate dataIngresso;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
