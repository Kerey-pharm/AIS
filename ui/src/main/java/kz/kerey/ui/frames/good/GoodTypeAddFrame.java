package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.loaders.GoodTypeLoader;
import kz.kerey.ui.frames.good.models.GoodComboboxModel;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;
import kz.kerey.ui.tools.WindowTool;

public class GoodTypeAddFrame extends JFrame {

	private static final long serialVersionUID = 5396624147326536479L;

	private GoodTypeLoader loader = GoodTypeLoader.getLoader();
	
	private GoodTypeEditPanel goodTypeEditPanel = new GoodTypeEditPanel("Закрыть");
	
	final private static GoodTypeAddFrame self = new GoodTypeAddFrame();
	public static GoodTypeAddFrame getSelf() {
		return self;
	}
	private GoodTypeAddFrame() {
		this.initComponents();
		WindowTool.setWindowDimensions(this, 400, 400);
		WindowTool.setWindowAtCenter(this);
		this.setTitle("Добавление номенклатурного типа");
	}
	
	public void dispose() {
		super.dispose();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(goodTypeEditPanel, BorderLayout.NORTH);
		
		goodTypeEditPanel.setGoodWrapperObject(new GoodTypeWrapper());
		
		goodTypeEditPanel.setUndoButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		goodTypeEditPanel.setSaveButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loader.saveElement(goodTypeEditPanel.getUpdatedGoodWrapper());
				GoodComboboxModel.getModel().reloadData();
				GoodTypeComboboxModel.getModel().reloadData();
				dispose();
			}
		});
		
		pack();
	}

	public void cleanFrame() {
		this.goodTypeEditPanel.cleanPanel();
	}
	
}