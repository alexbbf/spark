package io.github.alexbbf.spark.model.repository;

import io.github.alexbbf.spark.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
