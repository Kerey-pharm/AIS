package kz.kerey.loaders;

import java.util.List;

import kz.kerey.business.wrappers.RoleWrapper;

public class RoleLoader extends Loader<RoleWrapper> {

	final private static RoleLoader self = new RoleLoader();

	private RoleLoader() {
	}

	public static RoleLoader getLoader() {
		return self;
	}

	@Override
	public List<RoleWrapper> loadElements() {
		return userService.getRoleList(false, null, null);
	}

	@Override
	public RoleWrapper loadById(Long id) {
		return null;
	}

	@Override
	public void updateElement(RoleWrapper objWas, RoleWrapper objNew) {
	}

	@Override
	public void saveElement(RoleWrapper obj) {
		userService.createRole(obj);
	}

	@Override
	public void deleteElement(RoleWrapper obj) {
		userService.deleteRole(obj.getId());
	}

}