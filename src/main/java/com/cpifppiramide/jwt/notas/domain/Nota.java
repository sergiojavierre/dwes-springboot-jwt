package com.cpifppiramide.jwt.notas.domain;

import java.sql.Timestamp;

public class Nota {
    private Integer id;
    private String texto;
    private Timestamp timestamp;

    public Nota(Integer id, String texto, Timestamp timestamp) {
        this.id = id;
        this.texto = texto;
        this.timestamp = timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
