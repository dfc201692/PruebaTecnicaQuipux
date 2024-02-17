package com.musicapp.demo.service;


import com.musicapp.demo.model.ListaReproduccion;
import com.musicapp.demo.repository.ListaReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaReproduccionService {

    @Autowired
    private ListaReproduccionRepository listaReproduccionRepository;

    public ListaReproduccion agregarListaReproduccion(ListaReproduccion listaReproduccion) {
        if (listaReproduccion.getNombre() == null || listaReproduccion.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de lista no válido");
        }
        return listaReproduccionRepository.save(listaReproduccion);
    }

    public List<ListaReproduccion> obtenerTodasListasReproduccion() {
        return listaReproduccionRepository.findAll();
    }

    public ListaReproduccion obtenerListaReproduccionPorNombre(String nombre) {
        Optional<ListaReproduccion> listaReproduccionOptional = listaReproduccionRepository.findByNombre(nombre);
        if (listaReproduccionOptional.isPresent()) {
            return listaReproduccionOptional.get();
        } else {
            throw new IllegalArgumentException("Lista no encontrada");
        }
    }

    public void borrarListaReproduccion(String nombre) {
        Optional<ListaReproduccion> listaReproduccionOptional = listaReproduccionRepository.findByNombre(nombre);
        if (listaReproduccionOptional.isPresent()) {
            listaReproduccionRepository.delete(listaReproduccionOptional.get());
        } else {
            throw new IllegalArgumentException("Lista no encontrada");
        }
    }
}

