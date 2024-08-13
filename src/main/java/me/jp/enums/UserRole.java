package me.jp.enums;

public enum UserRole {
    CLIENTE("cliente"),
    FUNCIONARIO("funcionario"),
    DONO("dono");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
