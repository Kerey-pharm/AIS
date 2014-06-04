package kz.kerey.services.rs.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import kz.kerey.business.types.enums.RoleProperty;
import kz.kerey.business.types.enums.UserProperty;
import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.services.api.UserInterface;

@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UserRS implements UserInterface {

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;
	
	@EJB
	UserInterface bean;
	
	@Path("roles")
	@POST
	public void createRole(RoleWrapper obj) {
		bean.createRole(obj);
	}

	@Path("roles")
	@DELETE
	public void deleteRole(
			@QueryParam("id")
			Long id) {
		bean.deleteRole(id);
	}

	@Path("roles")
	@GET
	public List<RoleWrapper> getRoleList(
			@QueryParam("paged")
			boolean paged, 
			@QueryParam("pageNum")
			Integer pageNum,
			@QueryParam("perPage")
			Integer perPage) {
		return bean.getRoleList(paged, pageNum, perPage);
	}

	@Path("roles")
	@PUT
	public void changeRoleProperty(
			@QueryParam("id")
			Long id, 
			@QueryParam("propertyName")
			RoleProperty propertyName, 
			@QueryParam("newValue")
			String newValue) {
		bean.changeRoleProperty(id, propertyName, newValue);
	}

	@Path("users")
	@POST
	public void createUser(UserWrapper obj) {
		bean.createUser(obj);
	}

	@Path("users")
	@DELETE
	public void deleteUser(
			@QueryParam("id")
			Long id) {
		bean.deleteUser(id);
	}

	@Path("users")
	@GET
	public List<UserWrapper> getUserList(
			@QueryParam("paged")
			boolean paged,
			@QueryParam("pageNum")
			Integer pageNum,
			@QueryParam("perPage")
			Integer perPage) {
		return bean.getUserList(paged, pageNum, perPage);
	}

	@Override
	public List<UserWrapper> getUserListFiltered(boolean paged,
			Integer pageNum, Integer perPage, String filter) {
		return null;
	}

	@Path("users")
	@PUT
	public void changeUserProperty(
			@QueryParam("id")
			Long id,
			@QueryParam("propertyName")
			UserProperty propertyName,
			@QueryParam("newValue")
			String newValue) {
		bean.changeUserProperty(id, propertyName, newValue);
	}

	@Path("users/{userId}/{roleId}")
	@PUT
	public void addRoleToUser(
			@PathParam("userId")
			Long userId, 
			@PathParam("roleId")
			Long roleId) {
		bean.addRoleToUser(userId, roleId);
	}

	@Path("users/{userId}/{roleId}")
	@DELETE
	public void removeRoleFromUser(
			@PathParam("userId")
			Long userId, 
			@PathParam("roleId")
			Long roleId) {
		bean.removeRoleFromUser(userId, roleId);
	}

	@Path("users/{userId}/roles")
	@GET
	public List<RoleWrapper> getUserRolesList(
			@PathParam("id")
			Long id) {
		return bean.getUserRolesList(id);
	}

}
