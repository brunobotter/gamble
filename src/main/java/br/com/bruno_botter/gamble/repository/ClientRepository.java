package br.com.bruno_botter.gamble.repository;

import br.com.bruno_botter.gamble.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
    Optional<Client> findByCpf(String cpf);
    Optional<Client> findByUsername(String username);
}
