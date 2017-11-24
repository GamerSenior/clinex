package gioandbill.br.clinica.services;

import gioandbill.br.clinica.models.Login;
import gioandbill.br.clinica.models.NivelAcesso;
import gioandbill.br.clinica.repo.LoginRepository;
import gioandbill.br.clinica.repo.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Login login) {
        login.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
        login.setNiveis(new HashSet<NivelAcesso>(nivelAcessoRepository.findAll()));
        loginRepository.save(login);
    }

    @Override
    public Login findByUsername(String username) {
        return loginRepository.findByLogin(username);
    }
}
