package odontoprev.service;


import odontoprev.model.Paciente;

public interface PacienteService {
    Paciente autenticar(String usuario, String senha);
    Paciente cadastrar(String usuario, String senha);
}

