package desafio.matheus.desafio_tabela_financias.exceptions;

public class EmailAlreadyExistException extends RuntimeException {

	
	private final String userEmail;
	
 public EmailAlreadyExistException(String email) {
	 super("The email: " + email + " already exists");
	 this.userEmail = email;
 }

public String getUserEmail() {
	return userEmail;
}
 
 
 
 
	
	

}
