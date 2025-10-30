package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "acessos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_acessos_usuario", columnNames = "usuario")
        }
)
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @deprecated Construtor para uso exclusivo do JPA.
     */
    @Deprecated
    protected Acesso() {}

    public Acesso(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
}
