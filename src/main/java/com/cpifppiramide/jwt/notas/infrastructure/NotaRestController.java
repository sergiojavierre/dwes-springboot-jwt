package com.cpifppiramide.jwt.notas.infrastructure;

import com.cpifppiramide.jwt.notas.application.NotasUseCases;
import com.cpifppiramide.jwt.notas.domain.Nota;
import com.cpifppiramide.jwt.usuarios.domain.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaRestController {

    private NotasUseCases notasUseCases;

    public NotaRestController(){
        this.notasUseCases = new NotasUseCases(new NotasRepositoryPostgres());
    }

    @GetMapping()
    public List<Nota> list(Authentication auth){
        Usuario usuario = new Usuario(auth.getName(),null);
        return this.notasUseCases.list(usuario);
    }

    @PostMapping("/save")
    public Nota save(Authentication auth,
                     @RequestBody Nota nota){
        Usuario usuario = new Usuario(auth.getName(), null);
        return this.notasUseCases.save(nota, usuario);
    }

}
