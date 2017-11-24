package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;
    private String passwordConfirm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "login_id"), inverseJoinColumns = @JoinColumn(name = "nivelacesso_id"))
    private Set<NivelAcesso> niveis;
}
