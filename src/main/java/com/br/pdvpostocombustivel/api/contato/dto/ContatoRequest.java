package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoAcesso;
import org.springframework.format.annotation.DateTimeFormat;

public record ContatoRequest(String telefone, String email, String endereco, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
TipoAcesso tipoAcesso) {

}