package br.com.bruno_botter.gamble.model;

import br.com.bruno_botter.gamble.dto.ClientRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;
    private BigDecimal saldo;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @Column(unique = true)
    private String username;

    public Client() {
    }

    public Client(String name, String email, String password, String cpf, BigDecimal saldo, String username) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.saldo = saldo;
        this.username = username;
    }

    public static Client fromDTO(ClientRequest dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPassword(dto.getPassword());
        client.setCpf(dto.getCpf());
        client.setSaldo(new BigDecimal(0));
        client.setCreateAt(LocalDateTime.now());
        client.setUpdateAt(LocalDateTime.now());
        client.setUsername(dto.getUsername());
        return client;
    }
    public String getName() {
        return name;
    }

    public long getClientId() {
        return clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
