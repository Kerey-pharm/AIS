package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.ui.frames.good.models.GoodTypeComboboxModel;

public class GoodEditPanel extends JPanel {

	private static final long serialVersionUID = -2478520099302223963L;
	
	private JLabel nameLabel = new JLabel("Наименование");
	private JLabel primaryBarcodeLabel = new JLabel("Баркод");
	private JLabel countPerBoxLabel = new JLabel("Кол-во в упаковке");
	private JLabel countSellableLabel = new JLabel("Продаваемое кол-во");
	private JLabel goodTypeIdLabel = new JLabel("Группа препарата");
	private JLabel aboutGoodLabel = new JLabel("О препарате");
	
	private JTextField nameField = new JTextField();
	private JTextField primaryBarcodeField = new JTextField();
	private JCheckBox partialSellingField = new JCheckBox("Продается порционно");
	private JTextField countPerBoxField = new JTextField();
	private JTextField countSellableField = new JTextField();
	private JComboBox<GoodTypeWrapper> goodTypeIdField = new JComboBox<>();
	private JTextArea aboutGood = new JTextArea();
	
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JButton saveButton = new JButton("Сохранить");
	private JButton undoButton = new JButton("Вернуть");
	
	private JButton typesEditButton = new JButton("...");
	
	private JSplitPane splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	private GoodWrapper good;
	private GoodWrapper updatedGood;
	
	public GoodEditPanel() {
		this.initComponents();
		this.initComponentsValidators();
	}
	
	private void initComponentsValidators() {
		
	}
	
	private void initComponents() {
		buttonPanel.add(saveButton);
		buttonPanel.add(undoButton);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		aboutGood.setBorder(new LineBorder(Color.BLACK));
		
		JPanel combo = new JPanel();
		combo.setLayout(new BorderLayout());
		combo.add(goodTypeIdField,BorderLayout.CENTER);
		combo.add(typesEditButton, BorderLayout.EAST);
		
		panel1.setLayout(new GridLayout(12,1));
		panel1.add(nameLabel);
		panel1.add(nameField);
		panel1.add(primaryBarcodeLabel);
		panel1.add(primaryBarcodeField);
		panel1.add(partialSellingField);
		panel1.add(countPerBoxLabel);
		panel1.add(countPerBoxField);
		panel1.add(countSellableLabel);
		panel1.add(countSellableField);
		panel1.add(goodTypeIdLabel);
		panel1.add(combo);
		panel1.add(buttonPanel);
		
		panel2.setLayout(new BorderLayout());
		panel2.add(aboutGoodLabel, BorderLayout.NORTH);
		panel2.add(aboutGood,BorderLayout.CENTER);
		
		splitter.add(panel1);
		splitter.add(panel2);
		
		this.setLayout(new BorderLayout());
		this.add(splitter, BorderLayout.CENTER);
		
		goodTypeIdField.setModel(GoodTypeComboboxModel.getModel());
	}
	
	public void setGoodWrapperObject(GoodWrapper good) {
		this.good = good;
		this.updatedGood = new GoodWrapper();
		this.updateData();
	}
	
	public GoodWrapper getUpdatedGoodWrapper() {
		this.updatedGood.setId(this.good.getId());
		this.updatedGood.setName(this.nameField.getText());
		this.updatedGood.setCountPerBox(Long.valueOf(this.countPerBoxField.getText()));
		this.updatedGood.setCountSellable(Long.valueOf(this.countSellableField.getText()));
		this.updatedGood.setPartialSelling(this.partialSellingField.isSelected());
		this.updatedGood.setPrimaryBarcode(this.primaryBarcodeField.getText());
		this.updatedGood.setGoodTypeId(((GoodTypeWrapper) this.goodTypeIdField.getSelectedItem()).getId());
		return this.updatedGood;
	}
	
	public GoodWrapper getGoodWrapper() {
		return this.good;
	}
	
	private void clearData() {
		this.nameField.setText("");
		this.primaryBarcodeField.setText("");
		this.partialSellingField.setSelected(false);
		this.countPerBoxField.setText("");
		this.countSellableField.setText("");
	}
	
	private void updateData() {
		if (this.good!=null) {
			this.nameField.setText(this.good.getName()!=null ? this.good.getName() : "");
			this.primaryBarcodeField.setText(this.good.getPrimaryBarcode()!=null ? this.good.getPrimaryBarcode() : "");
			this.partialSellingField.setSelected(this.good.getPartialSelling()!=null ? this.good.getPartialSelling() : false);
			this.countPerBoxField.setText(String.valueOf(this.good.getCountPerBox()!=null ? this.good.getCountPerBox() : 0L));
			this.countSellableField.setText(String.valueOf(this.good.getCountSellable()!=null ? this.good.getCountSellable() : 0L));
			
			if (this.good.getGoodTypeId()!=null && this.good.getGoodTypeId()!=0) {
				GoodTypeComboboxModel model = GoodTypeComboboxModel.getModel();
				for (int i=0; i<model.getSize(); i++) {
					if (model.getElementAt(i).getId()!=null && model.getElementAt(i).getId().equals(this.good.getGoodTypeId())) {
						this.goodTypeIdField.setSelectedIndex(i);
						break;
					}
				}
			}
			
			return;
		}
		this.clearData();
	}
	
	public void setSaveButtonActionListener(ActionListener listener) {
		this.saveButton.addActionListener(listener);
	}
	
	public void setUndoButtonActionListener(ActionListener listener) {
		this.undoButton.addActionListener(listener);
	}
	
	public void setTypesButtonActionListener(ActionListener listener) {
		this.typesEditButton.addActionListener(listener);
	}
	
}