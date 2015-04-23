package Ferry;

import java.util.ArrayList;

public class Bus extends Vehicle{
	private final static int STATIC_FEE = 200;
	private final static int FEE_PER_PASS = 10;
	private final static int SPACE = 20;
	private final static int MAX_PASSENGERS = 20;
	
	private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public Bus(int pass){
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
