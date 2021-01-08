package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class InsertEmploye {

	

		@FXML
		private TextField fname1;
		
		@FXML
		private TextField typeEmp;
		
		@FXML
		private TextField lname1;
		
		@FXML
		private  TextField age1;
		
		@FXML
		private TextField date1;
	
	public void insertData(ActionEvent e)throws IOException{
		
		String typeEmploye = typeEmp.getText();
		String firstname = fname1.getText();
		String lastname = lname1.getText();
		String AgeE = age1.getText();
		String dateE = date1.getText();
		
		int ageEmp = Integer.parseInt(AgeE);
		
		Employes emp = new Employes();
		
		emp.setTypeEmp(typeEmploye);
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		emp.setAge(ageEmp);
		emp.setDateEntrer(dateE);
		
		
		
		int status = ConnDB.save(emp);
		
		
		if(status>0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved Successfully");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to save recoed");
		}
		
	}
	
}
