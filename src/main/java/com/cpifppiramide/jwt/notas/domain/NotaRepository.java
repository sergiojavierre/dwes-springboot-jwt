package com.cpifppiramide.jwt.notas.domain;

import com.cpifppiramide.jwt.usuarios.domain.Usuario;

import java.util.List;

public interface NotaRepository {
    public List<Nota> list(Usuario usuario);
    public Nota save(Nota nota, Usuario usuario);
}
