package desafio.matheus.desafio_tabela_financias.dto;

import java.util.List;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.entities.FinanceData;

public record UserViewDTO(String firstName,String lastName,String email,List<FinanceData> finance) {
	public  UserViewDTO(DataUser user) {
		this(user.getFirstName(),user.getLastName(),user.getEmail(),user.getDataFinance());
	}
}
