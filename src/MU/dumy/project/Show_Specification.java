package MU.dumy.project;
import java.sql.*;

import javax.swing.JOptionPane;

public class Show_Specification extends LoginBase{
	public int findmin(){
		int min=0;
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="select min(amount) from feature";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			while(rs.next()){
				min=rs.getInt(1);
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
		return min;
	}
	public int findmax(){
		int max=0;
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="select max(amount) from feature";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			while(rs.next()){
				max=rs.getInt(1);
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
		return max;
	}
	public int getrowno(int min, int max ){
		super.conn=Oracale_Connections.getConnection();
		int row=0;
		String sqlqry="select count(*) from feature where amount between '" + min + "' and '" + max +"'";
		try {
			super.ps=super.conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			if(rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}	/*finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}*/
		return row;
	}
	public  String[] get_model_name(int min1,int max1){
		conn=Oracale_Connections.getConnection();
		int row=getrowno(min1, max1),index=0;
				String []mname=new String [row];
		String sqlqry="select model_name from feature where amount between '" + min1 + "' and '" + max1 + "'";
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
	public String getbrand(String model){
		super.conn=Oracale_Connections.getConnection();
		String brand=null;
		String sqlqry="select brand_name from feature where model_name='" + model + "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			if(rs.next()){
				brand=super.rs.getString(1);
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
		return brand;
	}
	public String[] getname(){
		String strname[]=new String[13];
		strname[0]="Amount";
		strname[1]="Internal Storage";
		strname[2]="Os";
		strname[3]="Expadable-upto";
		strname[4]="Ram";
		strname[5]="Processor";
		strname[6]="Rear Camera";
		strname[7]="Front camera";
		strname[8]="Screen Size";
		strname[9]="Resulation";
		strname[10]="Battery";
		strname[11]="Network Support";
		strname[12]="Protection";
		return strname;
	}
}
