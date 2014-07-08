package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;
import kz.kerey.ui.frames.good.models.GoodComboboxModel;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.tools.WindowTool;

public class GoodAddFrame extends JFrame {

	private static final long serialVersionUID = -5600819889520437028L;

	private GoodLoader loader = GoodLoader.getLoader();
	
	private GoodEditPanel editPanel = new GoodEditPanel();
	
	private GoodTypeEditorFrame addTypeEditorFrame = GoodTypeEditorFrame.getSelf();
	
	final private static GoodAddFrame self = new GoodAddFrame();
	public static GoodAddFrame getSelf() {
		return self;
	}
	private GoodAddFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 400, 600);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Добавить номенклатуру");
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
				GoodComboboxModel.getModel().reloadData();
				dispose();
			}
		});
		editPanel.setTypesButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTypeEditorFrame.setVisible(true);
			}
		});
	}
	
	public void cleanFrame() {
		this.editPanel.cleanPanel();
	}
	
}