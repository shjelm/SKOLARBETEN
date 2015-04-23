package Ferry;

import java.util.ArrayList;

public class Car extends Vehicle {
	private final static int STATIC_FEE = 100;
	private final static int FEE_PER_PASS = 15;
	private final static int SPACE = 5;
	private final static int MAX_PASSENGERS = 4;
	
	private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public Car(int pass){
		super(getPassengers(pass),SPACE,STATIC_FEE, FEE_PER_PASS);
	}
	
	private static ArrayList<Passenger> getPassengers(int pass) {
		if(pass <= MAX_PASSENGERS){
			Passenger p = new Passenger();
			for(int i = 0; i < pass; i++){
				passengers.add(p);
			}
			return passengers; 
		}		
		else{
			return new ArrayList<Passenger>();
		}
	}
}
