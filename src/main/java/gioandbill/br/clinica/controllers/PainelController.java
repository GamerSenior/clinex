package gioandbill.br.clinica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PainelController {
    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        return "painel/index";
    }
}
