package MU.dumy.project;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.event.*;
public class DChangePassword implements FocusListener,ActionListener {
	JFrame frm;
	Font f;
	JLabel lbluname,lblsecquestion,lbldsecquestion,lblsecans,lblpassword,lblcpassword;
	JTextField txtuname;
	JPasswordField txtsecans,txtpassword,txtcpassword;
	JButton btnchangepassword;
	Boolean flag,sflag;
	public DChangePassword()
	{
		frm=new JFrame("Change Password");
		frm.setSize(420, 300);
		frm.setLocation(500,250);
		frm.setLayout(null);
		frm.setResizable(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=frm.getSize().width;//get the width of the frame
	    int frameheigth=frm.getSize().height; //get the height of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		frm.setLocation(framelocationX,framelocationY);
		Color hexa=Color.decode("#e3dac9");
		frm.getContentPane().setBackground(hexa);
		f=new Font("Consolas", Font.BOLD,14);
		
		lbluname=new JLabel("User Name");
		lbluname.setBounds(20, 20, 100, 30);
		lbluname.setFont(f);
		frm.add(lbluname);
		
		txtuname=new JTextField();
		txtuname.setBounds(160, 20, 170, 30);
		txtuname.setFont(f);
		frm.add(txtuname);
		txtuname.addFocusListener(this);
		
		lblsecquestion=new JLabel("Security Question");
		lblsecquestion.setBounds(20, 60, 150, 30);
		lblsecquestion.setFont(f);
		frm.add(lblsecquestion);
		
		lbldsecquestion=new JLabel("");
		lbldsecquestion.setBounds(160, 60, 220, 30);
		lbldsecquestion.setFont(f);
		frm.add(lbldsecquestion);
		
		lblsecans=new JLabel("Security Answer");
		lblsecans.setBounds(20, 100, 150, 30);
		lblsecans.setFont(f);
		frm.add(lblsecans);
		
		txtsecans=new JPasswordField();
		txtsecans.setBounds(160, 100, 170, 30);
		txtsecans.setFont(f);
		frm.add(txtsecans);
		
		lblpassword=new JLabel("Password");
		lblpassword.setBounds(20, 140, 150, 30);
		lblpassword.setFont(f);
		frm.add(lblpassword);
		
		txtpassword=new JPasswordField();
		txtpassword.setBounds(160,140,170,30);
		txtpassword.setFont(f);
		frm.add(txtpassword);
		
		lblcpassword=new JLabel("Confirm Password");
		lblcpassword.setBounds(20, 180, 150, 30);
		lblcpassword.setFont(f);
		frm.add(lblcpassword);
		
		txtcpassword=new JPasswordField();
		txtcpassword.setBounds(160, 180, 170, 30);
		txtcpassword.setFont(f);
		frm.add(txtcpassword);
		
		btnchangepassword=new JButton("Change Password");
		btnchangepassword.setBounds(160, 220, 170, 40);
		btnchangepassword.setFont(f);
		frm.add(btnchangepassword);
		btnchangepassword.addActionListener(this);
		frm.setVisible(true);
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		txtuname.selectAll();
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(txtuname.getText().length()>0)
		{
			ChangePassword ch=new ChangePassword(txtuname.getText());
			if(ch.showsecurityques().equals("User Does'nt Exist"))
			{
				JOptionPane.showMessageDialog(null, "User Does'nt Exist");
				lbldsecquestion.setText("");
			}
			else
			{
				lbldsecquestion.setText(ch.showsecurityques());
			}
		}
	}
	public Boolean frmvalidate()
	{
		flag=true;
		if(txtuname.getText().equals(""))
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Enter User Name");
			txtuname.grabFocus();
		}
		else if(txtsecans.getText().equals(""))
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Enter Security Question Answer");
			txtsecans.grabFocus();
		}
		else if(txtpassword.getText().equals(""))
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Enter New Password");
			txtpassword.grabFocus();
		}
		else if(txtcpassword.getText().equals(""))
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Enter Confirm Password");
			txtcpassword.grabFocus();
		}
		else if(txtpassword.getText().length()<8)
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Password Mininum 8 Character long");
			txtpassword.setText("");
			txtcpassword.setText("");
			txtpassword.grabFocus();
		}
		else if(!(txtpassword.getText().equals(txtcpassword.getText())))
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Password and Confirm Password Does't Match");
			txtpassword.setText("");
			txtcpassword.setText("");
			txtpassword.grabFocus();
		}
		return flag;
	}
	public Boolean strongpassword(String pass)
	{
		sflag=false;
		char[] ch=pass.toCharArray();
		int capcount,digcount,speccount;
		capcount=digcount=speccount=0;
		for(char c:ch)
		{
			if((int)c>=65 && (int)c<=90)
			{
				capcount++;
			}
			if((int)c>=48 && (int)c<=57){
				digcount++;
			}
			if(!((int)c>=65 && (int)c<=90) && !((int)c>=97 && (int)c<=122) && !((int)c>=48 && (int)c<=57))
			{
				speccount++;
			}
		}
		if(capcount>0 && digcount>0 && speccount>0)
		{
			sflag=true;
		}
		return sflag;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(frmvalidate())
		{
			if(strongpassword(txtpassword.getText()))
			{
				ChangePassword ch=new ChangePassword(lbldsecquestion.getText(),txtsecans.getText(),txtpassword.getText(),txtuname.getText());
				if(ch.valsecquesans())
				{
					if(ch.updatepassword()==1)
					{
						JOptionPane.showMessageDialog(null, "Password Update Successfully");
						new DLogin();
						frm.dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Security Answer Does't Match");
					txtsecans.grabFocus();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Week Password! Password must contain at least one Capital Letter,Digit,Special Symbol[A/0/@]");
				txtpassword.setText("");
				txtcpassword.setText("");
				txtpassword.grabFocus();
			}
		}
	}
}
