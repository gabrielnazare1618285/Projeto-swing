package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import com.br.pdvpostocombustivel.domain.repository.PrecoRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrecoService {

    private final PrecoRepository repository;

    public PrecoService(PrecoRepository repository) {
        this.repository = repository;
    }

    public PrecoResponse create(PrecoRequest req) {
        Preco novoPreco = toEntity(req);
        return toResponse(repository.save(novoPreco));
    }

    @Transactional(readOnly = true)
    public PrecoResponse getById(Long id) {
        Preco p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Preço não encontrado. id=" + id));
        return toResponse(p);
    }

    @Transactional(readOnly = true)
    public Page<PrecoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public PrecoResponse update(Long id, PrecoRequest req) {
        Preco p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Preço não encontrado. id=" + id));

        p.setValor(req.valor());
        p.setDataAlteracao(req.dataAlteracao());
        p.setValorAlteracao(req.valorAlteracao());

        return toResponse(repository.save(p));
    }

    public PrecoResponse patch(Long id, PrecoRequest req) {
        Preco p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Preço não encontrado. id=" + id));

        if (req.valor() != null) p.setValor(req.valor());
        if (req.dataAlteracao() != null) p.setDataAlteracao(req.dataAlteracao());
        if (req.valorAlteracao() != null) p.setValorAlteracao(req.valorAlteracao());

        return toResponse(repository.save(p));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Preço não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Preco toEntity(PrecoRequest req) {
        return new Preco(req.valor(), req.dataAlteracao(), req.valorAlteracao());
    }

    private PrecoResponse toResponse(Preco p) {
        return new PrecoResponse(p.getId(), p.getValor(), p.getDataAlteracao(), p.getValorAlteracao());
    }
}
