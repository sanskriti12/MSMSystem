package MU.dumy.project;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BufferCapabilities;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Event.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.PaintEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.VolatileImage;
import java.awt.peer.CheckboxPeer;
import java.awt.peer.ContainerPeer;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import net.proteanit.sql.DbUtils;

public class FrmSearchSale extends LoginBase implements ActionListener,WindowListener,MouseListener{
	DefaultTableModel jtable=new DefaultTableModel();
	JFrame frm;
	JLabel lbl_date,lbl_month,lbl_date_by,lbl_mon_by,lbl_brand,lbl_brand_by;
	JTextField txt_date;
	JPanel p;
	JButton btndatesrc,btnmonsrc,btnbrand;
	JTable info_table;
	JComboBox cmb_month,cmb_brandname,cmbyear;
	JCheckBox chkdate,chkmonth,chkbrand;
	MaskFormatter mf1;
	public FrmSearchSale(){
		frm=new JFrame("SEARCH");
		frm.setLayout(null);
		frm.setSize(700, 450);
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
		
		lbl_date=new JLabel("SEARCH DATE");
		lbl_date.setBounds(20, 20, 100, 40);
		frm.add(lbl_date);
		
		try {
			mf1=new MaskFormatter("##-UUU-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txt_date=new JFormattedTextField(mf1);
		txt_date.setBounds(130, 20, 200, 40);
		frm.add(txt_date);
		
		lbl_date_by=new JLabel("DATE BY");
		lbl_date_by.setBounds(360, 20, 100, 40);
		frm.add(lbl_date_by);
		
		chkdate=new JCheckBox();
		chkdate.setBounds(465, 20, 20, 20);
		chkdate.addActionListener(this);
		frm.add(chkdate);
		
		lbl_month=new JLabel("SEARCH YEAR");
		lbl_month.setBounds(20, 80, 100, 40);
		frm.add(lbl_month);
		cmbyear=new JComboBox();
		cmbyear.setBounds(130, 80, 100, 40);
		frm.add(cmbyear);
		
		cmb_month=new JComboBox();
		cmb_month.setBounds(230, 80, 100, 40);
		frm.add(cmb_month);

		lbl_mon_by=new JLabel("MONTH BY");
		lbl_mon_by.setBounds(360, 80, 100, 40);
		frm.add(lbl_mon_by);
		
		chkmonth=new JCheckBox();
		chkmonth.setBounds(465, 80, 20, 20);
		frm.add(chkmonth);
		chkmonth.addActionListener(this);
		
		lbl_brand=new JLabel("BRAND NAME");
		lbl_brand.setBounds(20, 130, 100, 40);
		frm.add(lbl_brand);
		
		cmb_brandname=new JComboBox();
		cmb_brandname.setBounds(130, 140, 200, 40);
		frm.add(cmb_brandname);
		
		lbl_brand_by=new JLabel("BRAND BY");
		lbl_brand_by.setBounds(360, 140, 100, 40);
		frm.add(lbl_brand_by);
		
		chkbrand=new JCheckBox();
		chkbrand.setBounds(465, 140, 20, 20);
		frm.add(chkbrand);
		chkbrand.addActionListener(this);
		
		btndatesrc=new JButton("SEARCH");
		btndatesrc.setBounds(550, 20, 100, 40);
		btndatesrc.addActionListener(this);
		frm.add(btndatesrc);
		
		btnmonsrc=new JButton("SEARCH");
		btnmonsrc.setBounds(550, 80, 100, 40);
		btnmonsrc.addActionListener(this);
		frm.add(btnmonsrc);
		
		btnbrand=new JButton("SEARCH");
		btnbrand.setBounds(550, 140, 100, 40);
		frm.add(btnbrand);
		btnbrand.addActionListener(this);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(20, 200, 670, 200);
		frm.add(p);
		
		info_table=new JTable(jtable);
		JScrollPane js=new JScrollPane(info_table);
		js.setBounds(0, 0,670, 250);
		Object[] columns={"Brand Name","Model Name","Price","Stock"};
		
		jtable.setColumnIdentifiers(columns);
		info_table.setModel(jtable);
		p.add(js);
		
		frm.setVisible(true);
	}
	public void datesrc(String saledate){
		String sqlqry="select distinct brand_name,model_name,price,stock_available from sale where purchase_date='" + saledate + "'";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
				info_table.setModel(DbUtils.resultSetToTableModel(super.rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void month_year(String month,String year){
		String sqlqry="select brand_name,model_name,price,stock_available from sale where sale_month='" + month +"' and sale_year='" + year + "'";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
				info_table.setModel(DbUtils.resultSetToTableModel(super.rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(chkdate)){
			if(chkdate.isSelected()){
				txt_date.grabFocus();
			txt_date.setEditable(true);
			btndatesrc.setEnabled(true);
			chkmonth.setSelected(false);
			cmb_month.setEnabled(false);
			cmbyear.setEnabled(false);
			btnmonsrc.setEnabled(false);
			cmb_brandname.setEnabled(false);
			btnbrand.setEnabled(false);
			}else{
				txt_date.setEditable(false);
				btndatesrc.setEnabled(false);
				txt_date.setText(null);
				cmb_brandname.removeAllItems();
			}
		}
		if(e.getSource().equals(btndatesrc)){
			if(btndatesrc.getText().equals("SEARCH")){
						datesrc(txt_date.getText());
						cmb_brandname.setEnabled(false);
						brand_show_date(txt_date.getText());
				}
		}
	
			if(e.getSource().equals(chkbrand)){
			if(chkbrand.isSelected()){
				cmb_brandname.setEnabled(true);
				btnbrand.setEnabled(true);
			}else{
				cmb_brandname.setEnabled(false);
				btnbrand.setEnabled(false);
			}
		}if(e.getSource().equals(btnbrand)){
			if(btnbrand.getText().equals("SEARCH")){
				brand_name_show(cmb_brandname.getSelectedItem().toString());
			}
		}if(e.getSource().equals(chkmonth)){
			if(chkmonth.isSelected()){
				getyear();
				getmonth();
				chkbrand.setSelected(false);
				chkdate.setSelected(false);
				cmb_month.setEnabled(true);
				cmbyear.setEnabled(true);
				btnmonsrc.setEnabled(true);
				txt_date.setText(null);
				txt_date.setEditable(false);
				btndatesrc.setEnabled(false);
				cmb_month.setSelectedIndex(-1);
				cmbyear.setSelectedIndex(-1);
			}else{
				cmb_brandname.removeAllItems();
			}
		}if(e.getSource().equals(btnmonsrc)){
			if(btnmonsrc.getText().equals("SEARCH")){
				if(cmbyear.getSelectedIndex()!=-1){
					if(cmb_month.getSelectedIndex()!=-1){
				month_year(cmb_month.getSelectedItem().toString(),cmbyear.getSelectedItem().toString());
				 get_year_or_month_by_brand(cmbyear.getSelectedItem().toString(), cmb_month.getSelectedItem().toString());
					}else{
						JOptionPane.showMessageDialog(null, "Select Month");

					}
					}else{
					JOptionPane.showMessageDialog(null, "Select Year");
				}
			}
		}
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
		cmb_month.setSelectedIndex(-1);
		cmbyear.setSelectedIndex(-1);
		txt_date.setEditable(false);
		cmb_month.setEnabled(false);
		cmb_month.setSelectedIndex(-1);
		btndatesrc.setEnabled(false);
		btnmonsrc.setEnabled(false);
		cmbyear.setEnabled(false);
		cmb_brandname.setEnabled(false);
		btnbrand.setEnabled(false); 
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
	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	public  void getyear(){
		cmbyear.removeAllItems();
		conn=Oracale_Connections.getConnection();
		String sqlqry="select distinct sale_year from sale";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
				while(super.rs.next()){
					cmbyear.addItem(rs.getString(1));
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		public  void getmonth(){
			cmb_month.removeAllItems();
			conn=Oracale_Connections.getConnection();
			String sqlqry="select distinct sale_month from sale";
			try {
				super.ps=conn.prepareStatement(sqlqry);
				super.rs=ps.executeQuery();
					while(super.rs.next()){
						cmb_month.addItem(rs.getString(1));
					}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  }
		public  void brand_show_date(String branddate){
			cmb_brandname.removeAllItems();
			conn=Oracale_Connections.getConnection();
			String sqlqry="select distinct brand_name from sale where purchase_date='" + branddate + "'";
			try {
				super.ps=super.conn.prepareStatement(sqlqry);
				super.rs=super.ps.executeQuery();
					while(super.rs.next()){
						cmb_brandname.addItem(rs.getString(1));
					}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  }
		public  void get_year_or_month_by_brand(String year,String month){
			cmb_brandname.removeAllItems();
			conn=Oracale_Connections.getConnection();
			String sqlqry="select distinct brand_name from sale where sale_year='" + year + "' and sale_month='" + month + "'";
			try {
				super.ps=super.conn.prepareStatement(sqlqry);
				super.rs=super.ps.executeQuery();
					while(super.rs.next()){
						cmb_brandname.addItem(rs.getString(1));
					}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  }
		public  void brand_name_show(String brand){
			conn=Oracale_Connections.getConnection();
			String sqlqry="select distinct model_name,price,stock_available from sale where brand_name='" + brand + "'";
			try {
				super.ps=super.conn.prepareStatement(sqlqry);
				super.rs=super.ps.executeQuery();
				info_table.setModel(DbUtils.resultSetToTableModel(super.rs));
					
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  }
}
