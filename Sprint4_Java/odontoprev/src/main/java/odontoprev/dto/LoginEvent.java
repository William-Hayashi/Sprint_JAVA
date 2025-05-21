package odontoprev.dto;

import java.time.LocalDateTime;

public class LoginEvent {
    private String usuario;
    private boolean sucesso;
    private LocalDateTime dataHora;

    public LoginEvent() {}

    public LoginEvent(String usuario, boolean sucesso, LocalDateTime dataHora) {
        this.usuario = usuario;
        this.sucesso = sucesso;
        this.dataHora = dataHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

