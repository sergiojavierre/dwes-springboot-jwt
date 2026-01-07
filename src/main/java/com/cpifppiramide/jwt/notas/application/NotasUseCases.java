package com.cpifppiramide.jwt.notas.application;

import com.cpifppiramide.jwt.notas.domain.Nota;
import com.cpifppiramide.jwt.notas.domain.NotaRepository;
import com.cpifppiramide.jwt.usuarios.domain.Usuario;

import java.util.List;

public class NotasUseCases {

    private NotaRepository notaRepository;

    public NotasUseCases(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> list(Usuario usuario){
        return this.notaRepository.list(usuario);
    }

    public Nota save(Nota nota, Usuario usuario){
        return this.notaRepository.save(nota, usuario);
    }
}
