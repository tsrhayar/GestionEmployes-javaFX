package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewEmployes implements Initializable{
	
	@FXML
	private TableView<Employes> table;
	@FXML
	private TableColumn<Employes, Integer> id;
	@FXML
	private TableColumn<Employes, String> type_Emp;
	@FXML
	private TableColumn<Employes, String> fname;
	@FXML
	private TableColumn<Employes, String> lname;
	@FXML
	private TableColumn<Employes, Integer> age;
	@FXML
	private TableColumn<Employes, String> date;
	
	public ObservableList<Employes> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			String sql = "SELECT * FROM employes ";
			 Connection con =  ConnDB.getConnection();
			 PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
			 
			 ResultSet RS = stm.executeQuery();
			 
			 while(RS.next()) {
				 
				 data.add(new Employes(RS.getInt(1),RS.getString(2),RS.getString(3),
						 RS.getString(4),RS.getInt(5),RS.getString(6)));
				 
			 }
			 
			 con.close(); 
		}catch(SQLException e){
			e.getMessage(); 
		}
		
		id.setCellValueFactory(new PropertyValueFactory<Employes,Integer>("id"));
		type_Emp.setCellValueFactory(new PropertyValueFactory<Employes,String>("typeEmp"));
		fname.setCellValueFactory(new PropertyValueFactory<Employes,String>("firstname"));
		lname.setCellValueFactory(new PropertyValueFactory<Employes,String>("lastname"));
		age.setCellValueFactory(new PropertyValueFactory<Employes,Integer>("age"));
		date.setCellValueFactory(new PropertyValueFactory<Employes,String>("dateEntrer"));

		
		table.setItems(data);
		
	}
	

}
