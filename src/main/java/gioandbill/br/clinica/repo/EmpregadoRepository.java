package gioandbill.br.clinica.repo;

import gioandbill.br.clinica.models.Empregado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmpregadoRepository extends CrudRepository<Empregado, Long>{
    List<Empregado> findByPessoa_Nome(String nome);
    Optional<Empregado> findOne(long id);
}
