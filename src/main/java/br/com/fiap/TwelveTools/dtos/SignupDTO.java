package br.com.fiap.TwelveTools.dtos;

import br.com.fiap.TwelveTools.model.enums.UserRole;

public record SignupDTO(String login, String password, UserRole role) {
}
