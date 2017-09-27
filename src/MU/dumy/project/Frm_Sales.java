package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.BranchElement;
import javax.swing.text.MaskFormatter;

public class Frm_Sales extends LoginBase implements WindowListener,ItemListener,FocusListener,ActionListener,TextListener,KeyListener {
	JFrame frm;
	JComboBox cmb_brand_name,cmb_model;
	JLabel lbl_brand_name,lbl_model_name,lbl_price,lbl_available,lbl_name,lbl_mob,lbl_address,
	lbl_ser,lbl_quantity,lbl_modelno,lbl_batteryno,lbl_chargerno,lbl_vat,lbl_totvat,lbl_tot,lbl_date;
	JTextField txt_price,txt_available,txt_name,txt_mob,txt_address,txt_ser,txt_quantity,txt_modelno,
	txt_batteryno,txt_chargerno,txt_vat,txt_totvat,txt_tot,txt_date;
	JButton btnsub,btnsrc,btnedit,btncancel;
	String getyear,getmonth;
	MaskFormatter m2,m3;
	public Frm_Sales() {
		frm=new JFrame();
		frm.setSize(750, 450);
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
		frm.setTitle("SALE");
		
		lbl_ser=new JLabel(" BILL NO.");
		lbl_ser.setBounds(25, 25, 120, 25);
		frm.add(lbl_ser);
		
		txt_ser=new JTextField();
		txt_ser.setBounds(150, 25, 200, 25);
		txt_ser.addFocusListener(this);
		frm.add(txt_ser);
		
		lbl_name=new JLabel(" CUSTOMER NAME");
		lbl_name.setBounds(380, 25, 120, 25);
		frm.add(lbl_name);
		
		txt_name=new JTextField();
		txt_name.setBounds(500, 25, 200, 25);
		frm.add(txt_name);
		
		lbl_address=new JLabel(" ADDRESS");
		lbl_address.setBounds(25, 65, 120, 25);
		frm.add(lbl_address);
		
		txt_address=new JTextField();
		txt_address.setBounds(150, 65, 200, 25);
		frm.add(txt_address);
		
		
		lbl_mob=new JLabel(" MOBILE NO.");
		lbl_mob.setBounds(380, 65, 120, 25);
		frm.add(lbl_mob);
		
		txt_mob=new JTextField();
		txt_mob.setBounds(500, 65, 200, 25);
		frm.add(txt_mob);
		
		lbl_brand_name=new JLabel("BRAND NAME");
		lbl_brand_name.setBounds(25, 105, 100, 25);
		frm.add(lbl_brand_name); 
		
		cmb_brand_name=new JComboBox();
		cmb_brand_name.setBounds(150, 105, 200, 25);
		cmb_brand_name.addItemListener(this);
		frm.add(cmb_brand_name);
		
		lbl_model_name=new JLabel("MODEL NAME");
		lbl_model_name.setBounds(380, 105, 100, 25);
		frm.add(lbl_model_name); 
		
		cmb_model=new JComboBox();
		cmb_model.setBounds(500, 105, 200, 25);
		cmb_model.addItemListener(this);
		frm.add(cmb_model);
		
		lbl_price=new JLabel("PRICE");
		lbl_price.setBounds(25, 145, 120, 25);
		frm.add(lbl_price);
		
		txt_price=new JTextField();
		txt_price.setBounds(150, 145, 200, 25);
		txt_price.addFocusListener(this);
		frm.add(txt_price);
		
		
		lbl_available=new JLabel("STOCK AVAILABLE");
		lbl_available.setBounds(380, 145, 120, 25);
		frm.add(lbl_available);
		
		txt_available=new JTextField();
		txt_available.setBounds(500, 145, 200, 25);
		frm.add(txt_available);
		
		
		lbl_modelno=new JLabel("MODEL NO.");
		lbl_modelno.setBounds(25, 185, 120, 25);
		frm.add(lbl_modelno);
		
		txt_modelno=new JTextField();
		txt_modelno.setBounds(150, 185, 200, 25);
		frm.add(txt_modelno);
		
		
		lbl_quantity=new JLabel("QUANTITY");
		lbl_quantity.setBounds(380, 185, 120, 25);
		frm.add(lbl_quantity);
		
		txt_quantity=new JTextField();
		txt_quantity.setBounds(500, 185, 200, 25);
		txt_quantity.addKeyListener(this);
		frm.add(txt_quantity);
		
		lbl_batteryno=new JLabel("BATTERY NO.");
		lbl_batteryno.setBounds(25, 225, 120, 25);
		frm.add(lbl_batteryno);
		
		txt_batteryno=new JTextField();
		txt_batteryno.setBounds(150, 225, 200, 25);
		frm.add(txt_batteryno);
		
		lbl_chargerno=new JLabel("CHARGER NO.");
		lbl_chargerno.setBounds(380, 225, 120, 25);
		frm.add(lbl_chargerno);
		
		txt_chargerno=new JTextField();
		txt_chargerno.setBounds(500, 225, 200, 25);
		frm.add(txt_chargerno);
		
		lbl_vat=new JLabel("VAT");
		lbl_vat.setBounds(25, 265, 120, 25);
		frm.add(lbl_vat);
		
		txt_vat=new JTextField();
		txt_vat.setBounds(150, 265, 200, 25);
		txt_vat.addFocusListener(this);
		frm.add(txt_vat);
		
		lbl_totvat=new JLabel("TOTAL VAT");
		lbl_totvat.setBounds(380, 265, 120, 25);
		frm.add(lbl_totvat);
		
		txt_totvat=new JTextField();
		txt_totvat.setBounds(500, 265, 200, 25);
		frm.add(txt_totvat);
		
		lbl_tot=new JLabel("TOTAL");
		lbl_tot.setBounds(25, 305, 120, 25);
		frm.add(lbl_tot);
		
		txt_tot=new JTextField();
		txt_tot.setBounds(150, 305, 200, 25);
		txt_tot.setEditable(false);
		frm.add(txt_tot);
		
		lbl_date=new JLabel("DATE");
		lbl_date.setBounds(380, 305, 120, 25);
		frm.add(lbl_date);
		
		txt_date=new JTextField();
		txt_date.setBounds(500, 305, 200, 25);
		frm.add(txt_date);
		btnsub=new JButton("SUBMIT");
		btnsub.setBounds(150,345, 120, 40);
		frm.add(btnsub);
		btnsub.addActionListener(this);
		
		btnsrc=new JButton("SEARCH");
		btnsrc.setBounds(300,345, 120, 40);
		frm.add(btnsrc);
		btnsrc.addActionListener(this);
			
		btnedit=new JButton("EDIT");
		btnedit.setBounds(450,345, 120, 40);
		frm.add(btnedit);
		btnedit.addActionListener(this);
		
		btncancel=new JButton("CANCEL");
		btncancel.setBounds(600, 345, 120, 40);
		frm.add(btncancel);
		btncancel.addActionListener(this);

		frm.setVisible(true);
	}
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
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
			cmb_brand_name.setSelectedIndex(-1);
			txt_price.setText(null);
			txt_available.setText(null);
		}
		btnsub.setText("NEW");
		txt_vat.setText("0");
		txt_totvat.setText("0");
		editfalse();
		btnedit.setEnabled(false);
		txt_ser.grabFocus();
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
			cmb_model.setSelectedIndex(-1);
		}
		if(e.getSource().equals(cmb_model)){
			if(e.getStateChange()==ItemEvent.SELECTED){
				Sales sa=new Sales();
				Add_Stock getstock=new Add_Stock();
				txt_price.setText(Integer.toString(sa.getprice(cmb_model.getSelectedItem().toString())));
				txt_price.setEditable(false);
				txt_available.setText(Integer.toString(getstock.quantity(cmb_model.getSelectedItem().toString())));
				txt_available.setEditable(false);
			}
			
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		double vat,vatstr;
		if(e.getSource().equals(txt_vat)){
		 if(txt_vat.getText().length()>0){
			 vat=Double.parseDouble(txt_price.getText())*Integer.parseInt(txt_quantity.getText());
			 if(Integer.parseInt(txt_vat.getText())>0){
				 vatstr=vat*Double.parseDouble(txt_vat.getText())/100;
				txt_totvat.setText(Double.toString(vatstr));
			 }
		 }else{
			 txt_totvat.setText("0");
		 }
		 
		if(Integer.parseInt(txt_price.getText())>0){
			if(txt_totvat.getText().length()>0){
				double str;
				str=(Double.parseDouble(txt_price.getText())*Integer.parseInt(txt_quantity.getText()) + Double.parseDouble(txt_totvat.getText()));
				txt_tot.setText(Double.toString(str));
			}
	   }
	}		
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnsrc)){
			if(txt_ser.getText().length()>0){
			Sales src=new Sales();
			String str[]=src.search(Integer.parseInt(txt_ser.getText()));
			txt_name.setText(str[0]);
			txt_address.setText(str[1]);
			txt_mob.setText(str[2]);
			cmb_brand_name.setSelectedItem(str[3]);
			cmb_model.setSelectedItem(str[4]);
			txt_price.setText(str[5]);
			txt_available.setText(str[6]);
			txt_modelno.setText(str[7]);
			txt_quantity.setText(str[8]);
			txt_batteryno.setText(str[9]);
			txt_chargerno.setText(str[10]);
			txt_vat.setText(str[11]);
			txt_tot.setText(str[12]);
			txt_date.setText(str[13]);
			txt_ser.setEditable(true);
			btnsub.setEnabled(false);
			btnedit.setEnabled(true);
			btnsrc.setEnabled(false);;
			editfalse();
			txt_quantity.setEditable(false);
			txt_totvat.setText(Integer.toString(Integer.parseInt(txt_tot.getText())-(Integer.parseInt(txt_price.getText()))));
			txt_totvat.setEditable(false);
		}else{
				JOptionPane.showMessageDialog(null, "Enter Bill No.");
			}
			
		}
		if(e.getSource().equals(btnedit)){
			if(btnedit.getText().equals("EDIT")){
				edit_true();
				btnedit.setText("UPDATE");
				
			}else if(btnedit.getText().equals("UPDATE")){
				Sales up=new Sales();
				up.update_model(txt_name.getText(), txt_address.getText(), txt_mob.getText(), txt_modelno.getText(), txt_batteryno.getText(), txt_chargerno.getText(),Integer.parseInt(txt_ser.getText().toUpperCase()));
				btnedit.setEnabled(false);
				btnedit.setText("EDIT");
				btnsub.setEnabled(true);
				btnsrc.setEnabled(true);
				blank();
				editfalse();
				txt_ser.setEditable(true);
				txt_ser.setText(null);
			}
		}
		if(e.getSource().equals(btnsub)){
			if(btnsub.getText().equals("NEW")){
				Date date=new Date();
				SimpleDateFormat f=new SimpleDateFormat("dd/MMM/yyyy");
				txt_date.setText(f.format(date));
				SimpleDateFormat fmonth=new SimpleDateFormat("MMM");
				 getmonth=fmonth.format(date);
				SimpleDateFormat fyear=new SimpleDateFormat("yyyy");
				 getyear=fyear.format(date);
				btnsrc.setEnabled(false);
				Sales ad=new Sales();
				txt_ser.setText(Integer.toString(ad.gen_serial_no()));
				edit_true();
				txt_ser.setEditable(false);
				cmb_brand_name.setEnabled(true);
				cmb_model.setEnabled(true);
				btnsub.setText("SUBMIT");
				txt_date.setEditable(false);
			}else if(btnsub.getText().equals("SUBMIT")){
					Sales ins=new Sales();
					if(frmvalid()){
						if(ins.insert(Integer.parseInt(txt_ser.getText().toString()),txt_name.getText(),txt_address.getText(),Double.parseDouble(txt_mob.getText()),cmb_brand_name.getSelectedItem().toString(),cmb_model.getSelectedItem().toString(),Integer.parseInt(txt_price.getText().toString()),Integer.parseInt(txt_available.getText().toString()),txt_modelno.getText(),Integer.parseInt(txt_quantity.getText().toString()),txt_batteryno.getText(),txt_chargerno.getText(),Integer.parseInt(txt_vat.getText().toString()),Double.parseDouble(txt_tot.getText().toString()),txt_date.getText(),(getmonth.toString()),(getyear.toString().toUpperCase()))==1){
						int strquantity;
						strquantity=Integer.parseInt(txt_available.getText())-Integer.parseInt(txt_quantity.getText());
						txt_available.setText(Integer.toString(strquantity));
						JOptionPane.showMessageDialog(null, "Record Inserted");
						ins.update_stock(strquantity, cmb_model.getSelectedItem().toString().toUpperCase());
						int str=0;
						str+=Integer.parseInt(txt_ser.getText())+1;
						txt_ser.setText(Integer.toString(str));
						blank();
						editfalse();
						btnsub.setText("NEW");
						btnsrc.setEnabled(true);
						txt_ser.setEditable(true);
						txt_ser.setText(null);
						}
					}
				}
		}
		if(e.getSource().equals(btncancel)){
			btnsub.setText("NEW");
			btnsub.setEnabled(true);
			btnsrc.setText("SEARCH");
			btnsrc.setEnabled(true);
			btnedit.setEnabled(false);
			btnedit.setText("EDIT");
			blank();
			txt_ser.setText(null);
			txt_ser.setEditable(true);
			editfalse();
			txt_quantity.setEditable(true);
			txt_totvat.setEditable(false);
		}
}
	@Override
	public void textValueChanged(TextEvent e) {
	}
	public void editfalse(){
		txt_name.setEditable(false);
		txt_address.setEditable(false);
		txt_mob.setEditable(false);
		cmb_brand_name.setEnabled(false);
		cmb_model.setEnabled(false);
		txt_price.setEditable(false);
		txt_available.setEditable(false);
		txt_modelno.setEditable(false);
		txt_batteryno.setEditable(false);
		txt_chargerno.setEditable(false);
		txt_vat.setEditable(false);
		txt_tot.setEditable(false);
		txt_date.setEditable(false);
	}
	public void edit_true(){
		txt_name.setEditable(true);
		txt_address.setEditable(true);
		txt_mob.setEditable(true);
		txt_modelno.setEditable(true);
		txt_batteryno.setEditable(true);
		txt_chargerno.setEditable(true);
		txt_vat.setEditable(true);
		txt_date.setEditable(true);
	}
	public void blank(){
		txt_name.setText(null);
		txt_address.setText(null);
		txt_mob.setText(null);
		cmb_brand_name.setSelectedIndex(-1);
		cmb_model.setSelectedIndex(-1);
		txt_price.setText(null);
		txt_available.setText(null);
		txt_modelno.setText(null);
		txt_quantity.setText(null);
		txt_batteryno.setText(null);
		txt_chargerno.setText(null);
		txt_vat.setText("0");
		txt_totvat.setText("0");
		txt_tot.setText(null);
		txt_date.setText(null);
	}
	public boolean frmvalid(){
		if(txt_name.getText().length()>0){
			if(txt_address.getText().length()>0){
				if(txt_mob.getText().length()>0){
					if(txt_mob.getText().length()>=10&&txt_mob.getText().length()<=10){
					if(txt_modelno.getText().length()>0){
						if(cmb_brand_name.getSelectedIndex()>-1){
							if(cmb_model.getSelectedIndex()>-1){
								if(Integer.parseInt(txt_price.getText())>0){
								if(txt_quantity.getText().length()>0){
									if(Integer.parseInt(txt_available.getText())>0){
									if(txt_batteryno.getText().length()>0){
										if(txt_chargerno.getText().length()>0){
											if(txt_vat.getText().length()>0){
												return true;
											}else{
												JOptionPane.showMessageDialog(null, "Enter Vat Amount Or 0 ");
											}
										}else{
											JOptionPane.showMessageDialog(null, "Enter Charger Number ");
										}
									}else{
										JOptionPane.showMessageDialog(null, "Enter Battery Number ");
									}
								}else{
									JOptionPane.showMessageDialog(null, "Stock Not Available ");

								}
								}else{
									JOptionPane.showMessageDialog(null, "Enter Sale Of Quantity ");
								}
								}else{
									JOptionPane.showMessageDialog(null, "Price Doesn't Vailid ");

								}
							}else{
								JOptionPane.showMessageDialog(null, "Select Model Name ");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Select Brand Name ");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Enter Model Number ");
					}
					  }else{
						  JOptionPane.showMessageDialog(null, "Enter Mobile Number not Vailid");
					  }
				}else{
					JOptionPane.showMessageDialog(null, "Enter Mobile Number ");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Enter Customer Address ");
			}
	
		}else{
			JOptionPane.showMessageDialog(null, "Enter Customer Name ");
		}
		return false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		double vat,vatstr;
		if(e.getSource().equals(txt_quantity)){
			 if(txt_vat.getText().length()>0){
				 vat=Double.parseDouble(txt_price.getText())*Integer.parseInt(txt_quantity.getText());
				 if(Integer.parseInt(txt_vat.getText())>0){
					 vatstr=vat*Double.parseDouble(txt_vat.getText())/100;
					txt_totvat.setText(Double.toString(vatstr));
				 }
			 }else{
				 txt_totvat.setText("0");
			 }
			 
			if(Integer.parseInt(txt_price.getText())>0){
				if(txt_totvat.getText().length()>0){
					double str;
					str=(Double.parseDouble(txt_price.getText())*Integer.parseInt(txt_quantity.getText()) + Double.parseDouble(txt_totvat.getText()));
					txt_tot.setText(Double.toString(str));
				}
		   }
		}
		
	}
}
