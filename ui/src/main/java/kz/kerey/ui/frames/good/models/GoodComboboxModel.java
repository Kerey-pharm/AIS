package kz.kerey.ui.frames.good.models;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kz.kerey.business.wrappers.GoodWrapper;

public class GoodComboboxModel extends DefaultComboBoxModel<GoodWrapper> {

	private static final long serialVersionUID = -5311669618799660525L;

	public GoodComboboxModel(List<GoodWrapper> data) {
		for (GoodWrapper good : data)
			this.addElement(good);
	}
	
}
