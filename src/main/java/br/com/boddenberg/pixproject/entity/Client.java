package br.com.boddenberg.pixproject.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Geral")
public class Client {

	
	@Id
	private String id;
		
	
	@CPF(message = "CPF inválido!")
	private String cpf;
	
	
	@Email(message = "Email inválido!")
	private String email;
	
	@Pattern(regexp = "[\\d]{2,3}[\\d]{4,5}[\\d]{5}", message = "Telefone inválido")
	private String phoneNumber;

	@CNPJ(message = "CNPJ inválido")
	@Pattern(regexp = "[\\d]{2}\\.[\\d]{3}\\.[\\d]{3}\\/[\\d]{4}\\-[\\d]{2}", message = "CNPJ inválido")
	private String CNPJ;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	

	public Client() {}

	public Client(String id, String cpf, String email, String phoneNumber) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	
}


