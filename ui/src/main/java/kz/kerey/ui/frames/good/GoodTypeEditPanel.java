package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import kz.kerey.business.wrappers.GoodTypeWrapper;

public class GoodTypeEditPanel extends JPanel {

	private static final long serialVersionUID = 2046320572000764088L;

	private JLabel nameLabel = new JLabel("Наименование");
	
	private JTextField nameField = new JTextField();
	
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JButton saveButton = new JButton("Сохранить");
	private JButton undoButton = new JButton("Вернуть");
	
	private JSplitPane splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	private GoodTypeWrapper goodType;
	private GoodTypeWrapper updatedGoodType;
	
	public GoodTypeEditPanel() {
		this.initComponents();
		this.initComponentsValidators();
	}
	
	private void initComponentsValidators() {
		
	}
	
	private void initComponents() {
		buttonPanel.add(saveButton);
		buttonPanel.add(undoButton);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(3,1));
		panel1.add(nameLabel);
		panel1.add(nameField);
		panel1.add(buttonPanel);
		
		splitter.add(panel1);
		splitter.add(panel2);
		
		this.setLayout(new BorderLayout());
		this.add(splitter, BorderLayout.CENTER);
	}
	
	public void setGoodWrapperObject(GoodTypeWrapper goodType) {
		this.goodType = goodType;
		this.updatedGoodType = new GoodTypeWrapper();
		this.updateData();
	}
	
	public GoodTypeWrapper getUpdatedGoodWrapper() {
		this.updatedGoodType.setId(this.goodType.getId());
		this.updatedGoodType.setName(this.nameField.getText());
		return this.updatedGoodType;
	}
	
	public GoodTypeWrapper getGoodWrapper() {
		return this.goodType;
	}
	
	private void clearData() {
		this.nameField.setText("");
	}
	
	private void updateData() {
		if (this.goodType!=null) {
			this.nameField.setText(this.goodType.getName());
			return;
		}
		this.clearData();
	}
	
	public void setSaveButtonActionListener(ActionListener listener) {
		this.saveButton.addActionListener(listener);
	}
	
	public void setUndoButtonActionListener(ActionListener listener) {
		this.undoButton.addActionListener(listener);
	}
	
}
