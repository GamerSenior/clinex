package gioandbill.br.clinica.repo;

import gioandbill.br.clinica.models.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);
    Optional<Pessoa> findOne(long id);
}
