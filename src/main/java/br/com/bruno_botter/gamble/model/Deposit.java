package br.com.bruno_botter.gamble.model;

import br.com.bruno_botter.gamble.dto.DepositRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long depositId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private String paymentMethod;

    private BigDecimal amount;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Deposit() {
    }

    public Deposit(Client client, String paymentMethod, BigDecimal amount) {
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public static Deposit fromDto(Optional<Client> client, DepositRequest depositRequest) {
        Deposit deposit = new Deposit();
        deposit.setAmount(depositRequest.getAmount());
        deposit.setPaymentMethod(depositRequest.getPaymentMethod());
        deposit.setClient(client.get());
        deposit.setCreateAt(LocalDateTime.now());
        deposit.setUpdateAt(LocalDateTime.now());
        return deposit;
    }

    public long getDepositId() {
        return depositId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}
