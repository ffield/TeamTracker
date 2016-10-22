package application.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Workout {
	LocalDate date;
	String workoutDescription;
	ErgSplit workoutSplit;
	String notes;
	
	public Workout(LocalDate wDate, String descrip, ErgSplit split, String workoutNotes){
		this.date = wDate;
		this.workoutDescription = descrip;
		this.workoutSplit = split;
		this.notes = workoutNotes;
	}
	
	public String getTitle(){
		return this.workoutDescription;
	}
	
	public ErgSplit getSplit(){
		return this.workoutSplit;
	}
	
	public LocalDate getDate(){
		return this.date;
	}
	
	public String getNotes() {
		return this.notes;
	}
	@Override
	public String toString(){
		return date + " " + workoutDescription;
	}
}
