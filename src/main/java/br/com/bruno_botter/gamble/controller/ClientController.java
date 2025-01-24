package br.com.bruno_botter.gamble.controller;

import br.com.bruno_botter.gamble.dto.ClientRequest;
import br.com.bruno_botter.gamble.dto.ClientResponse;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Criar um cliente
    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid ClientRequest clientRequest) {
        Client client = Client.fromDTO(clientRequest);
        Client createdClient = clientService.save(client);
        return new ResponseEntity<ClientResponse>(new ClientResponse(createdClient),HttpStatus.OK);
    }

    // Buscar um cliente por email
    @GetMapping("/email/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable String email) {
        Optional<Client> client = clientService.findByEmail(email);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar um cliente por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Client> getClientByCpf(@PathVariable String cpf) {
        Optional<Client> client = clientService.findByCpf(cpf);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
