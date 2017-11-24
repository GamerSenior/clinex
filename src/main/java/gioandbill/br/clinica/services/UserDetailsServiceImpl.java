package gioandbill.br.clinica.services;

import gioandbill.br.clinica.models.Login;
import gioandbill.br.clinica.models.NivelAcesso;
import gioandbill.br.clinica.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByLogin(username);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for(NivelAcesso nivelAcesso : login.getNiveis()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(nivelAcesso.getNomeAcesso()));
        }

        return new org.springframework.security.core.userdetails.User(login.getLogin(), login.getPassword(), grantedAuthoritySet);
    }
}
