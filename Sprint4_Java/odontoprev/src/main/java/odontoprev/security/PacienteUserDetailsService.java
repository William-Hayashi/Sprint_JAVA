package odontoprev.security;

import odontoprev.model.Paciente;
import odontoprev.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PacienteUserDetailsService implements UserDetailsService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Paciente paciente = pacienteRepository.findByUsuario(username);
        if (paciente == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new User(
                paciente.getUsuario(),
                paciente.getSenha(),
                Collections.emptyList() // ou suas roles/permissões
        );
    }
}