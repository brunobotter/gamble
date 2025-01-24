package br.com.bruno_botter.gamble.util;

import br.com.bruno_botter.gamble.dto.BoardResponse;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Deposit;
import br.com.bruno_botter.gamble.model.Gamble;
import br.com.bruno_botter.gamble.service.ClientService;
import br.com.bruno_botter.gamble.service.DepositService;
import br.com.bruno_botter.gamble.service.GambleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClientService clientService;
    private final DepositService depositService;
    private final GambleService gambleService;

    @Autowired
    public DataLoader(ClientService clientService, DepositService depositService,GambleService gambleService) {
        this.clientService = clientService;
        this.depositService = depositService;
        this.gambleService = gambleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Client client = new Client("jorge", "jorge@gmail.com", "123456", "79795920006", BigDecimal.ZERO, "botter");
        Client client2 =  clientService.save(client);
        Deposit deposit = new Deposit(client2, "pix", new BigDecimal(10000));
        depositService.depositAmount(deposit);
        BoardResponse board = new BoardResponse("AAA", "AAA", "AAA");
        for(int i = 0; i<50; i++){
            Gamble gamble = new Gamble(client2,BigDecimal.ONE, BigDecimal.TEN,board, true, LocalDateTime.now());
            gambleService.gamble(gamble);
        }
    }
}
