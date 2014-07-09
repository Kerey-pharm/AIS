package kz.kerey.ui.frames.flowconf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.loaders.RoleLoader;
import kz.kerey.ui.frames.flowconf.models.RoleComboModel;
import kz.kerey.ui.tools.WindowTool;

public class RoleAddFrame extends JFrame {

	private static final long serialVersionUID = -6696723001354943754L;
	
	private RoleLoader loader = RoleLoader.getLoader();
	private static RoleAddFrame self = new RoleAddFrame();
	public static RoleAddFrame getSelf() {
		return self;
	}

	private RoleEditPanel editPanel = new RoleEditPanel("Закрыть");
	
	private RoleAddFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 400, 400);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Добавление роли");
	}
	
	public void dispose() {
		super.dispose();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(editPanel, BorderLayout.NORTH);
		
		editPanel.setRoleWrapperObject(new RoleWrapper());
		
		editPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		editPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.saveElement(editPanel.getUpdatedRoleWrapper());
				RoleComboModel.getModel().reloadData();
				dispose();
			}
		});
		
		pack();
	}

	public void cleanFrame() {
		this.editPanel.cleanPanel();
	}
	
}
