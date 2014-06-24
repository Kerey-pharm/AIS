package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.ui.frames.good.models.GoodListModel;

public class GoodListPanel extends JPanel {

	private static final long serialVersionUID = 8333475170490065058L;
	
	private JPanel goodListPanel = new JPanel();
	private JLabel titleLabel = new JLabel("Наименования"); 
	private JList<GoodWrapper> goodList = new JList<GoodWrapper>();

	private JPanel buttonsPanel = new JPanel();
	private JButton addButton = new JButton("Добавить");
	private JButton delButton = new JButton("Удалить");
	private JButton refButton = new JButton("Обновить");
	
	public GoodListPanel() {
		this.initComponents();
	}
	
	private void initComponents() {
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(addButton, BorderLayout.WEST);
		buttonsPanel.add(refButton, BorderLayout.CENTER);
		buttonsPanel.add(delButton, BorderLayout.EAST);
		
		goodListPanel.setLayout(new BorderLayout());
		goodListPanel.add(titleLabel, BorderLayout.NORTH);
		goodListPanel.add(goodList, BorderLayout.CENTER);
		goodList.setBorder(new LineBorder(Color.BLACK));
		
		this.setLayout(new BorderLayout());
		this.add(goodListPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		this.goodList.setModel(GoodListModel.getModel());
	}
	
	public void setDeleteButtonActionListener(ActionListener listener) {
		this.delButton.addActionListener(listener);
	}
	
	public void setAddButtonActionListener(ActionListener listener) {
		this.addButton.addActionListener(listener);
	}
	
	public void setUpdateButtonActionListener(ActionListener actionListener) {
		this.refButton.addActionListener(actionListener);
	}
	
	public void setGoodListSelectionActionListener(ListSelectionListener listener) {
		this.goodList.addListSelectionListener(listener);
	}
	
}