package desafio.matheus.desafio_tabela_financias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
@ExceptionHandler(EmailAlreadyExistException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public ResponseEntity<String> handleEmailAlreadyExistException(EmailAlreadyExistException e){
	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	
}

@ExceptionHandler(UserNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
	 return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	
}


}
