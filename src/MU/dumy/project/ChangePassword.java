package MU.dumy.project;

import java.sql.*;

public class ChangePassword extends LoginBase {

	/**
	 * @param args
	 */
	Boolean usrflag=false;
	Boolean ansflag=false;
	String UserName,SecurityAns,password,confirmpassword;
	String sqlQuery,strsecque;
	public ChangePassword(String uname)
	{
		super.UserName=uname;
	}
	public ChangePassword(String secQue,String secQueAns,String usrPassword,String userName)
	{
		super.SecuriyQuestion=secQue;
		super.QuestionAnswer=secQueAns;
		super.UserPassword=usrPassword;
		super.UserName=userName;
	}
	public String showsecurityques()
	{
		strsecque="";
		UserRegistration ur=new UserRegistration(super.UserName);
		if(ur.validateusername())
		{
			super.conn=Oracale_Connections.getConnection();
			sqlQuery="select usersecurityque from userdetails where username='" + super.UserName + "'";
			try {
				super.ps=super.conn.prepareStatement(sqlQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				super.rs=ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while(rs.next())
				{
					strsecque=rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			strsecque="User Does'nt Exist";
		}
		return strsecque;
	}	
	public boolean valsecquesans()
	{
		ansflag=false;
		int status=0;
		super.conn=Oracale_Connections.getConnection();
		sqlQuery="select count(*) from userdetails where usersecurityque='" + super.SecuriyQuestion + "' and usersecurityans='" + super.QuestionAnswer + "'";
		try {
			super.ps=conn.prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			super.rs=super.ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				status=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(status==1)
		{
			ansflag=true;
		}
		return ansflag;
	}
	
	public int updatepassword()
	{
		int status=0;
		super.conn=Oracale_Connections.getConnection();
		sqlQuery="update userdetails set userpassword='" + super.UserPassword + "' where username='" + super.UserName + "' and usersecurityque='" + super.SecuriyQuestion + "' and usersecurityans='" + super.QuestionAnswer + "'";
		try {
			super.ps=conn.prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			status=super.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

}
