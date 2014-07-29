package kz.kerey.ui;

import javax.swing.SwingUtilities;

import kz.kerey.ui.frames.flowconf.UserEditorFrame;
import kz.kerey.ui.frames.good.GoodEditorFrame;
import kz.kerey.ui.frames.good.models.GoodComboboxModel;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;

public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -5799180172371779927L;

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GoodEditorFrame.getSelf().setVisible(true);
				//RoleEditorFrame.getSelf().setVisible(true);
				//UserEditorFrame.getSelf().setVisible(true);
			}
		});
		
	}

}