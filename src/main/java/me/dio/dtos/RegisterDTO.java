package me.dio.dtos;

import me.dio.enums.UserRole;

public record RegisterDTO(String login, String nome, String password, UserRole role) {
}
