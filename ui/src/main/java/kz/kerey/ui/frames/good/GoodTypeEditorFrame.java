package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.loaders.GoodTypeLoader;
import kz.kerey.ui.frames.base.ListPanel;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.tools.ErrorDialog;
import kz.kerey.ui.tools.WindowTool;

public class GoodTypeEditorFrame extends JFrame {

	private static final long serialVersionUID = 5396624147326536479L;
	
	private GoodTypeLoader loader = GoodTypeLoader.getLoader();

	private GoodTypeAddFrame addFrame = GoodTypeAddFrame.getSelf();
	
	private GoodTypeEditPanel goodTypeEditPanel = new GoodTypeEditPanel("Вернуть");
	private ListPanel goodTypeListPanel = new ListPanel("Производные",GoodTypeComboboxModel.getModel());
	private JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	private GoodTypeWrapper selectedObject;
	
	final private static GoodTypeEditorFrame self = new GoodTypeEditorFrame();
	public static GoodTypeEditorFrame getSelf() {
		return self;
	}
	
	private GoodTypeEditorFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 800, 400);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Редактор номенклатур");
	}
	
	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GoodTypeComboboxModel.getModel().reloadData();
		goodTypeListPanel.setUpdateButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodTypeComboboxModel.getModel().reloadData();
			}
		});
		goodTypeListPanel.setGoodListSelectionActionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList<GoodTypeWrapper> l = (JList<GoodTypeWrapper>) e.getSource();
				selectedObject = l.getSelectedValue();
				goodTypeEditPanel.setGoodWrapperObject(selectedObject);
			}
		});
		goodTypeListPanel.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame.cleanFrame();
				addFrame.setVisible(true);
			}
		});
		
		goodTypeEditPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.updateElement(goodTypeEditPanel.getGoodWrapper(), goodTypeEditPanel.getUpdatedGoodWrapper());
				GoodTypeComboboxModel.getModel().reloadData();
			}
		});
		
		goodTypeEditPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodTypeEditPanel.setGoodWrapperObject(selectedObject);
			}
		});
		goodTypeListPanel.setDeleteButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedObject!=null) {
					try {
						loader.deleteElement(selectedObject);
						GoodTypeComboboxModel.getModel().reloadData();
					}
					catch (RuntimeException ex) {
						ErrorDialog.showDialog(GoodTypeEditorFrame.getSelf(), "Удаление не возможно, существуют зависимости.");
  					}
				}
			}
		});
		
		splitter.add(goodTypeListPanel);
		splitter.add(goodTypeEditPanel);
		
		this.add(splitter,BorderLayout.CENTER);
		
        pack();
	}
	
}