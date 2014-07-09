package kz.kerey.ui.frames.flowconf;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kz.kerey.business.wrappers.UserWrapper;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

public class UserEditPanel extends JPanel {

	private static final long serialVersionUID = 411914983969430554L;

	private UserWrapper user;
	private UserWrapper updatedUser;
	
	private JTextField login;
	private JTextField passwordHash;
	private JTextField name;
	private JTextField lastName;
	private JTextField email;
	private JTextField cellPhone;
	private JDatePicker availableFromDate = JDateComponentFactory.createJDatePicker();
	private JCheckBox active;
	
	public UserEditPanel() {
		this.initComponents();
	}
	
	private void initComponents() {
		
	}
	
}
