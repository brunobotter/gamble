package br.com.bruno_botter.gamble.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class ClientRequest {

    @NotBlank(message = "O nome é obrigatório.")
    private String name;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String password;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.")
    @CPF(message = "O CPF é obrigatório.")
    private String cpf;


    public @NotBlank(message = "O nome é obrigatório.") String getName() {
        return name;
    }

    public @NotBlank(message = "O email é obrigatório.") @Email(message = "O email deve ser válido.") String getEmail() {
        return email;
    }

    public @NotBlank(message = "A senha é obrigatória.") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.") String getPassword() {
        return password;
    }

    public @NotBlank(message = "O CPF é obrigatório.") @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.") String getCpf() {
        return cpf;
    }

}
