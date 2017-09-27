package MU.dumy.project;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Add_Stock extends LoginBase {
public int get_quantity_stock(String model){
	int num=0;
	super.conn=Oracale_Connections.getConnection();
	String Sqlqry="select model_name from stock where model_name='" + model + "'";
	try {
		super.ps=conn.prepareStatement(Sqlqry);
		super.rs=ps.executeQuery();
		if(rs.next()){
			num=rs.getInt(1);
		}
	} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	return num;
	
	}
public void update_stock(int stock,String brand,String model){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="update stock set total_stock=" + stock +" where brand_name='" + brand + "' and model_name='" + model +"'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		int status=ps.executeUpdate();
		conn.commit();
		if(status==1){
			JOptionPane.showMessageDialog(null, "Row Updated");
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}
public int quantity(String model){
	int num=0;
	String Sqlqry="select total_stock from stock where model_name= '" + model + "'";
	super.conn=Oracale_Connections.getConnection();
	try {
		super.ps=super.conn.prepareStatement(Sqlqry);
		super.rs=super.ps.executeQuery();
		if(rs.next()){
			num=rs.getInt(1);
			
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	return num;
	
}
public void insert_stock(String brand,String model,int pres){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="insert into stock values('" + brand +"','" + model + "'," + pres + ")";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		int status=ps.executeUpdate();
		conn.commit();
		if(status==1){
			JOptionPane.showMessageDialog(null, "Record Inserted");
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}
}
