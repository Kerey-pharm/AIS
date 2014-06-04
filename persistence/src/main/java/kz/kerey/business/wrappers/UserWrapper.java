package kz.kerey.business.wrappers;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserWrapper implements Serializable {

	private Long id;
	private String login;
	private String passwordHash;
	private Set<RoleWrapper> roles;
	private String name;
	private String lastName;
	private String email;
	private String cellPhone;
	private Date availableFromDate;
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
	public Set<RoleWrapper> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleWrapper> roles) {
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
