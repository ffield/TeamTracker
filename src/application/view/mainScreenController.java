package application.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import application.Main;
import application.model.ergSplit;
import application.model.pr;
import application.model.rower;
import application.model.workout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mainScreenController {
	ObservableList<workout> workouts = FXCollections.observableArrayList();
	ObservableList<rower> rowers = FXCollections.observableArrayList();
	
	
	private Main mainApp;
	@FXML
	public ListView<workout> workoutList;
	
	@FXML
	public ListView<rower> rowerList;
	
	@FXML
	public ListView<pr> PRList;
	
	@FXML
	public Button addWorkoutButton;
	
	@FXML
	public Button addRowerButton;
	
	@FXML
	public TextField nameField;
	
	@FXML
	public TextField weightField;
	
	@FXML
	public TextField heightField;
	
	@FXML
	public LineChart<Integer,Integer> splitChart;
	
	@FXML
	public PieChart weekChart;
	
	public void setRower(ObservableList<rower> rowersList){
		rowerList.setItems(rowersList);
		
	}
	
	public rower currentRower;
	
	
	@FXML
	public void handleMouseClicked(){
		if (!rowers.isEmpty()){
		rower cr = rowers.get(rowerList.getSelectionModel().getSelectedIndex());
		currentRower = cr;
		nameField.setText(cr.getName());
		weightField.setText(Integer.toString(cr.getWeight()));
		heightField.setText(cr.getHeight());
		PRList.setItems(cr.getPRs());
		workoutList.setItems(cr.getWorkouts());
		rowerList.setItems(rowers);
		}
	}
	
	@FXML
	public GridPane workoutGPane;
	
	
	@FXML
	private void initialize() {
		if (!rowers.isEmpty()){
		rowerList.setItems(rowers);
		workoutList.setItems(rowers.get(0).getWorkouts());
		nameField.setText(rowers.get(0).getName());
		weightField.setText(Integer.toString(rowers.get(0).getWeight()));
		heightField.setText(rowers.get(0).getHeight());
		PRList.setItems(rowers.get(0).getPRs());
		}
		//System.out.println("This got called");
	}

	
	@FXML
	public void handleAddRower() throws IOException {
		//System.out.println("Got Called Yo ");
		Stage stage; 
		Parent root;
		FXMLLoader loader = new FXMLLoader (getClass().getResource("addRower.fxml"));
		addRowerController arc = new addRowerController();
		arc.setMainApp(this.mainApp);
		arc.setList(rowers,rowerList);
	    loader.setController(arc);
	    root = loader.load();
		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	@FXML
	public void handleClickedWorkoutList(){
		workout wo = currentRower.getWorkouts().get(workoutList.getSelectionModel().getSelectedIndex());
		System.out.println(wo);
		XYChart.Series series1 = currentRower.getSeries(wo);
		splitChart.setTitle(wo.getTitle());
		splitChart.getData().addAll(series1);
	}
	
	@FXML
	public void handleAddWorkout() throws IOException{
		Stage stage; 
		Parent root;
		FXMLLoader loader = new FXMLLoader (getClass().getResource("addWorkout.fxml"));
		addWorkoutController awc = new addWorkoutController();
		awc.setMainApp(this.mainApp);
		awc.setLists(rowers);
	    loader.setController(awc);
	    root = loader.load();
		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

	
}
