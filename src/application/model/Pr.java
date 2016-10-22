package application.model;

public class Pr {
	public int distance;
	public ErgSplit time;
	
	public Pr(int ddistance, ErgSplit eTime){
		this.distance = ddistance;
		this.time = eTime;
	}
	
	@Override
	public String toString(){
		return distance + ": " + time;
	}
}
