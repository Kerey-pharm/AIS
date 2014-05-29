package kz.kerey.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		
		JLabel label = new JLabel();
		label.setText("dakosha");
		
		mainFrame.add(label);
		
		JButton button = new JButton();
		button.setText("daka");
		
		mainFrame.add(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		
		mainFrame.setVisible(true);
		
		
		
	}

}
