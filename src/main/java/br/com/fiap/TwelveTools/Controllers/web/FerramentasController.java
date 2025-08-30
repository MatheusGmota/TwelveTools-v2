package br.com.fiap.TwelveTools.Controllers.web;

import br.com.fiap.TwelveTools.Service.FerrarmentasService;
import br.com.fiap.TwelveTools.dtos.FerramentaDTO;
import br.com.fiap.TwelveTools.model.Ferramenta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller("webFerramentasController")
@RequestMapping("/ferramentas")
public class FerramentasController {

    @Autowired
    public FerrarmentasService service;

    @GetMapping
    public String listarFerramentas(Model model) {
        model.addAttribute("ferramentas", service.getAll());
        return "listar";
    }

    @GetMapping
    public String novaFerramenta(Model model) {
        model.addAttribute("ferramentas", new Ferramenta());
        return "formulario";
    }

    @PostMapping()
    public String salvarFerramenta(@Valid @RequestBody FerramentaDTO entidade) {
        service.post(entidade);
        return "redirect:/ferramentas";
    }
}
