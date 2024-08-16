package desafio.matheus.desafio_tabela_financias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.repository.UserRepository;

@Service
public class UserService {

	
private UserRepository repo;

public List<DataUser> getAll(){
return repo.findAll();
}


public Optional<DataUser> getById(Long id){
return repo.findById(id);
}

public DataUser create(DataUser user) {
return repo.save(user);
}


}
