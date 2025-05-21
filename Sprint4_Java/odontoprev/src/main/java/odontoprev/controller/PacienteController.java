package odontoprev.controller;

import odontoprev.dto.LoginEvent;
import odontoprev.dto.LoginProducer;
import odontoprev.model.Paciente;
import odontoprev.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class PacienteController {

    private final PacienteService pacienteService;
    private final LoginProducer loginProducer;

    // Construtor correto
    @Autowired
    public PacienteController(PacienteService pacienteService, LoginProducer loginProducer) {
        this.pacienteService = pacienteService;
        this.loginProducer = loginProducer;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @PostMapping("/login-entrar")
    public String autenticar(@RequestParam String usuario,
                             @RequestParam String senha,
                             Model model) {
        System.out.println("Tentando login com: " + usuario + " | " + senha);

        Paciente paciente = pacienteService.autenticar(usuario, senha);
        boolean sucesso = paciente != null;

        // Envia evento de login para o RabbitMQ
        LoginEvent evento = new LoginEvent(usuario, sucesso, LocalDateTime.now());
        loginProducer.enviarEventoLogin(evento);

        if (sucesso) {
            System.out.println("Usuário autenticado com sucesso!");
            model.addAttribute("usuario", paciente.getUsuario());
            return "area-recompensas";
        } else {
            System.out.println("Falha na autenticação.");
            model.addAttribute("erro", "Usuário ou senha inválidos.");
            return "login";
        }
    }

    @GetMapping("/cadastro")
    public String cadastroForm() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String usuario, @RequestParam String senha) {
        Paciente paciente = pacienteService.cadastrar(usuario, senha);
        if (paciente != null) {
            return "redirect:/login?mensagem=Cadastro realizado com sucesso!";
        } else {
            return "redirect:/cadastro?erro=Usuário já cadastrado!";
        }
    }

    @GetMapping("/area-recompensa")
    public String areaRecompensas() {
        return "area-recompensas";
    }

    @GetMapping("/agendamento")
    public String agendamento() {
        return "agendamento";
    }

    @GetMapping("/recompensas")
    public String recompensas() {
        return "recompensas";
    }

    @GetMapping("/historico")
    public String historico() {
        return "historico";
    }
}
