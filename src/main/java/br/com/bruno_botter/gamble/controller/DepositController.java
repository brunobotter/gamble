package br.com.bruno_botter.gamble.controller;

import br.com.bruno_botter.gamble.dto.DepositRequest;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Deposit;
import br.com.bruno_botter.gamble.service.ClientService;
import br.com.bruno_botter.gamble.service.DepositService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

    private final DepositService depositService;
    private final ClientService clientService;

    @Autowired
    public DepositController(DepositService depositService, ClientService clientService) {
        this.depositService = depositService;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Deposit> deposit(@RequestBody @Valid DepositRequest depositRequest){
        Optional<Client> client = clientService.findByCpf(depositRequest.getCpf());
        Deposit deposit = Deposit.fromDto(client, depositRequest);
        Deposit newDeposit = depositService.depositAmount(deposit);
        return ResponseEntity.ok(newDeposit);
    }
}
