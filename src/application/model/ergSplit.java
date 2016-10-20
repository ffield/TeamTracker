package application.model;

public class ergSplit implements Comparable<ergSplit> {
	Integer minuteValue;
	Double secondsValue;
	
	public ergSplit(String numbers){
		for (int i =0; i < numbers.length(); i++){
			if (numbers.charAt(i)==':'){
				this.minuteValue = Integer.valueOf(numbers.substring(i-1,i));
				this.secondsValue = Double.valueOf(numbers.substring(i+1));
			}
		}
	}
	
	public int compareTo(ergSplit es){
		if (this.minuteValue.compareTo(es.minuteValue) == 0) {
			return Double.compare(this.secondsValue, es.secondsValue);
		}
		else {
		return this.minuteValue.compareTo(es.minuteValue);
		}
	}
	
	public String toString(){
		return minuteValue.toString() + ":" + secondsValue;
	}
	
	public double doubleValue() {
		double minVal = this.minuteValue;
		double dubVal = minVal + (secondsValue/60);
		return dubVal;
	}
}
