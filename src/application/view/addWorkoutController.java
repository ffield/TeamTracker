package application.view;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import application.Main;
import application.model.ergSplit;
import application.model.rower;
import application.model.workout;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class addWorkoutController {
	private Main mainApp;
	@FXML
	public ListView<rower> rowerListView;
	@FXML
	public TextField workoutDescriptionField;
	@FXML
	public DatePicker dateField;
	@FXML
	public TextField workoutTimeField;
	@FXML
	public TextArea workoutNotesArea;
	@FXML
	public Button logButton;
	
	ObservableList<rower> possibleRowers;
	
	public void setLists(ObservableList<rower> desiredListRowers){
		this.possibleRowers = desiredListRowers;
	}
	
	@FXML
	private void initialize(){
		System.out.println(possibleRowers);
		rowerListView.setItems(possibleRowers);
	}
	
	public void handleLogButton(){
		//System.out.println(datePicker.getValue());
		LocalDate wDate = dateField.getValue();
		String workoutDescription = workoutDescriptionField.getText();
		ergSplit workoutTime = new ergSplit(workoutTimeField.getText());
		String notes = workoutNotesArea.getText();
		rower cr = possibleRowers.get(rowerListView.getSelectionModel().getSelectedIndex());
		cr.addWorkout(new workout(wDate,workoutDescription,workoutTime,notes));
		workoutTimeField.clear();
		workoutNotesArea.clear();
	}
	
	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	
	

}
