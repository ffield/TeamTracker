package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class rower {
	public String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public ObservableList<pr> getPRs() {
		return prList;
	}
	public void setPRs(ObservableList<pr> prList) {
		this.prList = prList;
	}
	String Height;
	Integer weight;
	ObservableList<pr> prList =FXCollections.observableArrayList();
	ObservableList<workout>completedWorkoutList =FXCollections.observableArrayList();
	
	public ObservableList<workout> getWorkouts() {
		 return completedWorkoutList;
	}
	
	@Override
	public String toString(){
		return Name;
	}
	
	public rower(String rowerName, String rowerHeight, Integer rowerWeight, ObservableList<pr> prs){
		this.Name = rowerName;
		this.Height = rowerHeight;
		this.weight = rowerWeight;
		this.prList = prs;
	}
	
	public void addPR(pr newPR){
		this.prList.add(newPR);
	}
	
	public void addWorkout(workout wo){
		this.completedWorkoutList.add(wo);
	}

	public XYChart.Series<Integer,Integer> getSeries(workout wo) {
		System.out.println("series being generated");
//		XYChart.Series<LocalDate,ergSplit> series1 = new Series<LocalDate, ergSplit>();
		XYChart.Series<Integer,Integer> series1 = new Series<Integer, Integer>();
		Iterator<workout> workoutIterator = this.completedWorkoutList.iterator();
		Integer i = 1;
//		while (workoutIterator.hasNext()){
//			if (workoutIterator.next().getTitle().equals(wo.getTitle())){
//				series1.getData().add(new Data<Integer, ergSplit>(i,workoutIterator.next().getSplit()));
//				i++;
//			}
//		}
		while (workoutIterator.hasNext()){
			if (workoutIterator.next().getTitle().equals(wo.getTitle())){
				series1.getData().add(new Data<Integer, Integer>(i,i));
				i++;
			}
		}
		return series1;
	}
}
