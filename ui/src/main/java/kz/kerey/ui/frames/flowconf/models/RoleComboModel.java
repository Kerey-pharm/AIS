package kz.kerey.ui.frames.flowconf.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.loaders.RoleLoader;

public class RoleComboModel extends DefaultComboBoxModel<RoleWrapper> {

	private static final long serialVersionUID = 807553782299404958L;

	private static final RoleComboModel model = new RoleComboModel();
	private RoleComboModel() {}
	public static RoleComboModel getModel() {
		return model;
	}
	
	private void setData(List<RoleWrapper> data) {
		this.removeAllElements();
		for (RoleWrapper role : data) 
			this.addElement(role);
	}

	public void reloadData() {
		this.setData(RoleLoader.getLoader().loadElements());
	}
	
}