package br.com.fiap.TwelveTools.Service;

import br.com.fiap.TwelveTools.dtos.FerramentaDTO;
import br.com.fiap.TwelveTools.model.Ferramenta;
import br.com.fiap.TwelveTools.repository.FerramentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerrarmentasService {

    @Autowired
    private FerramentasRepository repository;

    public List<Ferramenta> getAll() {
        return repository.findAll();
    }

    public Object getById(Long id) {
        if(id == null) {
            return "Id da ferramenta não encontrado!";
        }
        Ferramenta ferramenta = repository.findById(id).orElse(null);
        if(ferramenta == null) {
            return "Ferramenta não encontrada.";
        }
        return ferramenta;
    }

    public Object post(FerramentaDTO objeto) {
        if(objeto != null) {
            Ferramenta ferramenta = new Ferramenta();
            ferramenta.setNome(objeto.getNome());
            ferramenta.setTipo(objeto.getTipo());
            ferramenta.setClassificacao(objeto.getClassificacao());
            ferramenta.setTamanho(objeto.getTamanho());
            ferramenta.setPreco(objeto.getPreco());
            repository.save(ferramenta);
            return ferramenta;
        } else {
            return "Erro ao tentar salvar a ferramenta!";
        }
    }

    public Object put(Long id, FerramentaDTO objeto) {
        if (id == null) {
            return "Id da ferramenta é obrigatório para atualização!";
        }

        Ferramenta existente = repository.findById(id).orElse(null);
        if (existente == null) {
            return "Ferramenta não encontrada para o ID informado!";
        }

        existente.setNome(objeto.getNome());
        existente.setTipo(objeto.getTipo());
        existente.setClassificacao(objeto.getClassificacao());
        existente.setTamanho(objeto.getTamanho());
        existente.setPreco(objeto.getPreco());

        repository.saveAndFlush(existente);
        return existente;
    }

    public Object delete(Long id) {
        Ferramenta ferramenta = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id:" + id + "não encontrado"));
        repository.delete(ferramenta);
        return ferramenta;
    }
}
