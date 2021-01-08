package application;

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UpdateDeleteEmploye {

	@FXML
	private TextField id;
	
	@FXML
	private TextField UD_type;
	
	@FXML
	private TextField UD_fname;
	
	@FXML
	private TextField UD_lname;
	
	@FXML
	private  TextField UD_age;
	
	@FXML
	private TextField UD_date;
	
	
	
//	-----GET EMPLOYEE BY ID
	
	public void getEmployeById(ActionEvent e)throws IOException{
		
		
		String idE = id.getText();
		int eid = Integer.parseInt(idE);
		
		
		Employes emp = ConnDB.getEmploye(eid);
		
		UD_type.setText(emp.getTypeEmp());
		UD_fname.setText(emp.getFirstname());
		UD_lname.setText(emp.getLastname());
		UD_age.setText(String.valueOf(emp.getAge()));
		UD_date.setText(emp.getDateEntrer());	
			
	}
	
	
//	-----UPDATE EMPLOYEE
	
	public void updateEmploye(ActionEvent e)throws IOException{
		String Sid = id.getText();
		int eid = Integer.parseInt(Sid);
		
		String textType = UD_type.getText();
		String textfname = UD_fname.getText();
		String textlname = UD_lname.getText();
		int textAge = Integer.parseInt(UD_age.getText());
		String textDate = UD_date.getText();
		
		
		Employes emp = new Employes();
		
		emp.setId(eid);
		emp.setTypeEmp(textType);
		emp.setFirstname(textfname);
		emp.setLastname(textlname);
		emp.setAge(textAge);
		emp.setDateEntrer(textDate);
		
        int status = ConnDB.update(emp);
		
		
		if(status>0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Update");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved Successfully");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to save recoed");
			
			alert.showAndWait(); 
		}
		
		
	}
	
	
//	-----DELETE EMPLOYEE
	
	public void deleteEmploye(ActionEvent e)throws IOException{
		
		String Sid = id.getText();
		int eid = Integer.parseInt(Sid);
			
		int status = ConnDB.delete(eid);
		if(status>0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Delete");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved Successfully");
			
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Delete");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to save recoed");
			
			alert.showAndWait(); 
		}
		
	}
	
	
	
}
