package kz.kerey.ui.frames.good;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.ui.frames.good.models.GoodTypeListModel;

public class GoodTypeListPanel extends JPanel {

	private static final long serialVersionUID = -6433302124291328566L;
	
	private JPanel buttonPanel = new JPanel();
	private JButton addButton = new JButton("Добавить");
	private JButton delButton = new JButton("Удалить");
	private JButton updButton = new JButton("Обновить");
	
	private JPanel goodTypeListPanel = new JPanel();
	private JList<GoodTypeWrapper> goodTypeList = new JList<GoodTypeWrapper>();
	private JLabel label = new JLabel("Список групп");
	
	public GoodTypeListPanel() {
		this.initComponents();
	}
	
	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.add(goodTypeListPanel,BorderLayout.CENTER);
		this.add(buttonPanel,BorderLayout.SOUTH);
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addButton);
		buttonPanel.add(updButton);
		buttonPanel.add(delButton);
		
		goodTypeListPanel.setLayout(new BorderLayout());
		goodTypeListPanel.add(label, BorderLayout.NORTH);
		goodTypeListPanel.add(goodTypeList, BorderLayout.CENTER);
		goodTypeList.setBorder(new LineBorder(Color.BLACK));
		goodTypeList.setModel(GoodTypeListModel.getModel());
	}
	
	public void setDeleteButtonActionListener(ActionListener listener) {
		this.delButton.addActionListener(listener);
	}
	
	public void setAddButtonActionListener(ActionListener listener) {
		this.addButton.addActionListener(listener);
	}
	
	public void setUpdateButtonActionListener(ActionListener actionListener) {
		this.updButton.addActionListener(actionListener);
	}
	
	public void setGoodListSelectionActionListener(ListSelectionListener listener) {
		this.goodTypeList.addListSelectionListener(listener);
	}
	
}
