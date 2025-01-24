package br.com.bruno_botter.gamble.service;

import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Deposit;
import br.com.bruno_botter.gamble.model.Gamble;
import br.com.bruno_botter.gamble.repository.ClientRepository;
import br.com.bruno_botter.gamble.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepositService {

    private final DepositRepository depositRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public DepositService(DepositRepository depositRepository, ClientRepository clientRepository) {
        this.depositRepository = depositRepository;
        this.clientRepository = clientRepository;
    }

    public Deposit depositAmount(Deposit deposit){
        Client client = deposit.getClient();
        client.setSaldo(client.getSaldo().add(deposit.getAmount()));
        clientRepository.save(client);
        return depositRepository.save(deposit);
    }

    public void removeAmount(Gamble gamble){
        Client client = gamble.getClient();
        client.setSaldo(client.getSaldo().subtract(gamble.getAmountBet()));
    }
}
