package application.model;

public class pr {
	public int distance;
	public ergSplit time;
	
	public pr(int ddistance, ergSplit eTime){
		this.distance = ddistance;
		this.time = eTime;
	}
	
	@Override
	public String toString(){
		return distance + ": " + time;
	}
}
