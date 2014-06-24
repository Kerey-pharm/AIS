package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultListModel;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;

public class GoodListModel extends DefaultListModel<GoodWrapper> {
	
	private static final long serialVersionUID = 3268388291216289868L;
	
	final private static GoodListModel model = new GoodListModel();
	private GoodListModel() {
	}
	public static GoodListModel getModel() {
		return model;
	}

	private void setData(List<GoodWrapper> data) {
		this.clear();
		for (GoodWrapper type : data) 
			this.addElement(type);
	}
	
	public void reloadData() {
		this.setData(GoodLoader.getLoader().loadElements());
	}
	
}