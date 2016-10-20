package application.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class workout {
	LocalDate date;
	String workoutDescription;
	ergSplit workoutSplit;
	String notes;
	
	public workout(LocalDate wDate, String descrip, ergSplit split, String workoutNotes){
		this.date = wDate;
		this.workoutDescription = descrip;
		this.workoutSplit = split;
		this.notes = workoutNotes;
	}
	
	public String getTitle(){
		return this.workoutDescription;
	}
	
	public ergSplit getSplit(){
		return this.workoutSplit;
	}
	
	public LocalDate getDate(){
		return this.date;
	}
	@Override
	public String toString(){
		return date + " " + workoutDescription;
	}
}
