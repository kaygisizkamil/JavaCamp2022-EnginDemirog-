package JDBC_DataBaseConnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Program {

	public static void main(String[] args) throws SQLException {

		read();
		insert();
		update();
		   
	}
	public static void read() {
		Connection connection=null;
		DbHelper dbHelper=new DbHelper();
		Statement statement=null;
		ResultSet resultSet;
	
			try {
				   connection=dbHelper.getConnection();
				   statement=connection.createStatement();
				 resultSet=statement.executeQuery("select* from country");
				   ArrayList<Country>coGet=new ArrayList<>();
				   while(resultSet.next()) {
					   coGet.add(new Country(resultSet.getString("Code"),
							   resultSet.getString("Name"),
							   resultSet.getString("Continent"),
							   resultSet.getString("Region")
							   ));
					  // System.out.println(resultSet.getString("Name"));
				   }
				   //get elements from database
				   coGet.forEach(e-> System.out.println(e.code+" "+e.name+" "+e.continent+" "+e.region));
			}
			catch(SQLException exception) {
				dbHelper.showErrorMessage(exception);
			}
			finally {
				try {
					connection.close();
					statement.close();
					//statementinsert.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	public static void insert() {
		Connection connection=null;
		PreparedStatement prepared=null;
		DbHelper db=new DbHelper();
		try {
		connection=db.getConnection();
	    prepared=connection.prepareStatement("insert into city (Name,CountryCode,District,Population) values('Duzce','TUR','DUZCE',5000)");
	    int affected=prepared.executeUpdate();	
	    System.out.println("Insert executed");
	    System.out.println(affected);
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		finally {
			try {
				prepared.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				 
	}
	public static void update() {
		Connection connection=null;
		PreparedStatement ps=null;
		DbHelper dbh=new DbHelper();
		String myStatement=("update city set population=5000 where id=?");
		try {
			connection=dbh.getConnection();
			ps=connection.prepareStatement(myStatement);
			ps.setInt(1, 4082);//statement icinde tek soru isratei var 1. soru isaretina atama yapýyoruz 
			//deger 4082 onceden bildigimiz icin  4082 degerini rahatlikla girebildik
			int affected=ps.executeUpdate();
			System.out.println("Update executed");
			System.out.println(affected);
		}
     	catch(SQLException e){
     		e.getStackTrace();
     	}
		finally {
			try {
				connection.close();
				ps.close();
			}
			catch(SQLException e) {
				// do nothin
			}
			
		}
	}
	
	

}
