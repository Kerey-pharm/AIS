package kz.kerey.services.ws.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import kz.kerey.business.types.enums.RoleProperty;
import kz.kerey.business.types.enums.UserProperty;
import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.services.api.UserInterface;

@WebService
public class UserWS implements UserInterface {

	@EJB
	UserInterface bean;
	
	public void createRole(RoleWrapper obj) {
		bean.createRole(obj);
	}

	public void deleteRole(
			@WebParam(name="id")
			Long id) {
		bean.deleteRole(id);
	}

	public List<RoleWrapper> getRoleList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum,
			@WebParam(name="perPage")
			Integer perPage) {
		return bean.getRoleList(paged, pageNum, perPage);
	}

	public void changeRoleProperty(
			@WebParam(name="id")
			Long id, 
			@WebParam(name="propertyName")
			RoleProperty propertyName, 
			@WebParam(name="newValue")
			String newValue) {
		bean.changeRoleProperty(id, propertyName, newValue);
	}

	public void createUser(UserWrapper obj) {
		bean.createUser(obj);
	}

	public void deleteUser(
			@WebParam(name="id")
			Long id) {
		bean.deleteUser(id);
	}

	public List<UserWrapper> getUserList(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum,
			@WebParam(name="perPage")
			Integer perPage) {
		return bean.getUserList(paged, pageNum, perPage);
	}

	public List<UserWrapper> getUserListFiltered(
			@WebParam(name="paged")
			boolean paged, 
			@WebParam(name="pageNum")
			Integer pageNum,
			@WebParam(name="perPage")
			Integer perPage, 
			@WebParam(name="filter")
			String filter) {
		return this.getUserList(paged, pageNum, perPage);
	}

	public void changeUserProperty(
			@WebParam(name="id")
			Long id, 
			@WebParam(name="propertyName")
			UserProperty propertyName, 
			@WebParam(name="newValue")
			String newValue) {
		bean.changeUserProperty(id, propertyName, newValue);
	}

	public void addRoleToUser(
			@WebParam(name="userId")
			Long userId, 
			@WebParam(name="roleId")
			Long roleId) {
		bean.addRoleToUser(userId, roleId);
	}

	public void removeRoleFromUser(
			@WebParam(name="userId")
			Long userId, 
			@WebParam(name="roleId")
			Long roleId) {
		bean.removeRoleFromUser(userId, roleId);
	}

	public List<RoleWrapper> getUserRolesList(
			@WebParam(name="id")
			Long id) {
		return bean.getUserRolesList(id);
	}

}
