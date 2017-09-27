package MU.dumy.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Frmshowmodelname extends LoginBase implements ActionListener,WindowListener{
	DefaultTableModel jtable=new DefaultTableModel();
	JFrame frm;
	JPanel p;
	JButton btnshow;
	JTable info_table;
	JComboBox cmbbrand;
	JLabel lbl_brand;
	public Frmshowmodelname(){
		frm=new JFrame("SEARCH MODEL");
		frm.setLayout(null);
		frm.setSize(350, 300);
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
		lbl_brand =new JLabel("BRAND");
		lbl_brand.setBounds(20, 20, 100, 40);
		frm.add(lbl_brand);
		cmbbrand=new JComboBox();
		cmbbrand.setBounds(130, 20, 200, 40);
		frm.add(cmbbrand);

		p=new JPanel();
		p.setLayout(null);
		p.setBounds(0, 80, 350, 140);
		frm.add(p);
		
		info_table=new JTable(jtable);
		JScrollPane js=new JScrollPane(info_table);
		js.setBounds(0, 0,350, 140);
		Object[] columns={"Model Name"};
		
		jtable.setColumnIdentifiers(columns);
		info_table.setModel(jtable);
		p.add(js);
		btnshow=new JButton("Show Model");
		btnshow.setBounds(105, 225, 120, 40);
		frm.add(btnshow);
		btnshow.addActionListener(this);
		frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnshow)){
			if(btnshow.getText().equals("Show Model")){
				if(cmbbrand.getSelectedIndex()!=-1){
				model(cmbbrand.getSelectedItem().toString());
				}else{
					JOptionPane.showMessageDialog(null, "Select Model Name");
				}
			}
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		Insert_Feature ins_rec=new Insert_Feature();
		for(String pname:ins_rec.get_brand_name()){
			cmbbrand.addItem(pname);
		}
		cmbbrand.setSelectedIndex(-1);//no value is selected in combo box
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void model(String brand){
		String sqlqry="select model_name from model_name where brand_name='" + brand +"'";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
				info_table.setModel(DbUtils.resultSetToTableModel(super.rs));//sets values in tables
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
