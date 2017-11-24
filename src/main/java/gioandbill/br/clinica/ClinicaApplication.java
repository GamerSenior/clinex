package gioandbill.br.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("gioandbill.br.clinica.repo")
@EntityScan("gioandbill.br.clinica.models")
@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}
}
