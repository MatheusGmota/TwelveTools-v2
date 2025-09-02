package br.com.fiap.TwelveTools.Controllers.api;

import br.com.fiap.TwelveTools.Service.FerrarmentasService;
import br.com.fiap.TwelveTools.dtos.FerramentaDTO;
import br.com.fiap.TwelveTools.model.Ferramenta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/ferramentas")
public class FerramentasController {

    @Autowired
    private FerrarmentasService service;

    @GetMapping()
    public CollectionModel<Ferramenta> get() {
        List<Ferramenta> ferramentas = service.getAll();

        for (Ferramenta ferramenta : ferramentas) {
            String ferramentaId = String.valueOf(ferramenta.getId());
            Link selfLink = linkTo(FerramentasController.class).slash(ferramentaId).withSelfRel();
            ferramenta.add(selfLink);
        }

        Link link = linkTo(FerramentasController.class).withSelfRel();
        return CollectionModel.of(ferramentas, link);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        Object resposta = service.getById(id);
        if (resposta instanceof Ferramenta) {
            Link selfLink = linkTo(FerramentasController.class).slash(id).withSelfRel();
            ((Ferramenta) resposta).add(selfLink);
            return ResponseEntity.ok().body(resposta);
        };
        return ResponseEntity.status(404).body(resposta);
    }

    @PostMapping()
    public ResponseEntity<Object> post(@Valid @RequestBody FerramentaDTO ferramentas) {
        Object resposta = service.post(ferramentas);

        if (resposta instanceof String) return ResponseEntity.status(404).body(resposta);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable Long id, @Valid @RequestBody FerramentaDTO ferramentas) {
        Object resposta = service.put(id, ferramentas);
        if (resposta instanceof String) return ResponseEntity.status(404).body(resposta);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Object delete = service.delete(id);
        return ResponseEntity.ok(delete);
    }

}
