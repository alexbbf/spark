package io.github.alexbbf.spark.model.repository;

import io.github.alexbbf.spark.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
