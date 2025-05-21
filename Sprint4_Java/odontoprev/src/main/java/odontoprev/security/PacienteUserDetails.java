package odontoprev.security;

import odontoprev.model.Paciente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PacienteUserDetails implements UserDetails {

    private final Paciente paciente;

    public PacienteUserDetails(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aqui pode colocar roles, por enquanto só USER
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return paciente.getSenha();
    }

    @Override
    public String getUsername() {
        return paciente.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // pode adaptar depois se quiser
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // pode adaptar depois se quiser
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // pode adaptar depois se quiser
    }

    @Override
    public boolean isEnabled() {
        return true;  // pode adaptar depois se quiser
    }
}
