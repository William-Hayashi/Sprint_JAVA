package odontoprev.dto;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LoginConsumer {

    @RabbitListener(queues = "login-eventos") // nome da fila que você está usando
    public void receberLogin(LoginEvent evento) {
        System.out.println("[INFO ] Evento de login recebido: usuario="
                + evento.getUsuario() + " | sucesso="
                + evento.isSucesso() + " | data="
                + evento.getDataHora());
    }
}
