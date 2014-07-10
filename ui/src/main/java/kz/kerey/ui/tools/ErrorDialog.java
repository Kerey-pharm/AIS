package kz.kerey.ui.tools;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialog extends JDialog {

	private static final long serialVersionUID = -7387556720493514643L;

	private String title = null;

	private ErrorDialog(Frame owner, String text) {
		super(owner, true);
		this.title = text;
		initComponents();
		WindowTool.setWindowAtCenter(this);
		this.setResizable(false);

	}

	private void initComponents() {
		this.setTitle("Warning");
		JPanel titlePanel = new JPanel();
		JButton okButton = new JButton("OK");
		JLabel titleLabel = new JLabel(this.title);
		if (titleLabel.getPreferredSize() != null) {
			WindowTool.setWindowDimensions(this, (int) titleLabel
					.getPreferredSize().getWidth() + 25, (int) titleLabel
					.getPreferredSize().getHeight() + 60);
		}
		if (okButton.getPreferredSize() != null) {
			okButton.setSize((int) okButton.getPreferredSize().getWidth(),
					(int) okButton.getPreferredSize().getHeight());
		}
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.add(okButton, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(titlePanel, BorderLayout.CENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component comp = (Component) e.getSource();
				while (comp != null && !(comp instanceof ErrorDialog)) {
					comp = comp.getParent();
				}
				((ErrorDialog) comp).dispose();
			}
		});
	}

	public static void showDialog(Frame owner, String text) {
		ErrorDialog dialog = new ErrorDialog(owner, text);
		dialog.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ErrorDialog.showDialog(null, "Error test!!!");
			}
		});
	}

}