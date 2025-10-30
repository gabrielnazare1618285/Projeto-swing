package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "precos")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

    @Column(name = "valor_alteracao", precision = 10, scale = 2)
    private BigDecimal valorAlteracao;

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public BigDecimal getValorAlteracao() {
        return valorAlteracao;
    }

    public void setValorAlteracao(BigDecimal valorAlteracao) {
        this.valorAlteracao = valorAlteracao;
    }

    /**
     * @deprecated Construtor para uso exclusivo do JPA.
     */
    @Deprecated
    protected Preco() {}

    public Preco(BigDecimal valor, LocalDate dataAlteracao, BigDecimal valorAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.valorAlteracao = valorAlteracao;
    }
}
