package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ConnDB {
	
	static Connection con = null;
	
	public static Connection getConnection() throws SQLException {
		
		 String url = "jdbc:mysql://localhost/gestionemployes";
		 String passwrd = "";
		 String user = "root";
	     con = DriverManager.getConnection(url, user, passwrd);
	     return con;
	}

//	----INSERT EMPLOYEE
	public static int save(Employes emp) {

		int st = 0;
		try {
			 String sql1 = "INSERT INTO `employes`(`typeEmp`,`first-name`,`last-name`,`age`,`dateEntrer`) VALUES (?,?,?,?,?)";
			 con = ConnDB.getConnection();
			 PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql1);
			 stm.setString(1, emp.getTypeEmp());
			 stm.setString(2, emp.getFirstname());
			 stm.setString(3, emp.getLastname());
			 stm.setInt(4, emp.getAge());
			 stm.setString(5, emp.getDateEntrer());
			 
			 st = stm.executeUpdate();
			 con.close();
		}catch(SQLException e){
			e.getMessage(); 
		}
		
		return st;
	}
	
	
//	----UPDATE EMPLOYEE
	public static int update(Employes emp) {
		int st = 0;
		
		try {
			
			String sql = "UPDATE `employes` SET `typeEmp`=?,`first-name`=?,`last-name`=?,`age`=?,`dateEntrer`=? WHERE `id`=? ";
			con = ConnDB.getConnection();
			 PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
			 stm.setString(1, emp.getTypeEmp());
			 stm.setString(2, emp.getFirstname());
			 stm.setString(3, emp.getLastname());
			 stm.setInt(4, emp.getAge());
			 stm.setString(5, emp.getDateEntrer());
			 stm.setInt(6, emp.getId());
			 
			 st = stm.executeUpdate();
			 con.close();
			
		}catch(SQLException e){
			e.getMessage();
		}return st;
	}
	
	
	
//	----DELETE EMPLOYEE
	public static int delete(int id) {
		int st = 0;
		try {
			String sql = "DELETE FROM `employes` WHERE `id` =?";
			con = ConnDB.getConnection();
			PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
			
			 stm.setInt(1, id);
			 st = stm.executeUpdate();
			 con.close();
		}catch(SQLException e) {
			e.getMessage();
		}
		return st;
	}
	
	
	
//	----GET EMPLOYEE BY ID
	public static Employes getEmploye(int id) {
		Employes emp = new Employes();
		
		try {
			String sql = "SELECT * FROM employes WHERE id =?";
			 con = ConnDB.getConnection();
			 PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
			 
			 stm.setInt(1, id);
			 ResultSet RS = stm.executeQuery();
			 
			 if(RS.next()) {
				 emp.setId(RS.getInt(1));
				 emp.setTypeEmp(RS.getString(2));
				 emp.setFirstname(RS.getString(3));
				 emp.setLastname(RS.getString(4));
				 emp.setAge(RS.getInt(5));
				 emp.setDateEntrer(RS.getString(6));
			 }
			 	
			 con.close();
	}catch(SQLException e) {
		e.getMessage();
	}return emp;
		
}
	

}
