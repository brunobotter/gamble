package br.com.bruno_botter.gamble.util;

import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Deposit;
import br.com.bruno_botter.gamble.service.ClientService;
import br.com.bruno_botter.gamble.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClientService clientService;
    private final DepositService depositService;

    @Autowired
    public DataLoader(ClientService clientService, DepositService depositService) {
        this.clientService = clientService;
        this.depositService = depositService;
    }

    @Override
    public void run(String... args) throws Exception {
        Client client = new Client("jorge", "jorge@gmail.com", "123456", "79795920006", BigDecimal.ZERO);
        Client client2 =  clientService.save(client);
        Deposit deposit = new Deposit(client2, "pix", new BigDecimal(100));
        depositService.depositAmount(deposit);
    }
}
