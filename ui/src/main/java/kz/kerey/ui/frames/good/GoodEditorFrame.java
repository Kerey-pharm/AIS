package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.loaders.GoodLoader;
import kz.kerey.ui.frames.base.ListPanel;
import kz.kerey.ui.frames.good.models.GoodComboboxModel;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.tools.ErrorDialog;
import kz.kerey.ui.tools.WindowTool;

public class GoodEditorFrame extends JFrame {

	private static final long serialVersionUID = -2721645318072690106L;

	private GoodLoader goodLoader = GoodLoader.getLoader();

	private final ListPanel goodListPanel = new ListPanel("Препараты",
			GoodComboboxModel.getModel());
	private final GoodEditPanel goodEditPanel = new GoodEditPanel();
	private JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

	private GoodAddFrame addFrame = GoodAddFrame.getSelf();
	private GoodTypeEditorFrame addTypeEditorFrame = GoodTypeEditorFrame
			.getSelf();

	private GoodWrapper selectedObject;

	final private static GoodEditorFrame self = new GoodEditorFrame();

	public static GoodEditorFrame getSelf() {
		return self;
	}

	private GoodEditorFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 800, 600);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Редактор номенклатуры");
	}

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		addTypeEditorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		GoodComboboxModel.getModel().reloadData();
		GoodTypeComboboxModel.getModel().reloadData();

		goodListPanel.setUpdateButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodComboboxModel.getModel().reloadData();
			}
		});
		goodListPanel
				.setGoodListSelectionActionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						JList<GoodWrapper> l = (JList<GoodWrapper>) e
								.getSource();
						selectedObject = l.getSelectedValue();
						goodEditPanel.setGoodWrapperObject(selectedObject);
					}
				});
		goodListPanel.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame.cleanFrame();
				addFrame.setVisible(true);
			}
		});

		goodEditPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodLoader.updateElement(goodEditPanel.getGoodWrapper(),
						goodEditPanel.getUpdatedGoodWrapper());
				GoodComboboxModel.getModel().reloadData();
			}
		});

		goodEditPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodEditPanel.setGoodWrapperObject(selectedObject);
			}
		});
		goodEditPanel.setTypesButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTypeEditorFrame.setVisible(true);
			}
		});
		goodListPanel.setDeleteButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedObject != null) {
					try {
						goodLoader.deleteElement(selectedObject);
						GoodComboboxModel.getModel().reloadData();
					} catch (RuntimeException ex) {
						ErrorDialog.showDialog(GoodEditorFrame.getSelf(),
								"Удаление не возможно, существуют зависимости.");
					}
				}
			}
		});

		splitter.add(goodListPanel);
		splitter.add(goodEditPanel);

		this.add(splitter, BorderLayout.CENTER);

		pack();
	}

}
