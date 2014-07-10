package kz.kerey.ui.frames.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = -7248480257302449680L;

	private JPanel listPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel();
	private JList list = new JList();
	
	private JPanel buttonsPanel = new JPanel();
	private JButton addButton = new JButton("Добавить");
	private JButton delButton = new JButton("Удалить");
	private JButton refButton = new JButton("Обновить");
	
	private void initComponents() {
		buttonsPanel.setLayout(new GridLayout(1,1));
		buttonsPanel.add(addButton);
		buttonsPanel.add(refButton);
		buttonsPanel.add(delButton);
		
		listPanel.setLayout(new BorderLayout());
		listPanel.add(titleLabel, BorderLayout.NORTH);
		listPanel.add(list, BorderLayout.CENTER);
		list.setBorder(new LineBorder(Color.BLACK));
		
		this.setLayout(new BorderLayout());
		this.add(listPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public ListPanel(String title, ListModel<?> model) {
		this.initComponents();		
		this.titleLabel.setText(title);
		this.list.setModel(model);
	}
	
	public void setListModel(ListModel<?> model) {
		this.list.setModel(model);
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
		this.list.addListSelectionListener(listener);
	}
	
}
