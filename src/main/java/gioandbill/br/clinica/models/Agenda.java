package gioandbill.br.clinica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn
    private Recepcionista recepcionista;

    @OneToOne
    @JoinColumn
    private Medico medico;

    @OneToOne
    @JoinColumn
    private Paciente paciente;

    @Column
    private Date dataAgendada;

    @Column
    private Timestamp horaAgendada;

    @Column
    private boolean cancelado;
}
