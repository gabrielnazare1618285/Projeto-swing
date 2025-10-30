package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ContatoResponse create(ContatoRequest req) {
        validarUnicidadeEmail(req.email(), null);
        Contato novoContato = toEntity(req);
        return toResponse(repository.save(novoContato));
    }

    // READ by ID
    @Transactional(readOnly = true)
    public ContatoResponse getById(Long id) {
        Contato c = repository.findById(id.intValue())
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));
        return toResponse(c);
    }

    // READ by Email
    @Transactional(readOnly = true)
    public ContatoResponse getByEmail(String email) {
        Contato c = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. email=" + email));
        return toResponse(c);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<ContatoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    // UPDATE
    public ContatoResponse update(Long id, ContatoRequest req) {
        Contato c = repository.findById(id.intValue())
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));

        if (req.email() != null && !req.email().equals(c.getEmail())) {
            validarUnicidadeEmail(req.email(), id);
        }

        c.setTelefone(req.telefone());
        c.setEmail(req.email());
        c.setEndereco(req.endereco());

        return toResponse(repository.save(c));
    }

    // PATCH
    public ContatoResponse patch(Long id, ContatoRequest req) {
        Contato c = repository.findById(id.intValue())
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));

        if (req.telefone() != null) c.setTelefone(req.telefone());
        if (req.email() != null) {
            if (!req.email().equals(c.getEmail())) {
                validarUnicidadeEmail(req.email(), id);
            }
            c.setEmail(req.email());
        }
        if (req.endereco() != null) c.setEndereco(req.endereco());

        return toResponse(repository.save(c));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id.intValue())) {
            throw new IllegalArgumentException("Contato não encontrado. id=" + id);
        }
        repository.deleteById(id.intValue());
    }

    // ---------- Helpers ----------
    private void validarUnicidadeEmail(String email, Long idAtual) {
        repository.findByEmail(email).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Email já cadastrado: " + email);
            }
        });
    }

    private Contato toEntity(ContatoRequest req) {
        return new Contato(req.telefone(), req.email(), req.endereco());
    }

    private ContatoResponse toResponse(Contato c) {
        return new ContatoResponse(c.getId(), c.getTelefone(), c.getEmail(), c.getEndereco());
    }
}
