package odontoprev.dto;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginProducer {

    private final RabbitTemplate rabbitTemplate;

    public LoginProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarEventoLogin(LoginEvent evento) {
        rabbitTemplate.convertAndSend("login-eventos", evento);
    }
}
