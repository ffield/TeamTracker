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

public class Rower {
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
	public ObservableList<Pr> getPRs() {
		return prList;
	}
	public void setPRs(ObservableList<Pr> prList) {
		this.prList = prList;
	}
	String Height;
	Integer weight;
	ObservableList<Pr> prList =FXCollections.observableArrayList();
	ObservableList<Workout>completedWorkoutList =FXCollections.observableArrayList();
	
	public ObservableList<Workout> getWorkouts() {
		 return completedWorkoutList;
	}
	
	@Override
	public String toString(){
		return Name;
	}
	
	public Rower(String rowerName, String rowerHeight, Integer rowerWeight, ObservableList<Pr> prs){
		this.Name = rowerName;
		this.Height = rowerHeight;
		this.weight = rowerWeight;
		this.prList = prs;
	}
	
	public void addPR(Pr newPR){
		this.prList.add(newPR);
	}
	
	public void addWorkout(Workout wo){
		this.completedWorkoutList.add(wo);
	}

	public XYChart.Series<Integer,Double> getSeries(Workout wo) {
		System.out.println("series being generated");
//		XYChart.Series<LocalDate,ergSplit> series1 = new Series<LocalDate, ergSplit>();
		XYChart.Series<Integer,Double> series1 = new Series<Integer, Double>();
		System.out.println("Workouts: ");
		System.out.println(this.completedWorkoutList);
		Iterator<Workout> workoutIterator = this.completedWorkoutList.iterator();
		Integer i = 1;
		while (workoutIterator.hasNext()){
			Workout currentWorkout = workoutIterator.next();
			if (currentWorkout.getTitle().equals(wo.getTitle())){
				System.out.println(currentWorkout.getSplit().doubleValue());
				Double d = currentWorkout.getSplit().doubleValue();
				series1.getData().add(new Data<Integer, Double>(i,d));
			//	series1.getData().add(new Data<Integer, Double>(i,1.67888));
				i++;
			}
		}
		//workoutIterator = this.completedWorkoutList.iterator();
		return series1;
	}
}
