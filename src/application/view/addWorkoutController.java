package application.view;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import application.Main;
import application.model.ErgSplit;
import application.model.Rower;
import application.model.Workout;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class addWorkoutController {
	private Main mainApp;
	@FXML
	public ListView<Rower> rowerListView;
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
	@FXML
	public Text selectRowerMessage;
	
	ObservableList<Rower> possibleRowers;
	
	public void setLists(ObservableList<Rower> desiredListRowers){
		this.possibleRowers = desiredListRowers;
	}
	
	@FXML
	private void initialize(){
		System.out.println(possibleRowers);
		rowerListView.setItems(possibleRowers);
		selectRowerMessage.setVisible(false);
	}
	
	public void handleLogButton(){
		try {
		//System.out.println(datePicker.getValue());
		LocalDate wDate = dateField.getValue();
		String workoutDescription = workoutDescriptionField.getText();
		ErgSplit workoutTime = new ErgSplit(workoutTimeField.getText());
		String notes = workoutNotesArea.getText();
		Rower cr = possibleRowers.get(rowerListView.getSelectionModel().getSelectedIndex());
		cr.addWorkout(new Workout(wDate,workoutDescription,workoutTime,notes));
		workoutTimeField.clear();
		workoutNotesArea.clear();
		selectRowerMessage.setVisible(false);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			selectRowerMessage.setVisible(true);
		}
	}
	
	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	
	

}
