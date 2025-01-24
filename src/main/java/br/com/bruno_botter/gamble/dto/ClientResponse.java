package br.com.bruno_botter.gamble.dto;

import br.com.bruno_botter.gamble.model.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ClientResponse {

    private long clientId;
    private String name;
    @Email
    private String email;
    private String password;
    @CPF
    private String cpf;
    private BigDecimal saldo;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createAt;

    public ClientResponse() {
    }

    public ClientResponse(Client client) {
        this.clientId = client.getClientId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.cpf = client.getCpf();
        this.saldo = client.getSaldo();
        this.createAt = client.getCreateAt();
    }

    public long getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public @Email String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}
