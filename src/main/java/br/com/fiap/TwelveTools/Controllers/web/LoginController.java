package br.com.fiap.TwelveTools.Controllers.web;

import br.com.fiap.TwelveTools.dtos.AuthenticationDTO;
import br.com.fiap.TwelveTools.dtos.SignupDTO;
import br.com.fiap.TwelveTools.model.User;
import br.com.fiap.TwelveTools.model.enums.UserRole;
import br.com.fiap.TwelveTools.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class LoginController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String signup() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("data") AuthenticationDTO data, BindingResult result) {
        if (result.hasErrors())
            return "redirect:/register";

        this.repository.save(new User(data.login(), data.login(), UserRole.ADMIN));

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("data") AuthenticationDTO data, BindingResult result) {
        if (result.hasErrors())
            return "login";
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/";
    }
}
