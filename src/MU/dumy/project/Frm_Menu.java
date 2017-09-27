package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class Frm_Menu implements ActionListener {
	JFrame frm;
	JMenuBar mb;
	JMenu AddCompany,AddModel,AddFeature,Dispaly,Comparison,Stock,Sale,Utility,salereport,exit;
	JLabel lblscreen;
	JMenuItem Add_company,Update_company,Add_model,updte_model,Show_feature,Add_feature,update_feature,
	Compare_model,Add_stock,Add_sale,update_sale,changepassword,createuser,sale_report,jmexit,branddetails,modeldetails;
	public Frm_Menu(){
		frm=new JFrame("MAIN FROM");
		Toolkit toolkit=frm.getToolkit();	
		Dimension size=toolkit.getScreenSize();
		frm.setSize(size.width, size.height);
		frm.setLayout(null);
		frm.setResizable(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=frm.getSize().width;//get the width of the frame
	    int frameheigth=frm.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		frm.setLocation(framelocationX,framelocationY);
			
		Image img=new ImageIcon(this.getClass().getResource("/banner.jpg")).getImage();
		lblscreen=new JLabel("");
		lblscreen.setBounds(0,30,1366,750);
		lblscreen.setIcon(new ImageIcon(img));
		frm.add(lblscreen);
		
		mb=new JMenuBar();
		mb.setSize(size.width, size.height);
		mb.setBounds(1, 1, size.width, 30);
		Font f2=new Font("console", Font.BOLD, 15);
		AddCompany=new JMenu("ADD COMPANY");
		AddCompany.setFont(f2);
		AddCompany.setBounds(1, 1, 120, 30);
		mb.add(AddCompany);
		Font f3=new Font("console", Font.BOLD, 15);
		AddModel=new JMenu("ADD MODEL");
		AddModel.setFont(f3);
		AddModel.setBounds(130, 1, 100, 30);
		mb.add(AddModel);
		Font f4=new Font("console", Font.BOLD, 15);
		AddFeature=new JMenu("ADD FEATURE");
		AddFeature.setFont(f4);
		AddFeature.setBounds(230, 1, 100, 30);
		mb.add(AddFeature);
		Font f5=new Font("console", Font.BOLD, 15);
		Dispaly=new JMenu("DISPLAY");
		Dispaly.setFont(f5);
		Dispaly.setBounds(330, 1, 100, 30);
		mb.add(Dispaly);
		Font f6=new Font("console", Font.BOLD, 15);
		Comparison=new JMenu("COMPARISON");
		Comparison.setFont(f6);
		Comparison.setBounds(430, 1, 100, 30);
		mb.add(Comparison);
		Font f7=new Font("console", Font.BOLD, 15);
		Stock=new JMenu("STOCK");
		Stock.setFont(f7);
		Stock.setBounds(530, 1, 100, 30);
		mb.add(Stock);
		Font f8=new Font("console", Font.BOLD, 15);
		Sale=new JMenu("SALE");
		Sale.setFont(f8);
		Sale.setBounds(630, 1, 100, 30);
		mb.add(Sale);
		Font f10=new Font("console", Font.BOLD, 15);
		salereport=new JMenu("SALE REPORT");
		salereport.setFont(f10);
		salereport.setBounds(730, 1, 100, 30);
		mb.add(salereport);
		Font f9=new Font("console", Font.BOLD, 15);
		Utility=new JMenu("UTILITY");
		Utility.setFont(f9);
		Utility.setBounds(830, 1, 100, 30);
		mb.add(Utility);
		Font f11=new Font("console", Font.BOLD, 15);
		exit=new JMenu("EXIT");
		exit.setFont(f11);
		exit.setBounds(930, 1, 100, 30);
		mb.add(exit);
		
		Add_company=new JMenuItem("Add");
		Add_company.addActionListener(this);
		Update_company=new JMenuItem("Update");
		Update_company.addActionListener(this);
		branddetails=new JMenuItem("Details");
		branddetails.addActionListener(this);
		Add_model=new JMenuItem("Add");
		Add_model.addActionListener(this);
		updte_model=new JMenuItem("Update");
		updte_model.addActionListener(this);
		modeldetails=new JMenuItem("Details");
		modeldetails.addActionListener(this);
		Show_feature=new JMenuItem("Range Of Price");
		Show_feature.addActionListener(this);
		Add_feature=new JMenuItem("Add");
		Add_feature.addActionListener(this);
		update_feature=new JMenuItem("Update");
		update_feature.addActionListener(this);
		Compare_model=new JMenuItem("Compare");
		Compare_model.addActionListener(this);
		Add_stock=new JMenuItem("Add");
		Add_stock.addActionListener(this);
		Add_sale=new JMenuItem("Add");
		Add_sale.addActionListener(this);
		update_sale=new JMenuItem("Update");
		update_sale.addActionListener(this);
		changepassword=new JMenuItem("Change Password");
		changepassword.addActionListener(this);
		createuser=new JMenuItem("Create User");
		createuser.addActionListener(this);
		sale_report=new JMenuItem("Sale Report");
		sale_report.addActionListener(this);
		jmexit=new JMenuItem("Exit");
		exit.add(jmexit);
		jmexit.addActionListener(this);
		salereport.add(sale_report);
		AddCompany.add(Add_company);
		AddCompany.add(Update_company);
		AddCompany.add(branddetails);
		AddModel.add(Add_model);
		AddModel.add(updte_model);
		AddModel.add(modeldetails);
		Dispaly.add(Show_feature);
		AddFeature.add(Add_feature);
		AddFeature.add(update_feature);
		Comparison.add(Compare_model);
		Stock.add(Add_stock);
		Sale.add(Add_sale);
		Sale.add(update_sale);
		Utility.add(changepassword);
		Utility.add(createuser);
		
		frm.add(mb);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		new Frm_Menu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Add_company)
		{
			FrmCompanyName fn=new FrmCompanyName();
			fn.btnsrc.setEnabled(false);
		}else if(e.getSource()==Update_company){
			FrmCompanyName fn=new FrmCompanyName();
			fn.btnAdd.setEnabled(false);
		}else if(e.getSource()==Add_model){
			FrmAddModelName fa=new FrmAddModelName();
			fa.btnsrc.setEnabled(false);
		}else if(e.getSource()==updte_model){
			FrmAddModelName fa=new FrmAddModelName();
			fa.btnadd.setEnabled(false);
		}else if(e.getSource()==Add_feature){
			Frmfeature ff=new Frmfeature();
			ff.btn_src_model_no.setEnabled(false);
		}else if(e.getSource()==update_feature){
			Frmfeature ff=new Frmfeature();
			ff.btn_src_model_no.setEnabled(true);
			ff.btn_add_model_no.setEnabled(false);
		}else if(e.getSource()==Show_feature){
			new Frm_Show_Feature();
		}else if(e.getSource()==Compare_model){
			new FrmCompare();
		}else if(e.getSource()==Add_stock){
			new Frm_Stock();
		}else if(e.getSource()==Add_sale){
			Frm_Sales fs=new Frm_Sales();
			fs.btnsrc.setEnabled(false);
			fs.txt_ser.setEditable(false);
		}else if(e.getSource()==update_sale){
			Frm_Sales fs=new Frm_Sales();
			fs.btnsub.setEnabled(false);
		}else if(e.getSource()==sale_report){
			new FrmSearchSale();
		}
		else if(e.getSource()==changepassword){
			new DChangePassword();
		}else if(e.getSource()==createuser){
			new DRegister();
			frm.dispose();
		}else if(e.getSource()==jmexit){
			System.exit(0);
		}else if(e.getSource()==branddetails){
			new FrmshowBrand();
		}else if(e.getSource()==modeldetails)
		new Frmshowmodelname();
	}
}
