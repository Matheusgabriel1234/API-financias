package desafio.matheus.desafio_tabela_financias.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	private final Long userId;
	
	public UserNotFoundException(Long id) {
	super("The user with id " + id + " not found");
	this.userId = id;
	}

	public Long getUserId() {
		return userId;
	}
	
	
	

}
