package com.br.pdvpostocombustivel.enums;

public enum TipoPreco {

     FIXO("Preco Fixo"),
     VARIAVEL("Preco Variavel");

    private final String descricao;

    private TipoPreco(String descricao) {
        this.descricao = descricao; }
    public String getDescricao() { return descricao; }
}
