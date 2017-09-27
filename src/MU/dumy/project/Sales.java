package MU.dumy.project;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

public class Sales extends LoginBase {
	public int getprice(String model){
		int num=0;
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="select amount from feature where model_name='" + model + "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			if(rs.next()){
				return num=rs.getInt(1);
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
	public int gen_serial_no(){
		int num=1;
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="select bill_no from sale order by bill_no desc";
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
	public int insert(int bill,String cust,String add,Double mob,String brnad,String model,int price,int stock,String modelno,int qunt,String batt,String chara,int vat,double totamout,String sale_date,String mondate,String saleyear){
		int status=0;
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="insert into sale values(" + bill +",'" + cust +"','" + add + "'," + mob + ",'" + brnad+ "','" + model + "'," + price + "," + stock + ",'" + modelno + "'," + qunt + ",'" + batt + "','" + chara + "'," + vat + "," + totamout + ",'" + sale_date + "','" + mondate + "','" + saleyear + "')";
		try {
			ps=conn.prepareStatement(sqlqry);
			 status=ps.executeUpdate();
		conn.commit();
		if(status==1){
			
		}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}return status;
		
	}
	public  String[] search(int serial){
		conn=Oracale_Connections.getConnection();
		String userdetail[]=new String[15];
		int index=0;
		String sqlqry="select customer_name,customer_address,mobile_no,brand_name,model_name,price,stock_available, model_no,quantity,batter_no,charger_no,vat,total_amount,purchase_date from sale where bill_no=" + serial + " ";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			if(super.rs.next()){
				while(index<14){
				userdetail[index]=rs.getString(index+1);
				index+=1;
				}
				return userdetail;
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
		return userdetail;
	   }
public void update_model(String customer,String address, String mob ,String model,String battery,String chno,int bill ){
		
		String sqlqry="update sale set customer_name='" + customer + "',customer_address='" + address + "',mobile_no='" + mob + "',model_no='" + model +"',batter_no='" + battery +"',charger_no='" + chno +"' where bill_no=" +bill + " ";
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
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
public void update_stock(int quan,String modelname){
	String sqlqry="update stock set total_stock=" + quan + " where model_name='" + modelname + "' "; 
	try {
		super.conn=Oracale_Connections.getConnection();
		super.ps=super.conn.prepareStatement(sqlqry);
		int status=super.ps.executeUpdate();
		super.conn.commit();
		if(status==1){
			//JOptionPane.showMessageDialog(null, "Quantity Updated");
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