package br.com.bruno_botter.gamble.controller;

import br.com.bruno_botter.gamble.config.exception.GambleNotFoundException;
import br.com.bruno_botter.gamble.config.exception.UserNotFoundException;
import br.com.bruno_botter.gamble.dto.ConsultaResponse;
import br.com.bruno_botter.gamble.dto.GambleRequest;
import br.com.bruno_botter.gamble.dto.GambleResponse;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Gamble;
import br.com.bruno_botter.gamble.service.ClientService;
import br.com.bruno_botter.gamble.service.GambleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gamble")
public class GambleController {

    private final ClientService clientService;
    private final GambleService gambleService;

    @Autowired
    public GambleController(ClientService clientService, GambleService gambleService) {
        this.clientService = clientService;
        this.gambleService = gambleService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GambleResponse> gamble(@RequestBody @Valid GambleRequest gambleRequest){
        Client client = clientService.findByCpf(gambleRequest.getCpf()).get();
        Gamble gamble = Gamble.fromDto(client, gambleRequest);
        Gamble gambleResult  = gambleService.gamble(gamble);
        return ResponseEntity.ok(new GambleResponse(gambleResult));
    }

    @GetMapping("/consultar/{username}")
    public ResponseEntity<?> consultarApostas(@PathVariable String username) throws UserNotFoundException, GambleNotFoundException {
        Client client = clientService.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        List<ConsultaResponse> response = gambleService.consultar(client);
        return ResponseEntity.ok(response);
    }
}
