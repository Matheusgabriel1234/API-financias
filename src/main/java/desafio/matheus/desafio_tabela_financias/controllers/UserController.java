package desafio.matheus.desafio_tabela_financias.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.service.UserService;

@RequestMapping
@RestController
public class UserController {

private UserService serv;

public UserController(UserService serv) {
	super();
	this.serv = serv;
}

public ResponseEntity<List<DataUser>> getAll(){
List<DataUser> obj = serv.getAll();
return new ResponseEntity<>(obj, HttpStatus.OK);
}

public ResponseEntity<Optional<DataUser>> getById(@PathVariable Long id){
Optional<DataUser> user = serv.getById(id);
return new ResponseEntity<>(user,HttpStatus.OK);


}

public ResponseEntity<DataUser> create(@RequestBody DataUser user){
DataUser obj = serv.create(user);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}


}
