package odontoprev.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;  // Se for MongoDB



@Document(collection = "pacientes")  // Para MongoDB
public class Paciente {

    @Id
    private String id;  // Usando id gerado automaticamente pelo banco (MongoDB ou JPA)

    private String usuario;
    private String senha;

    // Construtores, getters e setters

    public Paciente() {}

    public Paciente(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}