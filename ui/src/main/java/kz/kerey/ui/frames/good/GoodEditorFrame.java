package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;

public class GoodEditorFrame extends JFrame {

	private static final long serialVersionUID = -2721645318072690106L;
	
	private GoodLoader goodLoader = new GoodLoader();

	private final GoodListPanel goodListPanel = new GoodListPanel();
	private final GoodEditPanel goodEditPanel = new GoodEditPanel();
	private JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	public GoodEditorFrame() {
		this.initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		goodListPanel.setGoods(goodLoader.loadElements());
		goodListPanel.setUpdateButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goodListPanel.setGoods(goodLoader.loadElements());
			}
		});
		goodListPanel.setGoodListSelectionActionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList<GoodWrapper> l = (JList<GoodWrapper>) e.getSource();
				goodEditPanel.setGoodWrapperObject(l.getSelectedValue());
			}
		});
		
		goodEditPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodLoader.updateElement(goodEditPanel.getGoodWrapper(), goodEditPanel.getUpdatedGoodWrapper());
				goodListPanel.setGoods(goodLoader.loadElements());
			}
		});
		
		splitter.add(goodListPanel);
		splitter.add(goodEditPanel);
		
		this.add(splitter,BorderLayout.CENTER);
		
        pack();
    }   
	
}
