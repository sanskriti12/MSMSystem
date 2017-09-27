package MU.dumy.project;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Frm_Show_Feature implements ActionListener,ItemListener,ListSelectionListener {
	DefaultListModel model=new DefaultListModel();
	DefaultListModel show=new DefaultListModel();
	DefaultListModel showname=new DefaultListModel();
	JFrame frm;
	JLabel lbl_amount,lbl_brand_name,lbl_model_no,lbl_sepecification,lbl_image,lbl_min_amount,
	lbl_max_amount,lblrange,lbl_show_brand_name,lbl_lstname,lblpic;
	JList lst_specifecation,lst_model_no,lst_lbl_name;
	JComboBox cmb_;
	JButton btn_serch;
	JTextField txt_amount,txt_show_min_amount,txt_show_max_amount;
	String path=null;
	String str[]=null;
	public Frm_Show_Feature(){
	frm=new JFrame();
	frm.setSize(550, 530);
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
	frm.setTitle("SHOW FEATURE");
	
	lbl_min_amount=new JLabel("MIN AMOUNT");
	lbl_min_amount.setBounds(25, 25, 100, 25);
	frm.add(lbl_min_amount);
	
	txt_show_min_amount=new JTextField();
	txt_show_min_amount.setBounds(150, 25, 200, 25);
	frm.add(txt_show_min_amount);
	Show_Specification ss =new Show_Specification();
	txt_show_min_amount.setText(Integer.toString(ss.findmin()));
	txt_show_min_amount.setEditable(false);
	
	lbl_max_amount=new JLabel("MAX AMOUNT");
	lbl_max_amount.setBounds(25, 65, 100, 25);
	frm.add(lbl_max_amount);
	
	
	txt_show_max_amount=new JTextField();
	txt_show_max_amount.setBounds(150, 65, 200, 25);
	frm.add(txt_show_max_amount);
	txt_show_max_amount.setText(Integer.toString(ss.findmax()));
	txt_show_max_amount.setEditable(false);
	
	lbl_amount=new JLabel("RANGE OF PRICE");
	lbl_amount.setBounds(25, 105, 100, 25);
	frm.add(lbl_amount);
	
	lblpic=new JLabel("PICTURE");
	lblpic.setBounds(450, 25, 100,25);
	frm.add(lblpic);
	
	lbl_image=new JLabel("");
	lbl_image.setBounds(380, 50, 200, 350);
	frm.add(lbl_image);
	
	txt_amount=new JTextField();
	txt_amount.setBounds(150, 105, 200, 25);
//	txt_amount.addFocusListener(this);
	frm.add(txt_amount);
	
		lbl_model_no=new JLabel("MODEL NAME");
		lbl_model_no.setBounds(25, 145, 100, 25);
		frm.add(lbl_model_no);
		
		lst_model_no=new JList(model);
		JScrollPane js=new JScrollPane(lst_model_no);
		js.setBounds(150, 145, 200, 40);
		frm.add(js);
		lst_model_no.addListSelectionListener(this);		
		
		lbl_brand_name=new JLabel("BRAND NAME");
		lbl_brand_name.setBounds(25, 195, 100, 25);
		frm.add(lbl_brand_name);
		
		lbl_show_brand_name=new JLabel("");
		lbl_show_brand_name.setBounds(150, 195, 200, 25);
		frm.add(lbl_show_brand_name);
								
		lbl_sepecification=new JLabel("SEPECIFICATION:-");
		lbl_sepecification.setBounds(25, 225, 150, 25);
		frm.add(lbl_sepecification);
		
		lst_specifecation=new JList(show);
		lst_specifecation.setBounds(144, 248, 205, 237);
		frm.add(lst_specifecation);
		lst_lbl_name=new JList(showname);
		lst_lbl_name.setBounds(25, 248, 120, 237);
		frm.add(lst_lbl_name);
		btn_serch=new JButton("Show");
		btn_serch.setBounds(400, 450, 100, 40);
		frm.add(btn_serch);
		btn_serch.addActionListener(this);
		frm.setVisible(true);
	}
@Override
public void actionPerformed(ActionEvent e) {
	lbl_show_brand_name.setText(null);
	Show_Specification getmodel=new Show_Specification();
	if(e.getSource().equals(btn_serch)){
		if(txt_amount.getText().length()>0){
				if(Integer.parseInt(txt_show_min_amount.getText())<=Integer.parseInt(txt_amount.getText())){
					if(Integer.parseInt(txt_show_max_amount.getText())>=Integer.parseInt(txt_amount.getText())){
						String str[]=getmodel.get_model_name(Integer.parseInt(txt_show_min_amount.getText()),Integer.parseInt(txt_amount.getText().toString()));
						for(int i=0;i<str.length;i++){
							model.add(i, str[i]);
						}
					}else{
						JOptionPane.showMessageDialog(null, "enter amount in range Press Tab key");
						lst_lbl_name=null;
						lst_model_no=null;
						lst_specifecation=null;
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Enter  Min amount  press Tab key");
					txt_amount.setText(null);
				} 
		}else{
			JOptionPane.showMessageDialog(null, "Enter amount in range ");
			txt_amount.grabFocus();
		}
	}
  }
@Override
public void itemStateChanged(ItemEvent e) {

	
 }
@Override
public void valueChanged(ListSelectionEvent e) {
	Show_Specification sbrand=new Show_Specification();
	lbl_show_brand_name.setText(sbrand.getbrand(lst_model_no.getSelectedValue().toString()));
	String modelname=lst_model_no.getSelectedValue().toString();
	Insert_Feature get=new Insert_Feature();
	 String str[]=get.get_specification(modelname, lbl_show_brand_name.getText().toString());
	 String picname=null;
	 for(int i=0;i<str.length;i++){
		if(str[i]!=null){
			 show.add(i, str[i]);
			 picname=str[i];
		}
		
	 }
	 String strvalname[]=sbrand.getname();
	 for(int i=0;i<strvalname.length;i++){
				 showname.add(i, strvalname[i]);
		  }
	 	String url=this.getClass().getResource("").getPath();
			String path=url.substring(0, 39);
			//System.out.println(path);
			String imgPath = path + "/images/" +picname;
			try {
				BufferedImage img = ImageIO.read(new File(imgPath));
				Image resizedImage = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgIcon = new ImageIcon(resizedImage);
				lbl_image.setIcon(imgIcon);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	 }
	}
  

