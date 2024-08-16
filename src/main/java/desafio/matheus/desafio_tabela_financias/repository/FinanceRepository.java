package desafio.matheus.desafio_tabela_financias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.matheus.desafio_tabela_financias.entities.FinanceData;

public interface FinanceRepository extends JpaRepository<FinanceData, Long> {

}
