package desafio.matheus.desafio_tabela_financias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import desafio.matheus.desafio_tabela_financias.dto.UserDTO;
import desafio.matheus.desafio_tabela_financias.dto.UserViewDTO;
import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.exceptions.EmailAlreadyExistException;
import desafio.matheus.desafio_tabela_financias.exceptions.UserNotFoundException;
import desafio.matheus.desafio_tabela_financias.repository.UserRepository;

@Service
public class UserService {

	
private UserRepository repo;



public UserService(UserRepository repo) {
	super();
	this.repo = repo;
}


public List<UserViewDTO> getAll(){
return repo.findAll().stream().map(UserViewDTO::new).toList();
}


public UserViewDTO getById(Long id){
return repo.findById(id).map(UserViewDTO::new).orElseThrow(()-> new UserNotFoundException(id));
}

public UserDTO create(UserDTO userDto) {
if(isEmailAlreadyRegistred(userDto.email())) {
	throw new EmailAlreadyExistException(userDto.email());
}
DataUser user = userDto.convertToEntity();
DataUser savedUser= repo.save(user);
return UserDTO.fromEntity(savedUser);


}

public void delete(@PathVariable  Long id){
 repo.deleteById(id);	
}

public boolean isEmailAlreadyRegistred(String email) {
return repo.existsByEmail(email);	
}


}
