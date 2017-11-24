package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Empregado {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "pessoa_cpf")
    private Pessoa pessoa;

    @Column
    private Long salario;
}
