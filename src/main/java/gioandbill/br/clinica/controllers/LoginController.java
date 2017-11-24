package gioandbill.br.clinica.controllers;

import gioandbill.br.clinica.models.Login;
import gioandbill.br.clinica.models.NivelAcesso;
import gioandbill.br.clinica.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @GetMapping
    public Iterable findAll(){
        return loginRepository.findAll();
    }

    @GetMapping("/nivel/{$nivelAcesso}")
    public List findByNicelAcesso(@PathVariable NivelAcesso nivelAcesso){
        return loginRepository.findByNiveis(nivelAcesso);
    }

    @GetMapping("/{id}")
    public Login findOne(@PathVariable long id){
        return loginRepository.findOne(id).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/register")
    public String register(WebRequest webRequest, Model model){
        Login login = new Login();
        model.addAttribute("user", login);
        return "registration";
    }
}
