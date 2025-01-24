package br.com.bruno_botter.gamble.dto;

import br.com.bruno_botter.gamble.model.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class DepositRequest {

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.")
    @CPF(message = "O CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "The payment method is mandatory.")
    @NotEmpty(message = "The payment method is mandatory.")
    private String paymentMethod;

    @Min(value = 1, message = "The minimum value is 1 real")
    private BigDecimal amount;

    public String getCpf() {
        return cpf;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public  BigDecimal getAmount() {
        return amount;
    }
}
