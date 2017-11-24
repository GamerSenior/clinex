package gioandbill.br.clinica.controllers;

import gioandbill.br.clinica.exceptions.PessoaIdMismatchException;
import gioandbill.br.clinica.exceptions.PessoaNotFoundException;
import gioandbill.br.clinica.models.Pessoa;
import gioandbill.br.clinica.repo.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public Iterable findAll(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List findByNome(@PathVariable String pessoaNome){
        return pessoaRepository.findByNome(pessoaNome);
    }

    @GetMapping("/{id}")
    public Pessoa findOne(@PathVariable long id){
        return pessoaRepository.findOne(id)
                .orElseThrow(PessoaNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        pessoaRepository.findOne(id).orElseThrow(PessoaNotFoundException::new);
        pessoaRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Pessoa updatePessoa(@RequestBody Pessoa pessoa, @PathVariable long id){
        if(pessoa.getId() != id){
            throw new PessoaIdMismatchException();
        }
        pessoaRepository.findOne(id)
                .orElseThrow(PessoaNotFoundException::new);
        return pessoaRepository.save(pessoa);
    }
}
