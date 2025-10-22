package com.br.pdvpostocombustivel.enums;

public enum TipoContato {
    EMPRESARIAL("Contato Empresarial"),
    PRIVADO("Contato Privado");
    private String descricao;
    TipoContato(String descricao) {
        this.descricao = descricao;}
    public String getDescricao () { return descricao; }
}
