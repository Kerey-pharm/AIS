package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;

public class GoodComboboxModel extends DefaultComboBoxModel<GoodWrapper> {

	private static final long serialVersionUID = -5311669618799660525L;

	final private static GoodComboboxModel model = new GoodComboboxModel();

	private GoodComboboxModel() {
	}

	public static GoodComboboxModel getModel() {
		return model;
	}

	private void setData(List<GoodWrapper> data) {
		this.removeAllElements();
		for (GoodWrapper type : data)
			this.addElement(type);
	}

	public void reloadData() {
		this.setData(GoodLoader.getLoader().loadElements());
	}

	public static class GoodWorker extends SwingWorker<Integer, Integer> {

		@Override
		protected Integer doInBackground() throws Exception {
			GoodComboboxModel.getModel().reloadData();
			return 0;
		}
		
	}
	
}