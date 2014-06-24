package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;
import kz.kerey.loaders.GoodTypeLoader;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.frames.good.models.GoodTypeListModel;
import kz.kerey.ui.tools.WindowTool;

public class GoodAddFrame extends JFrame {

	private static final long serialVersionUID = -5600819889520437028L;

	private GoodLoader loader = GoodLoader.getLoader();
	
	private GoodEditPanel editPanel = new GoodEditPanel();
	
	public GoodAddFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 400, 600);
		WindowTool.setWindowAtCenter(this);
	}
	
	public void dispose() {
		super.dispose();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(editPanel, BorderLayout.CENTER);
		
		editPanel.setGoodWrapperObject(new GoodWrapper());
		GoodTypeComboboxModel.getModel().reloadData();
		
		editPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		editPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.saveElement(editPanel.getUpdatedGoodWrapper());
				GoodTypeComboboxModel.getModel().reloadData();
				GoodTypeListModel.getModel().reloadData();
				dispose();
			}
		});
	}
	
}