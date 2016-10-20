package application.view;

import application.Main;
import application.model.ergSplit;
import application.model.pr;
import application.model.rower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class addRowerController extends mainScreenController {
	String rowerName;
	String rowerHeight;
	Integer rowerWeight;
	ListView<rower> rowersListView;
	ObservableList<rower> rowers;
    ObservableList<pr> rowerPRs = FXCollections.observableArrayList();
	public void setList(ObservableList<rower> cRowers, ListView<rower> cRowersListView){
		this.rowers = cRowers;
		this.rowersListView = cRowersListView;
	}
	private Main mainApp;

	
	@FXML
	public TextField newRowerName;
	
	@FXML
	public TextField newRowerWeight;
	
	@FXML
	public TextField newRowerHeight;
	
	@FXML
	public TextField prDistance;
	
	@FXML
	public TextField prTime;
	
	@FXML
	public Button addPRButton;
	
	@FXML
	public Button finalAddWorkout;
	
	public void handleAddPRButton(){
		Integer dist = Integer.valueOf(prDistance.getText());
		ergSplit time = new ergSplit(prTime.getText());
		pr initPR = new pr(dist,time);
		System.out.println(initPR);
		System.out.println(rowerPRs);
		rowerPRs.add(initPR);
		prDistance.clear();
		prTime.clear();
	}
	
	@Override
	public void handleAddRower(){
		rowerName = newRowerName.getText();
		rowerHeight = newRowerHeight.getText();
		rowerWeight = Integer.valueOf(newRowerWeight.getText());
		rowers.add( new rower(rowerName,rowerHeight,rowerWeight,rowerPRs));
		newRowerName.clear();
		newRowerHeight.clear();
		newRowerWeight.clear();
		ObservableList<pr> newRowerPRs = FXCollections.observableArrayList();
		rowerPRs = newRowerPRs;
		//System.out.println(rowers);
		rowersListView.setItems(rowers);
	}

	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	
	
}
