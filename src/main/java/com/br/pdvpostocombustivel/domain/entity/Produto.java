package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "produtos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_produtos_referencia", columnNames = "referencia")
        }
)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "referencia", nullable = false, length = 50)
    private String referencia;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "fornecedor", length = 100)
    private String fornecedor;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @deprecated Construtor para uso exclusivo do JPA.
     */
    @Deprecated
    protected Produto() {}

    public Produto(String nome, String referencia, String marca, String fornecedor) {
        this.nome = nome;
        this.referencia = referencia;
        this.marca = marca;
        this.fornecedor = fornecedor;
    }
}
