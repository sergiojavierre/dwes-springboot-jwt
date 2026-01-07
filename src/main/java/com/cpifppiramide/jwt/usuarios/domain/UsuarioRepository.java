package com.cpifppiramide.jwt.usuarios.domain;

public interface UsuarioRepository {
    public Boolean registro(Usuario usuario);
    public Usuario login(Usuario usuario);
}
