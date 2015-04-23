package Ferry;

import java.util.ArrayList;

public class Lorry extends Vehicle{
	private final static int STATIC_FEE = 300;
	private final static int FEE_PER_PASS = 15;
	private final static int SPACE = 40;
	private final static int MAX_PASSENGERS = 2;
	
	private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public Lorry(int pass){
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
