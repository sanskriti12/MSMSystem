package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmCompare implements WindowListener,ItemListener,FocusListener,ActionListener,MouseListener {
	JFrame frm;
	JLabel lbl_company_id,lbl_brand_name,lbl_model_name,lbl_amount,lbl_os,lbl_processor,lbl_ram,
	lbl_primary_cam,lbl_secondray_cam,lbl_screen_size,lbl_internal_stroge,lbl_expandable_upto,
	lbl_resulation,lbl_protection,lbl_battery,lbl_nw,lbl_image,lbl_show_processor,lbl_show_rear,lbl_show_front,
	lbl_show_resulation,lbl_show_battery,lbl_show_protection,lbl_show_nw,lbl_show_screen,lbl_show_internal,
	lbl_show_exp_upto,lbl_showamount,lbl_show_os,lbl_show_ram;
	
	JLabel lbl_company_id1,lbl_brand_name1,lbl_model_name1,lbl_amount1,lbl_os1,lbl_processor1,lbl_ram1,
	lbl_primary_cam1,lbl_secondray_cam1,lbl_screen_size1,lbl_internal_stroge1,lbl_expandable_upto1,
	lbl_resulation1,lbl_protection1,lbl_battery1,lbl_nw1,lbl_image1,lbl_show_processor1,lbl_show_rear1,lbl_show_front1,
	lbl_show_resulation1,lbl_show_battery1,lbl_show_protection1,lbl_show_nw1,lbl_show_screen1,lbl_show_internal1,
	lbl_show_exp_upto1,lbl_showamount1,lbl_show_os1,lbl_show_ram1,lbl_pic1,lbl_pic2,lbl_show_pic1,
	lbl_show_pic2;
	
	
	JComboBox cmb_brand,cmb_brand1,cmb_model_name,cmb_model_name1;
	JButton btn_disply;
	public FrmCompare(){
		frm=new JFrame();
		frm.setSize(1100, 550);
		frm.setLayout(null);
		frm.setResizable(false);
		frm.setTitle("MODEL");
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=frm.getSize().width;//get the width of the frame
	    int frameheigth=frm.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		frm.setLocation(framelocationX,framelocationY);
		Color hexa=Color.decode("#e3dac9");
		frm.getContentPane().setBackground(hexa);
		frm.addWindowListener(this);
		
		lbl_brand_name=new JLabel("BRAND NAME");
		lbl_brand_name.setBounds(25, 25, 100, 25);
		frm.add(lbl_brand_name);
		
		lbl_pic1=new JLabel("PICTURE");
		lbl_pic1.setBounds(850, 25, 155, 25);
		frm.add(lbl_pic1);
		
		lbl_show_pic1=new JLabel("");
		lbl_show_pic1.setBounds(800, 60, 200, 200);
		lbl_show_pic1.setBackground(Color.BLUE);
		frm.add(lbl_show_pic1);
		
		cmb_brand=new JComboBox();
		cmb_brand.setBounds(150, 25, 150, 25);
		frm.add(cmb_brand);
		cmb_brand.addItemListener(this);
		
		lbl_model_name=new JLabel("MODEL NAME");
		lbl_model_name.setBounds(310, 25, 100, 25);
		frm.add(lbl_model_name);
						
		cmb_model_name=new JComboBox();
		cmb_model_name.setBounds(440, 25, 150, 25);
		frm.add(cmb_model_name);
		cmb_model_name.addItemListener(this);
		cmb_model_name.setSelectedIndex(-1);
		
		lbl_amount=new JLabel("AMOUNT");
		lbl_amount.setBounds(610, 25, 100, 25);
		frm.add(lbl_amount);
		
		lbl_showamount=new JLabel();
		lbl_showamount.setBounds(710, 25, 150, 25);
		frm.add(lbl_showamount);
		
		lbl_os=new JLabel("OS");
		lbl_os.setBounds(25, 60, 100, 25);
		frm.add(lbl_os);
		
		lbl_show_os=new JLabel();
		lbl_show_os.setBounds(150, 60, 150, 25);
		frm.add(lbl_show_os);
		
		lbl_ram=new JLabel("RAM");
		lbl_ram.setBounds(310, 60, 100, 25);
		frm.add(lbl_ram);
		
		lbl_show_ram=new JLabel();
		lbl_show_ram.setBounds(440, 60, 150, 25);
		frm.add(lbl_show_ram);
		
		lbl_processor=new JLabel("PROCESSOR");
		lbl_processor.setBounds(610, 60, 100, 25);
		frm.add(lbl_processor);
		
		lbl_show_processor=new JLabel("");
		lbl_show_processor.setBounds(710, 60, 150, 25);
		frm.add(lbl_show_processor);
		
		lbl_primary_cam=new JLabel("REAR CAMERA");
		lbl_primary_cam.setBounds(25, 90, 100, 25); 
		frm.add(lbl_primary_cam);
		
		lbl_show_rear=new JLabel(" ");
		lbl_show_rear.setBounds(150, 90, 150, 25); 
		frm.add(lbl_show_rear);
		
		lbl_secondray_cam=new JLabel("FRONT CAMERA");
		lbl_secondray_cam.setBounds(310, 90, 100, 25);
		frm.add(lbl_secondray_cam);
		
		lbl_show_front=new JLabel(" ");
		lbl_show_front.setBounds(440, 90, 150, 25);
		frm.add(lbl_show_front);

		lbl_resulation=new JLabel("RESOLUTION");
		lbl_resulation.setBounds(610, 90, 100, 25);
		frm.add(lbl_resulation);
		
		lbl_show_resulation=new JLabel(" ");
		lbl_show_resulation.setBounds(710, 90, 150, 25);
		frm.add(lbl_show_resulation);
		
		
		lbl_battery=new JLabel("BATTERY");
		lbl_battery.setBounds(25, 120, 115, 25);
		frm.add(lbl_battery);
		
		lbl_show_battery=new JLabel(" ");
		lbl_show_battery.setBounds(150, 120, 150, 25);
		frm.add(lbl_show_battery);
		
		lbl_nw=new JLabel("NETWORK SUPPORT");
		lbl_nw.setBounds(310, 120, 120, 25);
		frm.add(lbl_nw);
		

		lbl_show_nw=new JLabel(" ");
		lbl_show_nw.setBounds(440, 120, 150, 25);
		frm.add(lbl_show_nw);
		
		
		lbl_protection=new JLabel("PROTECTION");
		lbl_protection.setBounds(610, 120, 100, 25);
		frm.add(lbl_protection);
		

		lbl_show_protection=new JLabel(" ");
		lbl_show_protection.setBounds(710, 120, 150, 25);
		frm.add(lbl_show_protection);
		
		lbl_screen_size=new JLabel("SCREEN SIZE");
		lbl_screen_size.setBounds(610, 150, 100, 25);
		frm.add(lbl_screen_size);
		
		lbl_show_screen=new JLabel(" ");
		lbl_show_screen.setBounds(710, 150, 150, 25);
		frm.add(lbl_show_screen);
		
		lbl_internal_stroge=new JLabel("INTERNAL STORAGE");
		lbl_internal_stroge.setBounds(310, 150, 120, 25);
		frm.add(lbl_internal_stroge);
		
		lbl_show_internal=new JLabel(" ");
		lbl_show_internal.setBounds(440, 150, 150, 25);
		frm.add(lbl_show_internal);
		
		lbl_expandable_upto=new JLabel("EXPANDABLE UPTO");
		lbl_expandable_upto.setBounds(25, 150, 120, 25);
		frm.add(lbl_expandable_upto);
		
		
		lbl_show_exp_upto=new JLabel(" ");
		lbl_show_exp_upto.setBounds(150, 150, 150, 25);
		frm.add(lbl_show_exp_upto);
		
		lbl_brand_name1=new JLabel("BRAND NAME");
		lbl_brand_name1.setBounds(25, 275, 115, 25);
		frm.add(lbl_brand_name1);
		
		cmb_brand1=new JComboBox();
		cmb_brand1.setBounds(150, 275, 150, 25);
		frm.add(cmb_brand1);
		cmb_brand1.addFocusListener(this);
		cmb_brand1.addItemListener(this);
		
		lbl_model_name1=new JLabel("MODEL NAME");
		lbl_model_name1.setBounds(310, 275, 100, 25);
		frm.add(lbl_model_name1);
						
		cmb_model_name1=new JComboBox();
		cmb_model_name1.setBounds(440, 275, 150, 25);
		frm.add(cmb_model_name1);
		cmb_model_name1.addItemListener(this);
		cmb_model_name1.setSelectedIndex(-1);
		
		
		
		lbl_amount1=new JLabel("AMOUNT");
		lbl_amount1.setBounds(610, 275, 100, 25);
		frm.add(lbl_amount1);
		
		lbl_showamount1=new JLabel();
		lbl_showamount1.setBounds(710, 275, 150, 25);
		frm.add(lbl_showamount1);
		
		lbl_os1=new JLabel("OS");
		lbl_os1.setBounds(25, 305, 100, 25);
		frm.add(lbl_os1);
		
		lbl_show_os1=new JLabel();
		lbl_show_os1.setBounds(150, 305, 150, 25);
		frm.add(lbl_show_os1);
		
		lbl_ram1=new JLabel("RAM");
		lbl_ram1.setBounds(310, 305, 100, 25);
		frm.add(lbl_ram1);
		
		lbl_show_ram1=new JLabel();
		lbl_show_ram1.setBounds(440, 305, 150, 25);
		frm.add(lbl_show_ram1);
		
		lbl_processor1=new JLabel("PROCESSOR");
		lbl_processor1.setBounds(610, 305, 100, 25);
		frm.add(lbl_processor1);
		
		lbl_show_processor1=new JLabel("");
		lbl_show_processor1.setBounds(710, 305, 150, 25);
		frm.add(lbl_show_processor1);
		
		lbl_primary_cam1=new JLabel("REAR CAMERA");
		lbl_primary_cam1.setBounds(25, 340, 100, 25); 
		frm.add(lbl_primary_cam1);
		
		lbl_show_rear1=new JLabel(" ");
		lbl_show_rear1.setBounds(150, 340, 150, 25); 
		frm.add(lbl_show_rear1);
		
		lbl_secondray_cam1=new JLabel("FRONT CAMERA");
		lbl_secondray_cam1.setBounds(310, 340, 100, 25);
		frm.add(lbl_secondray_cam1);
		
		lbl_show_front1=new JLabel(" ");
		lbl_show_front1.setBounds(440, 340, 150, 25);
		frm.add(lbl_show_front1);

		lbl_resulation1=new JLabel("RESOLUTION");
		lbl_resulation1.setBounds(610, 340, 100, 25);
		frm.add(lbl_resulation1);
		
		lbl_show_resulation1=new JLabel(" ");
		lbl_show_resulation1.setBounds(710, 340, 150, 25);
		frm.add(lbl_show_resulation1);
		
		
		lbl_battery1=new JLabel("BATTERY");
		lbl_battery1.setBounds(25, 375, 375, 25);
		frm.add(lbl_battery1);
		
		lbl_show_battery1=new JLabel(" ");
		lbl_show_battery1.setBounds(150, 375, 150, 25);
		frm.add(lbl_show_battery1);
		
		lbl_nw1=new JLabel("NETWORK SUPPORT");
		lbl_nw1.setBounds(310, 375, 120, 25);
		frm.add(lbl_nw1);
		

		lbl_show_nw1=new JLabel(" ");
		lbl_show_nw1.setBounds(440, 375, 150, 25);
		frm.add(lbl_show_nw1);
		
		
		lbl_protection1=new JLabel("PROTECTION");
		lbl_protection1.setBounds(610, 375, 100, 25);
		frm.add(lbl_protection1);
		

		lbl_show_protection1=new JLabel(" ");
		lbl_show_protection1.setBounds(710, 375, 150, 25);
		frm.add(lbl_show_protection1);
		
		lbl_screen_size1=new JLabel("SCREEN SIZE");
		lbl_screen_size1.setBounds(610, 410, 100, 25);
		frm.add(lbl_screen_size1);
		
		lbl_show_screen1=new JLabel(" ");
		lbl_show_screen1.setBounds(710, 410, 150, 25);
		frm.add(lbl_show_screen1);
		
		lbl_internal_stroge1=new JLabel("INTERNAL STORAGE");
		lbl_internal_stroge1.setBounds(310, 410, 120, 25);
		frm.add(lbl_internal_stroge1);
		
		lbl_show_internal1=new JLabel(" ");
		lbl_show_internal1.setBounds(440, 410, 150, 25);
		frm.add(lbl_show_internal1);
		
		lbl_expandable_upto1=new JLabel("EXPANDABLE UPTO");
		lbl_expandable_upto1.setBounds(25, 410, 120, 25);
		frm.add(lbl_expandable_upto1);
		
		
		lbl_show_exp_upto1=new JLabel(" ");
		lbl_show_exp_upto1.setBounds(150, 410, 150, 25);
		frm.add(lbl_show_exp_upto1);
		
		btn_disply=new JButton("COMPARE");
		btn_disply.setBounds(290, 195, 150, 50);
		frm.add(btn_disply);
		btn_disply.addMouseListener(this);
		
		lbl_pic2=new JLabel("PICTURE");
		lbl_pic2.setBounds(850, 270, 150, 25);
		frm.add(lbl_pic2);
		
		lbl_show_pic2=new JLabel("");
		lbl_show_pic2.setBounds(800, 300, 200, 200);
		frm.add(lbl_show_pic2);
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
	public void windowOpened(WindowEvent arg0) {
		Insert_Feature ins_rec=new Insert_Feature();
		for(String pname:ins_rec.get_brand_name()){
			cmb_brand.addItem(pname);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(cmb_brand)){
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				Insert_Feature ser_pro=new Insert_Feature();
				 String[] modelname=ser_pro.get_model(cmb_brand.getSelectedItem().toString());
				 int j=modelname.length;
				 cmb_model_name.removeAllItems();
				for(int i=0;i<j;i++){
					 cmb_model_name.addItem(modelname[i]);
				}
				lbl_show_pic1.setText(null);
			}
		}
		else if(e.getSource().equals(cmb_model_name)){
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				Insert_Feature get_speci=new Insert_Feature();
				String[] strval=get_speci.get_specification(cmb_model_name.getSelectedItem().toString(),(cmb_brand.getSelectedItem().toString()));
				lbl_showamount.setText(strval[0]);
				lbl_show_os.setText(strval[2]);
				lbl_show_ram.setText(strval[4]);
				lbl_show_processor.setText(strval[5]);
				lbl_show_rear.setText(strval[6]);
				lbl_show_front.setText(strval[7]);
				lbl_show_resulation.setText(strval[9]);
				lbl_show_battery.setText(strval[10]);
				lbl_show_nw.setText(strval[11]);
				lbl_show_protection.setText(strval[12]);
				lbl_show_screen.setText(strval[8]);
				lbl_show_internal.setText(strval[1]);
				lbl_show_exp_upto.setText(strval[3]);
				String picname=(strval[13]);
				String url=this.getClass().getResource("").getPath();
				String path=url.substring(0, 39);
				System.out.println(path);
				String imgPath = path + "/images/" +picname;
				try {
					BufferedImage img = ImageIO.read(new File(imgPath));
					Image resizedImage = img.getScaledInstance(lbl_show_pic1.getWidth(), lbl_show_pic1.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon imgIcon = new ImageIcon(resizedImage);
					lbl_show_pic1.setIcon(imgIcon);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}
		if(e.getSource().equals(cmb_brand1)){
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				Insert_Feature ser_pro=new Insert_Feature();
				 String[] modelname=ser_pro.get_model(cmb_brand1.getSelectedItem().toString());
				 int j=modelname.length;
				 cmb_model_name1.removeAllItems();
				for(int i=0;i<j;i++){
					 cmb_model_name1.addItem(modelname[i]);
				}
				lbl_show_pic1.setText(null);
			}
		}
		else if(e.getSource().equals(cmb_model_name1)){
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				Insert_Feature get_speci=new Insert_Feature();
				String[] strval=get_speci.get_specification(cmb_model_name1.getSelectedItem().toString(),(cmb_brand1.getSelectedItem().toString()));
				lbl_showamount1.setText(strval[0]);
				lbl_show_os1.setText(strval[2]);
				lbl_show_ram1.setText(strval[4]);
				lbl_show_processor1.setText(strval[5]);
				lbl_show_rear1.setText(strval[6]);
				lbl_show_front1.setText(strval[7]);
				lbl_show_resulation1.setText(strval[9]);
				lbl_show_battery1.setText(strval[10]);
				lbl_show_nw1.setText(strval[11]);
				lbl_show_protection1.setText(strval[12]);
				lbl_show_screen1.setText(strval[8]);
				lbl_show_internal1.setText(strval[1]);
				lbl_show_exp_upto1.setText(strval[3]);
				String picname=(strval[13]);
				String url=this.getClass().getResource("").getPath();
				String path=url.substring(0, 39);
				System.out.println(path);
				String imgPath = path + "/images/" +picname;
				try {
					BufferedImage img = ImageIO.read(new File(imgPath));
					Image resizedImage = img.getScaledInstance(lbl_show_pic2.getWidth(), lbl_show_pic2.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon imgIcon = new ImageIcon(resizedImage);
					lbl_show_pic2.setIcon(imgIcon);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}
	}
	@Override
	public void focusGained(FocusEvent arg0) {
	
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		Insert_Feature com=new Insert_Feature();
		for(String pname:com.get_brand_name()){
			cmb_brand1.addItem(pname);
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}
