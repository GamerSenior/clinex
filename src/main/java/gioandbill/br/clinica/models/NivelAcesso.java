package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class NivelAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nomeAcesso;

    @ManyToMany(mappedBy = "login")
    private Set<Login> logins;
}
