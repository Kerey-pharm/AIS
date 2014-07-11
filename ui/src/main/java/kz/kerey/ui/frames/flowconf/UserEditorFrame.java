package kz.kerey.ui.frames.flowconf;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import kz.kerey.ui.frames.base.ListPanel;
import kz.kerey.ui.frames.flowconf.models.UserComboModel;
import kz.kerey.ui.tools.WindowTool;

public class UserEditorFrame extends JFrame  {

	private static final long serialVersionUID = -8870460508492310659L;

	private static UserEditorFrame self = new UserEditorFrame();

	private UserEditorFrame() {
		initComponents();
		WindowTool.setWindowAtCenter(this);
	}

	public static UserEditorFrame getSelf() {
		return self;
	}

	private ListPanel list = new ListPanel("Пользователи",
			UserComboModel.getSelf());
	private UserEditPanel editPanel = new UserEditPanel("Вернуть");
	private JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		splitter.add(list);
		splitter.add(editPanel);

		this.setLayout(new BorderLayout());
		this.add(splitter, BorderLayout.CENTER);

		pack();
	}

}
