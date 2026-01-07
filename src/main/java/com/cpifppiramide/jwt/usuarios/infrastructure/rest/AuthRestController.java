package com.cpifppiramide.jwt.usuarios.infrastructure.rest;

import com.cpifppiramide.jwt.context.security.JwtService;
import com.cpifppiramide.jwt.usuarios.application.UsuarioUseCases;
import com.cpifppiramide.jwt.usuarios.domain.Usuario;
import com.cpifppiramide.jwt.usuarios.infrastructure.db.UsuariosRepositoryPostgres;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final JwtService jwtService;
    private UsuarioUseCases usuarioUseCases;

    public AuthRestController(JwtService jwtService) {
        this.jwtService = jwtService;
        this.usuarioUseCases = new UsuarioUseCases(new UsuariosRepositoryPostgres());
    }

    @PostMapping("/registro")
    public String registro(@RequestBody Usuario usuario) {
        Boolean correcto = this.usuarioUseCases.registro(usuario);
        if(correcto){
            return "Registrado correctamente";
        }
        else return "Problemas con el registro";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario login = this.usuarioUseCases.login(usuario);
        if(login != null) {
            return jwtService.generateToken(login.getEmail());
        }
        else return "Usuario y/o contraseña incorrectos";
    }
}

