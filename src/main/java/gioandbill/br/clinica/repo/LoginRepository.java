package gioandbill.br.clinica.repo;

import gioandbill.br.clinica.models.Login;
import gioandbill.br.clinica.models.NivelAcesso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LoginRepository extends CrudRepository<Login, Long>{
    List<Login> findByNiveis(NivelAcesso nivelAcesso);
    Login findByLogin(String login);
    Optional<Login> findOne(long id);
}
