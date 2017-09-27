package MU.dumy.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class LoginBase {
	protected String UserName;
	protected String UserPassword;
	protected String SecuriyQuestion;
	protected String QuestionAnswer;
PreparedStatement ps;
ResultSet rs;
Connection conn;
}
