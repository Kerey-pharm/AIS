package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.loaders.GoodTypeLoader;

public class GoodTypeComboboxModel extends DefaultComboBoxModel<GoodTypeWrapper> {

	private static final long serialVersionUID = -8060072613055595342L;

	final private static GoodTypeComboboxModel model = new GoodTypeComboboxModel();
	private GoodTypeComboboxModel() {
	}
	public static GoodTypeComboboxModel getModel() {
		return model;
	}
	
	private void setData(List<GoodTypeWrapper> data) {
		this.removeAllElements();
		for (GoodTypeWrapper type : data) 
			this.addElement(type);
	}
	
	public void reloadData() {
		this.setData(GoodTypeLoader.getLoader().loadElements());
	}
	
}