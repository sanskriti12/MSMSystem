
package MU.dumy.project;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

public class DLogin extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	JFrame frm;
	JLabel lbluname,lblpassword;
	JTextField txtuname;
	JPasswordField txtpassword;
	JButton btnlogin,btnregister;
	Boolean flag;
	Font f;
	public DLogin()
	{
		frm=new JFrame();
		frm.setTitle("Login");
		frm.setSize(350,200);
		frm.setLocation(400, 250);
		frm.setLayout(null);
		frm.setResizable(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=frm.getSize().width;//get the width of the frame
	    int frameheigth=frm.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		frm.setLocation(framelocationX,framelocationY);
		Color hexa=Color.decode("#e3dac9");
		frm.getContentPane().setBackground(hexa);
		
		f=new Font("Consolas", Font.BOLD,14);
		
		lbluname=new JLabel("User Name");
		lbluname.setBounds(20, 20, 100, 30);
		frm.add(lbluname);
		
		txtuname=new JTextField();
		txtuname.setBounds(150, 20, 170, 30);
		txtuname.setFont(f);
		frm.add(txtuname);
		
		lblpassword=new JLabel("Password");
		lblpassword.setBounds(20, 60, 100, 30);
		frm.add(lblpassword);
		
		txtpassword=new JPasswordField();
		txtpassword.setBounds(150, 60, 170, 30);
		txtpassword.setFont(f);
		frm.add(txtpassword);
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(150, 100, 75, 40);
		frm.add(btnlogin);
		btnlogin.addActionListener(this);
		
		btnregister=new JButton("Register");
		btnregister.setBounds(235, 100, 85, 40);
		frm.add(btnregister);
		btnregister.addActionListener(this);
		
		frm.setVisible(true);
		changelookfeel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnlogin))
		{
			UserLogin ul=new UserLogin(txtuname.getText(), txtpassword.getText());
			if(frmvalidate())
			{
				if(ul.validatelogin())
				{
					JOptionPane.showMessageDialog(null, "Login Successfull");
					new Frm_Menu();
					frm.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login UnSuccessfull");
					txtuname.setText("");
					txtpassword.setText("");
					txtuname.grabFocus();
				}
			}
		}
		else if(e.getSource().equals(btnregister))
		{
			new DRegister();
			frm.dispose();
		}
		
	}
	public boolean frmvalidate()
	{
		flag=true;
		if(txtuname.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Name");
			txtuname.grabFocus();
			flag=false;
		}
		else if(txtpassword.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Password");
			txtpassword.grabFocus();
			flag=false;
		}
		return flag;
	}
	public  void changelookfeel()
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}


}
