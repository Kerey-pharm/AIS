package kz.kerey.ui;

import kz.kerey.ui.frames.good.GoodEditorFrame;

public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -5799180172371779927L;

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GoodEditorFrame.getSelf().setVisible(true);
            }
        });
	}
	
}
