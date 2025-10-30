package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import com.br.pdvpostocombustivel.domain.repository.CustoRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustoService {

    private final CustoRepository repository;

    public CustoService(CustoRepository repository) {
        this.repository = repository;
    }

    public CustoResponse create(CustoRequest req) {
        Custo novoCusto = toEntity(req);
        return toResponse(repository.save(novoCusto));
    }

    @Transactional(readOnly = true)
    public CustoResponse getById(Long id) {
        Custo c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Custo não encontrado. id=" + id));
        return toResponse(c);
    }

    @Transactional(readOnly = true)
    public Page<CustoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public CustoResponse update(Long id, CustoRequest req) {
        Custo c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Custo não encontrado. id=" + id));

        c.setImposto(req.imposto());
        c.setFrete(req.frete());
        c.setSeguro(req.seguro());
        c.setCustoVariavel(req.custoVariavel());
        c.setCustoFixo(req.custoFixo());
        c.setMargemLucro(req.margemLucro());
        c.setDataProcessamento(req.dataProcessamento());

        return toResponse(repository.save(c));
    }

    public CustoResponse patch(Long id, CustoRequest req) {
        Custo c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Custo não encontrado. id=" + id));

        if (req.imposto() != null) c.setImposto(req.imposto());
        if (req.frete() != null) c.setFrete(req.frete());
        if (req.seguro() != null) c.setSeguro(req.seguro());
        if (req.custoVariavel() != null) c.setCustoVariavel(req.custoVariavel());
        if (req.custoFixo() != null) c.setCustoFixo(req.custoFixo());
        if (req.margemLucro() != null) c.setMargemLucro(req.margemLucro());
        if (req.dataProcessamento() != null) c.setDataProcessamento(req.dataProcessamento());

        return toResponse(repository.save(c));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Custo não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Custo toEntity(CustoRequest req) {
        return new Custo(req.imposto(), req.frete(), req.seguro(), req.custoVariavel(), req.custoFixo(), req.margemLucro(), req.dataProcessamento());
    }

    private CustoResponse toResponse(Custo c) {
        return new CustoResponse(c.getId(), c.getImposto(), c.getFrete(), c.getSeguro(), c.getCustoVariavel(), c.getCustoFixo(), c.getMargemLucro(), c.getDataProcessamento());
    }
}
