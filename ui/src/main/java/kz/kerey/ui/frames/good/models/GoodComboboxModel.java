package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kz.kerey.business.wrappers.GoodWrapper;

public class GoodComboboxModel extends DefaultComboBoxModel<GoodWrapper> {

	private static final long serialVersionUID = -5311669618799660525L;

	final private static GoodComboboxModel model = new GoodComboboxModel();
	private GoodComboboxModel() {
	}
	public static GoodComboboxModel getModel() {
		return model;
	}
	
	public void setData(List<GoodWrapper> data) {
		this.removeAllElements();
		for (GoodWrapper type : data) 
			this.addElement(type);
	}
	
}