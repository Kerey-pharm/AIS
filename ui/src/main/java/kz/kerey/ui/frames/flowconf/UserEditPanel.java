package kz.kerey.ui.frames.flowconf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.loaders.RoleLoader;
import kz.kerey.ui.frames.base.ListPanel;
import kz.kerey.ui.frames.flowconf.models.RoleComboModel;
import kz.kerey.ui.tools.ErrorDialog;
import kz.kerey.ui.tools.WindowTool;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class UserEditPanel extends JPanel {

	private static final long serialVersionUID = 411914983969430554L;

	private UserWrapper user;
	private UserWrapper updatedUser;

	private JLabel loginLabel = new JLabel("Логин");
	private JLabel nameLabel = new JLabel("Имя");
	private JLabel lastNameLabel = new JLabel("Фамилия");
	private JLabel emailLabel = new JLabel("Е-Маил");
	private JLabel cellPhoneLabel = new JLabel("Сотовый телефон");
	private JLabel availableFromDateLabel = new JLabel("Дата создания");

	private JTextField login = new JTextField();
	private JTextField name = new JTextField();
	private JTextField lastName = new JTextField();
	private JTextField email = new JTextField();
	JFormattedTextField cellPhone = null;
	private JCheckBox active = new JCheckBox("Активный");

	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

	private JButton saveButton = new JButton("Сохранить");
	private JButton undoButton = new JButton();
	private JButton pswdButton = new JButton("Установить пароль");

	private JSplitPane splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

	public UserEditPanel(String undoButtonTitle) {
		this.initComponents();
		this.undoButton.setText(undoButtonTitle);
	}

	private void initComponents() {
		MaskFormatter cellMaskFormatter = null;
		try {
			cellMaskFormatter = new MaskFormatter("(###) ###-##-##");
			cellPhone = new JFormattedTextField(cellMaskFormatter);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 1));
		buttonPanel.add(saveButton);
		buttonPanel.add(undoButton);
		buttonPanel.add(pswdButton);

		JPanel editorPanel = new JPanel();
		editorPanel.setLayout(new GridLayout(14, 1));
		editorPanel.add(loginLabel);
		editorPanel.add(login);
		editorPanel.add(nameLabel);
		editorPanel.add(name);
		editorPanel.add(lastNameLabel);
		editorPanel.add(lastName);
		editorPanel.add(emailLabel);
		editorPanel.add(email);
		editorPanel.add(cellPhoneLabel);
		editorPanel.add(cellPhone);
		editorPanel.add(availableFromDateLabel);
		editorPanel.add(datePicker);
		editorPanel.add(active);

		splitter.add(editorPanel);
		splitter.add(buttonPanel);

		this.setLayout(new BorderLayout());
		this.add(splitter, BorderLayout.CENTER);
	}

	public void setSaveButtonActionListener(ActionListener listener) {
		this.saveButton.addActionListener(listener);
	}

	public void setUndoButtonActionListener(ActionListener listener) {
		this.undoButton.addActionListener(listener);
	}

	public void setPswdButtonActionListener(ActionListener listener) {
		this.pswdButton.addActionListener(listener);
	}

}