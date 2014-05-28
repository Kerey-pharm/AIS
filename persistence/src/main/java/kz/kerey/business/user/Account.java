package kz.kerey.business.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import kz.kerey.business.types.enums.Role;

@Entity
@DiscriminatorValue("Account")
public class Account extends User {

	@Column
	private String login;
	
	@Column
	private String passwordHash;

	@ElementCollection(targetClass=Role.class)
	@Column
	private List<Role> roles;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
