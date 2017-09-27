package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frm_Stock extends LoginBase implements WindowListener,ItemListener,ActionListener {
	JFrame frm;
	JComboBox cmb_brand_name,cmb_model;
	JLabel lbl_brand_name,lbl_model_name,lbl_current,lbl_present;
	JTextField txt_current,txt_present;
	JButton btnadd,btnupdate;
	int stock,stock1;
	public Frm_Stock() {
		frm=new JFrame();
		frm.setSize(385, 280);
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
		frm.setTitle("STOCK ADD");
		
		lbl_brand_name=new JLabel("BRAND NAME");
		lbl_brand_name.setBounds(25, 25, 100, 25);
		frm.add(lbl_brand_name); 
		
		cmb_brand_name=new JComboBox();
		cmb_brand_name.setBounds(150, 25, 200, 25);
		cmb_brand_name.addItemListener(this);
		frm.add(cmb_brand_name);
		
		lbl_model_name=new JLabel("MODEL NAME");
		lbl_model_name.setBounds(25, 65, 100, 25);
		frm.add(lbl_model_name); 
		
		cmb_model=new JComboBox();
		cmb_model.setBounds(150, 65, 200, 25);
		cmb_model.addItemListener(this);
		frm.add(cmb_model);
		
		lbl_current=new JLabel("CURRENT STOCK");
		lbl_current.setBounds(25, 105, 120, 25);
		frm.add(lbl_current);
		
		txt_current=new JTextField();
		txt_current.setBounds(150, 105, 200, 25);
		frm.add(txt_current);
		
		
		lbl_present=new JLabel("PRESENT STOCK");
		lbl_present.setBounds(25, 145, 120, 25);
		frm.add(lbl_present);
		
		txt_present=new JTextField();
		txt_present.setBounds(150, 145, 200, 25);
		frm.add(txt_present);
		
		btnadd=new JButton("ADD STOCK");
		btnadd.setBounds(150,185, 108, 40);
		frm.add(btnadd);
		btnadd.addActionListener(this);
		
		btnupdate=new JButton("EDIT");
		btnupdate.setBounds(260,185, 90, 40);
		frm.add(btnupdate);
		btnupdate.addActionListener(this);
		
		frm.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
	
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		Insert_Feature ins_rec=new Insert_Feature();
		for(String pname:ins_rec.get_brand_name()){
			cmb_brand_name.addItem(pname);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(cmb_brand_name)){
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				Insert_Feature ser_pro=new Insert_Feature();
				 String[] modelname=ser_pro.get_model(cmb_brand_name.getSelectedItem().toString());
				 int j=modelname.length;
				 cmb_model.removeAllItems();
				for(int i=0;i<j;i++){
					 cmb_model.addItem(modelname[i]);
				}
			}
		}
		if(e.getSource().equals(cmb_model)){
			Add_Stock as=new Add_Stock();
			if(e.getStateChange()==ItemEvent.SELECTED){
				txt_current.setText(Integer.toString(as.quantity(cmb_model.getSelectedItem().toString())));
				txt_current.setEditable(false);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Add_Stock ad=new Add_Stock();
		if(e.getSource().equals(btnadd)){
		if(Integer.parseInt(txt_current.getText())==0){
			ad.insert_stock(cmb_brand_name.getSelectedItem().toString(), cmb_model.getSelectedItem().toString(), Integer.parseInt(txt_present.getText().toString().toUpperCase()));
			stock=Integer.parseInt(txt_present.getText());
			txt_current.setText(Integer.toString(stock));
			txt_present.setText(null);
		}else{
			if(txt_present.getText().length()>0){
		 stock=Integer.parseInt(txt_present.getText())+ Integer.parseInt(txt_current.getText());
		txt_current.setText(Integer.toString(stock));
		ad.update_stock(stock, cmb_brand_name.getSelectedItem().toString(),cmb_model.getSelectedItem().toString().toUpperCase());
		txt_present.setText(null);
			}else{
				JOptionPane.showMessageDialog(null, "Select Brand & Model Name Enter Present Stock");
			}
		}
	  }
		if(e.getSource().equals(btnupdate)){
			if(btnupdate.getText().equals("EDIT")){
			cmb_brand_name.setEnabled(false);
			cmb_model.setEnabled(false);
			txt_present.setText(null);
			btnupdate.setText("UPDATE");
			btnadd.setEnabled(false);
			}else{
				if(txt_present.getText().length()>0){
					stock=Integer.parseInt(txt_present.getText());
					stock1= Integer.parseInt(txt_current.getText());
					stock1=stock;
					txt_current.setText(Integer.toString(stock1));
				ad.update_stock(stock, cmb_brand_name.getSelectedItem().toString(),cmb_model.getSelectedItem().toString());
					txt_present.setText(null);
					btnadd.setEnabled(true);
					btnupdate.setText("EDIT");
					cmb_brand_name.setEnabled(true);
					cmb_model.setEnabled(true);
				}else{
					JOptionPane.showMessageDialog(null, "Enter Present Stock");
				}
			}
		}
	}
}
