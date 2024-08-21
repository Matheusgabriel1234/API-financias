package desafio.matheus.desafio_tabela_financias.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(Long id) {
		super("The user with id " + id + " not found");
	}

}
