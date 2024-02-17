package com.musicapp.demo.service;

import com.musicapp.demo.model.Usuario;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorUsername(String username);
}

