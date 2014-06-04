package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.enums.RoleProperty;
import kz.kerey.business.types.enums.UserProperty;
import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.business.wrappers.UserWrapper;

public interface UserInterface {

	public void createRole(RoleWrapper obj);
	public void deleteRole(Long id);
	public List<RoleWrapper> getRoleList(Boolean paged, Integer pageNum, Integer perPage);
	public void changeRoleProperty(Long id, RoleProperty propertyName, String newValue);
	
	public void createUser(UserWrapper obj);
	public void deleteUser(Long id);
	public List<UserWrapper> getUserList(Boolean paged, Integer pageNum, Integer perPage);
	public List<UserWrapper> getUserListFiltered(Boolean paged, Integer pageNum, Integer perPage, String filter);
	public void changeUserProperty(Long id, UserProperty propertyName, String newValue);
	
	public void addRoleToUser(Long userId, Long roleId);
	public void removeRoleFromUser(Long userId, Long roleId);
	public List<RoleWrapper> getUserRolesList(Long id);
	
}