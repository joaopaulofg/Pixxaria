package me.jp.dtos;

import me.jp.models.user.User;

public class UserResponseDTO {

    private String nome;
    private String email;

    public static UserResponseDTO fromEntity(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.nome = user.getNome();
        userResponseDTO.email = user.getEmail();
        return userResponseDTO;
    }
}
