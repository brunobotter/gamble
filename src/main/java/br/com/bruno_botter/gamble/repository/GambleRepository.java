package br.com.bruno_botter.gamble.repository;

import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Gamble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GambleRepository extends JpaRepository<Gamble, Long> {

    List<Gamble> findByClient(Client client);
}
