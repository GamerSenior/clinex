package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn
    private Pessoa pessoa;
}
