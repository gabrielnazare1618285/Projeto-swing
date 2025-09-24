package com.br.pdvpostocombustivel.api.pessoa.dto;

public record PessoaResponse (
        Long id,
        String nomeCompleto,
        String cpfCnpj)
{}
