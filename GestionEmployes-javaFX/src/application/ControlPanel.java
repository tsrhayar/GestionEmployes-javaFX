package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlPanel {
	
	public void viewEmployes(ActionEvent e) throws SQLException, IOException {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("View-Employes.fxml"));
		
		Scene scene = new Scene(root,817.0,500.0);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
     public void insertEmployes(ActionEvent e) throws SQLException, IOException {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("InsertEmploye.fxml"));
		
		Scene scene = new Scene(root,546.0,631.0);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
     
     public void updateDeleteEmployes(ActionEvent e) throws SQLException, IOException {
 		
 		Stage primaryStage = new Stage();
 		Parent root = FXMLLoader.load(getClass().getResource("UpdateDeleteEmploye.fxml"));
 		
 		Scene scene = new Scene(root,527.0,546.0);
 		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 		
 		primaryStage.setScene(scene);
 		primaryStage.show();
 	}
	

}
