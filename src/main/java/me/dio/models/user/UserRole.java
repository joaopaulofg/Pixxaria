package me.dio.models.user;

public enum UserRole {
    CLIENTE("cliente"),
    FUNCIONARIO("funcionario");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
