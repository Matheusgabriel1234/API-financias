package desafio.matheus.desafio_tabela_financias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.repository.UserRepository;

@Service
public class UserService {

	
private UserRepository repo;



public UserService(UserRepository repo) {
	super();
	this.repo = repo;
}


public List<DataUser> getAll(){
return repo.findAll();
}


public Optional<DataUser> getById(Long id){
return repo.findById(id);
}

public DataUser create(DataUser user) {
return repo.save(user);
}

public void delete(@PathVariable  Long id){
 repo.deleteById(id);	
}


}
