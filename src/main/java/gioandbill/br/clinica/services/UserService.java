package gioandbill.br.clinica.services;

import gioandbill.br.clinica.models.Login;

public interface UserService {
    void save(Login login);

    Login findByUsername(String username);
}