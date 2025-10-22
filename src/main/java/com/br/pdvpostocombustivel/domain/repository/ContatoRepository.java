package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    Optional<Contato> findByTelefone(String Telefone);
    Optional<Contato> findByEmail(String Email);
    Optional<Contato> findByEndereco(String Endereco);
    boolean existsByTelefone(String Telefone);
    boolean existsByEmail(String Email);
    boolean existsByEndereco(String Endereco);
}
