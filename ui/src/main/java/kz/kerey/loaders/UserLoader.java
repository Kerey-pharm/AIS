package kz.kerey.loaders;

import java.util.List;

import kz.kerey.business.wrappers.UserWrapper;

public class UserLoader extends Loader<UserWrapper> {

	private static UserLoader self = new UserLoader();
	private UserLoader() {}
	public static UserLoader getSelf() {
		return self;
	}
	
	@Override
	public List<UserWrapper> loadElements() {
		return userService.getUserList(false, null, null);
	}

	@Override
	public UserWrapper loadById(Long id) {
		return null;
	}

	@Override
	public void updateElement(UserWrapper objWas, UserWrapper objNew) {
		
	}

	@Override
	public void saveElement(UserWrapper obj) {
		userService.createUser(obj);
	}

	@Override
	public void deleteElement(UserWrapper obj) {
		userService.deleteUser(obj.getId());
	}

}
