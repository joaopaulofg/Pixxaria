package me.dio.dtos;

import lombok.Getter;
import lombok.Setter;
import me.dio.models.user.User;

@Getter
@Setter
public class UserCreateDTO {

    private String login;
    private String nome;
    private String email;
    private String password;

    public UserCreateDTO fromEntity(User user) {
        this.login = user.getLogin();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.password = user.getPassword();
        return this;
    }

}
