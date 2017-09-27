package MU.dumy.project;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Insert_Feature extends LoginBase{
	
	Connection conn;
public void insertfeture(String brandname,int productid,String modelname,int amount,String internalstorage,
		String os,String expandablestorage, String ram,String cpu,String rearcamera,String frontcamera,
		String screensize,String resulation,String battery,String networksupport,String protection,String imag){
	conn=Oracale_Connections.getConnection();
	String sqlqry="insert into feature values('" + brandname + "','" + productid + "','" + modelname + "','" + amount + "','" + internalstorage + "','" + os + "','" + expandablestorage + "','" + ram + "','" + cpu + "','" + rearcamera + "','" + frontcamera + "','" + screensize +"','" + resulation +"','" + battery + "','" + networksupport + "','" + protection + "','" + imag + "')";
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
public boolean inserted_record_validate(String model){
	conn=Oracale_Connections.getConnection();
	String sqlqry="select model_name from feature where model_name='" + model + "'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
		if(rs.next()){
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
public int getrowno(){
	super.conn=Oracale_Connections.getConnection();
	int row=0;
	String sqlqry="select count(*) from company_name";
	try {
		super.ps=super.conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
		if(rs.next()){
			row=rs.getInt(1);
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}	
	return row;
	
}
public  String[] get_brand_name(){
	conn=Oracale_Connections.getConnection();
	int row=getrowno(),index=0;
			String []bname=new String [row];
	String sqlqry="select brand_name from company_name";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
			while(super.rs.next()){
				bname[index]=rs.getString(1);
				index+=1;
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
	
	return bname;
  }
public int get_product_id(String brandname){
	String sqlqry=null;
	int num=0;
	conn=Oracale_Connections.getConnection();
	sqlqry="select company_id from company_name where brand_name='" + brandname +"'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
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
public String[] get_specification(String modelname,String brandname){
	super.conn=Oracale_Connections.getConnection();
	int packetsize=0;
	String []strmodel=new String[15];
	String sqlqry="select amount,internal_storage,os,external_upto,ram,processor,rear_camera,front_camera,screen_size,resulation,battery,network_support,protection,picture from feature where brand_name='" + brandname + "' and model_name='" + modelname + "'";
	try {
		super.ps=super.conn.prepareStatement(sqlqry);
		super.rs=super.ps.executeQuery();
		if(super.rs.next()){
			while(packetsize<14){
			strmodel[packetsize]=rs.getString(packetsize+1);
			packetsize++;
			}
	return strmodel;
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	return strmodel;
}
public int get_model_no_row(String brand){
	super.conn=Oracale_Connections.getConnection();
	int row=0;
	String sqlqry="select count(model_name) from model_name where brand_name='" + brand + "'";
	try {
		super.ps=super.conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
		if(rs.next()){
			row=rs.getInt(1);
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}	
	return row;
	
}
public  String[] get_model(String brand){
	conn=Oracale_Connections.getConnection();
	int row=get_model_no_row(brand),index=0;
	String []mname=new String [row];
	String sqlqry="select model_name from model_name where brand_name='" + brand +"'";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		super.rs=ps.executeQuery();
		while(super.rs.next()){
			mname[index]=rs.getString(1);
			index+=1;
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
	return mname;
   }
	
	public void update_model(int price,String internalstr,String operating, String externalupto,String ramcapacity, String cpu,String rear,String front,String screen, String resu,String power,String network,String protect,String model ){
		
		String sqlqry="update feature set amount=" + price + ",internal_storage='" + internalstr + "',os='" + operating + "',external_upto='" + externalupto +"',ram='" + ramcapacity +"',processor='" + cpu +"',rear_camera='" + rear +"',front_camera='" + front +"',screen_size='" + screen +"',resulation='" + resu + " ',battery='" +power +"',network_support='" +network +"',protection='" + protect + "' where model_name='" + model +"'";
		try {
			super.conn=Oracale_Connections.getConnection();
			super.ps=super.conn.prepareStatement(sqlqry);
			int status=super.ps.executeUpdate();
			super.conn.commit();
			if(status==1){
				JOptionPane.showMessageDialog(null, "Row Updated");
			}
				} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}/*finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}*/
	}
	public String get_pic_model(String model){
		String pic=null;
		conn=Oracale_Connections.getConnection();
		String sqlqry="select picture from feature where model_name='" + model + "'";
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
			if(super.rs.next()){
				return pic=rs.getString(1);
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
		
		return pic;
	  }
}
