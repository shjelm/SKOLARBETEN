package Ferry;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
	private final static int STATIC_FEE = 40;
	private final static int FEE_PER_PASS = 0;
	private final static int SPACE = 1;
	
	private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public Bicycle(){
		super(getPassenger(),SPACE,STATIC_FEE, FEE_PER_PASS);
	}

	private static ArrayList<Passenger> getPassenger() {
		Passenger p = new Passenger();
		passengers.add(p);
		return passengers;
	}

}
