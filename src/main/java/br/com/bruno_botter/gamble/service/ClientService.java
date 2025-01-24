package br.com.bruno_botter.gamble.service;

import br.com.bruno_botter.gamble.config.exception.DataIntegrityException;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public Optional<Client> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Client save(Client client) {
        try{
        return clientRepository.save(client);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Duplicate item");
        }
    }
}
