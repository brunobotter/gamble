package br.com.bruno_botter.gamble.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class GambleRequest {

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.")
    @CPF(message = "O CPF é obrigatório.")
    private String cpf;

    @Min(value = 1, message = "The minimum value is 1 real")
    private BigDecimal amount;

    public String getCpf() {
        return cpf;
    }

    public  BigDecimal getAmount() {
        return amount;
    }
}
