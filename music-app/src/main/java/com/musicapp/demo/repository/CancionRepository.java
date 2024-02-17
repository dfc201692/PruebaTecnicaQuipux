package com.musicapp.demo.repository;


import com.musicapp.demo.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}

