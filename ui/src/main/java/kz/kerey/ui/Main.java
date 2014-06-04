package kz.kerey.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import kz.kerey.services.api.GoodTypeInterface;
import net.miginfocom.swing.MigLayout;

public class Main {

	public static void main(String[] args) throws NamingException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame frame = new JFrame("DAKOSHA");
		
		frame.setTitle("DAKOSHA");
		
		JTextField text1 = new JTextField();
		text1.setText("������� ����� ����!");
		
		JLabel label1 = new JLabel();
		label1.setText("Type text here!");
		
		JButton button1 = new JButton();
		button1.setText("press me");
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		panel.add(label1,"wrap");
		panel.add(text1);
	    panel.add(button1);
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		/*for (int i=0; i<1000; i++) {
			String jndiName = "ejb:/services//GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
			GoodTypeInterface service = Main.lookupRemoteStatelessCalculator(jndiName);
			GoodTypeWrapper wrapper = new GoodTypeWrapper();
			wrapper.setName("FFF"+i);
			service.createGoodType(wrapper);
		}*/
	}

	private static GoodTypeInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        GoodTypeInterface ser = (GoodTypeInterface) ctx.lookup(url);
        return ser;
    }
	
}
