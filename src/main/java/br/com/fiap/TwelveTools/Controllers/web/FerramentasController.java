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

    @GetMapping("/nova")
    public String novaFerramenta(Model model) {
        model.addAttribute("ferramenta", new FerramentaDTO());
        return "formulario";
    }

    @PostMapping()
    public String salvarFerramenta(@Valid @ModelAttribute("ferramenta") FerramentaDTO entidade) {
        service.post(entidade);
        return "redirect:/ferramentas";
    }

    @GetMapping("delete/{id}")
    public String deletarFerramenta(@PathVariable("id") Long id, Model model){
        service.delete(id);
        return "redirect:/ferramentas";
    }

    @GetMapping("editar/{id}")
    public String editarFerramenta(@PathVariable("id") Long id, Model model){
        model.addAttribute("ferramenta", service.getById(id));
        return "formularioEdit";
    }

    @PostMapping("atualizar/{id}")
    public String atualizarFerramenta(@PathVariable("id") Long id, Model model, FerramentaDTO ferramenta){
        service.put(id, ferramenta);
        return "redirect:/ferramentas";
    }
}
