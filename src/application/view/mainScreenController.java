package application.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import application.Main;
import application.model.ErgSplit;
import application.model.Pr;
import application.model.Rower;
import application.model.Workout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainScreenController {
	ObservableList<Workout> workouts = FXCollections.observableArrayList();
	ObservableList<Rower> rowers = FXCollections.observableArrayList();
	
	
	private Main mainApp;
	@FXML
	public ListView<Workout> workoutList;
	
	@FXML
	public ListView<Rower> rowerList;
	
	@FXML
	public ListView<Pr> PRList;
	
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
	public LineChart<Integer,Double> splitChart;
	
	@FXML
	public PieChart weekChart;
	
	@FXML
	public TextArea notesTextArea;
	
	@FXML
	public TextField splitTextField;
	
	@FXML
	public TextField workoutTextField;
	
	@FXML
	public Text splitFieldText;
	
	@FXML
	public Text workoutFieldText;
	
	@FXML
	public Text workoutAreaText;
	
	
	
	public void setRower(ObservableList<Rower> rowersList){
		rowerList.setItems(rowersList);
		
	}
	
	public Rower currentRower;
	
	
	@FXML
	public void handleMouseClicked(){
		if (!rowers.isEmpty()){
		Rower cr = rowers.get(rowerList.getSelectionModel().getSelectedIndex());
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
	
	@SuppressWarnings("unchecked")
	@FXML
	public void handleClickedWorkoutList(){
		Workout wo = currentRower.getWorkouts().get(workoutList.getSelectionModel().getSelectedIndex());
		System.out.println(wo);
		Series<Integer, Double> series1 = currentRower.getSeries(wo);
		splitChart.setTitle(wo.getTitle());
		splitChart.getData().addAll(series1);
		workoutTextField.setText(wo.getTitle());
		splitTextField.setText(wo.getSplit().toString());
		notesTextArea.setText(wo.getNotes());
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
