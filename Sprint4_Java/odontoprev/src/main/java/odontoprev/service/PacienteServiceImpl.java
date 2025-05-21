package odontoprev.service;

import odontoprev.model.Paciente;
import odontoprev.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente autenticar(String usuario, String senha) {
        System.out.println("Tentando autenticar: " + usuario + " / " + senha);
        Paciente paciente = pacienteRepository.findByUsuario(usuario);

        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente.getUsuario());
            if (paciente.getSenha().equals(senha)) {
                System.out.println("Senha confere!");
                return paciente;
            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("Paciente não encontrado");
        }

        return null;
    }


    @Override
    public Paciente cadastrar(String usuario, String senha) {
        Paciente pacienteExistente = pacienteRepository.findByUsuario(usuario);
        if (pacienteExistente != null) {
            return null;  // Usuário já cadastrado
        }

        Paciente paciente = new Paciente();
        paciente.setUsuario(usuario);
        paciente.setSenha(senha);  // prefixa a senha com {noop} para texto puro
        return pacienteRepository.save(paciente);
    }
}