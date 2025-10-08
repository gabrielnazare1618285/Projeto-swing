package com.br.pdvpostocombustivel.domain.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String dataAlteracao;
    private String valorAlteracao;

    public Preco(BigDecimal valor, String dataAlteracao, String valorAlteracao) {

    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getValorAlteracao() {
        return valorAlteracao;
    }

    public void setValorAlteracao(String valorAlteracao) {
        this.valorAlteracao = valorAlteracao;
    }

    protected Preco() {}
}
