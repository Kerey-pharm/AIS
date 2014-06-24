package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultListModel;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.loaders.GoodTypeLoader;

public class GoodTypeListModel extends DefaultListModel<GoodTypeWrapper> {

	private static final long serialVersionUID = 6910201466363644234L;

	final private static GoodTypeListModel model = new GoodTypeListModel();
	private GoodTypeListModel() {
	}
	public static GoodTypeListModel getModel() {
		return model;
	}
	
	private void setData(List<GoodTypeWrapper> data) {
		this.clear();
		for (GoodTypeWrapper type : data) 
			this.addElement(type);
	}
	
	public void reloadData() {
		this.setData(GoodTypeLoader.getLoader().loadElements());
	}
	
}