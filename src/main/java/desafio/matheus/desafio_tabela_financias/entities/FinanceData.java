package desafio.matheus.desafio_tabela_financias.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_financeData")
public class FinanceData {

public Long id;	
public DataUser userId;
public BigDecimal value;
public String description;
public String category;




	
	
}
