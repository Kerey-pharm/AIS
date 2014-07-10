package kz.kerey.ui.frames.flowconf.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.loaders.UserLoader;

public class UserComboModel extends DefaultComboBoxModel<UserWrapper> {

	private static final long serialVersionUID = -5269332494262279784L;

	private static UserComboModel self = new UserComboModel();

	private UserComboModel() {
	}

	public static UserComboModel getSelf() {
		return self;
	}

	private void setData(List<UserWrapper> data) {
		this.removeAllElements();
		for (UserWrapper user : data)
			this.addElement(user);
	}

	public void reloadData() {
		this.setData(UserLoader.getSelf().loadElements());
	}

}