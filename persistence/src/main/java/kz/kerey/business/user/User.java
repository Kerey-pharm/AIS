package kz.kerey.business.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="K_USER")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String login;
	
	@Column
	private String passwordHash;

	@OneToMany
	private Set<Role> roles;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String cellPhone;
	
	@Column(nullable=false)
	private Date availableFromDate;
	
	@Column(nullable=false)
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Date getAvailableFromDate() {
		return availableFromDate;
	}

	public void setAvailableFromDate(Date availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
