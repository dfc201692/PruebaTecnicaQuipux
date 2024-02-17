package com.musicapp.demo.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "listas_reproduccion")
public class ListaReproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lista_reproduccion_id")
    private List<Cancion> canciones;

    public ListaReproduccion(Long id, String nombre, String descripcion, List<Cancion> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.canciones = canciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}

