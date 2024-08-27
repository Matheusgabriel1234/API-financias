package desafio.matheus.desafio_tabela_financias.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_financeData")
public class FinanceData {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;	

@JsonIgnore
@ManyToOne
@JoinColumn(name = "user_id")
public DataUser userId;
@Column(name ="created_At")
public LocalDateTime createdAt;
public BigDecimal amount;
public String description;
public String category;


@PrePersist
protected void onCreate() {
	createdAt = LocalDateTime.now();
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public DataUser getUserId() {
	return userId;
}
public void setUserId(DataUser userId) {
	this.userId = userId;
}
public BigDecimal getamount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public FinanceData(Long id, DataUser userId, BigDecimal amount, String description, String category) {
	super();
	this.id = id;
	this.userId = userId;
	this.amount = amount;
	this.description = description;
	this.category = category;
}


public FinanceData() {
	
}


	
	
}
