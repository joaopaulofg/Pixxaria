package me.jp.dtos.authentication;

import me.jp.enums.UserRole;

public record RegisterDTO(String login, String nome, String password, UserRole role) {
}
