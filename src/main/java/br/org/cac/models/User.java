package br.org.cac.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.org.cac.enums.PerfilEnum;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -6397875999349763060L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
	private int id;
	
	private String nome;
	
	private String email;
	
	private String username;
	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
	private Colaborador colaborador;

	@Enumerated(EnumType.STRING)
	private PerfilEnum role;
	
	public User() {
	}
	
	public User(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.colaborador = user.getColaborador();
		this.role = user.getRole();
		this.nome = user.getNome();
		this.email = user.getEmail();
	}

	public User(int id, String userName, String passWord, Colaborador colaborador, PerfilEnum role, String nome, String email) {
		super();
		this.id = id;
		this.username = userName;
		this.password = passWord;
		this.colaborador = colaborador;
		this.role = role;
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public PerfilEnum getRole() {
		return role;
	}

	public void setRole(PerfilEnum role) {
		this.role = role;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
