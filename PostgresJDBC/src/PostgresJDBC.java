import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresJDBC {
	
	public PostgresJDBC() {
		try {
			String databaseUser = "dizach";
			String databaseUserPass = "123";
			Class.forName("org.postgresql.Driver");
			
			Connection connection = null;
			String url = "jdbc:postgresql://localhost/testdb";
			connection = DriverManager.getConnection(url, databaseUser, databaseUserPass);
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from roles");
			
			while (rs.next()) {
				System.out.println(rs.getString("role_name"));
			}
			
			rs.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login error: " + e.toString());
		}
	}
	
	public static void main(String[] args) {
		new PostgresJDBC();
	}
}
