package com.br.pdvpostocombustivel.api.acesso.dto;

import com.br.pdvpostocombustivel.domain.entity.Acesso;
import com.br.pdvpostocombustivel.domain.repository.AcessoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcessoService {

    private final AcessoRepository repository;

    public AcessoService(AcessoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public AcessoResponse create(AcessoRequest req) {
        validarUnicidadeUsuario(req.usuario(), null);
        Acesso novoAcesso = toEntity(req);
        // TODO: A senha deve ser criptografada antes de salvar
        return toResponse(repository.save(novoAcesso));
    }

    // READ by ID
    @Transactional(readOnly = true)
    public AcessoResponse getById(Long id) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));
        return toResponse(a);
    }

    // READ by Usuario
    @Transactional(readOnly = true)
    public AcessoResponse getByUsuario(String usuario) {
        Acesso a = repository.findByUsuario(usuario)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. usuario=" + usuario));
        return toResponse(a);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<AcessoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    // UPDATE
    public AcessoResponse update(Long id, AcessoRequest req) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));

        if (req.usuario() != null && !req.usuario().equals(a.getUsuario())) {
            validarUnicidadeUsuario(req.usuario(), id);
        }

        a.setUsuario(req.usuario());
        a.setSenha(req.senha()); // TODO: Criptografar

        return toResponse(repository.save(a));
    }

    // PATCH
    public AcessoResponse patch(Long id, AcessoRequest req) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));

        if (req.usuario() != null) {
            if (!req.usuario().equals(a.getUsuario())) {
                validarUnicidadeUsuario(req.usuario(), id);
            }
            a.setUsuario(req.usuario());
        }
        if (req.senha() != null) {
            a.setSenha(req.senha()); // TODO: Criptografar
        }

        return toResponse(repository.save(a));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Acesso não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    // ---------- Helpers ----------
    private void validarUnicidadeUsuario(String usuario, Long idAtual) {
        repository.findByUsuario(usuario).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Usuário já cadastrado: " + usuario);
            }
        });
    }

    private Acesso toEntity(AcessoRequest req) {
        return new Acesso(req.usuario(), req.senha());
    }

    private AcessoResponse toResponse(Acesso a) {
        // A senha não deve ser exposta na resposta. Retornando null ou uma string vazia.
        return new AcessoResponse(a.getUsuario(), null);
    }
}
