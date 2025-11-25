package br.com.fatec.modulo4.entity;

import java.time.LocalDate;

public record Pessoa(
        String nome,
        LocalDate dataNascimento
) { }
