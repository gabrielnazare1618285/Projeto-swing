package com.br.pdvpostocombustivel.api.contato.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContatoRequest(
        @NotBlank(message = "O telefone não pode estar em branco.")
        String telefone,

        @Email(message = "O email deve ser válido.")
        String email,

        String endereco
) {}
