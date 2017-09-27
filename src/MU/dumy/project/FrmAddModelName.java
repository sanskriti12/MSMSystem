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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmAddModelName extends LoginBase implements WindowListener,ItemListener,ActionListener,FocusListener {
	JFrame frm;
	JComboBox cmb_brand_name;
	JLabel lbl_brand_name,lbl_cid_no,lbl_model_name,lbl_pid_no;
	JTextField txt_cid_no,txt_pid_no,txt_model_name;
	JButton btnadd,btnsrc,btnedit;
	public FrmAddModelName(){
	frm=new JFrame();
	frm.setSize(385, 300);
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
	frm.setTitle("ADD MODEL NAME");

	
	lbl_brand_name=new JLabel("BRAND NAME");
	lbl_brand_name.setBounds(25, 25, 100, 25);
	frm.add(lbl_brand_name); 
	
	cmb_brand_name=new JComboBox();
	cmb_brand_name.setBounds(150, 25, 200, 25);
	cmb_brand_name.addItemListener(this);
	frm.add(cmb_brand_name);
	
	lbl_cid_no=new JLabel("COMPANY ID");
	lbl_cid_no.setBounds(25, 70, 100, 25);
	frm.add(lbl_cid_no); 
		
	txt_cid_no=new JTextField();
	txt_cid_no.setBounds(150, 70, 200, 25);
	frm.add(txt_cid_no);
	txt_cid_no.setEditable(false);;
		
	lbl_model_name=new JLabel("MODEL NAME");
	lbl_model_name.setBounds(25, 160, 100, 25);
	frm.add(lbl_model_name); 
	
	txt_model_name=new JTextField();
	txt_model_name.setBounds(150, 160, 200, 25);
	frm.add(txt_model_name);
	
	lbl_pid_no=new JLabel("PRODUCT ID");
	lbl_pid_no.setBounds(25, 115, 100, 25);
	frm.add(lbl_pid_no); 
	
	txt_pid_no=new JTextField();
	txt_pid_no.setBounds(150, 115, 200, 25);
	frm.add(txt_pid_no);
	txt_pid_no.setEditable(false);
	
	btnadd=new JButton("ADD");
	btnadd.setBounds(25,200, 100, 40);
	frm.add(btnadd);
	btnadd.addActionListener(this);
	
	btnsrc=new JButton("SEARCH");
	btnsrc.setBounds(135,200, 100, 40);
	frm.add(btnsrc);
	btnsrc.addActionListener(this);
		
	btnedit=new JButton("EDIT");
	btnedit.setBounds(247,200, 100, 40);
	frm.add(btnedit);
	btnedit.addActionListener(this);

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
		cmb_brand_name.setSelectedIndex(-1);
		btnedit.setEnabled(false);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(cmb_brand_name.getSelectedIndex()==-1){
			txt_cid_no.setText("");
			txt_pid_no.setText("");
		}else{
			if(cmb_brand_name.getSelectedIndex()!=-1){
				Insert_Feature ser_pro=new Insert_Feature();
				txt_cid_no.setText(Integer.toString(ser_pro.get_product_id(cmb_brand_name.getSelectedItem().toString())));
			}
			if(cmb_brand_name.getSelectedIndex()!=-1){
				Add_Model_Name genpi=new Add_Model_Name();
				txt_pid_no.setText(Integer.toString(genpi.gen_Pid(cmb_brand_name.getSelectedItem().toString())));
				}
		}
		

  }
	@Override
	public void actionPerformed(ActionEvent e) {
		int pid=0;
		if(e.getSource().equals(btnadd)){
			if(e.getActionCommand().equalsIgnoreCase("ADD")){
				Add_Model_Name insert=new Add_Model_Name();
				if(txt_model_name.getText().length()>0){
					if(insert.validate_model_name(txt_model_name.getText())){
						insert.insert_Model(cmb_brand_name.getSelectedItem().toString(),Integer.parseInt(txt_cid_no.getText().toString()),Integer.parseInt(txt_pid_no.getText().toString()),txt_model_name.getText().toString().toUpperCase());
						pid+=(Integer.parseInt(txt_pid_no.getText()))+1;
						txt_pid_no.setText(Integer.toString(pid));
						txt_model_name.setText(null);
					}else{
							JOptionPane.showMessageDialog(null, "This model all ready Exist");
							txt_model_name.setText(null);
						}
				}else {
						JOptionPane.showMessageDialog(null, "Enter Model Name");
				}
			}
		}
		if(e.getSource().equals(btnadd)){
			if(btnadd.getText().equals("UPDATE")){
				Add_Model_Name up=new Add_Model_Name();
				up.update(cmb_brand_name.getSelectedItem().toString(), Integer.parseInt(txt_pid_no.getText()), txt_model_name.getText().toUpperCase());
				btnadd.setEnabled(true);
				btnadd.setText("ADD");
				btnsrc.setEnabled(true);
				btnsrc.setText("SEARCH");
				btnedit.setEnabled(false);
				btnedit.setText("EDIT");
				txt_model_name.setText(null);
				cmb_brand_name.setEnabled(true);
			}
		}
			if(e.getSource().equals(btnsrc)){
				txt_pid_no.addFocusListener(this);
				btnadd.setEnabled(false);
				btnedit.setEnabled(true);
				btnsrc.setText("NEXT");
				cmb_brand_name.setEnabled(true);
				txt_pid_no.setText(null);
				txt_pid_no.setEditable(true);
				txt_model_name.setEditable(false);
				
			}
		if(e.getSource().equals(btnedit)){
			if(btnedit.getText().equals("EDIT")){
				if(txt_pid_no.getText().length()>0){
					btnadd.setText("UPDATE");
					btnadd.setEnabled(true);
					btnedit.setEnabled(false);
					txt_pid_no.setEditable(false);
					txt_model_name.setEditable(true);
					cmb_brand_name.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Enter Product Id and Press Tab Key");
				}
			}
	}if(e.getSource().equals(btnsrc)){
		if(btnsrc.getText().equals("NEXT")){
			
			txt_model_name.setText(null);
		}
	}
}
	@Override
	public void focusGained(FocusEvent arg0) {
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		btnsrc.removeActionListener(this);
		Add_Model_Name src=new Add_Model_Name();
		if(e.getSource().equals(txt_pid_no)){
			if(txt_pid_no.getText().length()>0){
			if(src.validate_product(Integer.parseInt(txt_pid_no.getText()))){
				txt_model_name.setText(src.searchmodel(Integer.parseInt(txt_pid_no.getText()), cmb_brand_name.getSelectedItem().toString()));
				txt_pid_no.setEditable(false);
			}else{
				JOptionPane.showMessageDialog(null, "Enter valid Product Id");
				txt_pid_no.setText(null);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Enter Product Id");
			}
		}
	}
}
