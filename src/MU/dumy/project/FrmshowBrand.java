package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class FrmshowBrand extends LoginBase implements ActionListener {
	DefaultTableModel jtable=new DefaultTableModel();
	JFrame frm;
	JPanel p;
	JButton btnshow;
	JTable info_table;
	public FrmshowBrand(){
		frm=new JFrame("SEARCH BRAND");
		frm.setLayout(null);
		frm.setSize(227, 300);
		frm.setResizable(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=frm.getSize().width;//get the width of the frame
	    int frameheigth=frm.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		frm.setLocation(framelocationX,framelocationY);
		Color hexa=Color.decode("#e3dac9");
		frm.getContentPane().setBackground(hexa);
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 240, 220);
		frm.add(p);
		
		info_table=new JTable(jtable);
		JScrollPane js=new JScrollPane(info_table);
		js.setBounds(0, 0,220, 220);
		Object[] columns={"Brand Name"};
		
		jtable.setColumnIdentifiers(columns);
		info_table.setModel(jtable);
		p.add(js);
		btnshow=new JButton("Show Brand");
		btnshow.setBounds(50, 225, 120, 40);
		frm.add(btnshow);
		btnshow.addActionListener(this);
		frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnshow)){
			if(btnshow.getText().equals("Show Brand")){
				brand();
			}
		}
		
	}
	public void brand(){
		String sqlqry="select brand_name from company_name";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
				info_table.setModel(DbUtils.resultSetToTableModel(super.rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
