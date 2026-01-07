package com.cpifppiramide.jwt.usuarios.infrastructure.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {

    @GetMapping
    public String index(Authentication auth) {
        //este endpoint devuelve el token
        return "Email del token: " + auth.getName();
    }
}