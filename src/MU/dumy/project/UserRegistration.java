package MU.dumy.project;

import java.sql.SQLException;
public class UserRegistration extends LoginBase {

	/**
	 * @param args
	 */
	String sqlquery="";
	Boolean flag=false;
	int status;
	public UserRegistration(String username)
	{
		super.UserName=username;
	}
	public UserRegistration(String uname,String upass,String usecquestion,String usecqueans)
	{
		try
		{
			super.UserName=uname;
			super.UserPassword=upass;
			super.SecuriyQuestion=usecquestion;
			super.QuestionAnswer=usecqueans;
		}
		catch(Exception exp)
		{
			System.out.print(exp.toString());
		}
	}
	public boolean validateusername()
	{
		flag=false;
		sqlquery="select username from userdetails";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=super.conn.prepareStatement(sqlquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			super.rs=super.ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				if(super.UserName.equals(rs.getString(1)))
				{
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	public int insertRegRecord()
	{
		sqlquery="insert into userdetails(username,userpassword,usersecurityque,usersecurityans) values('" + super.UserName + "', '" + super.UserPassword + "', '" + super.SecuriyQuestion + "', '" + super.QuestionAnswer + "')";
		super.conn=Oracale_Connections.getConnection();
		try {
			super.ps=conn.prepareStatement(sqlquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			status=super.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
}
