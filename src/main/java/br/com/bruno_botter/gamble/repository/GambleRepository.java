package br.com.bruno_botter.gamble.repository;

import br.com.bruno_botter.gamble.dto.ConsultaResponse;
import br.com.bruno_botter.gamble.model.Client;
import br.com.bruno_botter.gamble.model.Gamble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GambleRepository extends JpaRepository<Gamble, Long> {

    List<Gamble> findByClient(Client client);

    @Query("SELECT new br.com.bruno_botter.gamble.dto.ConsultaResponse(c.saldo, c.name, c.username, " +
            "g.amountBet, g.dataAposta, g.prizeValue, g.win, g.result.boardA, g.result.boardB, g.result.boardC) " +
            "FROM Client c JOIN Gamble g ON c.clientId = g.client.clientId " +
            "WHERE c.clientId = :clientId " +
            "AND (:startDate IS NULL OR g.dataAposta >= :startDate) " +
            "AND (:endDate IS NULL OR g.dataAposta <= :endDate)")
    List<ConsultaResponse> findClientAndGambleByClientIdAndDateRange(
            @Param("clientId") Long clientId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
