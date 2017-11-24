package gioandbill.br.clinica.controllers;

import gioandbill.br.clinica.models.Empregado;
import gioandbill.br.clinica.repo.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/empregado")
public class EmpregadoController {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @GetMapping
    public Iterable findAll(){
        return empregadoRepository.findAll();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List findByNome(@PathVariable String empregadoNome){
        return empregadoRepository.findByPessoa_Nome(empregadoNome);
    }

    @GetMapping("/{id}")
    public Empregado findOne(@PathVariable long id){
        return empregadoRepository.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empregado create(@RequestBody Empregado empregado){
        return empregadoRepository.save(empregado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        empregadoRepository.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
        empregadoRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Empregado updateEmpregado(@RequestBody Empregado empregado, @PathVariable long id){
        if(empregado.getId() != id){
            throw new RuntimeException();
        }
        empregadoRepository.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
        return empregadoRepository.save(empregado);
    }
}
