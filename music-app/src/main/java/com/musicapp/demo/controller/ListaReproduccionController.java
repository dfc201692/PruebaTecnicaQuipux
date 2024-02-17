package com.musicapp.demo.controller;

import com.musicapp.demo.model.ListaReproduccion;
import com.musicapp.demo.service.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListaReproduccionController {

    @Autowired
    private ListaReproduccionService listaReproduccionService;

    @PostMapping
    public ResponseEntity<Object> agregarListaReproduccion(@RequestBody ListaReproduccion listaReproduccion) {
        try {
            ListaReproduccion nuevaLista = listaReproduccionService.agregarListaReproduccion(listaReproduccion);
            URI location = new URI("/lists/" + nuevaLista.getNombre());
            return ResponseEntity.created(location).body(nuevaLista);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Nombre de lista no válido");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<ListaReproduccion>> obtenerTodasListasReproduccion() {
        List<ListaReproduccion> listas = listaReproduccionService.obtenerTodasListasReproduccion();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{listName}")
    public ResponseEntity<Object> obtenerListaReproduccion(@PathVariable String listName) {
        try {
            ListaReproduccion lista = listaReproduccionService.obtenerListaReproduccionPorNombre(listName);
            return ResponseEntity.ok(lista);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Lista no encontrada");
        }
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Object> borrarListaReproduccion(@PathVariable String listName) {
        try {
            listaReproduccionService.borrarListaReproduccion(listName);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Lista no encontrada");
        }
    }
}

