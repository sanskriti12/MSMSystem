package MU.dumy.project;
import java.sql.SQLException;
public class UserLogin extends LoginBase {

	/**
	 * @param args
	 */
	
	Boolean flag=false;
	public UserLogin(String uname,String upassword)
	{
			super.UserName=uname;
			super.UserPassword=upassword;
	}
	public boolean validatelogin()
	{
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="select username,userpassword from userdetails";
		try {
			
			super.ps=super.conn.prepareStatement(sqlqry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			super.rs=super.ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(super.rs.next())
			{
				if(super.UserName.equals(super.rs.getString(1)) && super.UserPassword.equals(super.rs.getString(2)))
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
				super.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
}
