package kz.kerey.ui.frames.flowconf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import kz.kerey.business.wrappers.RoleWrapper;

public class RoleEditPanel extends JPanel {

	private static final long serialVersionUID = -8105939564935348523L;

	private JLabel nameLabel = new JLabel("Наименование");
	
	private JTextField nameField = new JTextField();
	
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JButton saveButton = new JButton("Сохранить");
	private JButton undoButton = new JButton();
	
	private JSplitPane splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	private RoleWrapper role;
	private RoleWrapper updatedRole;
	
	public RoleEditPanel(String undoButtonTitle) {
		this.initComponents();
		this.initComponentsValidators();
		this.undoButton.setText(undoButtonTitle);
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
	
	public void setRoleWrapperObject(RoleWrapper role) {
		this.role = role;
		this.updatedRole = new RoleWrapper();
		this.updateData();
	}
	
	public RoleWrapper getUpdatedRoleWrapper() {
		this.updatedRole.setId(this.role.getId());
		this.updatedRole.setName(this.nameField.getText());
		return this.updatedRole;
	}
	
	public RoleWrapper getRoleWrapper() {
		return this.role;
	}
	
	private void clearData() {
		this.nameField.setText("");
	}
	
	private void updateData() {
		if (this.role!=null) {
			this.nameField.setText(this.role.getName());
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
	
	public void cleanPanel() {
		this.nameField.setText("");
	}
	
}