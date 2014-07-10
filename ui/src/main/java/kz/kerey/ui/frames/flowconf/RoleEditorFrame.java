package kz.kerey.ui.frames.flowconf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.loaders.RoleLoader;
import kz.kerey.ui.frames.base.ListPanel;
import kz.kerey.ui.frames.flowconf.models.RoleComboModel;
import kz.kerey.ui.frames.good.GoodTypeEditorFrame;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.tools.ErrorDialog;
import kz.kerey.ui.tools.WindowTool;

public class RoleEditorFrame extends JFrame {

	private static final long serialVersionUID = -306465153130569663L;

	private static final RoleEditorFrame self = new RoleEditorFrame();

	public static RoleEditorFrame getSelf() {
		return self;
	}

	private RoleAddFrame addFrame = RoleAddFrame.getSelf();
	private final RoleLoader loader = RoleLoader.getLoader();

	private final ListPanel listPanel = new ListPanel("Роли",
			RoleComboModel.getModel());
	private final RoleEditPanel editPanel = new RoleEditPanel("Вернуть");
	private final JSplitPane splitter = new JSplitPane(
			JSplitPane.HORIZONTAL_SPLIT);

	private RoleWrapper selectedObject;

	private RoleEditorFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 800, 400);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Редактор ролей");
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		RoleComboModel.getModel().reloadData();
		listPanel.setUpdateButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoleComboModel.getModel().reloadData();
			}
		});
		listPanel
				.setGoodListSelectionActionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						JList<RoleWrapper> l = (JList<RoleWrapper>) e
								.getSource();
						selectedObject = l.getSelectedValue();
						editPanel.setRoleWrapperObject(selectedObject);
					}
				});
		listPanel.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame.cleanFrame();
				addFrame.setVisible(true);
			}
		});

		editPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.updateElement(editPanel.getRoleWrapper(),
						editPanel.getUpdatedRoleWrapper());
				GoodTypeComboboxModel.getModel().reloadData();
			}
		});

		editPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPanel.setRoleWrapperObject(selectedObject);
			}
		});
		listPanel.setDeleteButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedObject != null) {
					try {
						loader.deleteElement(selectedObject);
						RoleComboModel.getModel().reloadData();
					} catch (RuntimeException ex) {
						ErrorDialog.showDialog(GoodTypeEditorFrame.getSelf(),
								"Удаление не возможно, существуют зависимости.");
					}
				}
			}
		});

		splitter.add(listPanel);
		splitter.add(editPanel);

		this.add(splitter, BorderLayout.CENTER);

		pack();
	}

}
