package desafio.matheus.desafio_tabela_financias.exceptions;

public class EmailAlreadyExistException extends RuntimeException {

 public EmailAlreadyExistException(String email) {
	 super("The Email: " + email + " already exists");
 }
 
 
	
	

}
