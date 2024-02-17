package com.musicapp.demo.repository;

import com.musicapp.demo.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Long> {
    Optional<ListaReproduccion> findByNombre(String nombre);
}

