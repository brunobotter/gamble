package br.com.bruno_botter.gamble.repository;

import br.com.bruno_botter.gamble.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {


}
