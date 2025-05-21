package odontoprev.repository;

import odontoprev.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByUsuario(String usuario);
}

