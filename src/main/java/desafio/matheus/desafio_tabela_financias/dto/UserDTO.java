package desafio.matheus.desafio_tabela_financias.dto;



import java.util.List;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.entities.FinanceData;

public record UserDTO(String lastName,String firstName,String email,String password,List<FinanceData> finance) {

	
	
public static UserDTO fromEntity(DataUser user) {
        return new UserDTO(
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPassword(),
            user.getDataFinance()
        );
    }
	
	
	
	
public DataUser convertToEntity() {
DataUser user = new DataUser();

user.setFirstName(this.firstName);
user.setLastName(this.lastName);
user.setEmail(this.email);
user.setPassword(password);
user.setDataFinance(finance);

return user;
	
}
}
