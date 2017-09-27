package MU.dumy.project;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class DRegister extends JFrame implements ActionListener,ListSelectionListener {

	/**
	 * @param args
	 */
	JFrame frm;
	JLabel lbluname,lblupass,lblsecque,lblsecqueans;
	JTextField txtuname;
	JPasswordField txtpassword,txtsecqueans;
	JList lstsecque;
	JButton btnregister,btnlogin;
	Font f;
	String secquestion[]={"What is your fav place","Your fav color","Your best friend name","Your pet name"};
	String strquestion;
	Boolean flag=true;
	public DRegister()
	{
		frm=new JFrame("Registration");
		frm.setSize(420, 300);
		frm.setLocation(500,250);
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
		lbluname.setBounds(20, 20, 110, 30);
		lbluname.setFont(f);
		frm.add(lbluname);
		
		txtuname=new JTextField();
		txtuname.setBounds(170, 20, 200, 30);
		txtuname.setFont(f);
		frm.add(txtuname);
		
		lblupass=new JLabel("User Password");
		lblupass.setBounds(20, 60, 150, 30);
		lblupass.setFont(f);
		frm.add(lblupass);
		
		txtpassword=new JPasswordField();
		txtpassword.setBounds(170, 60, 200, 30);
		txtpassword.setFont(f);
		frm.add(txtpassword);
		
		lblsecque=new JLabel("Security Question");
		lblsecque.setBounds(20, 100, 150, 30);
		lblsecque.setFont(f);
		frm.add(lblsecque);
		
		lstsecque=new JList(secquestion);
		lstsecque.setBounds(170, 100, 200, 70);
		frm.add(lstsecque);
		lstsecque.setFont(f);
		lstsecque.addListSelectionListener(this);
		
		lblsecqueans=new JLabel("Security Answer");
		lblsecqueans.setBounds(20, 180, 150, 30);
		lblsecqueans.setFont(f);
		frm.add(lblsecqueans);
		
		txtsecqueans=new JPasswordField();
		txtsecqueans.setBounds(170,180, 200, 30);
		txtsecqueans.setFont(f);
		frm.add(txtsecqueans);
		
		btnregister=new JButton("Register");
		btnregister.setBounds(170, 220, 100, 40);
		btnregister.setFont(f);
		frm.add(btnregister);
		btnregister.addActionListener(this);
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(280, 220, 90, 40);
		btnlogin.setFont(f);
		frm.add(btnlogin);
		btnlogin.addActionListener(this);
		
		frm.setVisible(true);	
		//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnregister))
		{
			UserRegistration ur=new UserRegistration(txtuname.getText(),txtpassword.getText(),strquestion,txtsecqueans.getText());
			if(frmvalidate())
			{
				if(ur.validateusername())
				{
					JOptionPane.showMessageDialog(null, "User Already Exist");
					txtuname.grabFocus();
					txtuname.selectAll();
				}
				else
				{
					if(ur.insertRegRecord()==1)
					{
						JOptionPane.showMessageDialog(null, "User Successful Register");
						new DLogin();
						frm.dispose();
					}
				}
			}
		}
		else if(e.getSource().equals(btnlogin))
		{
			new DLogin();
			frm.dispose();
		}
		
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		strquestion=lstsecque.getSelectedValue().toString();
	}
	public boolean frmvalidate()
	{
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
		else if(lstsecque.getSelectedIndex()==-1)
		{
			JOptionPane.showMessageDialog(null, "Select Security Question");
			lstsecque.setSelectedIndex(0);
			lstsecque.grabFocus();
			flag=false;
		}
		else if(txtsecqueans.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter Security Answer");
			txtsecqueans.grabFocus();
			flag=false;
		}
		return flag;
	}
}
