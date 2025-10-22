package com.br.pdvpostocombustivel.enums;

public enum TipoAcesso {
    FUNCIONARIO("Acesso Funcionario"),
    GERENTE("Acesso Gerente");

    private final String descricao;

    private TipoAcesso(String descricao) {
        this.descricao = descricao; }
        public String getDescricao() { return descricao; }
}
