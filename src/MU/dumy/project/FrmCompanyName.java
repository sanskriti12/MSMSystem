package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmCompanyName implements ActionListener,FocusListener,WindowListener,TextListener {
	JFrame frm;
	JLabel lbl_name_brand,lbl_company_id;
	JTextField txt_name_brand, txt_company_id;
	JButton btnAdd,btnEdit,btnsrc;
	boolean flag;
	public FrmCompanyName() {
		frm=new JFrame();
		frm.setTitle("BRAND");
		frm.setSize(300, 180);
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
		frm.addWindowListener(this);

		lbl_company_id=new JLabel("COMPANY ID");
		lbl_company_id.setBounds(10, 10, 80, 30);
		frm.add(lbl_company_id);

		txt_company_id=new JTextField();
		txt_company_id.setBounds(150, 10, 120, 30);
		frm.add(txt_company_id);
		txt_company_id.setEditable(false);
		
		lbl_name_brand=new JLabel("BRAND NAME");
		lbl_name_brand.setBounds(10, 60, 100, 30);
		frm.add(lbl_name_brand);

		txt_name_brand=new JTextField();
		txt_name_brand.setBounds(150, 60, 120, 30);
		frm.add(txt_name_brand);
		txt_name_brand.addFocusListener(this);

		btnsrc=new JButton("SRC");
		btnsrc.setBounds(108, 100, 80, 40);
		btnsrc.addActionListener(this);
		frm.add(btnsrc);
		
		btnAdd=new JButton("ADD");
		btnAdd.setBounds(10, 100, 80, 40);
		frm.add(btnAdd);
		btnAdd.addActionListener(this);

		btnEdit=new JButton("EDIT");
		btnEdit.setBounds(205, 100, 80, 40);
		frm.add(btnEdit);
		btnEdit.setEnabled(false);
	
		btnEdit.addActionListener(this);
		frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int pid=0;int str=0;
		if(e.getSource().equals(btnAdd)){
			if(btnAdd.getText()=="ADD"){
				company_Add ca=new company_Add();
				if(txt_name_brand.getText().length()>0){
					if(ca.validate_brand_name(txt_name_brand.getText())){
						if(ca.insert(Integer.parseInt(txt_company_id.getText().toString()),txt_name_brand.getText().toUpperCase())==1){
							txt_name_brand.grabFocus();
							str=pid+=(Integer.parseInt(txt_company_id.getText()))+1;
							txt_company_id.setText(Integer.toString(pid));
							txt_name_brand.grabFocus();
							JOptionPane.showMessageDialog(null, "Records Inserted");
							txt_name_brand.setText(null);
						} 
					}else{
						JOptionPane.showMessageDialog(null, "This Brand all ready Eixst");	
						txt_name_brand.setText(null);
					}
				}else{
						JOptionPane.showMessageDialog(null, "Enter Brand Name");	

					}
					
				}
				
			}		if(e.getSource().equals(btnsrc)){
					btnEdit.setEnabled(true);
					btnAdd.setEnabled(false);
					btnsrc.setEnabled(false);
					txt_company_id.setEditable(true);
					txt_company_id.setText(null);
					txt_name_brand.setEditable(false);
					txt_company_id.addFocusListener(this);

			}
			if(e.getSource().equals(btnEdit)){
				if(btnEdit.getText().equals("EDIT")){
					if(txt_company_id.getText().length()>0){
					btnsrc.setEnabled(true);
					btnsrc.setText("NEXT");
					btnAdd.setEnabled(true);
					btnAdd.setText("UPDATE");
					btnEdit.setEnabled(false);
					txt_name_brand.setEditable(true);
					}else {
						JOptionPane.showMessageDialog(null, "Enter Company Id and Press Tab Key");
					}
				}
		  }
			if(e.getSource().equals(btnAdd)){
			  if(btnAdd.getText().equals("UPDATE")){
					company_Add ca=new company_Add();
					ca.update(txt_company_id.getText(),txt_name_brand.getText().toUpperCase());
					txt_company_id.setEditable(false);;
					txt_name_brand.setText(null);
					btnAdd.setEnabled(true);
					btnsrc.setEnabled(true);
					btnAdd.setText("ADD");
					btnsrc.setText("SRC");
					company_Add ac=new company_Add();
					txt_company_id.setText(Integer.toString(ac.gen_Product_Id()));
					txt_company_id.removeFocusListener(this);
				}
		  }if(e.getSource().equals(btnsrc)){
			  if(btnsrc.getText().equals("NEXT")){
				  txt_name_brand.setText(null);
			  }
		  }
	}
	@Override
	public void focusGained(FocusEvent e) {

	}
	@Override
	public void focusLost(FocusEvent e) {
		company_Add ca=new company_Add();
		if(e.getSource().equals(txt_company_id)){
			if(txt_company_id.getText().length()>0){
			if(ca.validate_company_id(Integer.parseInt(txt_company_id.getText()))){
			txt_name_brand.setText(ca.search(txt_company_id.getText()));
			txt_company_id.setEditable(false);
				}else{
					JOptionPane.showMessageDialog(null, "Enter Company Not Valid");
					txt_company_id.setText(null);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Enter Company id");
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
	
	}
	@Override
	public void windowClosed(WindowEvent e) {
	
	}
	@Override
	public void windowClosing(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		company_Add ca=new company_Add();
		txt_company_id.setText(Integer.toString(ca.gen_Product_Id()));
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		if(txt_company_id!=null){
			company_Add src=new company_Add();
			txt_name_brand.setText(src.search(txt_company_id.getText()));
		}else{
			JOptionPane.showMessageDialog(null, "Enter Company Id");
		}
	}
	
}
