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
import kz.kerey.ui.frames.good.models.GoodTypeListModel;
import kz.kerey.ui.tools.WindowTool;

public class GoodTypeEditorFrame extends JFrame {

	private static final long serialVersionUID = 5396624147326536479L;
	
	private GoodTypeLoader loader = GoodTypeLoader.getLoader();

	private GoodTypeAddFrame addFrame = GoodTypeAddFrame.getSelf();
	
	private GoodTypeEditPanel goodTypeEditPanel = new GoodTypeEditPanel();
	private GoodTypeListPanel goodTypeListPanel = new GoodTypeListPanel();
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
	}
	
	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GoodTypeListModel.getModel().reloadData();
		goodTypeListPanel.setUpdateButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodTypeListModel.getModel().reloadData();
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
				addFrame.setVisible(true);
			}
		});
		
		goodTypeEditPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.updateElement(goodTypeEditPanel.getGoodWrapper(), goodTypeEditPanel.getUpdatedGoodWrapper());
				GoodTypeListModel.getModel().reloadData();
			}
		});
		
		goodTypeEditPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodTypeEditPanel.setGoodWrapperObject(selectedObject);
			}
		});
		
		splitter.add(goodTypeListPanel);
		splitter.add(goodTypeEditPanel);
		
		this.add(splitter,BorderLayout.CENTER);
		
        pack();
	}
	
}