package io.github.alexbbf.spark.model.repository;

import io.github.alexbbf.spark.model.entity.Militar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilitarRepository extends JpaRepository<Militar, Integer> {
}
