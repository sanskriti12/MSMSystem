package MU.dumy.project;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class FrmSplashScreen {
	JFrame frm;
	JLabel lblsplash;
	JProgressBar jb;
	int i=0,num=0;
	public FrmSplashScreen(){
		
	frm=new JFrame("Mobile Shop Management System");
	frm.setSize(900,550);
	frm.setLayout(null);
	frm.setUndecorated(true);
	frm.setAlwaysOnTop(false);
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    int framewidth=frm.getSize().width;//get the width of the frame
    int frameheigth=frm.getSize().height; //get the heigth of the frame
    int framelocationX=(dim.width-framewidth)/2; 
    int framelocationY=(dim.height-frameheigth)/2;
	frm.setLocation(framelocationX,framelocationY);
	
	Image img=new ImageIcon(this.getClass().getResource("/screen.jpg")).getImage();
	
	lblsplash=new JLabel("");
	lblsplash.setBounds(0,0, 900, 530);
	lblsplash.setIcon(new ImageIcon(img));
	frm.add(lblsplash);

	jb=new JProgressBar(0,2000);  
	jb.setBounds(00,520,900,30);  
	frm.add(jb);
	
	jb.setValue(0);  
	jb.setStringPainted(true);  
	
	frm.setVisible(true);
	}
	public void iterate(){  
		while(i<=2000){  
		  jb.setValue(i);  
		  i=i+20;  
		  try{Thread.sleep(50);
		  }catch(Exception e){
		 }  
	}  
		if(i==2020)
		{
			new DLogin();
			frm.dispose();
		}
	}  
	public static void main(String[] args) {  
	    FrmSplashScreen m=new FrmSplashScreen();    
	    m.iterate();  
	}  

}
