package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Medico {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn
    private Empregado empregado;
}
