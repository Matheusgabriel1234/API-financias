package desafio.matheus.desafio_tabela_financias.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.matheus.desafio_tabela_financias.entities.FinanceData;
import desafio.matheus.desafio_tabela_financias.service.FinanceService;

@RestController
@RequestMapping("/api/finances")
public class FinancesController {
	
private FinanceService service;

public FinancesController(FinanceService service) {
this.service = service;
}


@GetMapping
public ResponseEntity<List<FinanceData>> getAll(){
List<FinanceData> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
	
}

@GetMapping("/{id}")
public ResponseEntity<Optional<FinanceData>> getById(@PathVariable Long id){
Optional<FinanceData> obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);	}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteById(@PathVariable Long id){
service.deleteById(id);
return ResponseEntity.noContent().build();
}






}








