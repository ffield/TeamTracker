package application.model;

public class ErgSplit implements Comparable<ErgSplit> {
	Integer minuteValue;
	Double secondsValue;
	
	public ErgSplit(String numbers){
		for (int i =0; i < numbers.length(); i++){
			if (numbers.charAt(i)==':'){
				this.minuteValue = Integer.valueOf(numbers.substring(i-1,i));
				this.secondsValue = Double.valueOf(numbers.substring(i+1));
			}
		}
	}
	
	public int compareTo(ErgSplit es){
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
	
	public Double doubleValue() {
		System.out.println("double value was called");
		Double minVal = Double.valueOf(this.minuteValue);
		System.out.println("Minute Value: " + minVal);
		Double dubVal = minVal + (secondsValue/60);
		System.out.println("Seconds: "+ dubVal);
		return dubVal;
	}
}
