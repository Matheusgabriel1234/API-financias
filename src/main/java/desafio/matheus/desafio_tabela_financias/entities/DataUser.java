package desafio.matheus.desafio_tabela_financias.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class DataUser {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String firstName;
private String lastName;
private String email;
private String password;

@OneToMany(mappedBy = "userId",cascade = CascadeType.ALL)
private List<FinanceData> dataFinance;



public DataUser(Long id, String firstName, String lastName, String email, String password,
		List<FinanceData> dataFinance) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.dataFinance = dataFinance;
}


public DataUser() {
	
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public List<FinanceData> getDataFinance() {
	return dataFinance;
}


public void setDataFinance(List<FinanceData> dataFinance) {
	this.dataFinance = dataFinance;
}









}
