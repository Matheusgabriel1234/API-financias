package desafio.matheus.desafio_tabela_financias.dto;



import java.util.List;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.entities.FinanceData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank(message = "Last name is mandatory") String lastName,@NotBlank(message = "First Name is mandatory")String firstName,@Email(message = "Email must be valid") @NotBlank(message = "Email is mandatory") String email,@NotBlank(message = "Password is mandatory") String password,List<FinanceData> finance) {

	
	
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
