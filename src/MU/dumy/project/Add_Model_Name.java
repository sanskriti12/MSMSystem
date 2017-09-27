package MU.dumy.project;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Add_Model_Name extends LoginBase {
public void insert_Model(String brand,int cid,int pid,String modelname){
	conn=Oracale_Connections.getConnection();
	String sqlqry="insert into model_name values('" + brand + "'," + cid + "," + pid + ",'" + modelname + "')";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		int i=ps.executeUpdate();
		conn.commit();
		if(i==1){
			JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
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
public int gen_Pid(String brandname){
	int num=1;
super.conn=Oracale_Connections.getConnection();
String sqlqry="select product_id from model_name where brand_name='" + brandname +"'order by company_id desc";
try {
	super.ps=conn.prepareStatement(sqlqry);
	rs=ps.executeQuery();
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, e);
}
try {
	if(rs.next()){
		return rs.getInt(1)+1;
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
/*public void del(String product){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="delete from model_name where product_id='" + product + "'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		int sta=super.ps.executeUpdate();
		conn.commit();
		if(sta==1){
			JOptionPane.showMessageDialog(null, "Row Deleted");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
  }
*/
public String searchmodel(int productid, String brand){
	super.conn=Oracale_Connections.getConnection();
	String modelname=null;
	 String sqlqry="select model_name from model_name where product_id=" + productid + " and brand_name='" + brand + "'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
		if(rs.next()){
			return rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	return modelname;
}
public void update(String brand,int pro,String modelname){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="update model_name set model_name='" + modelname + "'where product_id=" + pro + " and brand_name='" + brand + "'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		int status=super.ps.executeUpdate();
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
public boolean validate_model_name(String model){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="select model_name from model_name where model_name='" + model + "'";
	try {
		super.ps=super.conn.prepareStatement(sqlqry);
		super.rs=super.ps.executeQuery();
		if(super.rs.next()){
			return false;
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
	return true;
}
public boolean validate_product(int pro_model){
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="select product_id from model_name where product_id=" + pro_model + "";
	try {
		super.ps=super.conn.prepareStatement(sqlqry);
		super.rs=super.ps.executeQuery();
		if(super.rs.next()){
			return true;
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
	return false;
}

}
