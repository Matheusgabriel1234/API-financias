package desafio.matheus.desafio_tabela_financias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;

public interface UserRepository extends JpaRepository<DataUser, Long>{
	
boolean existsByEmail(String email);

}
